package id.cogman.auditrail.aspects.actions;

import id.cogman.auditrail.entities.Base;
import java.lang.reflect.Field;
import javax.persistence.EntityManager;
import javax.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public abstract class AuditTemplate {

  protected final EntityManager entityManager;

  public void process(Base base) throws IllegalAccessException {

    Class<? extends Base> clazz = base.getClass();
    String tableName = clazz.getSimpleName().toLowerCase() + "s_audit_trails";

    String sql = String.format(
        "INSERT INTO %s(id, action, timestamp , field, old_value, new_value, table_name, user_id) "
            + "VALUES(:id, :action, :timestamp , :field, :old_value, :new_value, :table_name, :user_id)",
        tableName
    );

    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      Object oldBase = base.getOldBase() == null ? null : field.get(base.getOldBase());

      this.execute(sql, clazz, field.getName(), oldBase, field.get(base),
          clazz.getAnnotation(Table.class).name());
    }

  }

  protected abstract void execute(String sql, Class<? extends Base> clazz, String column,
      Object oldVal, Object newVal, String tableName);

}

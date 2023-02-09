package id.cogman.auditrail.aspects.actions;

import id.cogman.auditrail.entities.Base;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Component;

@Component
public class AuditRemove extends AuditTemplate {

  public AuditRemove(EntityManager entityManager) {
    super(entityManager);
  }

  @Override
  protected void execute(String sql, Class<? extends Base> clazz, String column, Object oldVal,
      Object newVal, String tableName) {
    this.entityManager.createNativeQuery(sql, clazz)
        .setParameter("id", UUID.randomUUID().toString())
        .setParameter("action", "DELETE")
        .setParameter("timestamp", LocalDateTime.now())
        .setParameter("field", column)
        .setParameter("old_value", oldVal)
        .setParameter("new_value", newVal)
        .setParameter("table_name", tableName)
        .setParameter("user_id", "7fc27943-97ea-4544-9da0-b4855a934e1a")
        .executeUpdate();
  }

}

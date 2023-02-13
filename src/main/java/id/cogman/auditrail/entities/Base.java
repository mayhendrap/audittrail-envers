package id.cogman.auditrail.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {

  @CreatedDate
  @Column(name = "created_date", updatable = false)
  protected LocalDateTime createdDate;

  @Column(name = "last_modified")
  protected LocalDateTime lastModified;

  @CreatedBy
  @Column(name = "created_by")
  protected String createdBy;

  @LastModifiedBy
  @Column(name = "modified_by")
  protected String modifiedBy;

}

package id.cogman.auditrail.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Data
@Entity
@RevisionEntity
@Table(name = "revision_info")
public class RevisionInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @RevisionNumber
  private Integer id;

  @RevisionTimestamp
  private long timestamp;

  private String username;

}

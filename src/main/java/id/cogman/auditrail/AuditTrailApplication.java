package id.cogman.auditrail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AuditTrailApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuditTrailApplication.class, args);
  }

}

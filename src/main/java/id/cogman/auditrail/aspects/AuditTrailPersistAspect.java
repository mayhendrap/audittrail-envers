package id.cogman.auditrail.aspects;

import id.cogman.auditrail.aspects.actions.AuditTemplate;
import id.cogman.auditrail.entities.Base;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AuditTrailPersistAspect {

  private final ApplicationContext applicationContext;

  @Pointcut("execution(public * javax.persistence.EntityManager.persist(..))")
  public void jpaPersist() {
  }

  @Pointcut("execution(public * javax.persistence.EntityManager.merge(..))")
  public void jpaMerge() {
  }

  @AfterReturning("jpaPersist() || jpaMerge()")
  public void auditPersistActor(JoinPoint joinPoint)
      throws IllegalAccessException {
    Object[] args = joinPoint.getArgs();
    Object obj = args[0];

    String action = joinPoint
        .getSignature().getName().substring(0, 1).toUpperCase() +
        joinPoint.getSignature().getName().substring(1);

    if (obj instanceof Base base) {
      log.info("[TRIGGERING JPA - Audit{}]", action);
      AuditTemplate audit = (AuditTemplate) applicationContext.getBean("audit" + action);
      audit.process(base);
    }
  }

}

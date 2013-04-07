package info.yalamanchili.office.logging;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
import javax.persistence.Entity;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingInterceptor {

    @Autowired
    public OfficeServiceConfiguration officeServiceConfiguration;
    private static final Log log = LogFactory.getLog(LoggingInterceptor.class);

    @Before("execution(* info.yalamanchili.office..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        //dont log call to OfficeServiceConfiguration.EnableLogginIntereptor
        if (joinPoint.getSignature().toShortString().contains("EnableLoginInterceptor")) {
            return;
        }
        if (officeServiceConfiguration.getEnableLoginInterceptor()) {
            if (log.isInfoEnabled()) {
                log.info("-------------- invoking ---------------- :" + joinPoint.getSignature());
                for (Object input : joinPoint.getArgs()) {
                    if (input != null) {
                        // if entity dont use Reflection to print tostring as it causes hibernate session closing exception with async methods
                        if (isEntity(input)) {
                            input.toString();
                        } else {
                            log.info("with input:" + ReflectionToStringBuilder.toString(input));
                        }
                    }
                }
            }
        }
    }

    protected boolean isEntity(Object obj) {
        return obj.getClass().getAnnotation(Entity.class) == null ? false : true;
    }

    @AfterReturning(pointcut = "execution(* info.yalamanchili.office..*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        //dont log call to OfficeServiceConfiguration.EnableLogginIntereptor
        if (joinPoint.getSignature().toShortString().contains("EnableLoginInterceptor")) {
            return;
        }
        if (log.isInfoEnabled()) {
            log.info("------------ returning------------------ :" + joinPoint.getSignature() + "------------ with result :"
                    + ReflectionToStringBuilder.toString(result));
        }
    }

    @Around("execution(* info.yalamanchili.office..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        if (!pjp.getSignature().toShortString().contains("EnableLoginInterceptor")) {
            log.info("Method " + pjp.getSignature().toShortString() + " execution time: " + elapsedTime + " milliseconds.");
        }
        return output;
    }
}

package info.yalamanchili.office.logging;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingInterceptor {

    private static final Log log = LogFactory.getLog(LoggingInterceptor.class);

    @Before("execution(* info.yalamanchili.office..*.*(..))")
    @Order(1)
    public void logBefore(JoinPoint joinPoint) {
        if (log.isInfoEnabled()) {
            log.info("-------------- invoking ---------------- :" + joinPoint.getSignature());
            for (Object input : joinPoint.getArgs()) {
                log.info("with input:" + ReflectionToStringBuilder.toString(input));
            }
        }
    }

    @AfterReturning(pointcut = "execution(* info.yalamanchili.office..*.*(..))", returning = "result")
    @Order(2)
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (log.isInfoEnabled()) {
            log.info("------------ returning------------------ :" + joinPoint.getSignature() + "------------ with result :"
                    + ReflectionToStringBuilder.toString(result));
        }
    }

    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
    @Order(3)
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        if (log.isErrorEnabled()) {
            log.error("*********************An exception has been thrown in*************: " + joinPoint.getSignature().getName() + "()");
            log.error("Cause :" + e.getCause());
        }
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.logging;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.ws.rs.core.Response;
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
        if (ignoreMethod(joinPoint.getSignature().toShortString())) {
            return;
        }
        if (officeServiceConfiguration.getEnableLoginInterceptor()) {
            if (log.isDebugEnabled()) {
                log.debug("-------------- invoking ---------------- :" + joinPoint.getSignature());
                for (Object input : joinPoint.getArgs()) {
                    if (input != null) {
                        // if entity dont use Reflection to print tostring as it causes hibernate session closing exception with async methods
                        if (isEntity(input)) {
                            input.toString();
                        } else {
                            log.debug("with input:" + input.toString());
                        }
                    }
                }
            }
        }
    }
    protected static List<String> ignoreMethods = new ArrayList<String>();

    static {
        ignoreMethods.add("EnableLoginInterceptor");
        ignoreMethods.add("TemplateService");
    }

    protected boolean ignoreMethod(String name) {
        for (String key : ignoreMethods) {
            if (name.contains(key)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isEntity(Object obj) {
        return obj.getClass().getAnnotation(Entity.class) == null ? false : true;
    }

    @AfterReturning(pointcut = "execution(* info.yalamanchili.office..*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        if (ignoreMethod(joinPoint.getSignature().toShortString())) {
            return;
        }
        if (log.isDebugEnabled()) {
            if (logResultType(result)) {
                log.debug("------------ returning------------------ :" + joinPoint.getSignature() + "------------ with result :"
                        + result.toString());
            } else {
                log.debug("------------ returning------------------ :" + joinPoint.getSignature() + "------------");
            }
        }
    }

    protected boolean logResultType(Object res) {
        if (res instanceof Response) {
            return false;
        } else if (res instanceof byte[]) {
            return false;
        }
        return true;
    }

    @Around("execution(* info.yalamanchili.office..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        if (log.isDebugEnabled()) {
            if (!pjp.getSignature().toShortString().contains("EnableLoginInterceptor")) {
                log.debug("Method " + pjp.getSignature().toShortString() + " execution time: " + elapsedTime + " milliseconds.");
            }
        }
        return output;
    }
}

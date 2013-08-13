/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Aspect
@Component
@Scope("request")
public class PrivacyInterceptor {

    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(privacyAware)")
    public Object privacyCheck(ProceedingJoinPoint joinPoint, PrivacyAware privacyAware) throws Throwable {
        Object result = null;
        try {
            if (PrivacyService.instance().performPrivacyCheck(joinPoint, privacyAware.key())) {
                result = joinPoint.proceed();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}

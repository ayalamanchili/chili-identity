/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.chili.service.jrs.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Aspect
@Component
@Scope("request")
public class PrivacyInterceptor {

    @Pointcut(value = "execution(* info.yalamanchili.office..*.*(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(privacyAware)")
    @Transactional(readOnly = true)
    public Object privacyCheck(ProceedingJoinPoint joinPoint, PrivacyAware privacyAware) throws Throwable {
        Object result = null;
        boolean validCall = PrivacyService.instance().performPrivacyCheck(joinPoint, privacyAware);
        try {
            if (validCall) {
                result = joinPoint.proceed();
            } else {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "privacy.voilation", "Data is hidden based on user privacy settings");
            }
        } catch (Exception e) {
            if (e instanceof ServiceException) {
                throw e;
            } else {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}

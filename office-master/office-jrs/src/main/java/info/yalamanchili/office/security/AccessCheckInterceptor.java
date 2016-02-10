/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

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
 * @author ayalamanchili
 */
@Aspect
@Component
@Scope("request")
public class AccessCheckInterceptor {

    @Pointcut(value = "execution(* info.yalamanchili.office..*.*(..))")
    public void anyPublicMethod() {
    }

    @Around("anyPublicMethod() && @annotation(accessCheck)")
    @Transactional(readOnly = true)
    public Object accessCheck(ProceedingJoinPoint joinPoint, AccessCheck accessCheck) throws Throwable {
        Object result = null;
        if (!accessCheck.checkOnReturnObj()) {
            try {
                if (AccessCheckService.instance().performAccessCheck(joinPoint, accessCheck)) {
                    result = joinPoint.proceed();
                } else {
                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "access.voilation", "You dont have access to this data");
                }
            } catch (Exception e) {
                if (e instanceof ServiceException) {
                    throw e;
                } else {
                    throw new RuntimeException(e);
                }
            }

        } else {
            try {
                result = joinPoint.proceed();
                if (AccessCheckService.instance().performAccessCheck(result, accessCheck)) {
                    result = joinPoint.proceed();
                } else {
                    throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "access.voilation", "You dont have access to this data");
                }
            } catch (Exception e) {
                if (e instanceof ServiceException) {
                    throw e;
                } else {
                    throw new RuntimeException(e);
                }
            }
        }
        return result;
    }
}

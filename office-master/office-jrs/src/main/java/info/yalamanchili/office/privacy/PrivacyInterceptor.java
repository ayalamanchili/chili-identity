/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Employee;
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
    public Object privacyCheck(ProceedingJoinPoint joinPoint,PrivacyAware privacyAware) throws Throwable {
        Object result = null;
        try {
            if (performPrivacyCheck(joinPoint)) {
                result = joinPoint.proceed();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    protected boolean performPrivacyCheck(ProceedingJoinPoint joinPoint) {
        Employee employee = getEmployee(joinPoint);
        if (employee != null) {
            Employee currentUser = SecurityService.instance().getCurrentUser();
//            if (currentUser.getEmployeeId().equals("useruser")) {
//                return false;
//            }
            //TODO check here
        }

        return true;
    }

    protected Employee getEmployee(ProceedingJoinPoint joinPoint) {
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] instanceof Long) {
            return EmployeeDao.instance().findById((Long) joinPoint.getArgs()[0]);
        }
        return null;
    }
}

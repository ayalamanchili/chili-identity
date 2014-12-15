/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.analytics;

import info.yalamanchili.office.config.OfficeServiceConfiguration;
import javax.persistence.Entity;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili will post(async) all activity events to analytics
 * database
 */
//@Aspect
//@Component
public class EventInterceptor {

    @Autowired
    public OfficeServiceConfiguration officeServiceConfiguration;

    @Before("execution(* info.yalamanchili.office.jrs..*.*(..))")
    public void before(JoinPoint joinPoint) {

    }

    @AfterReturning(pointcut = "execution(* info.yalamanchili.office.jrs..*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }

    @Around("execution(* info.yalamanchili.office..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
       
        Object output = pjp.proceed();

        return output;
    }

    protected boolean isEntity(Object obj) {
        return obj.getClass().getAnnotation(Entity.class) != null;
    }
}

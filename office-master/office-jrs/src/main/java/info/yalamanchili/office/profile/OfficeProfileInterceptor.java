/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.profile.ProfileInterceptor;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author phani
 */
@Aspect
@Component
public class OfficeProfileInterceptor extends ProfileInterceptor {

    private static final Log log = LogFactory.getLog(OfficeProfileInterceptor.class);
    @Autowired
    public OfficeServiceConfiguration officeServiceConfiguration;

    @Around("execution(* info.yalamanchili.office..*.*(..))")
    @Override
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        return super.profile(pjp);
    }

    @Override
    protected boolean enabled() {
        return log.isDebugEnabled();
    }

    @Override
    protected boolean persistLogData() {
        return true;
    }

    @Override
    protected List<String> ingoreMethods() {
        return IGNORE_METHODS;
    }

    protected final static List<String> IGNORE_METHODS = new ArrayList<>();

    static {
        IGNORE_METHODS.add("OfficeServiceConfiguration.getEnableAnalytics()");
        IGNORE_METHODS.add("OfficeServiceConfiguration.getEnableLoginInterceptor()");
    }

}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.analytics;

import info.chili.analytics.model.Event;
import info.chili.analytics.service.EventsService;
import info.yalamanchili.office.config.OfficeServiceConfiguration;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import java.util.Date;
import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili will post(async) all activity events to analytics
 * database
 */
@Aspect
@Component
@Transactional
@Order(10)
public class EventInterceptor {

    @Autowired
    public OfficeServiceConfiguration officeServiceConfiguration;

    @Autowired
    protected OfficeSecurityService officeSecurityService;

    @Autowired
    protected EventsService eventsService;

    @Autowired(required = true)
    private HttpServletRequest request;

    @Pointcut(value = "execution(* info.yalamanchili.office.jrs..*.*(..))")
    public void anyJRSMethod() {
    }

    @Around("anyJRSMethod() && @annotation(path)")
    public Object profile(ProceedingJoinPoint pjp, Path path) throws Throwable {
        Object output;
        if (officeServiceConfiguration.getEnableAnalytics()) {
            Event event = new Event();
            event.setEvenTimeStamp(new Date());
            event.setUser(officeSecurityService.getCurrentUserName());
            event.setName(pjp.getSignature().toShortString());
            event.setUserAgentInfo(request.getHeader("User-Agent-X"));
            event.setInput(describeInput(pjp));
            output = pjp.proceed();
            event.setOutput(describeOutput(pjp, output));
            eventsService.saveEvents(event);
        } else {
            output = pjp.proceed();
        }
        return output;
    }

    protected String describeOutput(ProceedingJoinPoint pjp, Object result) {
        StringBuilder sb = new StringBuilder();
        if (logResultType(result) && result != null) {
            if (isEntity(result)) {
                sb.append(result.toString());
            } else {
                sb.append(ReflectionToStringBuilder.toString(result));
            }
        }
        return sb.toString();
    }

    protected String describeInput(ProceedingJoinPoint pjp) {
        StringBuilder sb = new StringBuilder();
        for (Object input : pjp.getArgs()) {
            if (input != null) {
                if (isEntity(input)) {
                    sb.append(input.toString());
                } else {
                    sb.append(ReflectionToStringBuilder.toString(input));
                }
            }
        }
        return sb.toString();
    }

    protected boolean logResultType(Object res) {
        if (res instanceof Response) {
            return false;
        } else if (res instanceof byte[]) {
            return false;
        }
        return true;
    }

    protected boolean isEntity(Object obj) {
        return obj.getClass().getAnnotation(Entity.class) != null;
    }
}

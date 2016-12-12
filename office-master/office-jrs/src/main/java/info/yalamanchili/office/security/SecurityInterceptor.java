/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.commons.ReflectionUtils;
import info.chili.security.Obfuscated;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
//TODO currently not being used
@Aspect
@Component
public class SecurityInterceptor {

    public static final String OBFUSCATED_STR = "*********";

//    @AfterReturning(pointcut = "execution(* info.yalamanchili.office.jrs..*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        for (Field field : ReflectionUtils.getAllFields(result.getClass())) {
            Method getterMethod = ReflectionUtils.getGetterMethod(field, result.getClass());
            if (getterMethod != null) {
                if (getterMethod.getAnnotation(Obfuscated.class) != null) {
                    ReflectionUtils.callSetter(result, field.getName(), OBFUSCATED_STR);
                }
            }
        }
    }
}

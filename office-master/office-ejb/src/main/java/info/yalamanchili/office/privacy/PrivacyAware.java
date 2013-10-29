/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.entity.profile.Employee;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to trigger customer interceptor to filter the return results based on
 * privacy settings
 *
 * @author anuyalamanchili
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrivacyAware {

    PrivacyData key();

    Class<?> identityClass() default Employee.class;

    String identityReference() default "";
}

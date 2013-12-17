/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.chili.commons.ReflectionUtils;
import info.chili.service.jrs.ServiceMessages;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.privacy.PrivacyMode;
import info.yalamanchili.office.entity.privacy.PrivacySetting;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("request")
public class PrivacyService {

    @PersistenceContext
    protected EntityManager em;

    protected boolean performPrivacyCheck(ProceedingJoinPoint joinPoint, PrivacyAware privacyAware) {
        Employee employee = getIdentity(joinPoint, privacyAware);
        if (employee == null) {
            //indicates invalid employee/identity passed aling
            return true;
        }
        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return true;
        }
        if (employee != null) {
            PrivacySetting setting = PrivacySettingDao.instance().getPrivacySettingsForData(employee, privacyAware.key());
            if (setting != null && !PrivacyMode.PUBLIC.equals(setting.getPrivacyMode())) {
                if (PrivacyMode.PRIVATE.equals(setting.getPrivacyMode())) {
                    return canAccessPrivateData(currentUser);
                }
            }

        }
        return true;
    }

    protected boolean canAccessPrivateData(Employee currentUser) {
        if ("Corporate Employee".equals(currentUser.getEmployeeType().getName())) {
            return true;
        } else {
            ServiceMessages.instance().addError(new info.chili.service.jrs.types.Error("privacy", "NOT_AUTHORIZED", "Data is hidden based on user privacy settings"));
            return false;
        }

    }

    protected Employee getIdentity(ProceedingJoinPoint joinPoint, PrivacyAware privacyAware) {
        Employee employee = null;
        if (privacyAware.identityClass().equals(Employee.class)) {
            employee = EmployeeDao.instance().findById((Long) joinPoint.getArgs()[0]);
        } else {
            //TODO get entitymanager by demand
            Object ref = em.find(privacyAware.identityClass(), joinPoint.getArgs()[0]);
            //supports only one level
            employee = (Employee) ReflectionUtils.callGetter(ref, privacyAware.identityReference());
        }
        return employee;
    }

    public static PrivacyService instance() {
        return SpringContext.getBean(PrivacyService.class);
    }
}

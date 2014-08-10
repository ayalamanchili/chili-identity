/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.chili.commons.ReflectionUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
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
            //TODO should return false
            //indicates invalid employee/identity passed along
            return true;
        }
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return true;
        }
        if (OfficeSecurityService.instance().getUserRoles(employee).contains(OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            //this is corp emp info check if user has HR role
            if (OfficeSecurityService.instance().hasRole(info.yalamanchili.office.OfficeRoles.OfficeRole.ROLE_CORPORATE_DATA.name())) {
                return true;
            }
        } else {
            //This is consultant employee information check is the user has corp emp role
            if (OfficeSecurityService.instance().hasRole(info.yalamanchili.office.OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
                return true;
            }
        }
        PrivacySetting setting = PrivacySettingDao.instance().getPrivacySettingsForData(employee, privacyAware.key());
        if (setting != null && PrivacyMode.PUBLIC.equals(setting.getPrivacyMode())) {
            return true;
        }
        return false;
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

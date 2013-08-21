/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.privacy;

import info.chili.service.jrs.ServiceMessages;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.privacy.PrivacyData;
import info.yalamanchili.office.entity.privacy.PrivacyMode;
import info.yalamanchili.office.entity.privacy.PrivacySetting;
import info.yalamanchili.office.entity.profile.Employee;
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

    protected boolean performPrivacyCheck(ProceedingJoinPoint joinPoint, PrivacyData privacyData) {
        Employee employee = getEmployee(joinPoint);
        Employee currentUser = SecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return true;
        }
        if (employee != null) {
            PrivacySetting setting = PrivacySettingDao.instance().getPrivacySettingsForData(employee, privacyData);
            if (setting != null && !PrivacyMode.PUBLIC.equals(setting.getPrivacyMode())) {
                if (PrivacyMode.PRIVATE.equals(setting.getPrivacyMode())) {
                    return canAccessPrivateData(currentUser);
                }
            }

        }
        return true;
    }

    protected boolean canAccessPrivateData(Employee currentUser) {
        if ("CORPORATE_EMPLOYEE".equals(currentUser.getEmployeeType().getName())) {
            return true;
        } else {
            ServiceMessages.instance().addError(new info.chili.service.jrs.types.Error("privacy", "NOT_AUTHORIZED", "Data is hidden based on user privacy settings"));
            return false;
        }

    }

    protected Employee getEmployee(ProceedingJoinPoint joinPoint) {
        if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] instanceof Long) {
            return EmployeeDao.instance().findById((Long) joinPoint.getArgs()[0]);
        }
        return null;
    }

    public static PrivacyService instance() {
        return SpringContext.getBean(PrivacyService.class);
    }
}

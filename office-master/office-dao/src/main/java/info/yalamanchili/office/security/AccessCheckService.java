/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class AccessCheckService {

    public boolean performAccessCheck(ProceedingJoinPoint joinPoint, AccessCheck accessCheck) {
        Employee employee = (Employee) joinPoint.getArgs()[0];
        return performAccessCheck(employee, accessCheck);
    }

    public boolean performAccessCheck(Employee employee, AccessCheck accessCheck) {
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return true;
        }
        if (OfficeSecurityService.instance().hasAnyRole((String[]) accessCheck.roles())) {
            return true;
        }
        for (String cc : accessCheck.companyContacts()) {
            Employee companyContact = CompanyContactDao.instance().getCompanyContactForEmployee(employee, cc);
            if (companyContact != null && companyContact.getId().equals(currentUser.getId())) {
                return true;
            }
        }
        return false;
    }

    public static AccessCheckService instance() {
        return SpringContext.getBean(AccessCheckService.class);
    }
}

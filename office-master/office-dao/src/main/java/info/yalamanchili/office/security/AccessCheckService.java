/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.security;

import com.google.common.base.Strings;
import info.chili.commons.ReflectionUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Objects;
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
        Employee employee = null;
        if (joinPoint.getArgs()[0] == null) {
            return false;
        } else if (!Strings.isNullOrEmpty(accessCheck.employeePropertyName())) {
            employee = (Employee) ReflectionUtils.callGetter(joinPoint.getArgs()[0], accessCheck.employeePropertyName());
        } else if (joinPoint.getArgs()[0] instanceof Employee) {
            employee = (Employee) joinPoint.getArgs()[0];
        } else if (joinPoint.getArgs()[0] instanceof Long) {
            employee = EmployeeDao.instance().findById((Long) joinPoint.getArgs()[0]);
        }
        if (employee == null) {
            throw new RuntimeException("Invalid Access Check Method param");
        }
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
            boolean canAccess = canAccess(cc, employee, currentUser);
            if (canAccess) {
                return true;
            }
            if (hasContactType(cc, employee) && accessCheck.strictOrderCheck()) {
                break;
            }
        }
        return false;
    }

    protected boolean hasContactType(String companyContactType, Employee employee) {
        return CompanyContactDao.instance().getCompanyContactForEmployee(employee, companyContactType) != null;
    }

    protected boolean canAccess(String companyContactType, Employee employee, Employee currentUser) {
        Employee companyContact = CompanyContactDao.instance().getCompanyContactForEmployee(employee, companyContactType);
        while (companyContact != null) {
            if (companyContact.getId().equals(currentUser.getId())) {
                return true;
            } else if (!Objects.equals(CompanyContactDao.instance().getCompanyContactForEmployee(companyContact, companyContactType).getId(), employee.getId())) {
                return canAccess(companyContactType, companyContact, currentUser);
            }
        }
        return false;
    }

    public static AccessCheckService instance() {
        return SpringContext.getBean(AccessCheckService.class);
    }
}

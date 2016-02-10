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
import java.util.List;
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

    public boolean performAccessCheck(Object returnObj, AccessCheck accessCheck) {
        Employee employee = null;
        if (!Strings.isNullOrEmpty(accessCheck.employeePropertyName())) {
            employee = (Employee) ReflectionUtils.callGetter(returnObj, accessCheck.employeePropertyName());
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
            boolean canAccess = canAccess(cc, employee.getId(), currentUser);
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
//TODO avoid recurssion & caching?

    protected boolean canAccess(String companyContactType, Long employeeId, Employee currentUser) {
        List<Long> ids = CompanyContactDao.instance().getCompanyContactIds(employeeId, companyContactType);
        while (ids.size() > 0) {
            if (ids.contains(currentUser.getId())) {
                return true;
            } else {
                Long cc = CompanyContactDao.instance().getCompanyContactIdForEmployeeId(ids.get(0), companyContactType);
                if (cc != null && cc.equals(employeeId)) {
                    break;
                } else {
                    return canAccess(companyContactType, cc, currentUser);
                }
            }
        }
        return false;
    }

    public static AccessCheckService instance() {
        return SpringContext.getBean(AccessCheckService.class);
    }
}

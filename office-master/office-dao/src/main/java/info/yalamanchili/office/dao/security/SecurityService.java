/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.security;

import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;
import org.jasypt.digest.StandardStringDigester;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SecurityService {

    private final static Logger logger = Logger.getLogger(SecurityService.class.getName());
    @PersistenceContext
    protected EntityManager em;

//TODO move to chili-security SecurityService
    public CUser createCuser(CUser user) {
        return em.merge(user);
    }

    public Employee login(CUser user) {
        TypedQuery<Employee> query = em.createQuery("from Employee emp where emp.user.username=:userNameParam and emp.user.passwordHash=:passwordParam", Employee.class);
        query.setParameter("userNameParam", user.getUsername());
        query.setParameter("passwordParam", SecurityUtils.encodePassword(user.getPasswordHash(), null));

        try {
            Employee emp= query.getSingleResult();
            LoginSuccessListener.instance().onLoginSuccess(emp);
            return emp;
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", auth.getName());
        try {
            return getUserQuery.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        } catch (NoResultException e) {
            return null;
        }
    }

    public boolean isValidEmployeeId(String employeeId) {
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Employee findEmployee(String employeeId) {
        TypedQuery<Employee> getUserQuery = em.createQuery("from " + Employee.class.getName() + " where employeeId=:employeeIdParam", Employee.class);
        getUserQuery.setParameter("employeeIdParam", employeeId);
        if (getUserQuery.getResultList().size() > 0) {
            return getUserQuery.getResultList().get(0);
        } else {
            return null;
        }
    }

    public Employee findEmployeeBySSN(String ssn) {
        StandardStringDigester officeStringDigester = (StandardStringDigester) SpringContext.getBean("officeStringDigester");
        return QueryUtils.findEntity(em, Employee.class, "ssnHash", officeStringDigester.digest(ssn));
    }

    public String getCurrentUserId() {
        if (getCurrentUser() != null) {
            return getCurrentUser().getEmployeeId();
        } else {
            return null;
        }
    }

    public List<String> getUserRoles(Employee employee) {
        List<String> roles = new ArrayList<String>();
        for (CRole role : employee.getUser().getRoles()) {
            roles.add(role.getRolename());
        }
        return roles;
    }

    public static SecurityService instance() {
        return SpringContext.getBean(SecurityService.class);
    }
}

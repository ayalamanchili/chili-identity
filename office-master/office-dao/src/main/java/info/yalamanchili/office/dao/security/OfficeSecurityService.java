/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.security;

import info.chili.jpa.QueryUtils;
import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.chili.security.domain.CUser;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;
import org.dozer.Mapper;
import org.jasypt.digest.StandardStringDigester;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class OfficeSecurityService {

    private final static Logger logger = Logger.getLogger(OfficeSecurityService.class.getName());
    @PersistenceContext
    protected EntityManager em;

//TODO move to chili-security OfficeSecurityService
    public CUser createCuser(CUser user) {
        return em.merge(user);
    }

    public EmployeeLoginDto login(CUser user) {
        TypedQuery<Employee> query = em.createQuery("from Employee emp where emp.user.username=:userNameParam and emp.user.passwordHash=:passwordParam", Employee.class);
        query.setParameter("userNameParam", user.getUsername().toLowerCase());
        query.setParameter("passwordParam", SecurityUtils.encodePassword(user.getPasswordHash(), null));

        try {
            Mapper mapper = (Mapper) SpringContext.getBean("mapper");
            Employee emp = query.getSingleResult();
            EmployeeLoginDto res = mapper.map(emp, EmployeeLoginDto.class);
            res.setUsername(emp.getUser().getUsername());
            for (CRole role : emp.getUser().getRoles()) {
                res.getRoles().add(role.getRolename());
            }
            return res;
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

    public boolean hasAnyRole(String... roles) {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return false;
        }
        Authentication authentication = context.getAuthentication();
        if (authentication == null) {
            return false;
        }

        for (GrantedAuthority auth : authentication.getAuthorities()) {
            for (String role : roles) {
                if (role.equals(auth.getAuthority())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasRole(String role) {
        return hasAnyRole(role);
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

    public List<String> getUserRoles(Employee employee) {
        List<String> roles = new ArrayList<String>();
        for (CRole role : employee.getUser().getRoles()) {
            roles.add(role.getRolename());
        }
        return roles;
    }

    public List<Employee> getUsersWithRoles(int start, int limit, String role) {
        CRole crole = QueryUtils.findEntity(em, CRole.class, "rolename", role);
        Query query = em.createNativeQuery("SELECT * from CONTACT emp INNER JOIN CUSER cuser ON cuser.userId=emp.user_userId INNER JOIN USERROLES userRoles ON userRoles.UserId=cuser.userId where cuser.enabled= TRUE and userRoles.RoleId=" + crole.getRoleId(), Employee.class);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public void syncOfficeRoles() {
        for (OfficeRole role : OfficeRole.values()) {
            CRoleDao.instance().createRole(role.name());
        }
    }

    public CRole getRole(OfficeRole role) {
        return QueryUtils.findEntity(em, CRole.class, "rolename", role.name());
    }

    public static OfficeSecurityService instance() {
        return SpringContext.getBean(OfficeSecurityService.class);
    }
}

package info.yalamanchili.office.dao.security;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.*;
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
            return query.getSingleResult();
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

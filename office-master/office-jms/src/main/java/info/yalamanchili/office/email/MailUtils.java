/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.email;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class MailUtils {

    private final static Logger logger = Logger.getLogger(MailUtils.class.getName());
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public Set<String> getEmailsAddressesForRoles(List<String> roles) {
        Set<String> emails = new HashSet<String>();
        Query getUsersInRoleQuery = em.createQuery("select user from CUser user join user.roles role where role.rolename in (:roles)", CUser.class);
        getUsersInRoleQuery.setParameter("roles", roles);
        List<CUser> users = getUsersInRoleQuery.getResultList();
        //TODO improve the query into a single query
        for (CUser user : users) {
            TypedQuery<Employee> getEmployeeQuery = em.createQuery("from Employee where user=:userParam", Employee.class);
            getEmployeeQuery.setParameter("userParam", user);
            Employee emp = getEmployeeQuery.getSingleResult();
            emails.add(emp.getPrimaryEmail().getEmail());
        }
        logger.info("emails:" + emails);
        return emails;
    }
}

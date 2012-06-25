package info.yalamanchili.office.dao.security;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CRole;
import info.yalamanchili.office.entity.security.CUser;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public CUser login(CUser user) {
        Query findUserQuery = em.createQuery("from " + CUser.class.getCanonicalName()
                + " where username=:userNameParam and passwordHash=:passwordParam", CUser.class);
        findUserQuery.setParameter("userNameParam", user.getUsername());
        findUserQuery.setParameter("passwordParam", user.getPasswordHash());
        try {
            return (CUser) findUserQuery.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getCurrentUser() {
        CUser user = null;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Query getUserQuery = em.createQuery("from " + CUser.class.getName() + " where username=:usernameParam", CUser.class);
        getUserQuery.setParameter("usernameParam", auth.getName());
        try {
            user = (CUser) getUserQuery.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        } catch (NoResultException e) {
            return null;
        }
        return user.getEmployee();
    }

    public List<String> getEmailsAddressesForRoles(List<String> roles) {
        List<String> emails = new ArrayList<String>();
        Query getUsersInRoleQuery = em.createQuery("select user from CUser user join user.roles role where role.rolename in (:roles)", CUser.class);
        getUsersInRoleQuery.setParameter("roles", roles);
        List<CUser> users = getUsersInRoleQuery.getResultList();
        System.out.println(":-----------" + users.size());
        for (CUser user : users) {
            if (user.getEmployee().getPrimaryEmail() != null) {
                emails.add(user.getEmployee().getPrimaryEmail().getEmail());
            }
        }
        System.out.println(emails);
        return emails;
    }
}

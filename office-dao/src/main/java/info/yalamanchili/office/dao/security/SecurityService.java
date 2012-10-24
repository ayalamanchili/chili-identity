package info.yalamanchili.office.dao.security;

import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {
//TODO need to remove extended scope

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public CUser login(CUser user) {
        Query findUserQuery = em.createQuery("from " + CUser.class.getCanonicalName()
                + " where username=:userNameParam and passwordHash=:passwordParam", CUser.class);
        findUserQuery.setParameter("userNameParam", user.getUsername());
        findUserQuery.setParameter("passwordParam", SecurityUtils.encodePassword(user.getPasswordHash(), null));
        try {
            CUser s = (CUser) findUserQuery.getSingleResult();
            //TODO need to have this sice the user or roles infor is not getting refreshed
            em.refresh(s);
            return s;
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

    //TODO move to different method
    public Set<String> getEmailsAddressesForRoles(List<String> roles) {
        Set<String> emails = new HashSet<String>();
        Query getUsersInRoleQuery = em.createQuery("select user from CUser user join user.roles role where role.rolename in (:roles)", CUser.class);
        getUsersInRoleQuery.setParameter("roles", roles);
        List<CUser> users = getUsersInRoleQuery.getResultList();
        for (CUser user : users) {
            if (user.getEmployee().getPrimaryEmail() != null) {
                emails.add(user.getEmployee().getPrimaryEmail().getEmail());
            }
        }
        System.out.println(emails);
        return emails;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dto.profile;

import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.security.CUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author raghu
 */
public class EmployeeService {

    @PersistenceContext
    protected EntityManager em;

    public CUser changePassword(User user) {
        CUser user1 = null;
        javax.persistence.Query findUserQuery = em.createQuery("from CUser where username=:usernameParam and passwordHash=:passwordHashParam");
        findUserQuery.setParameter("usernameParam", user.getUserName());
        findUserQuery.setParameter("passwordHashParam ", user.getOldPassword());
        if (findUserQuery.getResultList().size() > 0) {
            user1 = (CUser) findUserQuery.getResultList().get(0);
        } else {
            //no user found means incorrect current passwrod
            return null;
        }
        user1.setPasswordHash(user.getNewPassword());
        return em.merge(user1);

    }
}

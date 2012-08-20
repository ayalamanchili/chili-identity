/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.security.CUser;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
public class EmployeeService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public CUser changePassword(Long empId, User user) {
        CUser user1 = null;
        javax.persistence.Query findUserQuery = em.createQuery("from CUser where employee.id=:empIdParam and passwordHash=:passwordHashParam");
        findUserQuery.setParameter("empIdParam", empId);
        findUserQuery.setParameter("passwordHashParam", user.getOldPassword());
        if (findUserQuery.getResultList().size() > 0) {
            user1 = (CUser) findUserQuery.getResultList().get(0);
        } else {
            //no user found means incorrect current passwrod
            return null;

        }
        user1.setPasswordHash(user.getNewPassword());
        return em.merge(user1);

    }

    public CUser ResetPassword(Long empId, User user) {
        CUser user1 = null;
        javax.persistence.Query findUserQuery = em.createQuery("from CUser where employee.id=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.security.SecurityUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
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
        findUserQuery.setParameter("passwordHashParam", SecurityUtils.encodePassword(user.getOldPassword(), null));
        if (findUserQuery.getResultList().size() > 0) {
            user1 = (CUser) findUserQuery.getResultList().get(0);
        } else {
            System.out.println("no user found");
            //no user found means incorrect current passwrod
            return null;

        }
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        return em.merge(user1);

    }

    public CUser resetPassword(Long empId, User user) {
        CUser user1 = null;
        javax.persistence.Query findUserQuery = em.createQuery("from CUser where employee.id=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
        if (findUserQuery.getResultList().size() > 0) {
            user1 = (CUser) findUserQuery.getResultList().get(0);
        } else {
            System.out.println("no user found");
            return null;

        }
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        return em.merge(user1);

    }
    
    public void deactivateUser(Long empId) {
        CUser user1 = null;
        javax.persistence.Query findUserQuery = em.createQuery("from CUser where employee.id=:empIdParam");
        findUserQuery.setParameter("empIdParam", empId);
        if (findUserQuery.getResultList().size() > 0) {
            user1 = (CUser) findUserQuery.getResultList().get(0);
        } else {
            System.out.println("no user found");
            

        }
        user1.setEnabled(false);
         em.merge(user1);

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.chili.service.jrs.exception.ServiceException;
import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.profile.notification.ProfileNotificationService;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("request")
public class EmployeeService {

    private final static Logger logger = Logger.getLogger(EmployeeService.class.getName());
    //TODO remove extended
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;
    @Autowired
    protected ProfileNotificationService profileNotificationService;

    public CUser changePassword(Long empId, User user) {
        //TODO check existing password
        CUser user1 = getEmployee(empId).getUser();
        String oldpswd = SecurityUtils.encodePassword(user.getOldPassword(), null);
        if (oldpswd.equals(user1.getPasswordHash())) {
            user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
            return em.merge(user1);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.password", "Old Password Doesn't Match");
        }

    }

    public CUser resetPassword(Long empId, User user) {
        CUser user1 = getEmployee(empId).getUser();
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        profileNotificationService.sendResetPasswordNotification(getEmployee(empId), user.getNewPassword());
        return em.merge(user1);

    }

    public void deactivateUser(Long empId) {
        CUser user1 = getEmployee(empId).getUser();
        user1.setEnabled(false);
        em.merge(user1);

    }

    public String generatepassword() {
        final int PASSWORD_LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < PASSWORD_LENGTH; x++) {
            sb.append((char) ((int) (Math.random() * 26) + 97));
        }
        return sb.toString();
    }

    private Employee getEmployee(Long empId) {
        Employee employee = em.find(Employee.class, empId);
        if (employee == null) {
            logger.warning("employee not found" + employee.getEmployeeId());
            return null;
        } else {
            return employee;
        }
    }
}

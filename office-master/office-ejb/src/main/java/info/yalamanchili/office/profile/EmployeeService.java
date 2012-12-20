/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.dto.security.User;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.security.SecurityUtils;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
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
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public CUser changePassword(Long empId, User user) {
        //TODO check existing password
        CUser user1 = getEmployee(empId).getUser();
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        return em.merge(user1);

    }

    public CUser resetPassword(Long empId, User user) {
        CUser user1 = getEmployee(empId).getUser();
        user1.setPasswordHash(SecurityUtils.encodePassword(user.getNewPassword(), null));
        return em.merge(user1);

    }

    public void deactivateUser(Long empId) {
        CUser user1 = getEmployee(empId).getUser();
        user1.setEnabled(false);
        em.merge(user1);

    }
    
     public String generatepassword()
    {
    final int PASSWORD_LENGTH = 6;  
    StringBuilder sb = new StringBuilder();  
    for (int x = 0; x < PASSWORD_LENGTH; x++)  
    {  
      sb.append((char)((int)(Math.random()*26)+97));  
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

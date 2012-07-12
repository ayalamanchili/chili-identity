/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.notification;

import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author yalamanchili
 */
@Component
public class ProfileNotificationService {

    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected MessagingService messagingService;
    @Autowired
    public EmployeeDao employeeDao;

    @Async
    public void sendNewUserCreatedNotification(CUser user) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("New System Soft Office User Created");
        String messageText = "New User " + user.getUsername().toString() + " Is Created";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendEmployeeAddressUpdatedNotification(Employee emp) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Address Updated");
        String messageText = "Employee Address For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);

    }
}

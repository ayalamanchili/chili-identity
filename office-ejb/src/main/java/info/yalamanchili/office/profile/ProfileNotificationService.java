/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile;

import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.email.Email;
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

    @Async
    public void sendNewUserCreatedNotification(CUser user) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("New System Soft Office User Created");
        email.setBody(user.getEmployee().toString());
        messagingService.sendEmail(email);
    }

    @Async
    public void sendEmployeeAddressUpdatedNotification(CUser user) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Adress Updated");
        email.setBody(user.getEmployee().toString());
        messagingService.sendEmail(email);

    }
}

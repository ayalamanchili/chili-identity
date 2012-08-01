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
import info.yalamanchili.office.entity.social.PostFile;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
/**
 *
 * @author Bapuji
 */
@Component
public class SocialNotificationService {
   
    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected MessagingService messagingService;
    @Autowired
    public EmployeeDao employeeDao;
    
    @Async
    public void sendNewCompanyPostNotification() {
        String[] roles = {"USER_ROLE,USER_HR,USER_ADMIN"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("New Post in company feed");
        String messageText = "News is posted in company feed " ;
        email.setBody(messageText);
        messagingService.sendEmail(email);

    }
    
}

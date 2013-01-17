/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.notification;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author yalamanchili
 */
@Component
@Scope("request")
public class ProfileNotificationService {
    
    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected MessagingService messagingService;
    @Autowired
    public EmployeeDao employeeDao;
    @PersistenceContext
    public EntityManager em;
    
    @Async
    public void skillSetUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Resume Updated");
        String messageText = emp.getFirstName() + " " + emp.getLastName() + "'s Resume Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
    
    @Async
    public void sendNewUserCreatedNotification(Employee employee) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("New System Soft Office User Created");
        String messageText = "New User " + employee.getFirstName() + "," + employee.getLastName() + "," + employee.getEmployeeId() + " Is Created";
        email.setBody(messageText);
        messagingService.sendEmail(email);

        // Email Intimation for User
        Email newUserEmailObj = new Email();
        info.yalamanchili.office.entity.profile.Email newUserEmail = employee.getPrimaryEmail();
        Set<String> newUserEmails = new HashSet<String>();
        newUserEmails.add(newUserEmail.getEmail());
        newUserEmailObj.setTos(newUserEmails);
        newUserEmailObj.setSubject("Welcome to System Soft Portal");
        String messageTextforuser = "Your Username and Employee Id is:" + employee.getEmployeeId() + ": and You can obtain Password by contacting HR dept. Access Portal at http://apps.sstech.us/portal";
        newUserEmailObj.setBody(messageTextforuser);
        messagingService.sendEmail(newUserEmailObj);
    }
    
    @Async
    public void sendEmployeeAddressUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE, OfficeRoles.ROLE_TIME};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Address Updated");
        String messageText = "Employee Address For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
        
    }
    
    @Async
    public void sendClientInformationUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Client Information Added/Updated");
        String messageText = "Client Information For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Added/Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
        
    }
    
    @Async
    public void sendEmergencyContactUpdateNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Emergency Contact Addition");
        String messageText = "Emergency Contact For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
    
    @Async
    public void sendForgotPasswordNotification(Employee emp, String tempPassword) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        if (emp.getPrimaryEmail() == null) {
            throw new RuntimeException("no primary email for employee");
        }
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        email.setBody("you temp password is:" + tempPassword);
        messagingService.sendEmail(email);
    }
    
    @Async
    public void feedBackNotification(Feedback fb) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        tos.add(info.yalamanchili.office.config.OfficeServiceConfiguration.instance().getAdminEmail());
        email.setTos(tos);
        String UserName = securityService.getCurrentUser().getFirstName() + securityService.getCurrentUser().getLastName();
        email.setSubject("Employee Feedback from " + UserName);
        email.setBody(fb.getFeedbackmsg());
        messagingService.sendEmail(email);
    }
    
    @Async
    public void sendNewMessageNotification(Message msg) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        for (Employee emp : msg.getTos()) {
            email.addCc(emp.getPrimaryEmail().getEmail());
        }
        email.setTos(tos);
        email.setBody("New Message Is:" + msg);
        messagingService.sendEmail(email);
    }
    
    public static ProfileNotificationService instance() {
        return SpringContext.getBean(ProfileNotificationService.class);
    }
}

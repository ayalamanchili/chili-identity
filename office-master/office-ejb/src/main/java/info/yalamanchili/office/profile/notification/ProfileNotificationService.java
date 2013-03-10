/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.notification;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.types.AccountReset;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 *
 * @author yalamanchili
 */
@Component
@Scope("prototype")
public class ProfileNotificationService {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    protected MessagingService messagingService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;

    @Async
    public void skillSetUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Resume Updated");
        String messageText = emp.getFirstName() + " " + emp.getLastName() + "'s Resume Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendNewUserCreatedNotification(Employee employee) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
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
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Address Updated");
        String messageText = "Employee Address For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendClientInformationUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Client Information Added/Updated");
        String messageText = "Client Information For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Added/Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);

    }

    @Async
    public void sendEmergencyContactUpdateNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_RECRUITER};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
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
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.email", "no primary email for employee");
        }
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        email.setBody("you temp password is:" + tempPassword);
        messagingService.sendEmail(email);
    }

    @Async
    public void feedBackNotification(Feedback fb, String username) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        tos.add(info.yalamanchili.office.config.OfficeServiceConfiguration.instance().getAdminEmail());
        email.setTos(tos);
        email.setSubject("Employee Feedback from " + username);
        email.setBody(fb.getFeedbackmsg());
        messagingService.sendEmail(email);
    }

    @Async
    public void sendAccountResetRequestNotification(AccountReset account) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Account Reset Request received");
        String messageText = "Account Reset Request received for : " + account.getFirstName() + "," + account.getLastName();
        messageText = messageText.concat("Email:" + account.getEmail() + ": PhoneNumber:" + account.getPhoneNumber());
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendAccountResetApprovedNotification(String username, String password) {
        Employee emp = mailUtils.findEmployee(username);
        if (emp != null) {
            Email email = new Email();
            Set<String> tos = new HashSet<String>();
            tos.add(emp.getPrimaryEmail().getEmail());
            email.setTos(tos);
            email.setSubject("Account Reset Complete");
            String messageText = "New account information username:" + username + ": password:" + password;
            email.setBody(messageText);
            messagingService.sendEmail(email);
        } else {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.username", "employee not found with username. pleaes re complete the task with correct username");
        }
    }

    @Async
    public void sendNewMessageNotification(Message msg) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        for (Employee emp : msg.getTos()) {
            tos.add(emp.getPrimaryEmail().getEmail());
        }
        email.setTos(tos);
        email.setSubject("New Message From The Employee:" + msg.getFromEmp().getFirstName() + "," + msg.getFromEmp().getFirstName());
        email.setBody("New Message:" + msg.getMessage());
        messagingService.sendEmail(email);
    }

    public static ProfileNotificationService instance() {
        return SpringContext.getBean(ProfileNotificationService.class);
    }
}

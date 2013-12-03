/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.profile.notification;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
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
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("Employee Skillset Updated");
        String messageText = emp.getFirstName() + " " + emp.getLastName() + "'s Skillset Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendNewUserCreatedNotification(Employee employee) {
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_RELATIONSHIP};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
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
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_HR, OfficeRoles.ROLE_EXPENSE};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("Employee Address Updated");
        String messageText = "Employee Address For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendEmergencyContactUpdateNotification(Employee emp) {
        String[] roles = {OfficeRoles.ROLE_RELATIONSHIP, OfficeRoles.ROLE_HR};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
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
        email.setSubject("Employee Temp Password");
        email.setBody("you temp password is:" + tempPassword);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendResetPasswordNotification(Employee emp, String resetPassword) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        if (emp.getPrimaryEmail() == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.email", "no primary email for employee");
        }
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        email.setSubject("Employee Reset Password");
        email.setBody("username of the employee id : " + emp.getEmployeeId() + "  and reset password is:" + resetPassword);
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
        email.setIsHtml(Boolean.TRUE);
        email.setTemplateName("default_html_email_template.html");
        messagingService.sendEmail(email);
    }

    @Async
    public void sendNewMessageNotification(Message msg) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        for (Employee emp : msg.getTos()) {
            tos.add(emp.getPrimaryEmail().getEmail());
        }
        email.setTos(tos);
        email.setSubject("Portal Message: " + msg.getSubject() + " :From:" + msg.getFromEmp().getFirstName() + "," + msg.getFromEmp().getFirstName());
        email.setBody(msg.getMessage());
        email.setTemplateName("default_html_email_template.html");
        email.setIsHtml(true);
        messagingService.sendEmail(email);
    }

    public static ProfileNotificationService instance() {
        return SpringContext.getBean(ProfileNotificationService.class);
    }
}

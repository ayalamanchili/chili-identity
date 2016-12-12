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
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.chili.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.Feedback.Feedback;
import info.yalamanchili.office.entity.message.Message;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void skillSetUpdatedNotification(Employee emp) {
        String[] roles = {OfficeRole.ROLE_RECRUITER.name()};
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("Employee Skillset Updated");
        String messageText = emp.getFirstName() + " " + emp.getLastName() + "'s Skillset Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    @Transactional
    public void sendNewUserCreatedNotification(Employee currentEmployee, Employee employee) {
        String[] roles = {OfficeRole.ROLE_ADMIN.name(), OfficeRole.ROLE_HR.name(), OfficeRole.ROLE_RELATIONSHIP.name()};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("New System Soft Office User Created");
        String messageText = "New " + employee.getEmployeeType().getName() + " has been Created.. \n Employee Name is: " + employee.getFirstName() + "  " + employee.getLastName() + " \n Employee Id is: " + employee.getEmployeeId();
        if (currentEmployee != null) {
            messageText = messageText.concat(" \n Created By " + currentEmployee.getFirstName() + " " + currentEmployee.getLastName());
        }
        String messageTxt = messageText.replaceAll("[^a-zA-Z0-9\\.;:_ ,]+", " ");
        email.setBody(messageTxt);
        messagingService.sendEmail(email);

        // Email Intimation for User
        Email newUserEmailObj = new Email();
        newUserEmailObj.setRichText(Boolean.TRUE);
        newUserEmailObj.setHtml(Boolean.TRUE);
        newUserEmailObj.addTo(EmployeeDao.instance().getPrimaryEmail(employee));
        newUserEmailObj.setSubject("Welcome to System Soft Portal");
        Map<String, Object> emailCtx = new HashMap<>();
        emailCtx.put("employeeId", employee.getEmployeeId());
        newUserEmailObj.setContext(emailCtx);
        newUserEmailObj.setTemplateName("new_employee_notification_template.html");
        messagingService.sendEmail(newUserEmailObj);
    }

    @Async
    @Transactional(readOnly = true)
    public void sendResetPasswordNotification(Employee emp, String resetPassword) {
        emp = EmployeeDao.instance().findById(emp.getId());
        Email email = new Email();
        String primaryEmail = EmployeeDao.instance().getPrimaryEmail(emp);
        if (primaryEmail == null) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.email", "no primary email for employee");
        }
        email.addTo(primaryEmail);
        email.setHtml(Boolean.TRUE);
        email.setRichText(Boolean.TRUE);
        email.setSubject("Employee Password Reset");
        email.setBody("<b>Your password has been reset</br></br><i>Username</i></b>: " + emp.getEmployeeId() + "</br><b><i>Password</i></b>: " + resetPassword + "</br> please change your password after you login from your profile </br> Portal URL: https://apps.sstech.us/portal");
        messagingService.sendEmail(email);
    }

    @Async
    @Transactional
    public void feedBackNotification(Feedback fb, String username) {
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        tos.add(info.yalamanchili.office.config.OfficeServiceConfiguration.instance().getAdminEmail());
        email.setTos(tos);
        email.setSubject("Employee Feedback from " + username);
        email.setBody(fb.getFeedbackmsg());
        email.setRichText(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    @Async
    @Transactional
    public void sendNewMessageNotification(Message msg) {
        Email email = new Email();
        for (Employee emp : msg.getTos()) {
            email.addTo(EmployeeDao.instance().getPrimaryEmail(emp));
        }
        email.setSubject("Portal Message: " + msg.getSubject() + " :From:" + msg.getFromEmp().getFirstName() + "," + msg.getFromEmp().getLastName());
        email.setBody(msg.getMessage());
        email.setHtml(true);
        email.setRichText(Boolean.TRUE);
        messagingService.sendEmail(email);
    }

    @Async
    @Transactional
    public void sendEmployeeDeactivationNotification(String deactivateBy, Employee emp) {
        String[] roles = {OfficeRole.ROLE_ADMIN.name(), OfficeRole.ROLE_HR_ADMINSTRATION.name(), OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRole.ROLE_CONSULTANT_TIME_ADMIN.name()};
        Email email = new Email();
        email.setHtml(Boolean.TRUE);
        email.setTos(mailUtils.getEmailsAddressesForRoles(roles));
        email.setSubject("Employee Deactivated ");
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String messageText = "Employee  " + emp.getFirstName() + "," + emp.getLastName() + " Account Is Deactivated by:" + deactivateBy + "; End Date: " + sdf.format(emp.getEndDate());
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    public static ProfileNotificationService instance() {
        return SpringContext.getBean(ProfileNotificationService.class);
    }
}

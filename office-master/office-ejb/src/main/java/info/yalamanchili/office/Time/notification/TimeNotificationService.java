/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time.notification;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
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
 * @author Prashanthi
 */
@Component
@Scope("prototype")
public class TimeNotificationService {

    @Autowired
    protected MailUtils mailUtils;
    @Autowired
    protected MessagingService messagingService;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;

    @Async
    public void sendOvertimeRequestSubmitedNotification(Employee emp) {
        //send email to roles ROLE_TIME,ROLE_EXPENSE,ROLE_ADMIN
        //subject "Overtime Pay request submited for [add employee name]"
        //body "overtime Pay request submited for empleyee name  please go to my tasks to complete the task to approve or deny.
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_EXPENSE};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Overtime Pay request submited for" + emp.getFirstName() + " " + emp.getLastName());
        String messageText = "'overtime Pay request submited for empleyee name  please go to my tasks to complete the task to approve or deny.";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendOvertimeRequestApprovedNotification(Employee emp, String reason) {
        //send email to roles ROLE_TIME,ROLE_EXPENSE,ROLE_ADMIN
        //subject "Overtime Pay request was approved]"
        //new line
        //reason is: reason
        String[] roles = {OfficeRoles.ROLE_ADMIN, OfficeRoles.ROLE_TIME, OfficeRoles.ROLE_EXPENSE};
        Email email = new Email();
        email.setTos(mailUtils.getEmailsAddressesForRoles(Arrays.asList(roles)));
        Set<String> tos = new HashSet<String>();
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        email.setSubject("Overtime Pay request was approved " + emp.getFirstName() + "," + emp.getLastName());
        email.setBody("reason is:" + reason);
        messagingService.sendEmail(email);
    }

    @Async
    public void sendOvertimeRequestDeniedNotification(Employee emp, String reason) {
        //send email to just employee email
        //subject "Your Overtime Pay request was denied"
        //body "overtime Pay request submited was denied
        //ne line
        //reason is: reason
        Email email = new Email();
        Set<String> tos = new HashSet<String>();
        tos.add(emp.getPrimaryEmail().getEmail());
        email.setTos(tos);
        email.setSubject("Your Overtime Pay request was denied" + emp.getFirstName() + "," + emp.getLastName());
        email.setBody("overtime Pay request submited was denied:" + reason);
        messagingService.sendEmail(email);
    }

    public static TimeNotificationService instance() {
        return SpringContext.getBean(TimeNotificationService.class);
    }
}

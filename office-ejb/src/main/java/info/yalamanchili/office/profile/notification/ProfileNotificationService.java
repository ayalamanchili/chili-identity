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
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    @PersistenceContext
    public EntityManager em;
    
    @Async
    public void skillSetUpdatedNotification(Employee emp) {
        String[] roles = {"ROLE_RECRUITER"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Resume Updated");
        String messageText = emp.getFirstName() + " " + emp.getLastName()  + "'s Resume Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);
    }
    @Async
    public void sendNewUserCreatedNotification(CUser user) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("New System Soft Office User Created");
        String messageText = "New User " + user.getUsername().toString() + " Is Created";
        email.setBody(messageText);
        messagingService.sendEmail(email);
        
        // Email Intimation for User
        Email emailUser = new Email();
        emailUser.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        emailUser.setSubject("Welcome to System Soft Portal");
        String messageTextforuser = "Your Username and Employee Id are" + user.getUsername().toString() + " and You can obtain Password from HR to access our portal at http://apps.sstech.us/portal";
        emailUser.setBody(messageTextforuser);
    }

    @Async
    public void sendEmployeeAddressUpdatedNotification(Employee emp) {
        String[] roles = {"ROLE_ADMIN", "ROLE_HR","ROLE_ACCOUNTANT","ROLE_PAYROLL"};
        Email email = new Email();
        email.setTos(securityService.getEmailsAddressesForRoles(Arrays.asList(roles)));
        email.setSubject("Employee Address Updated");
        String messageText = "Employee Address For The Employee " + emp.getFirstName() + "," + emp.getLastName() + " Is Updated";
        email.setBody(messageText);
        messagingService.sendEmail(email);

    }
    public void BirthdayNotification()
    {
       javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + "where  day(dateOfBirth.dateTime) = :date and month(dateOfBirth.dateTime) = :month ");
       findUserQuery.setParameter("date", Calendar.getInstance().DATE);
       findUserQuery.setParameter("month", Calendar.getInstance().MONTH);
       
       List lstResult = findUserQuery.getResultList();
        for (int i = 0; i < lstResult.size(); i++) {
            Employee empres = new  Employee();
             Set<String> emailto = new HashSet<String>();
             Email email = new Email();
             emailto.add(empres.getPrimaryEmail().getEmail());
             email.setTos(emailto);
             email.setSubject("Birthday Wishes");
             String messageText = "SystemSoft Technologies Wishes a very Happy Birthday to " + empres.getFirstName() + "," + empres.getLastName();
             email.setBody(messageText);
             messagingService.sendEmail(email);
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.task;

import info.yalamanchili.commons.DateUtils;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This class contains tasks that are triggered by scheduler
 *
 * @author ayalamanchili
 */
public class TaskService {

    @PersistenceContext
    public EntityManager em;
    @Autowired
    protected MessagingService messagingService;

//    public void birthdayNotification() {
//        System.out.println("----------------RUNNING BIRTHDAY NOTIFICATION---------------");
//        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where  Day_Only(dateOfBirth) = :date and calendar_month(dateOfBirth) = :month ");
//        findUserQuery.setParameter("date", Calendar.getInstance().DATE);
//        findUserQuery.setParameter("month", Calendar.getInstance().MONTH);
//
//        List lstResult = findUserQuery.getResultList();
//        for (int i = 0; i < lstResult.size(); i++) {
//            Employee empres = new Employee();
//            Set<String> emailto = new HashSet<String>();
//            Email email = new Email();
//            emailto.add(empres.getPrimaryEmail().getEmail());
//            email.setTos(emailto);
//            email.setSubject("Birthday Wishes");
//            String messageText = "SystemSoft Technologies Wishes a very Happy Birthday to " + empres.getFirstName() + "," + empres.getLastName();
//            email.setBody(messageText);
//            messagingService.sendEmail(email);
//        }
//    }
     public void birthdayNotification() {
        System.out.println("----------------RUNNING BIRTHDAY NOTIFICATION---------------");
        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName());

        
        List lstResult = findUserQuery.getResultList();
        Iterator itr = lstResult.iterator();
        while(itr.hasNext()) {
            Employee empres = new Employee();
            empres = ((Employee)itr.next());
            if((empres.getDateOfBirth().getDate() == Calendar.getInstance().DATE)&&(empres.getDateOfBirth().getMonth() == Calendar.getInstance().MONTH))
            {
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
}

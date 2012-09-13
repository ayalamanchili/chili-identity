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
import javax.persistence.PersistenceContextType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This class contains tasks that are triggered by scheduler
 *
 * @author ayalamanchili
 */
public class TaskService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;
    @Autowired
    protected MessagingService messagingService;

    public void birthdayNotification() {
        System.out.println("----------------RUNNING BIRTHDAY NOTIFICATION---------------");
        System.out.println("day :" + Calendar.getInstance().DATE);
        System.out.println("month :" + Calendar.getInstance().MONTH);
        
        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where  day(dateOfBirth) = 13 and month(dateOfBirth) = 9 ");
        findUserQuery.setParameter("date1", Calendar.getInstance().DATE);
        findUserQuery.setParameter("month1", Calendar.getInstance().MONTH);

        List lstResult = findUserQuery.getResultList();
         Iterator itr = lstResult.iterator();
        while(itr.hasNext()) {
            Employee empres = new Employee();
            empres = ((Employee)itr.next());
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
//     public void birthdayNotification() {
//        System.out.println("----------------RUNNING BIRTHDAY NOTIFICATION---------------");
//        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName());
//
//        
//        List lstResult = findUserQuery.getResultList();
//        Iterator itr = lstResult.iterator();
//        while(itr.hasNext()) {
//            Employee empres = new Employee();
//            empres = ((Employee)itr.next());
//            if((empres.getDateOfBirth().getDate() == Calendar.getInstance().DATE)&&(empres.getDateOfBirth().getMonth() == Calendar.getInstance().MONTH))
//            {
//                Set<String> emailto = new HashSet<String>();
//                Email email = new Email();
//                emailto.add(empres.getPrimaryEmail().getEmail());
//                email.setTos(emailto);
//                email.setSubject("Birthday Wishes");
//                String messageText = "SystemSoft Technologies Wishes a very Happy Birthday to " + empres.getFirstName() + "," + empres.getLastName();
//                email.setBody(messageText);
//                messagingService.sendEmail(email);
//            }
//        }
//    }
}

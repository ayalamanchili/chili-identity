/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.task;

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

/**
 * This class contains tasks that are triggered by scheduler
 *
 * @author ayalamanchili
 */
//TODO rename this scheduling service?
public class TaskService {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    public EntityManager em;
    @Autowired
    protected MessagingService messagingService;

    public void birthdayNotification() {
        System.out.println("----------------RUNNING BIRTHDAY NOTIFICATION---------------");
        System.out.println("day :" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        int monthb = Calendar.getInstance().get(Calendar.MONTH);
        monthb = monthb + 1;
        System.out.println("month :" + monthb);

        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where  day(dateOfBirth)=:date1 and month(dateOfBirth)=:month1 ");
        findUserQuery.setParameter("date1", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        findUserQuery.setParameter("month1", monthb);

        List lstResult = findUserQuery.getResultList();
        Iterator itr = lstResult.iterator();
        while (itr.hasNext()) {
            Employee empres = new Employee();
            empres = ((Employee) itr.next());
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

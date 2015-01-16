/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.task;

import info.yalamanchili.office.Time.AssociateTimeAccuralService;
import info.yalamanchili.office.Time.CorporateTimeAccuralService;
import info.yalamanchili.office.Time.TimeJobService;
import info.yalamanchili.office.dao.profile.EmployeeDao;
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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class contains tasks that are triggered by scheduler
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class OfficeSchedulerService {

    @PersistenceContext
    public EntityManager em;

    /**
     * runs every night at 1.07 AM
     */
    @Scheduled(cron = "0 7 1 * * ?")
    public void sendTodaysLeaveNotifications() {
        TimeJobService.instance().sendTodaysLeaveNotifications();
    }

    /**
     * runs at 1'0 clock every month to accumulate monthly earned PTO,
     */
//    @Scheduled(cron = "0 1 1 * * ?")
    public void accuredMonthlyTime() {
        CorporateTimeAccuralService.instance().accureMonthlyTime();
        AssociateTimeAccuralService.instance().accureMonthlyConsTime();
    }

    /**
     * run at jan 1st 1'0 clock every year to accumulate Yearly Hours,
     */
    @Scheduled(cron = "0 1 1 1 0 ?")
    public void accuredtimeforIndiaemployee() {
        CorporateTimeAccuralService.instance().accureMonthlyTime();
    }

    /**
     * runs every night at 1.10 AM
     */
    @Scheduled(cron = "0 10 1 * * ?")
    public void birthdayNotification() {
        int monthb = Calendar.getInstance().get(Calendar.MONTH);
        monthb = monthb + 1;
        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where  user.enabled= TRUE and day(dateOfBirth)=:date1 and month(dateOfBirth)=:month1 ");
        findUserQuery.setParameter("date1", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        findUserQuery.setParameter("month1", monthb);
        List lstResult = findUserQuery.getResultList();
        Iterator itr = lstResult.iterator();
        while (itr.hasNext()) {
            Employee empres = null;
            empres = ((Employee) itr.next());
            //TODO enhance it to collect all emails and send once
            if (empres.isActive()) {
                Set<String> emailto = new HashSet<String>();
                Email email = new Email();
                emailto.add(EmployeeDao.instance().getPrimaryEmail(empres));
                email.setTos(emailto);
                email.setSubject("Birthday Wishes");
                String messageText = "SystemSoft Technologies Wishes a very Happy Birthday to " + empres.getFirstName() + "," + empres.getLastName();
                email.setBody(messageText);
                MessagingService.instance().sendEmail(email);
            }
        }
    }
}

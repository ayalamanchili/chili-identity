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
import info.yalamanchili.office.dao.employee.statusreport.CorporateStatusReportDao;
import info.yalamanchili.office.dao.message.NotificationGroupDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.TimePeriodDao;
import info.chili.email.Email;
import info.yalamanchili.office.client.InvoiceScheduleService;
import info.yalamanchili.office.dao.profile.EmployeeDto;
import info.yalamanchili.office.employee.probeval.ProbationPeriodEvaluationInitiator;
import info.yalamanchili.office.entity.message.NotificationGroup;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.jms.MessagingService;
import info.yalamanchili.office.prospect.ProspectService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public Mapper mapper;

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
    @Scheduled(cron = "0 0 1 1 * ?")
    public void accuredMonthlyTime() {
        CorporateTimeAccuralService.instance().accureMonthlyTime();
        AssociateTimeAccuralService.instance().accureMonthlyConsTime();
    }

    /**
     * runs 10 15 AM every WEDNESDAY
     */
    @Scheduled(cron = "0 15 10 ? * WED")
    public void syncWeeklyTimePeriods() {
        TimePeriodDao.instance().syncWeeklyTimePeriods();
    }

    /**
     * runs 3 15 PM every Monday
     */
    @Scheduled(cron = "0 15 15 ? * MON")
    public void sendWeeklyStatusReportsRemainder() {
        CorporateStatusReportDao.instance().notSubmittedEmailNotification();
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
        if (lstResult != null && lstResult.size() > 0) {
            List<EmployeeDto> dtos = new ArrayList();
            for (Object emp : lstResult) {
                Employee employee = (Employee) emp;
                if (employee.isActive() == true) {
                    dtos.add(EmployeeDto.map(mapper, employee));
                }
            }
            NotificationGroup ng = NotificationGroupDao.instance().findByName(BIRTHDAY_ANNUAL_NOTIFICATION_GROUP);
            if (ng != null) {
                Email email1 = new Email();
                Set<String> emailto1 = new HashSet<String>();
                for (Employee emp : ng.getEmployees()) {
                    if (emp.isActive() == true) {
                        emailto1.add(emp.getPrimaryEmail().getEmail());
                    }
                }
                email1.setTos(emailto1);
                email1.setSubject("Birthday Wishes on :" + new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
                HashMap<String, Object> emailContext = new HashMap();
                emailContext.put("employees", dtos);
                emailContext.put("isAnniversary", "false");
                email1.setContext(emailContext);
                email1.setTemplateName("birthday_annual_notification_template.html");
                MessagingService.instance().sendEmail(email1);
            }
            Iterator itr = lstResult.iterator();
            while (itr.hasNext()) {
                Employee empres = null;
                empres = ((Employee) itr.next());
                //TODO enhance it to collect all emails and send once
                Set<String> emailto = new HashSet<String>();
                Email email = new Email();
                if (empres.isActive() == true) {
                    emailto.add(EmployeeDao.instance().getPrimaryEmail(empres));
                }
                email.setTos(emailto);
                email.setSubject("Birthday Wishes To");
                String messageText = "System Soft Technologies Wishes a very Happy Birthday to " + empres.getFirstName() + "," + empres.getLastName();
                email.setBody(messageText);
                MessagingService.instance().sendEmail(email);
            }
        }
    }

    /**
     * runs every night at 1.20 AM
     */
    @Scheduled(cron = "0 20 1 * * ?")
    public void initiateProbationPeriodEvaluations() {
        ProbationPeriodEvaluationInitiator.instance().initiateNewHireProbationPeriodEvaluations();
    }
    public static final String BIRTHDAY_ANNUAL_NOTIFICATION_GROUP = "Birthday_Annual_Notification_Group";

    @Scheduled(cron = "0 30 1 * * ?")
    public void anniversaryNotification() {
        int monthb = Calendar.getInstance().get(Calendar.MONTH);
        monthb = monthb + 1;
        javax.persistence.Query findUserQuery = em.createQuery("from " + Employee.class.getCanonicalName() + " where  user.enabled= TRUE and day(startDate)=:date1 and month(startDate)=:month1 ");
        findUserQuery.setParameter("date1", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        findUserQuery.setParameter("month1", monthb);
        List lstResult = findUserQuery.getResultList();
        if (lstResult != null && lstResult.size() > 0) {
            List<EmployeeDto> dtos = new ArrayList();
            for (Object emp : lstResult) {
                Employee employee = (Employee) emp;
                if (employee.isActive() == true) {
                    EmployeeDto dto = EmployeeDto.map(mapper, employee);
                    Calendar date1 = Calendar.getInstance();
                    date1.setTime(employee.getStartDate());
                    Calendar date2 = Calendar.getInstance();
                    dto.setNoOfYears(yearsBetween(date1, date2));
                    dtos.add(dto);
                }
            }
            NotificationGroup ng = NotificationGroupDao.instance().findByName(BIRTHDAY_ANNUAL_NOTIFICATION_GROUP);
            if (ng != null) {
                Email email1 = new Email();
                Set<String> emailto1 = new HashSet<String>();
                for (Employee emp : ng.getEmployees()) {
                    if (emp.isActive() == true) {
                        emailto1.add(emp.getPrimaryEmail().getEmail());
                    }
                }
                email1.setTos(emailto1);
                email1.setSubject("Anniversary Wishes on :" + new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
                HashMap<String, Object> emailContext = new HashMap();
                emailContext.put("employees", dtos);
                emailContext.put("isAnniversary", "true");
                email1.setContext(emailContext);
                email1.setTemplateName("birthday_annual_notification_template.html");
                MessagingService.instance().sendEmail(email1);
            }
            Iterator itr = lstResult.iterator();
            while (itr.hasNext()) {
                Employee empres = null;
                empres = ((Employee) itr.next());
                Calendar date1 = Calendar.getInstance();
                date1.setTime(empres.getStartDate());
                Calendar date2 = Calendar.getInstance();

                int years = yearsBetween(date1, date2);
                //TODO enhance it to collect all emails and send once

                if (years > 0 && empres.isActive()) {
                    Set<String> emailto = new HashSet<String>();
                    Email email = new Email();
                    email.setHtml(Boolean.TRUE);
                    if (empres.isActive() == true) {
                        emailto.add(EmployeeDao.instance().getPrimaryEmail(empres));
                    }
                    email.setTos(emailto);
                    email.setSubject("Anniversary Wishes");
                    String messageText = "Congratulations " + empres.getFirstName() + "," + empres.getLastName() + " on " + years + " year(s) Anniversary with System Soft Technologies. "
                            + "Thank you for being a part of our SSTech family & wish you more successful years.";
                    email.setBody(messageText);
                    MessagingService.instance().sendEmail(email);
                }
            }
        }
    }

    public static int yearsBetween(Calendar date1, Calendar date2) {
        int years = 0;
        //difference in of years
        if (date2.get(Calendar.MONTH) == date1.get(Calendar.MONTH)) {
            years = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
        }
        return years;
    }

    /**
     * runs every night at 1.15 AM
     */
    @Scheduled(cron = "0 15 1 * * ?")
    public void sendProspectStatusNotChangeNotification() {
        ProspectService.instance().sendProspectStatusNotChangeNotification();
    }

    /**
     * runs 2 15 PM every Monday
     */
    @Scheduled(cron = "0 15 2 ? * MON")
    public void sendBenchProspectsWeeklyNotification() {
        ProspectService.instance().sendBenchProspectsWeeklyNotification();
    }

    /**
     * runs every night at 2.00 AM
     */
    @Scheduled(cron = "0 0 2 * * ?")
    public void sendInvoiceReminderToBillingTeam() {
        InvoiceScheduleService.instance().sendReminderInvoiceNotification();
    }
}

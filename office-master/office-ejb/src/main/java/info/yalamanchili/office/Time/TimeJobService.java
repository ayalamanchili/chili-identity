/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.commons.DateUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.email.Email;
import info.yalamanchili.office.email.MailUtils;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.CorporateTimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import info.yalamanchili.office.entity.time.TimeSheetStatus;
import info.yalamanchili.office.jms.MessagingService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Component
@Transactional
public class TimeJobService {

    @PersistenceContext
    protected EntityManager em;

    /**
     *
     */
    public void sendTodaysLeaveNotifications() {
        TypedQuery<CorporateTimeSheet> query = em.createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where status=:statusParam and category in (:categoryParam) and startDate =:startDateParam", CorporateTimeSheet.class);
        query.setParameter("statusParam", TimeSheetStatus.Approved);
        query.setParameter("categoryParam", TimeSheetCategory.getLeaveSpentCategories());
        query.setParameter("startDateParam", new Date(), TemporalType.DATE);
        for (CorporateTimeSheet ts : query.getResultList()) {
            Employee emp = CompanyContactDao.instance().getCompanyContactForEmployee(ts.getEmployee(), "Reports_To");
            Email email = new Email();
            email.addTo(EmployeeDao.instance().getPrimaryEmail(emp));
            email.setSubject("Leave Remainder: " + ts.getEmployee().getFirstName() + " is on leave");
//            String messageText = "TODO add timesheet details here";
            String messageText = "Time Sheet Hours" + ts.getHours() + ", Category" + ts.getCategory() + ", StartDate" + ts.getStartDate() + ", EndDate" + ts.getEndDate() + " details ";
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
    }

    public static TimeJobService instance() {
        return SpringContext.getBean(TimeJobService.class);
    }
}

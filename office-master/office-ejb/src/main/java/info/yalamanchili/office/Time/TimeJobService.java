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
     * This method will create prepopulated timesheet periods
     */
    public void syncTimeSheetPeriods() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int year = currentYear - 3; year < currentYear + 1; year++) {
            for (int month = 0; month < 12; month++) {
                TimeSheetPeriodDao.instance().createTimePeriod(year, month);
            }
        }
    }

    /**
     * this method will update pending and saved time sheets to approved upon
     * the start date equal to current date for emps who have not completed 1
     * year.
     *
     */
    public void approveNewCorpEmployeeTimeSheets() {
        List<CorporateTimeSheet> approvedts = new ArrayList<CorporateTimeSheet>();
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 2000, OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (emp.getStartDate() != null && new Date().before(DateUtils.getNextYear(DateUtils.getLastDayOfYear(emp.getStartDate()), 1))) {
                for (CorporateTimeSheet ts : CorporateTimeSheetDao.instance().getTimeSheetsForEmployee(emp, TimeSheetStatus.getPendingAndSavedCategories(), TimeSheetCategory.getEarnedCategories())) {
                    if (ts.getBpmProcessId() == null && ts.getStartDate().before(new Date())) {
                        ts.setStatus(TimeSheetStatus.Approved);
                        approvedts.add(CorporateTimeSheetDao.instance().save(ts));
                    }
                }
            }
        }
        if (approvedts.size() > 0) {
            sendApprovedTimeSheetsEmail(approvedts);
        }
    }

    protected void sendApprovedTimeSheetsEmail(List<CorporateTimeSheet> timesheets) {
        Email email = new Email();
        email.setTos(MailUtils.instance().getEmailsAddressesForRoles(OfficeRole.ROLE_HR_ADMINSTRATION.name()));
        email.setSubject("System Approved the following TimeSheets for New Employees");
        email.setHtml(Boolean.TRUE);
        StringBuilder sb = new StringBuilder();
        for (CorporateTimeSheet ts : timesheets) {
            sb.append(ts.describe()).append("\n");
        }
        email.setBody(sb.toString());
        MessagingService.instance().sendEmail(email);
    }

    /**
     *
     */
    public void sendTodaysLeaveNotifications() {
        TypedQuery<CorporateTimeSheet> query = em.createQuery("from " + CorporateTimeSheet.class.getCanonicalName() + " where status=:statusParam and category in (:categoryParam) and startDate =:startDateParam", CorporateTimeSheet.class);
        query.setParameter("statusParam", TimeSheetStatus.Approved);
        query.setParameter("categoryParam", TimeSheetCategory.getLeaveSpentCategories());
        query.setParameter("startDateParam", new Date(), TemporalType.DATE);
        for (CorporateTimeSheet ts : query.getResultList()) {
            Employee emp = CompanyContactDao.instance().getReportsToContactForEmployee(ts.getEmployee());
            Email email = new Email();
            email.addTo(EmployeeDao.instance().getPrimaryEmail(emp));
            email.setSubject("Leave Remainder: " + ts.getEmployee().getFirstName() + " is on leave");
//            String messageText = "TODO add timesheet details here";
            String messageText = "Time Sheet Hours" + ts.getHours() + ", Category" + ts.getCategory() + ", StartDate" + ts.getStartDate() + ", EndDate" + ts.getEndDate() + " details ";
            email.setBody(messageText);
            MessagingService.instance().sendEmail(email);
        }
    }

    /**
     * This will create yearly PTO,vacation days for corp
     * employees
     */
    public void processCorpEmpYearlyEarnedTimeSheets() {
        //TODO also create prorate hours for emp who passed probation period
        for (Employee emp : OfficeSecurityService.instance().getUsersWithRoles(0, 5000, OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
            if (hasMoreThanOneYearService(emp)) {
                //8 days(64 hours) PTO earned
                CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.PTO_Earned, CorporateTimeConstants.ptoEarned, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                //10 days(80 hours) vacation earned
                CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_Earned, CorporateTimeConstants.vacationEarned, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                //Get Available Vacation in previous year and Create carry forword for max of 5days--> 40 hours
                BigDecimal carryFwdVacation = CorporateTimeService.instance().getYearlyVacationBalance(emp, DateUtils.getNextYear(new Date(), -1));
                if (carryFwdVacation.longValue() >= CorporateTimeConstants.carryForward.longValue()) {
                    CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_CarryForward, CorporateTimeConstants.carryForward, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                } else {
                    CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_CarryForward, carryFwdVacation, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                }
            }
        }
    }

    /**
     * This will create yearly PTO,vacation days for Consultant
     * Employees
     */
    public void processConsultantEmpYearlyEarnedTimeSheets() {
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Employee")) {
            if (hasMoreThanOneYearService(emp)) {
                //8 days(64 hours) PTO earned
                ConsultantTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.PTO_Earned, ConsultantTimeContstants.ptoEarned, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                //10 days(80 hours) vacation earned
                ConsultantTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_Earned, ConsultantTimeContstants.vacationEarned, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                //Get Available Vacation in previous year and Create carry forword for max of 5days--> 40 hours
                BigDecimal carryFwdVacation = ConsultantTimeService.instance().getYearlyVacationBalance(emp, DateUtils.getNextYear(new Date(), -1));
                if (carryFwdVacation.longValue() >= ConsultantTimeContstants.carryForward.longValue()) {
                    ConsultantTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_CarryForward, ConsultantTimeContstants.carryForward, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                } else {
                    ConsultantTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_CarryForward, carryFwdVacation, DateUtils.getFirstDayOfCurrentYear(), DateUtils.getLastDayCurrentOfYear());
                }
            }
        }
    }

    protected boolean isInProbationPeriod(Employee emp) {
        //TODO check for null start date
        if (DateUtils.getNextMonth(emp.getStartDate(), 2).before(new Date())) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean hasMoreThanOneYearService(Employee emp) {
        //TODO possible bug for leap year???
        if (emp.getStartDate() != null && DateUtils.getNextYear(emp.getStartDate(), 1).before(new Date())) {
            return true;
        } else {
            return false;
        }
    }

    public static TimeJobService instance() {
        return SpringContext.getBean(TimeJobService.class);
    }
}

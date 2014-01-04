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
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheetCategory;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
     * This will create yearly sick,vacation and personal days for corp
     * employees
     */
    public void processYearlyEarnedTimeSheets() {
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
            if (hasMoreThanOneYearService(emp)) {
                //TODO externalize values of days/hours
                //4 days(32 hours) Personal earned
                CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Personal_Earned, new BigDecimal(32), DateUtils.getFirstDayOfYear(new Date().getYear()), DateUtils.getLastDayOfYear(new Date().getYear()));
                //4 days(32 hours) Sick earned
                CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Sick_Earned, new BigDecimal(32), DateUtils.getFirstDayOfYear(new Date().getYear()), DateUtils.getLastDayOfYear(new Date().getYear()));
                //10 days(80 hours) vacation earned
                CorporateTimeSheetDao.instance().saveTimeSheet(emp, TimeSheetCategory.Vacation_Earned, new BigDecimal(80), DateUtils.getFirstDayOfYear(new Date().getYear()), DateUtils.getLastDayOfYear(new Date().getYear()));
            }
        }
    }

    protected boolean hasMoreThanOneYearService(Employee emp) {
        //TODO possible bug for leap year???
        if (DateUtils.getNextYear(emp.getStartDate(), 1).before(new Date())) {
            return true;
        } else {
            return false;
        }
    }

    public static TimeJobService instance() {
        return SpringContext.getBean(TimeJobService.class);
    }
}

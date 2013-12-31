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
import info.yalamanchili.office.dao.time.TimeSheetPeriodDao;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
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
    public void processYearlyLeaves() {

    }

    protected boolean hasMoreThanOneYearService(Employee emp) {
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

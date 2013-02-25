/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
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
                createTimePeriod(year, month);
            }
        }
    }

    protected void createTimePeriod(int year, int month) {
        if (getTimePeriod(year, month) == null) {
            TimeSheetPeriod tp = new TimeSheetPeriod();

            Calendar startDate = Calendar.getInstance();
            startDate.set(year, month, 1);

            Calendar endDate = Calendar.getInstance();
            endDate.set(year, month, getLastDayOfMonth(month));

            tp.setStartDate(startDate.getTime());
            tp.setEndDate(endDate.getTime());

            SimpleDateFormat formatter = new SimpleDateFormat("MMMM, yyyy", Locale.US);
            tp.setName(formatter.format(startDate.getTime()).toString());
            em.merge(tp);
        }
    }

    public TimeSheetPeriod getTimePeriod(int year, int month) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(year, month, 1);

        Calendar endDate = Calendar.getInstance();
        endDate.set(year, month, getLastDayOfMonth(month));

        TypedQuery<TimeSheetPeriod> qry = em.createQuery("from " + TimeSheetPeriod.class.getCanonicalName() + " where startDate=:startDateParam and endDate=:endDateParam", TimeSheetPeriod.class);
        qry.setParameter("startDateParam", startDate.getTime(), TemporalType.DATE);
        qry.setParameter("endDateParam", endDate.getTime(), TemporalType.DATE);
        if (qry.getResultList().size() > 0) {
            return qry.getResultList().get(0);
        } else {
            return null;
        }
    }

    protected int getLastDayOfMonth(int month) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.MONTH, month);
        return date.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static TimeJobService instance() {
        return SpringContext.getBean(TimeJobService.class);
    }
}

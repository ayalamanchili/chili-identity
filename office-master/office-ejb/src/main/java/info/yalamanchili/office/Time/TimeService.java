/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.Time;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dto.time.TimeSummary;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.AdjustmentHours;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("request")
public class TimeService {

    @PersistenceContext
    protected EntityManager em;

    public TimeSummary getTimeSummary(Employee emp) {
        TimeSummary ts = new TimeSummary();
        //Get sum of quick books and adp hours.
        String adpAndQBHoursQueryString = "SELECT SUM(quickBooksHours), SUM(adpHours) FROM TimeSheet WHERE employee=:employeeparam ";
        Query adpAbdQBHoursQuery = em.createQuery(adpAndQBHoursQueryString);
        adpAbdQBHoursQuery.setParameter("employeeparam", emp);
        Object[] row = (Object[]) adpAbdQBHoursQuery.getSingleResult();
        ts.setQuickBooksHours((BigDecimal) row[0]);
        ts.setAdpHours((BigDecimal) row[1]);
        //get sum of adjustment hours
        String sumBonusHoursQueryString = "SELECT SUM(paidHours) FROM " + AdjustmentHours.class.getCanonicalName() + " WHERE employee=:employeeparam ";
        Query bonusHoursQuery = em.createQuery(sumBonusHoursQueryString);
        bonusHoursQuery.setParameter("employeeparam", emp);
        BigDecimal sumAdjustmentHours = (BigDecimal) bonusHoursQuery.getSingleResult();
        ts.setAdjustmentHours(sumAdjustmentHours);
        //Calcluate balance
        if (ts.getQuickBooksHours() != null && ts.getAdpHours() != null && ts.getAdjustmentHours() != null) {
            ts.setBalanceHours((ts.getQuickBooksHours().subtract(ts.getAdpHours()).subtract(ts.getAdjustmentHours())));
        }
        return ts;
    }

    public static TimeService instance() {
        return SpringContext.getBean(TimeService.class);
    }
}

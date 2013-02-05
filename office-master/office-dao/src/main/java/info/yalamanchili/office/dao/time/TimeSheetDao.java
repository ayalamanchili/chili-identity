/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.BeanMapper;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("prototype")
public class TimeSheetDao extends CRUDDao<TimeSheet> {

    @PersistenceContext
    protected EntityManager em;

    public List<TimeSheet> getTimeSheetsForPeriod(TimeSheetPeriod period, int start, int limit) {
        Query query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where timeSheetPeriod=:timePeriodParam");
        query.setParameter("timePeriodParam", period);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<TimeSheet> getTimeSheetsEmployee(Employee employee, int start, int limit) {
        Query query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where employee=:employeeParam");
        query.setParameter("employeeParam", employee);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public TimeSheet save(TimeSheet entity) {
        validatetimesheet(entity);
        if (entity.getId() != null) {
            entity = (TimeSheet) BeanMapper.merge(entity, getEntityManager().find(TimeSheet.class, entity.getId()));
        }
        //Statemenet of work
        if (entity.getStatementOfWork() == null) {
            entity.setStatementOfWork(null);
        } else {
            StatementOfWork sow = getEntityManager().find(StatementOfWork.class, entity.getStatementOfWork().getId());
            entity.setStatementOfWork(sow);
        }
        //TimeSheetPeriod
        TimeSheetPeriod period = getEntityManager().find(TimeSheetPeriod.class, entity.getTimeSheetPeriod().getId());
        entity.setTimeSheetPeriod(period);
        //Employee
        Employee emp = getEntityManager().find(Employee.class, entity.getEmployee().getId());
        entity.setEmployee(emp);
        return getEntityManager().merge(entity);
    }

    protected void validatetimesheet(TimeSheet newTS) {
        //validate new timesheet start date less than end date
        if (!newTS.getStartDate().before(newTS.getEndDate())) {
            throw new RuntimeException("start date must be less than end date");
        }
        //validate if new timesheet belongs to existing period
        TimeSheetPeriod payPeriod = TimeSheetPeriodDao.instance().findById(newTS.getTimeSheetPeriod().getId());

        Calendar timesheetPeriodCalender = Calendar.getInstance();
        Calendar newTSStartDateCalnder = Calendar.getInstance();
        Calendar newTSEndDateCalender = Calendar.getInstance();

        timesheetPeriodCalender.setTime(payPeriod.getStartDate());
        newTSStartDateCalnder.setTime(newTS.getStartDate());
        newTSEndDateCalender.setTime(newTS.getEndDate());

        if (newTSStartDateCalnder.get(Calendar.MONTH) != timesheetPeriodCalender.get(Calendar.MONTH)) {
            throw new RuntimeException("start date does not belong to current payperiod");
        }

        if (newTSEndDateCalender.get(Calendar.MONTH) != timesheetPeriodCalender.get(Calendar.MONTH)) {
            throw new RuntimeException("end date does not belong to current payperiod");
        }
        //Validate is new and existing date do not overlap

        TypedQuery<TimeSheet> sizeQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:currentEmpid and timeSheetPeriod.id=:payperiodid", TimeSheet.class);
        sizeQuery.setParameter("currentEmpid", newTS.getEmployee().getId());
        sizeQuery.setParameter("payperiodid", newTS.getTimeSheetPeriod().getId());

        if (sizeQuery.getResultList().size() > 0) {
            TimeSheet existingTS = sizeQuery.getResultList().get(0);
            if (newTS.getStartDate().before(existingTS.getEndDate())) {
                throw new RuntimeException("New Timesheet Start date should be after Old Timesheet Enddate");
            }
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TimeSheetDao() {
        super(TimeSheet.class);
    }

    public static TimeSheetDao instance() {
        return SpringContext.getBean(TimeSheetDao.class);
    }
}

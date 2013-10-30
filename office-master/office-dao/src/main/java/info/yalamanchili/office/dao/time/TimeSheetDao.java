/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.BeanMapper;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.service.jrs.exception.ServiceException.StatusCode;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class TimeSheetDao extends CRUDDao<TimeSheet> {

    @PersistenceContext
    protected EntityManager em;

    public List<TimeSheet> getTimeSheetsForPeriod(TimeSheetPeriod period, int start, int limit, boolean includeInactive) {
        Query query;
        if (includeInactive) {
            query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where timeSheetPeriod=:timePeriodParam");
        } else {
            query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where timeSheetPeriod=:timePeriodParam and versionStatus='ACTIVE'");
        }
        query.setParameter("timePeriodParam", period);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();

    }

    public Long getTimeSheetsSizeForPeriod(TimeSheetPeriod period, boolean includeInactive) {
        Query query;
        if (includeInactive) {
            query = getEntityManager().createQuery("select count(*) from " + TimeSheet.class.getCanonicalName() + " where timeSheetPeriod=:timePeriodParam");
        } else {
            query = getEntityManager().createQuery("select count(*) from " + TimeSheet.class.getCanonicalName() + " where timeSheetPeriod=:timePeriodParam and versionStatus='ACTIVE'");
        }
        query.setParameter("timePeriodParam", period);
        return (Long) query.getSingleResult();
    }

    public Long getTimeSheetsSizeForEmployee(Employee employee, boolean includeInactive) {
        Query query;
        if (includeInactive) {
            query = getEntityManager().createQuery("select count(*) from " + TimeSheet.class.getCanonicalName() + " where employee=:employeeParam");
        } else {
            query = getEntityManager().createQuery("select count(*) from " + TimeSheet.class.getCanonicalName() + " where employee=:employeeParam and versionStatus='ACTIVE'");
        }
        query.setParameter("employeeParam", employee);
        return (Long) query.getSingleResult();
    }

    public List<TimeSheet> getTimeSheetsEmployee(Employee employee, int start, int limit, boolean includeInactive) {
        Query query;
        if (includeInactive) {
            query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where employee=:employeeParam");
        } else {
            query = getEntityManager().createQuery("from " + TimeSheet.class.getCanonicalName() + " where employee=:employeeParam and versionStatus='ACTIVE'");
        }
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

    //TODO move this to a validator (spring or hibernate based
    protected void validatetimesheet(TimeSheet newTS) {
        //validate new timesheet start date less than end date
        if (!newTS.getStartDate().before(newTS.getEndDate())) {
            throw new ServiceException(StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.timesheet", "start date must be less than end date");
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
            //TODO throw service exceptions
            throw new ServiceException(StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.timesheet", "start date does not belong to current payperiod");
        }

        if (newTSEndDateCalender.get(Calendar.MONTH) != timesheetPeriodCalender.get(Calendar.MONTH)) {
            throw new ServiceException(StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.timesheet", "end date does not belong to current payperiod");
        }
        //Validate is new and existing date do not overlap

        TypedQuery<TimeSheet> sizeQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:currentEmpid and timeSheetPeriod.id=:payperiodid", TimeSheet.class);
        sizeQuery.setParameter("currentEmpid", newTS.getEmployee().getId());
        sizeQuery.setParameter("payperiodid", newTS.getTimeSheetPeriod().getId());

        if (sizeQuery.getResultList().size() > 0) {
            TimeSheet existingTS = sizeQuery.getResultList().get(0);
            if (newTS.getId() != null && newTS.getId() != existingTS.getId()) {
                return;
            }
            if (newTS.getStartDate().before(existingTS.getEndDate())) {
                throw new ServiceException(StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.timesheet", "You are trying to enter a duplicate timesheet please check dates");
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

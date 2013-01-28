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
    
    protected void validatetimesheet(TimeSheet ts)
    {
        TypedQuery<Long> sizeQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:currentEmpid and timeSheetPeriod.id=:payperiodid", Long.class);
        sizeQuery.setParameter("currentEmpid", ts.getEmployee().getId());
        sizeQuery.setParameter("payperiodid",ts.getTimeSheetPeriod().getId());
        
       if (sizeQuery.getSingleResult() > 0) 
       {
         if ((ts.getStartDate() == null) && (ts.getEndDate() == null))
         {
            throw new RuntimeException("Enter Timesheet Start date and End date");
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

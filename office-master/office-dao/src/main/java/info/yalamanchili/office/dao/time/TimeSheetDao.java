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
    
    protected void validatetimesheet(TimeSheet newTS)
    {
        //TypedQuery<Long> sizeQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:currentEmpid and timeSheetPeriod.id=:payperiodid", Long.class);
        //TypedQuery<TimeSheet> sizeQuery = getEntityManager().createQuery("select oldts from timesheet oldts  where oldts.employee.id=:currentEmpid and oldts.timeSheetPeriod.id=:payperiodid", TimeSheet.class);
       // Query sizeQuery = getEntityManager().createQuery("select startDate,endDate from " + entityCls.getCanonicalName() + " where employee.id=:currentEmpid and timeSheetPeriod.id=:payperiodid");
        
      //  sizeQuery.setParameter("currentEmpid", ts.getEmployee().getId());
      //  sizeQuery.setParameter("payperiodid",ts.getTimeSheetPeriod().getId());
        
        //List lstresults = sizeQuery.getResultList();
        
       //if (lstresults.size() > 0) 
     //  {
       //  if ((ts.getStartDate() == null) && (ts.getEndDate() == null))
       //  {
       //     throw new RuntimeException("Enter Timesheet Start date and End date");
       //  }
       //  else if(lstresults.get(0)!= null)
       //  {
         //   Date dtstart = (Date)lstresults.get(0)   ;
         //   if(dtstart.compareTo(ts.getEndDate()) < 0)
         //   {
         //   throw new RuntimeException("New Timesheet Start Date should be greater than old Timesheet end date");
        //    }
            
        // }
         
      // }
        
         //validate if new timesheet belongs to existing period
        //TODO
        //validate new timesheet start date less than end date
        if (!newTS.getStartDate().before(newTS.getEndDate())) {
            throw new RuntimeException("start date must be less than end date");
        }
        
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
       // Calendar c3 = Calendar.getInstance();
        
        c1.setTime(newTS.getStartDate());
        c2.setTime(newTS.getEndDate());
        //c3.setTime(newTS.getTimeSheetPeriod().getStartDate());
        
        //TODO try to process all the errors collect them and throw a service exception at the end
        if ((c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)))
        {
        //validate if there is a existing timesheet and compare the start date of newTS is greater than end date of existingTS
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
        else
        {
          throw new RuntimeException("Start date, End date,Timesheet Period should be in same month");
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

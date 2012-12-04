/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.beans.BeanMapper;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("request")
public class TimeSheetDao extends CRUDDao<TimeSheet> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public TimeSheet save(TimeSheet entity) {
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

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TimeSheetDao() {
        super(TimeSheet.class);
    }
}

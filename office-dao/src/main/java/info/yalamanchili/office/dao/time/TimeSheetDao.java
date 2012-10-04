/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.client.StatementOfWork;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.time.TimeSheet;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
public class TimeSheetDao extends CRUDDao<TimeSheet> {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Override
    public TimeSheet save(TimeSheet entity) {
        Employee emp = getEntityManager().find(Employee.class, entity.getEmployee().getId());
        if (entity.getStatementOfWork() == null) {
            entity.setStatementOfWork(null);
        } else {
            StatementOfWork sow = getEntityManager().find(StatementOfWork.class, entity.getStatementOfWork().getId());
            entity.setStatementOfWork(sow);
        }
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

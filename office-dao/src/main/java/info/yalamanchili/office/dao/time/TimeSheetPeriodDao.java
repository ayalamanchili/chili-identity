/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
/**
 *
 * @author bala
 */
@Component
public class TimeSheetPeriodDao extends CRUDDao<TimeSheetPeriod> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TimeSheetPeriodDao() {
        super(TimeSheetPeriod.class);
    }
}
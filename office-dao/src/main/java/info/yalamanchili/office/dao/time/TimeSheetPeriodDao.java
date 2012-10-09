/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.beans.BeanMapper;
import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import java.util.Calendar;
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
    @Override
    public TimeSheetPeriod save(TimeSheetPeriod entity) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(entity.getStartDate());
        c2.setTime(entity.getEndDate());
        if(c1.get(Calendar.DAY_OF_WEEK) !=2 || c2.get(Calendar.DAY_OF_WEEK) !=1 ){
           throw new RuntimeException("StartDate and EndDate are invalid");
        }

        if (entity instanceof AbstractEntity) {
            if (((AbstractEntity) entity).getId() != null) {
                entity = (TimeSheetPeriod) BeanMapper.merge(entity, findById(((AbstractEntity) entity).getId()));
            }
        }
        return getEntityManager().merge(entity);
    }
}
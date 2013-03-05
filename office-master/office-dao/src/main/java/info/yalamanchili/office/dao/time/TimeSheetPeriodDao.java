/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.BeanMapper;
import info.chili.jpa.AbstractEntity;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author bala
 */
@Component
@Scope("prototype")
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
        //TODO try to process all the errors collect them and throw a service exception at the end
        if (c1.get(Calendar.MONTH) != c2.get(Calendar.MONTH)) {
             throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "invalid.timesheetperiod", "Start date and End date should be in same month");
        }
        
        
        //TODO check if the startDate and endDate belong to same week
        if (entity instanceof AbstractEntity) {
            if (((AbstractEntity) entity).getId() != null) {
                entity = (TimeSheetPeriod) BeanMapper.merge(entity, findById(((AbstractEntity) entity).getId()));
            }
        }
        return getEntityManager().merge(entity);
    }

    public static TimeSheetPeriodDao instance() {
        return SpringContext.getBean(TimeSheetPeriodDao.class);
    }
}

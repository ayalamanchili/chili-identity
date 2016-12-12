/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.BeanMapper;
import info.chili.commons.DateUtils;
import info.chili.jpa.AbstractEntity;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.time.TimeSheetPeriod;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bala
 */
@Repository
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

    public void createTimePeriod(int year, int month) {
        if (getTimePeriod(year, month) == null) {
            TimeSheetPeriod tp = new TimeSheetPeriod();

            Calendar startDate = Calendar.getInstance();
            startDate.set(year, month, 1);

            Calendar endDate = Calendar.getInstance();
            endDate.set(year, month, DateUtils.getLastDayOfMonth(month, year));

            tp.setStartDate(startDate.getTime());
            tp.setEndDate(endDate.getTime());

            SimpleDateFormat formatter = new SimpleDateFormat("MMMM, yyyy", Locale.US);
            tp.setName(formatter.format(startDate.getTime()).toString());
            em.merge(tp);
        }
    }

    public TimeSheetPeriod getTimePeriod(int year, int month) {
        Calendar startDate = Calendar.getInstance();
        startDate.set(year, month, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(year, month, DateUtils.getLastDayOfMonth(month, year));
        TypedQuery<TimeSheetPeriod> qry = getEntityManager().createQuery("from " + TimeSheetPeriod.class.getCanonicalName() + " where startDate=:startDateParam and endDate=:endDateParam", TimeSheetPeriod.class);
        qry.setParameter("startDateParam", startDate.getTime(), TemporalType.DATE);
        qry.setParameter("endDateParam", endDate.getTime(), TemporalType.DATE);
        if (qry.getResultList().size() > 0) {
            return qry.getResultList().get(0);
        } else {
            return null;
        }
    }

    public static TimeSheetPeriodDao instance() {
        return SpringContext.getBean(TimeSheetPeriodDao.class);
    }
}

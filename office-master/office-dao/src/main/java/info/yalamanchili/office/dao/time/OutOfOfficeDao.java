/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.time;

import info.chili.commons.DateUtils;
import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.time.OutOfOfficeRequest;
import info.yalamanchili.office.entity.time.OutOfOfficeRequestStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ramana.Lukalapu
 */
@Repository
@Scope("prototype")
public class OutOfOfficeDao extends CRUDDao<OutOfOfficeRequest> {

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    @Override
    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#start,#limit}")
    public List<OutOfOfficeRequest> query(int start, int limit) {
        TypedQuery<OutOfOfficeRequest> findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName(), entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<OutOfOfficeRequest> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam ", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public List<OutOfOfficeRequest> queryForCurrentWeekRequests(Integer start, Integer limit) {
        TypedQuery<OutOfOfficeRequest> query = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where status=:statusParam and (startDate <=:dateRangeEndParam ) and (endDate >=:dateRangeStartParam))", entityCls);
        query.setParameter("statusParam", OutOfOfficeRequestStatus.Approved);
        query.setParameter("dateRangeStartParam", DateUtils.getNextDay(new Date(), -1), TemporalType.DATE);
        query.setParameter("dateRangeEndParam", DateUtils.getNextDay(new Date(), 1), TemporalType.DATE);
        return query.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    public OutOfOfficeDao() {
        super(OutOfOfficeRequest.class);
    }

    @Override
    @CacheEvict(value = OfficeCacheKeys.OUTOFOFFICEREQUEST, allEntries = true)
    public OutOfOfficeRequest save(OutOfOfficeRequest entity) {
        return super.save(entity);
    }

    public static OutOfOfficeDao instance() {
        return SpringContext.getBean(OutOfOfficeDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

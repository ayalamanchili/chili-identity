/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.travelauthorization;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class TravelAuthorizationDao extends CRUDDao<TravelAuthorization> {

    @Override
    @CacheEvict(value = OfficeCacheKeys.TRAVEL_AUTH, allEntries = true)
    public TravelAuthorization save(TravelAuthorization entity) {
        return em.merge(entity);
    }

    @Override
    public TravelAuthorization findById(Long id) {
        TravelAuthorization entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        return entity;
    }

    @Cacheable(value = OfficeCacheKeys.TRAVEL_AUTH, key = "{#root.methodName,#start,#limit}")
    public List<TravelAuthorization> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by dateRequested DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.TRAVEL_AUTH, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<TravelAuthorization> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by dateRequested DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    @Cacheable(value = OfficeCacheKeys.TRAVEL_AUTH, key = "{#root.methodName}")
    public Long size() {
        return super.size();
    }

    @Cacheable(value = OfficeCacheKeys.TRAVEL_AUTH, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    public TravelAuthorizationDao() {
        super(TravelAuthorization.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static TravelAuthorizationDao instance() {
        return SpringContext.getBean(TravelAuthorizationDao.class);
    }
}

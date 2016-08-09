/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.insurance;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.insurance.HealthInsuranceWaiver;
import info.yalamanchili.office.entity.profile.insurance.HealthInsurances;
import info.yalamanchili.office.entity.profile.insurance.InsuranceEnrollment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
public class HealthInsuranceDao extends CRUDDao<HealthInsurances> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public HealthInsurances findById(Long id) {
        HealthInsurances entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        entity.setInsuranceEnrollment(InsuranceEnrollmentDao.instance().find(entity));
        entity.setHealthInsuranceWaiver(HealthInsuranceWaiverDao.instance().find(entity));
        return entity;
    }

    @Override
    public HealthInsurances save(HealthInsurances entity) {
        InsuranceEnrollment insuEnrt = entity.getInsuranceEnrollment();
        HealthInsuranceWaiver healthWaiver = entity.getHealthInsuranceWaiver();
        entity = super.save(entity);
        if (insuEnrt != null) {
            InsuranceEnrollmentDao.instance().save(insuEnrt, entity);
        }
        if (healthWaiver != null) {
            HealthInsuranceWaiverDao.instance().save(healthWaiver, entity);
        }
        return entity;
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#start,#limit}")
    public List<HealthInsurances> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by dateRequested DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<HealthInsurances> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by dateRequested DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName}")
    public Long size() {
        return super.size();
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public HealthInsuranceDao() {
        super(HealthInsurances.class);
    }

    public static HealthInsuranceDao instance() {
        return SpringContext.getBean(HealthInsuranceDao.class);
    }

}

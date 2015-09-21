/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.chkreq;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ImmigrationCheckRequisitionDao extends CRUDDao<ImmigrationCheckRequisition> {

    @PersistenceContext
    private EntityManager em;

    @Override
//    @Cacheable(value = OfficeCacheKeys.IMMIGRATION_CHECK, key = "{#root.methodName,#id}")
    //TODO fix issue with lazy init after caching result on print. 
    public ImmigrationCheckRequisition findById(Long id) {
        ImmigrationCheckRequisition entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        return entity;
    }

    @Cacheable(value = OfficeCacheKeys.IMMIGRATION_CHECK, key = "{#root.methodName,#start,#limit}")
    public List<ImmigrationCheckRequisition> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by requestedDate DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.IMMIGRATION_CHECK, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<ImmigrationCheckRequisition> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by requestedDate DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Override
    @CacheEvict(value = OfficeCacheKeys.IMMIGRATION_CHECK, allEntries = true)
    public ImmigrationCheckRequisition save(ImmigrationCheckRequisition entity) {
        return super.save(entity);
    }

    public ImmigrationCheckRequisitionDao() {
        super(ImmigrationCheckRequisition.class);
    }

    public static ImmigrationCheckRequisitionDao instance() {
        return SpringContext.getBean(ImmigrationCheckRequisitionDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

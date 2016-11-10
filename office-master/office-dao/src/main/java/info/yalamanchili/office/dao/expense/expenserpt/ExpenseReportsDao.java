/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReportStatus;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Hibernate;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Prasanthi.p
 */
@Repository
@Scope("prototype")
public class ExpenseReportsDao extends CRUDDao<ExpenseReport> {

    @Override
    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    public ExpenseReport save(ExpenseReport entity) {
        if (entity.getId() == null) {
            entity.setStatus(ExpenseReportStatus.SAVED);
            entity.setEmployee(OfficeSecurityService.instance().getCurrentUser());
        }
        return super.save(entity);
    }

    @Override
    public ExpenseReport findById(Long id) {
        ExpenseReport entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        return entity;
    }

    @Cacheable(value = OfficeCacheKeys.EXPENSE, key = "{#root.methodName,#start,#limit}")
    public List<ExpenseReport> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by submittedDate DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.EXPENSE, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<ExpenseReport> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by submittedDate DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    @Cacheable(value = OfficeCacheKeys.EXPENSE, key = "{#root.methodName}")
    public Long size() {
        return super.size();
    }

    @Cacheable(value = OfficeCacheKeys.EXPENSE, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    public ExpenseReportsDao() {
        super(ExpenseReport.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ExpenseReportsDao instance() {
        return SpringContext.getBean(ExpenseReportsDao.class);
    }
}

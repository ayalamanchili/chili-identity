/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class ImmigrationCheckRequisitionDao extends CRUDDao<ImmigrationCheckRequisition>{
  
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public ImmigrationCheckRequisition findById(Long id) {
        ImmigrationCheckRequisition entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        return entity;
    }
    
    public List<ImmigrationCheckRequisition> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by dateRequested DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }
    
    public List<ImmigrationCheckRequisition> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by dateRequested DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }
    
    @Override
    public ImmigrationCheckRequisition save(ImmigrationCheckRequisition entity) {
        if (entity.getId() != null) {
            ImmigrationCheckRequisition updatedImmigrationCheckRequisition = null;
            updatedImmigrationCheckRequisition = super.save(entity);
            if (entity.getCompany() != null) {
                updatedImmigrationCheckRequisition.setCompany(em.find(Company.class, entity.getCompany().getId()));
            } else {
                updatedImmigrationCheckRequisition.setCompany(null);
            }
            return em.merge(updatedImmigrationCheckRequisition);
        }
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

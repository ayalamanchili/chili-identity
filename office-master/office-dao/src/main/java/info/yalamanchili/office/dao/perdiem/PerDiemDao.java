/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.perdiem;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.expense.Perdiem.PerDiem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class PerDiemDao extends CRUDDao<PerDiem> {

    @PersistenceContext
    protected EntityManager em;

    public PerDiemDao() {
        super(PerDiem.class);
    }

    public static PerDiemDao instance() {
        return SpringContext.getBean(PerDiemDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<PerDiem> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.types.Entry;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.ImmigrationCase;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bhavana.Atluri
 */
@Repository
@Scope("prototype")
public class ImmigrationCaseDao extends CRUDDao<ImmigrationCase>{

    @PersistenceContext
    protected EntityManager em;
    
    public ImmigrationCaseDao() {
        super(ImmigrationCase.class);
    }

    public static ImmigrationCaseDao instance() {
        return SpringContext.getBean(ImmigrationCaseDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<ImmigrationCase> getImmigrationCases(Employee emp, int start, int limit) {
        //TODO order by created date
        Query query = getEntityManager().createQuery("from " + ImmigrationCase.class.getCanonicalName() + " st where st.employee=:employeeParam order by st.createdDate DESC", ImmigrationCase.class);
        query.setParameter("employeeParam", emp);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Long getImmigrationCaseSize(Employee emp, int start, int limit) {
        Query query = getEntityManager().createQuery("select count (*) from " + ImmigrationCase.class.getCanonicalName() + " st where st.employee=:employeeParam", Long.class);
        query.setParameter("employeeParam", emp);
        return (Long) query.getSingleResult();
    }
    
     public List<Entry> searchSuggestions() {
         return null;
//        Query findAllQuery = getEntityManager().createQuery("SELECT NEW " + Entry.class.getCanonicalName() + "(case.id,case.employeeName)" + " FROM " + ImmigrationCase.class.getCanonicalName() + " case)");
//        return findAllQuery.getResultList();
    }
}

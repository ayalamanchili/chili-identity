/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.company;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.company.CompanyContactType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class CompanyContactTypeDao extends CRUDDao<CompanyContactType> {

    @PersistenceContext
    protected EntityManager em;
    
    public Long getCompanyContactId(String companyContactType) {
        TypedQuery<Long> query = em.createQuery("select type.id from " + CompanyContactType.class.getCanonicalName() + " as type where type.name=:typeParam", Long.class);
        query.setParameter("typeParam", companyContactType);
        return query.getSingleResult();
    }

    public CompanyContactTypeDao() {
        super(CompanyContactType.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CompanyContactTypeDao instance() {
        return SpringContext.getBean(CompanyContactTypeDao.class);
    }
}

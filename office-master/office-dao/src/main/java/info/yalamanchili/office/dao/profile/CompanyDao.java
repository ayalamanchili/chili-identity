/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.Company;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class CompanyDao extends CRUDDao<Company> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Company findByCompanyName(String companyName) {
        Query q = em.createQuery("FROM Company WHERE lower(name) = :CompanyNameParam");
        q.setParameter("CompanyNameParam", companyName.toLowerCase());
        if (q.getResultList().size() > 0) {
            return (Company) q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public CompanyDao() {
        super(Company.class);
    }

    public static CompanyDao instance() {
        return SpringContext.getBean(CompanyDao.class);
    }
}

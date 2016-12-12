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
import info.yalamanchili.office.entity.profile.EmployeeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bala
 */
@Repository
@Scope("prototype")
public class EmployeeTypeDao extends CRUDDao<EmployeeType> {

    public EmployeeTypeDao() {
        super(EmployeeType.class);
    }

    public EmployeeType findByName(String name) {
        Query q = em.createQuery("FROM EmployeeType WHERE lower(name) = :nameParam");
        q.setParameter("nameParam", name.toLowerCase());
        if (q.getResultList().size() > 0) {
            return (EmployeeType) q.getResultList().get(0);
        } else {
            return null;
        }
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmployeeTypeDao instance() {
        return SpringContext.getBean(EmployeeTypeDao.class);
    }
}

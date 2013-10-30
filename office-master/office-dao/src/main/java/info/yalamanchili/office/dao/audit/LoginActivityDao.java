/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.audit;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.audit.LoginActivity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class LoginActivityDao extends CRUDDao<LoginActivity> {

    @PersistenceContext
    protected EntityManager em;

    public LoginActivityDao() {
        super(LoginActivity.class);
    }

    @Override
    public List<LoginActivity> query(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + LoginActivity.class.getCanonicalName() + " order by loginTimeStamp DESC", LoginActivity.class);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public Long getLoginCount(String employeeId) {
        Query query = getEntityManager().createQuery("select count(*) from " + LoginActivity.class.getCanonicalName() + " where employeeId=:employeeIdParam", Long.class);
        query.setParameter("employeeIdParam", employeeId);
        return (Long) query.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static LoginActivityDao instance() {
        return SpringContext.getBean(LoginActivityDao.class);
    }
}

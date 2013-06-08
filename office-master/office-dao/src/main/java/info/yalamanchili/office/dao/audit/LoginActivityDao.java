/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.audit;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.audit.LoginActivity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author anuyalamanchili
 */
@Component
@Scope("prototype")
public class LoginActivityDao extends CRUDDao<LoginActivity> {

    @PersistenceContext
    protected EntityManager em;

    public LoginActivityDao() {
        super(LoginActivity.class);
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

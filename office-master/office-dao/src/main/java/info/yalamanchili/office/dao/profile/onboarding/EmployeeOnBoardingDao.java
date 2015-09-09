/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.onboarding;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding;
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
public class EmployeeOnBoardingDao extends CRUDDao<EmployeeOnBoarding> {

    public EmployeeOnBoardingDao() {
        super(EmployeeOnBoarding.class);
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EmployeeOnBoarding findByEmail(String email) {
        String L = entityCls.getCanonicalName();
        Query findQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where email=:employeeEmailParam ");
        findQuery.setParameter("employeeEmailParam", email);
        if (findQuery.getResultList().size() > 1) {
            return null;
        } else {
            EmployeeOnBoarding entity = (EmployeeOnBoarding) findQuery.getResultList().get(0);
            return entity;
        }
    }

    public static EmployeeOnBoardingDao instance() {
        return SpringContext.getBean(EmployeeOnBoardingDao.class);
    }

}

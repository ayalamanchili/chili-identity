/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.RetirementPlan;
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
public class RetirementPlanDao extends CRUDDao<RetirementPlan> {

    public RetirementPlan find(Employee emp) {
        TypedQuery<RetirementPlan> q = getEntityManager().createQuery("from " + RetirementPlan.class.getCanonicalName() + " where employee=:employeeParam", RetirementPlan.class);
        if (emp != null) {
            q.setParameter("employeeParam", emp);
        } else {
            q.setParameter("employeeParam", OfficeSecurityService.instance().getCurrentUser());
        }
        if (q.getResultList().size() > 0) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }

    public List<RetirementPlan> getActiveRetirementPlans() {
        TypedQuery<RetirementPlan> query = em.createQuery("from " + RetirementPlan.class.getCanonicalName() + " where optIn=:OptInParam", RetirementPlan.class);
        query.setParameter("OptInParam", Boolean.TRUE);
        return query.getResultList();

    }

    public RetirementPlanDao() {
        super(RetirementPlan.class);
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static RetirementPlanDao instance() {
        return SpringContext.getBean(RetirementPlanDao.class);
    }

}

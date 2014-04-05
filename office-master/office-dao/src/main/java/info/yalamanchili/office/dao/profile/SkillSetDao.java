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
import info.yalamanchili.office.entity.profile.SkillSet;
import info.yalamanchili.office.security.SecurityUtils;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author raghu
 */
@Repository
@Scope("prototype")
public class SkillSetDao extends CRUDDao<SkillSet> {

    public SkillSetDao() {
        super(SkillSet.class);
    }

    @PersistenceContext
    protected EntityManager em;

    public SkillSet getCurrentUserSkillSet() {
        TypedQuery<SkillSet> query = em.createQuery("from " + SkillSet.class.getCanonicalName() + " where employee.employeeId=:empIdParam", SkillSet.class);
        query.setParameter("empIdParam", SecurityUtils.getCurrentUser());
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static SkillSetDao instance() {
        return SpringContext.getBean(SkillSetDao.class);
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.project.offboarding;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.expense.ImmigrationCheckRequisition;
import info.yalamanchili.office.entity.profile.offboarding.ProjectEndDetails;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ProjectEndDetailsDao extends CRUDDao<ProjectEndDetails> {
    public static ProjectEndDetailsDao instance;

    public static ProjectEndDetailsDao instance() {
        return instance;
    }

    @PersistenceContext
    protected EntityManager em;

    @Transactional(readOnly = true)
    @Override
    public List<ProjectEndDetails> query(int start, int limit) {
        TypedQuery<ProjectEndDetails> findAllQuery = getEntityManager().createQuery("from " + ProjectEndDetails.class.getCanonicalName() + " order by endDate DESC ", ProjectEndDetails.class);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }
    
    public ProjectEndDetailsDao() {
        super(ProjectEndDetails.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

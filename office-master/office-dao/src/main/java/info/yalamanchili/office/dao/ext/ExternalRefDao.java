/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.ext;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.ext.ExternalRef;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class ExternalRefDao extends AbstractHandleEntityDao<ExternalRef> {

    @PersistenceContext
    protected EntityManager em;

    public ExternalRef getExternalRefId(String externalSource, String externalId) {
        Query query = em.createQuery("from " + ExternalRef.class.getCanonicalName() + " where source=:sourceParam and externalId=:externalIdParam");
        query.setParameter("sourceParam", externalSource);
        query.setParameter("externalIdParam", externalId);
        if (query.getResultList().size() > 0) {
            return (ExternalRef) query.getSingleResult();
        } else {
            return null;
        }
    }

    public String getExternalRefId(String externalSource, Class targetClassName, Long targetEntityId) {
        TypedQuery<String> query = em.createQuery("select externalId from " + ExternalRef.class.getCanonicalName() + " where source=:sourceParam and targetEntityName=:targetEntityNameParam and targetEntityId=:targetEntityIdParam", String.class);
        query.setParameter("sourceParam", externalSource);
        query.setParameter("targetEntityNameParam", targetClassName.getCanonicalName());
        query.setParameter("targetEntityIdParam", targetEntityId);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    public String getTargetEntityIdForExternalId(String externalSource, String externalId) {
        TypedQuery<Long> query = em.createQuery("select targetEntityId from " + ExternalRef.class.getCanonicalName() + " where source=:sourceParam and externalId=:externalIdParam", Long.class);
        query.setParameter("sourceParam", externalSource);
        query.setParameter("externalIdParam", externalId);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0).toString();
        } else {
            return null;
        }
    }

    public ExternalRefDao() {
        super(ExternalRef.class);
    }

    public static ExternalRefDao instance() {
        return SpringContext.getBean(ExternalRefDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

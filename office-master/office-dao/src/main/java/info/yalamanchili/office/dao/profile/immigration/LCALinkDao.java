/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.jpa.AbstractEntity;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.LCALink;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Madhu.Badiginchala
 */
@Repository
@Scope("prototype")
public class LCALinkDao extends AbstractHandleEntityDao<LCALink> {

    @PersistenceContext
    protected EntityManager em;

    public LCALinkDao() {
        super(LCALink.class);
    }

    public static LCALinkDao instance() {
        return SpringContext.getBean(LCALinkDao.class);
    }

    @Transactional(readOnly = true)
    public List<LCALink> findLCA(Long id, String sourceClassName) {
        TypedQuery<LCALink> query = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where sourceEntityName=:sourceEntityNameParam and sourceEntityId=:sourceEntityIdParam", entityCls);
        query.setParameter("sourceEntityNameParam", sourceClassName);
        query.setParameter("sourceEntityIdParam", id);
        if (query.getResultList().size() > 0) {
            return query.getResultList();
        } else {
            //TODO throw exception
            return Collections.EMPTY_LIST;
        }
    }

    @Transactional(readOnly = true)
    public List<LCALink> findAllLCA(AbstractEntity target) {
        TypedQuery<LCALink> query = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where targetEntityName=:targetEntityNameParam and targetEntityId=:targetEntityIdParam", entityCls);
        query.setParameter("targetEntityNameParam", target.getClass().getCanonicalName());
        query.setParameter("targetEntityIdParam", target.getId());
        if (query.getResultList().size() > 0) {
            return query.getResultList();
        } else {
            //TODO throw exception
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

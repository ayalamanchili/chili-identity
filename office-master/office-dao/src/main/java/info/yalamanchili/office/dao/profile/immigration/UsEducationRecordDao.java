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
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.immigration.USEducationRecord;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class UsEducationRecordDao extends AbstractHandleEntityDao<USEducationRecord> {

    @PersistenceContext
    protected EntityManager em;

    public UsEducationRecordDao() {
        super(USEducationRecord.class);
    }

    public static UsEducationRecordDao instance() {
        return SpringContext.getBean(UsEducationRecordDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    @Transactional(readOnly = true)
    @Override
    public List<USEducationRecord> findAll(Long id, String targetClassName) {
        System.out.println("entity cls is .... " + entityCls+" entity manager is .... "+em);
        TypedQuery<USEducationRecord> query = em.createQuery("from " + USEducationRecord.class.getCanonicalName() + " where targetEntityName=:targetEntityNameParam and targetEntityId=:targetEntityIdParam", entityCls);
        query.setParameter("targetEntityNameParam", targetClassName);
        query.setParameter("targetEntityIdParam", id);
        return query.getResultList();
    }
}

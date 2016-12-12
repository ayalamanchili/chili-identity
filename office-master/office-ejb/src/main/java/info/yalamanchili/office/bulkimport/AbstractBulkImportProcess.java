/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.jpa.AbstractEntity;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportEntity;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public abstract class AbstractBulkImportProcess<T extends AbstractEntity> implements BulkImportProcess {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public BulkImport commit(BulkImport bulkImport) {
        bulkImport = em.find(BulkImport.class, bulkImport.getId());
        for (BulkImportEntity biEntity : bulkImport.getEntities()) {
            Query q = em.createQuery("from " + biEntity.getEntityType() + " where id=:idParam");
            q.setParameter("idParam", biEntity.getEntityId());
            if (q.getResultList().size() > 0) {
                T entity = (T) q.getResultList().get(0);
                entity = saveOnCommit(entity);
                em.merge(entity);
            }
        }
        return em.merge(bulkImport);
    }

    /**
     * update status on commit
     *
     * @param entity
     * @return
     */
    protected abstract T saveOnCommit(T entity);

    @Override
    public BulkImport revert(BulkImport bulkImport) {
        bulkImport = em.find(BulkImport.class, bulkImport.getId());
        for (BulkImportEntity entity : bulkImport.getEntities()) {
            Query q = em.createQuery("from " + entity.getEntityType() + " where id=:idParam");
            q.setParameter("idParam", entity.getEntityId());
            if (q.getResultList().size() > 0) {
                em.remove(q.getResultList().get(0));
            }
        }
        return em.merge(bulkImport);
    }

    protected void addBulkImportEntity(BulkImport bulkImport, AbstractEntity entity) {
        BulkImportEntity biEntity = new BulkImportEntity();
        biEntity.setEntityType(entity.getClass().getCanonicalName());
        biEntity.setEntityId(entity.getId());
        biEntity = em.merge(biEntity);
        bulkImport.addEntity(biEntity);
    }

    protected void createBulkImportMessage(BulkImport bulkImport, String code, String description, BulkImportMessageType type) {
        BulkImportMessage msg = new BulkImportMessage();
        msg.setCode(code);
        msg.setDescription(description);
        msg.setMessageType(type);
        msg = em.merge(msg);
        bulkImport.addMessage(msg);
    }

    @Override
    public BulkImport resubmit(BulkImport bulkImport) {
        return bulkImport;
    }
}

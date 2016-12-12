/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.bulkimport;

import info.chili.document.AbstractDocument;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.bulkimport.BulkImportEntity;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

/**
 *
 * @author ayalamanchili
 */
public abstract class AbstractBulkImportDocumentProcess<T extends AbstractDocument> implements BulkImportProcess {
    
    @Autowired
    protected MongoOperations mongoTemplate;
    
    @PersistenceContext
    protected EntityManager em;
    
    @Override
    public BulkImport commit(BulkImport bulkImport) {
        return bulkImport;
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
        return bulkImport;
    }
    
    protected void addBulkImportEntity(BulkImport bulkImport, AbstractDocument entity) {
        BulkImportEntity biEntity = new BulkImportEntity();
        biEntity.setEntityType(entity.getClass().getCanonicalName() + ":" + entity.getId());
//        biEntity.setEntityType(entity.getClass().getCanonicalName());
//        biEntity.setEntityId(entity.getId().longValueExact());
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

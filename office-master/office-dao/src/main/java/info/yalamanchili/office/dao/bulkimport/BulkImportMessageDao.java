/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.bulkimport;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessageType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class BulkImportMessageDao extends CRUDDao<BulkImportMessage> {

    @PersistenceContext
    protected EntityManager em;

    public BulkImportMessageDao() {
        super(BulkImportMessage.class);
    }

    public List<BulkImportMessage> getMessages(Long bulkImportId, BulkImportMessageType messageType, int start, int limit) {
        String queryString = "from " + BulkImportMessage.class.getCanonicalName() + " bim where bim.bulkImport.id=:bulkImportIdParam";
        if (messageType != null) {
            queryString = queryString + " and bim.messageType=:messageTypeParam";
        }
        Query query = em.createQuery(queryString);
        query.setParameter("bulkImportIdParam", bulkImportId);
        if (messageType != null) {
            query.setParameter("messageTypeParam", messageType);
        }
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Long getMessagesSize(Long bulkImportId, BulkImportMessageType messageType) {
        String queryString = "select count(*) from " + BulkImportMessage.class.getCanonicalName() + " bim where bim.bulkImport.id=:bulkImportIdParam";
        if (messageType != null) {
            queryString = queryString + " and bim.messageType=:messageTypeParam";
        }
        TypedQuery<Long> sizeQuery = getEntityManager().createQuery(queryString, Long.class);
        sizeQuery.setParameter("bulkImportIdParam", bulkImportId);
        if (messageType != null) {
            sizeQuery.setParameter("messageTypeParam", messageType);
        }
        return sizeQuery.getSingleResult();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

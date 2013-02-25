/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.bulkimport;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.bulkimport.BulkImportMessage;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
@Scope("prototype")
public class BulkImportMessageDao extends CRUDDao<BulkImportMessage> {

    @PersistenceContext
    protected EntityManager em;

    public BulkImportMessageDao() {
        super(BulkImportMessage.class);
    }

    public List<BulkImportMessage> getMessages(Long bulkImportId, int start, int limit) {
        Query query = em.createQuery("from" + BulkImportMessage.class.getCanonicalName() + " bim where bim.bulkImport.id=:bulkImportIdParam");
        query.setParameter("bulkImportIdParam", bulkImportId);
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

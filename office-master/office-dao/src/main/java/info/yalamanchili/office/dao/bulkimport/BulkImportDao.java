/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.bulkimport;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.bulkimport.BulkImport;
import info.yalamanchili.office.entity.client.Client;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("prototype")
public class BulkImportDao extends CRUDDao<BulkImport> {

    @PersistenceContext
    protected EntityManager em;

    public BulkImportDao() {
        super(BulkImport.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

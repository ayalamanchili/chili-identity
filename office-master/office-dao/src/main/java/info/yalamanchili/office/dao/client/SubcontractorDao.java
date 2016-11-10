/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.client;

import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.client.Client;
import info.yalamanchili.office.entity.client.Subcontractor;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class SubcontractorDao extends CRUDDao<Subcontractor> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public SubcontractorDao() {
        super(Subcontractor.class);
    }

    public static SubcontractorDao instance() {
        return SpringContext.getBean(SubcontractorDao.class);
    }
    
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Map<String, String> getEntityStringMapByParams(int start, int limit, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Subcontractor.class.getCanonicalName(), params) + " where subcontractorStatus='ACTIVE' ", start, limit, params);
    }
}

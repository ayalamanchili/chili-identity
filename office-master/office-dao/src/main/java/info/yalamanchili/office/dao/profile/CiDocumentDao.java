/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.CIDocument;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class CiDocumentDao extends CRUDDao<CIDocument> {

    public CiDocumentDao() {
        super(CIDocument.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @CacheEvict(value = OfficeCacheKeys.CLIENTINFORMATION, allEntries = true)
    @Override
    public void delete(Long id) {
        delete(findById(id));
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CiDocumentDao instance() {
        return SpringContext.getBean(CiDocumentDao.class);
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.Certification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

/**
 *
 * @author bala
 */
@Repository
@Scope("prototype")
public class CertificationDao extends CRUDDao<Certification> {

    public CertificationDao() {
        super(Certification.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @CacheEvict(value = OfficeCacheKeys.CERTIFICATION, allEntries = true)
    @Override
    public Certification save(Certification entity) {
        return super.save(entity);
    }

    public static CertificationDao instance() {
        return SpringContext.getBean(CertificationDao.class);
    }
}

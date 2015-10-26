/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.ClientInformation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class ClientInformationDao extends CRUDDao<ClientInformation> {

    @PersistenceContext
    protected EntityManager em;

    public ClientInformationDao() {
        super(ClientInformation.class);
    }
    
    @CacheEvict(value = OfficeCacheKeys.CLIENTINFORMATION, allEntries = true)
    public ClientInformation save(ClientInformation entity) {
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ClientInformationDao instance() {
        return SpringContext.getBean(ClientInformationDao.class);
    }
}

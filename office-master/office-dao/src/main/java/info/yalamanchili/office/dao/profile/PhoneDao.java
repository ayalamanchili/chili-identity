/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class PhoneDao extends CRUDDao<Phone> {

    @PersistenceContext
    protected EntityManager em;

    public PhoneDao() {
        super(Phone.class);
    }

    @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true)
    @Override
    public Phone save(Phone entity) {
        if (entity.getId() != null) {
            Phone updatedPhone = null;
            updatedPhone = super.save(entity);
            if (entity.getPhoneType() == null) {
                updatedPhone.setPhoneType(null);
            } else {
                updatedPhone.setPhoneType(em.find(PhoneType.class, entity.getPhoneType().getId()));
            }
            return em.merge(updatedPhone);
        }
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static PhoneDao instance() {
        return SpringContext.getBean(PhoneDao.class);
    }
}

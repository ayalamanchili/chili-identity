/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.Phone;
import info.yalamanchili.office.entity.profile.PhoneType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public List<Phone> getPhoneByType(Employee emp, String type) {
        TypedQuery<Phone> query = em.createQuery("from " + Phone.class.getCanonicalName() + " where contact=:contactParam and phoneType.phoneType=:phoneTypeParam", Phone.class);
        query.setParameter("contactParam", emp);
        query.setParameter("phoneTypeParam", type);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static PhoneDao instance() {
        return SpringContext.getBean(PhoneDao.class);
    }
}

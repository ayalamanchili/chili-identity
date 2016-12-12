/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.profile.AddressType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class AddressTypeDao extends CRUDDao<AddressType> {

    @PersistenceContext
    protected EntityManager em;

    public AddressTypeDao() {
        super(AddressType.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public static AddressTypeDao instance() {
        return SpringContext.getBean(AddressTypeDao.class);
    }

    public AddressType getAddressType(String addrressType) {
        Query getAddrType = em.createQuery("from " + AddressType.class.getCanonicalName()
                + " where addressType=:addressTypeParam");
        getAddrType.setParameter("addressTypeParam", addrressType);
        if (getAddrType.getResultList().size() > 0) {
            return (AddressType) getAddrType.getResultList().get(0);
        } else {
            AddressType addressType = new AddressType();
            addressType.setAddressType(addrressType);
            return em.merge(addressType);
        }
    }
}
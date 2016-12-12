/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile.immigration;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.AddressDao;
import info.yalamanchili.office.entity.immigration.AddressHandleEntity;
import info.yalamanchili.office.entity.profile.Address;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class AddressHandleEntityDao extends AbstractHandleEntityDao<AddressHandleEntity> {

    @PersistenceContext
    protected EntityManager em;

    public AddressHandleEntityDao() {
        super(AddressHandleEntity.class);
    }

    public static AddressHandleEntityDao instance() {
        return SpringContext.getBean(AddressHandleEntityDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Transactional(readOnly = false)
    public List<Address> getAllAddress(Long targetId) {
        TypedQuery<AddressHandleEntity> getAddressQuery = getEntityManager().createQuery("from " + AddressHandleEntity.class.getCanonicalName() + " WHERE targetEntityId=:targetIdParam", AddressHandleEntity.class);
        getAddressQuery.setParameter("targetIdParam", targetId);
        List<Address> addresses = new ArrayList();
        List<AddressHandleEntity> resultList = getAddressQuery.getResultList();
        if (resultList != null && resultList.size() > 0) {
            for (AddressHandleEntity addr : resultList) {
                addresses.add(AddressDao.instance().findById(addr.getTargetEntityId()));
            }
        }
        return addresses;
    }
}
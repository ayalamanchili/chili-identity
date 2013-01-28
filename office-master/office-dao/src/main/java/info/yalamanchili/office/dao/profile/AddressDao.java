/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

/**
 * @todo add comment for javadoc
 *
 * @author ayalamanchili
 * @generated
 */
@Component
@Scope("prototype")
public class AddressDao extends CRUDDao<Address> {

    @PersistenceContext
    protected EntityManager em;

    public AddressDao() {
        super(Address.class);
    }

    @Override
    public Address save(Address entity) {
        if (entity.getId() != null) {
            Address updatedAddress = null;
            updatedAddress = super.save(entity);
            if (entity.getAddressType() == null) {
                updatedAddress.setAddressType(null);
            } else {
                updatedAddress.setAddressType(em.find(AddressType.class, entity.getAddressType().getId()));
            }
            return em.merge(updatedAddress);
        }
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static AddressDao instance() {
        return SpringContext.getBean(AddressDao.class);
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

/**
 * @todo add comment for javadoc
 *
 * @author ayalamanchili
 * @generated
 */
@Repository
@Scope("prototype")
public class AddressDao extends CRUDDao<Address> {

    @PersistenceContext
    protected EntityManager em;

    public AddressDao() {
        super(Address.class);
    }

    @Override
    public Address save(Address entity) {
        //Set address Type
        if (entity.getAddressType() == null) {
            entity.setAddressType(null);
        } else if (entity.getAddressType().getAddressType() != null && !entity.getAddressType().getAddressType().isEmpty()) {
            entity.setAddressType(QueryUtils.findEntity(em, AddressType.class, "addressType", entity.getAddressType().getAddressType()));
        } else if (entity.getAddressType().getId() != null) {
            entity.setAddressType(em.find(AddressType.class, entity.getAddressType().getId()));
        }
        return super.save(entity);
    }

    public List<Address> getAddressByType(Employee emp, String type) {
        TypedQuery<Address> query = em.createQuery("from " + Address.class.getCanonicalName() + " where contact=:contactParam and addressType.addressType=:addressTypeParam", Address.class);
        query.setParameter("contactParam", emp);
        query.setParameter("addressTypeParam", type);
        return query.getResultList();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static AddressDao instance() {
        return SpringContext.getBean(AddressDao.class);
    }
}

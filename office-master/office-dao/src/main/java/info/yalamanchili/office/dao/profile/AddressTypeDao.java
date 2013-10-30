/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.AddressType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}

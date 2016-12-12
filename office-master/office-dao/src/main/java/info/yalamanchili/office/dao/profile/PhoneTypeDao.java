/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.PhoneType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class PhoneTypeDao extends CRUDDao<PhoneType> {

    @PersistenceContext
    protected EntityManager em;

    public PhoneTypeDao() {
        super(PhoneType.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

/**
 * Automanage Copyright (C) 2011 yalamanchili.info
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Address;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 * @todo add comment for javadoc
 * 
 * @author ayalamanchili @generated
 */
@Component
public class AddressDao extends CRUDDao<Address> {

	@PersistenceContext
	protected EntityManager em;

	public AddressDao() {
		super(Address.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}

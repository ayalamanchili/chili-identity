package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class AddressTypeDao extends CRUDDao<Address> {

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
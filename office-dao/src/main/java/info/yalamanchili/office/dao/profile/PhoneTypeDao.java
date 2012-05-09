package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.PhoneType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
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
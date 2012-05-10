package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Phone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class PhoneDao extends CRUDDao<Phone> {

	@PersistenceContext
	protected EntityManager em;

	public PhoneDao() {
		super(Phone.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
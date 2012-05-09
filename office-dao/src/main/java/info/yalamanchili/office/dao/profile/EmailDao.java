package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Email;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
@Component
public class EmailDao extends CRUDDao<Email> {

	@PersistenceContext
	protected EntityManager em;

	public EmailDao() {
		super(Email.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
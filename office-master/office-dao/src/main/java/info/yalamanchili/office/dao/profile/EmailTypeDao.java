package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.EmailType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class EmailTypeDao extends CRUDDao<EmailType> {

	@PersistenceContext
	protected EntityManager em;

	public EmailTypeDao() {
		super(EmailType.class);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}

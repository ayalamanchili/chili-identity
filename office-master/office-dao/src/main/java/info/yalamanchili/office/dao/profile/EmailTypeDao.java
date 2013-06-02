package info.yalamanchili.office.dao.profile;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.EmailType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
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

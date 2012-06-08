package info.yalamanchili.office.dao.profile;

import info.yalamanchili.mapper.BeanMapper;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.ReportsTo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class ReportsToDao extends CRUDDao<ReportsTo> {

	@PersistenceContext
	protected EntityManager em;

	public ReportsToDao() {
		super(ReportsTo.class);
	}

	public ReportsTo save(ReportsTo entity) {
		if (entity.getId() != null) {
			ReportsTo updateReportsTo = null;
			updateReportsTo = super.save(entity);
			Contact contact = em.find(Contact.class, entity.getContact().getId());
			updateReportsTo.setContact((Contact) BeanMapper.merge(entity.getContact(), contact));
			return em.merge(updateReportsTo);
		}
		return super.save(entity);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}
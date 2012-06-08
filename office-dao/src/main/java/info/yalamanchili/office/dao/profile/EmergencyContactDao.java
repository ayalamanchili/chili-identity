package info.yalamanchili.office.dao.profile;

import info.yalamanchili.mapper.BeanMapper;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.EmergencyContact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class EmergencyContactDao extends CRUDDao<EmergencyContact> {
	@PersistenceContext
	protected EntityManager em;

	public EmergencyContactDao() {
		super(EmergencyContact.class);
	}

	public EmergencyContact save(EmergencyContact entity) {
		if (entity.getId() != null) {
			EmergencyContact updateEmergencyContact = null;
			updateEmergencyContact = super.save(entity);
			Contact contact = em.find(Contact.class, entity.getContact().getId());
			updateEmergencyContact.setContact((Contact) BeanMapper.merge(entity.getContact(), contact));
			return em.merge(updateEmergencyContact);
		}
		return super.save(entity);
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}
}

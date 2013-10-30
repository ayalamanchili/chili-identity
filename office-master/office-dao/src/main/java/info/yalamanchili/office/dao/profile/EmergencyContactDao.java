/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.commons.BeanMapper;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.EmergencyContact;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
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

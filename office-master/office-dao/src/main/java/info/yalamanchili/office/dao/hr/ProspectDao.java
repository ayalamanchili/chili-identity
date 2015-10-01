/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.hr;

import info.chili.commons.BeanMapper;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.hr.Prospect;
import info.yalamanchili.office.entity.profile.Contact;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author radhika.mukkala
 */
@Repository
@Scope("prototype")
public class ProspectDao extends CRUDDao<Prospect>{
    
    @PersistenceContext
    protected EntityManager em;
    
    public ProspectDao(){
        super(Prospect.class);
    }
    
    public Prospect save(Prospect entity) {
        if (entity.getId() != null) {
            Prospect updateProspect = null;
            updateProspect = super.save(entity);
            Contact contact = em.find(Contact.class, entity.getContact());
            updateProspect.setContact((Contact) BeanMapper.merge(entity.getContact(), contact));
            return em.merge(updateProspect);
        }
        return super.save(entity);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}

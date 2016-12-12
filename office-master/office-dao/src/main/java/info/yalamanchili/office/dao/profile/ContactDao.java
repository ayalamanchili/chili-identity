/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.security.SecurityUtils;
import info.yalamanchili.office.entity.profile.Contact;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class ContactDao extends CRUDDao<Contact> {

    @PersistenceContext
    protected EntityManager em;

    public ContactDao() {
        super(Contact.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ContactDao instance() {
        return SpringContext.getBean(ContactDao.class);
    }

    //TODO use cache
    public Contact findByEmail(String emailAddress) {
        Query getEmailQ = em.createQuery("from " + info.yalamanchili.office.entity.profile.Email.class.getCanonicalName() + " where emailHash=:emailAddressParam");
        getEmailQ.setParameter("emailAddressParam", SecurityUtils.hash(emailAddress));
        if (getEmailQ.getResultList().size() > 0) {
            info.yalamanchili.office.entity.profile.Email email = (info.yalamanchili.office.entity.profile.Email) getEmailQ.getResultList().get(0);
            return email.getContact();
        } else {
            return null;
        }
    }
}

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
import info.yalamanchili.office.entity.profile.Contact;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    public Contact findByEmail(String email) {
        String L = Contact.class.getCanonicalName();
        TypedQuery<Contact> qry = getEntityManager().createQuery("from " + Contact.class.getCanonicalName() + " where emails.email=:emailParam ", Contact.class);
        qry.setParameter("emailParam", email);
        if (qry.getResultList().size() > 0) {
            return qry.getResultList().get(0);
        } else {
            return null;
        }
    }
}

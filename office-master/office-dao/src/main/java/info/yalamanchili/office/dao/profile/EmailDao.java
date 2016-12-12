/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.dao.profile;

import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;
import info.yalamanchili.office.entity.profile.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class EmailDao extends CRUDDao<Email> {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected EmployeeDao employeeDao;

    public EmailDao() {
        super(Email.class);
    }

    public Email findEmail(String emailAddress) {
        Query getEmailQ = getEntityManager().createQuery("from " + Email.class.getCanonicalName() + " email where email.email=:emailAddressParam");
        getEmailQ.setParameter("emailAddressParam", emailAddress);
        if (getEmailQ.getResultList().size() > 0) {
            return (Email) getEmailQ.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Override
    @Caching(evict = {
        @CacheEvict(value = OfficeCacheKeys.EMPLOYEES, allEntries = true),
        @CacheEvict(value = info.chili.email.Email.EMAILS_CACHE_KEY, allEntries = true)
    })
    public Email save(Email entity) {
        if (entity.getId() != null) {
            Contact cnt = ContactDao.instance().findById(entity.getContact().getId());
            entity = employeeDao.updatePrimaryEmail(cnt, entity);
            Email updatedEmail = null;
            updatedEmail = super.save(entity);
            if (entity.getEmailType() == null) {
                updatedEmail.setEmailType(null);
            } else {
                updatedEmail.setEmailType(em.find(EmailType.class, entity.getEmailType().getId()));
            }
            return em.merge(updatedEmail);
        }
        return super.save(entity);
    }

    @Override
    public void delete(Long id) {
        Email email = em.find(Email.class, id);
        Contact contact = ContactDao.instance().findById(email.getContact().getId());

        if (contact instanceof Employee) {
            Employee emp = (Employee) contact;
            if (emp.getEmails().size() == 1) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "emp.atleast.one.email", "Employee must have atleast one email");
            }
            if (emp.getPrimaryEmail() != null && emp.getPrimaryEmail().getId().equals(email.getId())) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "cannot.delete.primary.email", "Cannot delete primary email");
            }
        }
        //This is needed to avoid flushing contact which throws a email entity not found exception
        em.detach(contact);
        super.delete(id);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmailDao instance() {
        return SpringContext.getBean(EmailDao.class);
    }
}

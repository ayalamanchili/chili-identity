package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

@Component
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
    public Email save(Email entity) {
        if (entity.getId() != null) {
            Contact cnt = ContactDao.instance().findById(entity.getContact().getId());
            entity = employeeDao.updatePrimaryEmail(cnt, entity);
            Email updatedEmail=null;
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
      Email ent =  em.find(Email.class , id);
//     Contact cnt = ContactDao.instance().findById(ent.getContact().getId());
      super.delete(id);
      if(ent.getContact().getPrimaryEmail() == null)
      {
        if(ent.getContact().getEmails().size() > 0)
        {
         ent.getContact().getEmails().get(0).setPrimaryEmail(Boolean.TRUE);
        }
      }
          
     }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmailDao instance() {
        return SpringContext.getBean(EmailDao.class);
    }
}
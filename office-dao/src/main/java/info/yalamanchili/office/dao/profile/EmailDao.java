package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.EmailType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class EmailDao extends CRUDDao<Email> {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    protected EmployeeDao employeeDao;

    public EmailDao() {
        super(Email.class);
    }

    public Email save(Email entity) {
        if (entity.getId() != null) {
            employeeDao.updatePrimaryEmail(entity.getContact(), entity);
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
    public EntityManager getEntityManager() {
        return em;
    }
}
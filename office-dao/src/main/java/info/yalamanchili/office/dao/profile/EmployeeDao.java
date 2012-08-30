/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    public Email updatePrimaryEmail(Contact emp, Email Newemail) {
        if (emp.getPrimaryEmail() == null) {
            Newemail.setPrimaryEmail(Boolean.TRUE);
        } else {
            if (Newemail.getPrimaryEmail()) {
                Email chkEmail = emp.getPrimaryEmail();
                chkEmail.setPrimaryEmail(Boolean.FALSE);
            }
        }
        return Newemail;

    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void delete(Long id) {
        Employee emp = findById(id);
        CUser cuser = emp.getUser();
        em.remove(cuser);
        em.flush();

    }
}

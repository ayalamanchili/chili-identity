/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.security.CUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

    public CUser getUser(Long id) {
        Query getUserQ = getEntityManager().createQuery("from " + CUser.class.getCanonicalName() + " user where user.employee.id=:empIdParam");
        getUserQ.setParameter("empIdParam", id);
        try {
            return (CUser) getUserQ.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        }
    }

    public Employee getEmployeWithEmpId(String empId) {
        Query getEmployeQ = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " emp where emp.empId=:empIdParam");
        getEmployeQ.setParameter("empIdParam", empId);
        try {
            return (Employee) getEmployeQ.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        }
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

    public static EmployeeDao instance() {
        return SpringContext.getBean(EmployeeDao.class);
    }
}

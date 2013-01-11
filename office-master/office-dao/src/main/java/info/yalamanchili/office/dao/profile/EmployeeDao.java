/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.dao.security.SecurityService;
import info.yalamanchili.office.entity.profile.Address;
import info.yalamanchili.office.entity.profile.AddressType;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import info.yalamanchili.office.entity.security.CUser;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
@Scope("request")
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    public Employee save(Employee entity) {
        if (entity.getId() != null) {
            Employee updatedEmployee = null;
            updatedEmployee = super.save(entity);
            updatedEmployee.setEmployeeType(em.find(EmployeeType.class, entity.getEmployeeType().getId()));
            return em.merge(updatedEmployee);
        }
        return super.save(entity);
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

    public Employee getEmployeWithEmpId(String empId) {
        Query getEmployeQ = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " emp where emp.employeeId=:empIdParam");
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

    public static EmployeeDao instance() {
        return SpringContext.getBean(EmployeeDao.class);
    }
}

/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import info.chili.security.SecurityUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import java.util.List;
import java.util.Map;

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
@Scope("prototype")
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    @Override
    public Employee save(Employee entity) {
        updateSSN(entity);
        if (entity.getId() != null) {
            Employee updatedEmployee = null;
            updatedEmployee = super.save(entity);
            updatedEmployee.setEmployeeType(em.find(EmployeeType.class, entity.getEmployeeType().getId()));
            return em.merge(updatedEmployee);
        }
        return super.save(entity);
    }
    //TODO move this to entity setter

    protected void updateSSN(Employee entity) {
        if (SecurityUtils.OBFUSCATED_STR.equals(entity.getSsn()) && null != entity.getId()) {
            entity.setSsn(findById(entity.getId()).getSsn());
        }
    }

    public Email updatePrimaryEmail(Contact emp, Email newEmail) {
        if (emp.getPrimaryEmail() == null) {
            newEmail.setPrimaryEmail(Boolean.TRUE);
        } else {
            Email existingEmail = emp.getPrimaryEmail();
            if (newEmail.getPrimaryEmail()) {
                existingEmail.setPrimaryEmail(Boolean.FALSE);
            }
            if (emp.getPrimaryEmail() != null && emp.getPrimaryEmail().getId().equals(newEmail.getId()) && newEmail.getPrimaryEmail().equals(Boolean.FALSE)) {
                throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "emp.atleast.one.priary.email", "Employee must have atleast one primary email");
            }
        }
        return newEmail;
    }

    public List<Employee> searchByCompanyContact(Employee companyContact, int start, int limit) {
        Query query = getEntityManager().createQuery("select DISTINCT cc.employee FROM " + CompanyContact.class.getCanonicalName() + " cc WHERE cc.contact.id=:contactIdParam", Employee.class);
        query.setParameter("contactIdParam", companyContact.getId());
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
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

    public Map<String, String> getCorpEntityStringMapByParams(int start, int limit, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Employee.class.getCanonicalName(), params) + " where employeeType.name='CORPORATE_EMPLOYEE'", start, limit, params);
    }

    public Map<String, String> getEmpByRoleEntityMap(int start, int limit, String... roles) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Employee.class.getCanonicalName()) + " where user.roles.rolename in " + roles[0] + "", start, limit);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static EmployeeDao instance() {
        return SpringContext.getBean(EmployeeDao.class);
    }
}

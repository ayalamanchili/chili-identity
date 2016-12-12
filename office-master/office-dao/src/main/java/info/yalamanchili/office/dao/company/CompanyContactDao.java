/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.company;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.profile.EmployeeDao;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anuyalamanchili
 */
@Repository
@Scope("prototype")
public class CompanyContactDao extends CRUDDao<CompanyContact> {

    @PersistenceContext
    protected EntityManager em;

    public CompanyContactDao() {
        super(CompanyContact.class);
    }

    public List<CompanyContact> getEmployeeCompanyContacts(Long employeeId) {
        Query query = getEntityManager().createQuery("from " + CompanyContact.class.getCanonicalName() + "  where employee.id=:employeeIdParam", CompanyContact.class);
        query.setParameter("employeeIdParam", employeeId);
        return query.getResultList();
    }

    public List<CompanyContact> getCompanyContact(Employee employee, String companyContactType) {
        TypedQuery<CompanyContact> query = em.createQuery("from " + CompanyContact.class.getCanonicalName() + " where employee=:empParam and type.name=:typeParam and contact.user.enabled=true", CompanyContact.class);
        query.setParameter("empParam", employee);
        query.setParameter("typeParam", companyContactType);
        return query.getResultList();
    }

    public List<Long> getCompanyContactIds(Long employeeId, String companyContactType) {
        TypedQuery<Long> query = em.createQuery("select contact.id from " + CompanyContact.class.getCanonicalName() + " where employee.id=:empParam and type.name=:typeParam and contact.user.enabled=true", Long.class);
        query.setParameter("empParam", employeeId);
        query.setParameter("typeParam", companyContactType);
        return query.getResultList();
    }

    public List<Employee> getCompanyContactsForEmployee(Employee emp, String companyContactType) {
        List<Employee> res = new ArrayList();
        for (CompanyContact cc : getCompanyContact(emp, companyContactType)) {
            res.add(cc.getContact());
        }
        return res;
    }
//TODO caching

    public Employee getCompanyContactForEmployee(Employee emp, String companyContactType) {
        List<CompanyContact> contacts = getCompanyContact(emp, companyContactType);
        if (contacts.size() > 0) {
            return contacts.get(0).getContact();
        } else {
            return null;
        }
    }

    public Long getCompanyContactIdForEmployeeId(Long employeeId, String companyContactType) {
        List<Long> contacts = getCompanyContactIds(employeeId, companyContactType);
        if (contacts.size() > 0) {
            return contacts.get(0);
        } else {
            return null;
        }
    }

    @Override
    public CompanyContact save(CompanyContact cnt) {
        CompanyContact entity = null;
        if (cnt.getId() == null) {
            entity = new CompanyContact();
            entity.setEmployee(EmployeeDao.instance().findById(cnt.getEmployee().getId()));
        } else {
            entity = findById(cnt.getId());
        }
        entity.setType(CompanyContactTypeDao.instance().findById(cnt.getType().getId()));
        entity.setContact(EmployeeDao.instance().findById(cnt.getContact().getId()));
        return em.merge(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static CompanyContactDao instance() {
        return SpringContext.getBean(CompanyContactDao.class);
    }
}

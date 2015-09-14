/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.profile;

import com.google.common.base.Joiner;
import info.chili.security.SecurityUtils;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.chili.jpa.QueryUtils;
import info.chili.security.dao.CRoleDao;
import info.chili.security.domain.CRole;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.bpm.OfficeBPMIdentityService;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.advreq.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
import info.yalamanchili.office.entity.Company;
import info.yalamanchili.office.entity.company.CompanyContact;
import info.yalamanchili.office.entity.profile.Contact;
import info.yalamanchili.office.entity.profile.Email;
import info.yalamanchili.office.entity.profile.Employee;
import info.yalamanchili.office.entity.profile.EmployeeType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class EmployeeDao extends CRUDDao<Employee> {

    @PersistenceContext
    protected EntityManager em;

    public EmployeeDao() {
        super(Employee.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> query(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " emp where emp.user.enabled=true order by upper(emp.firstName) ASC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();

    }

    @Transactional(readOnly = true)
    public List<Employee> queryAll(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " emp", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();

    }

    @Transactional(readOnly = true)
    @Override
    public Long size() {
        Query sizeQuery = getEntityManager().createQuery("select count (*) from " + Employee.class.getCanonicalName() + " emp where emp.user.enabled=true");
        return (Long) sizeQuery.getSingleResult();
    }
    //TODO temp method remove later

    @Transactional
    public void syncCorpEmployeeRoles() {
        CRole role = CRoleDao.instance().findRoleByName(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name());
        for (Employee emp : EmployeeDao.instance().getEmployeesByType("Corporate Employee")) {
            if (!OfficeSecurityService.instance().hasRole(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name())) {
                emp.getUser().addRole(role);
                em.merge(emp);
            }
        }

    }

    @Override
    public Employee save(Employee entity) {
        updateSSN(entity);
        if (entity.getId() != null) {
            Employee updatedEmployee = null;
            updatedEmployee = super.save(entity);
            updatedEmployee.setEmployeeType(em.find(EmployeeType.class, entity.getEmployeeType().getId()));
            if (entity.getCompany() != null) {
                updatedEmployee.setCompany(em.find(Company.class, entity.getCompany().getId()));
            } else {
                updatedEmployee.setCompany(null);
            }
            syncEmployeeTypeChange(updatedEmployee);
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

    protected void syncEmployeeTypeChange(Employee emp) {
        if ("Corporate Employee".equals(emp.getEmployeeType().getName())) {
            OfficeBPMIdentityService.instance().createUser(emp.getEmployeeId());
            emp.getUser().addRole(CRoleDao.instance().findRoleByName(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name()));
        } else {
            OfficeBPMIdentityService.instance().deleteUser(emp.getEmployeeId());
            emp.getUser().removeRole(CRoleDao.instance().findRoleByName(OfficeRoles.OfficeRole.ROLE_CORPORATE_EMPLOYEE.name()));
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

    @Transactional(readOnly = true)
    @Override
    public List<Employee> sqlSearch(String searchText, int start, int limit, List<String> columns) {
        return sqlSearch(searchText, start, limit, columns, false);
    }

    @Transactional(readOnly = true)
    public List<Employee> sqlSearch(String searchText, int start, int limit, List<String> columns, boolean includeDeactivated) {
        String queryStr = null;
        if (includeDeactivated) {
            queryStr = "FROM " + Employee.class.getCanonicalName() + " WHERE (upper(firstName) LIKE :firstNameParam OR upper(lastName) LIKE :lastNameParam)";

        } else {
            queryStr = "FROM " + Employee.class.getCanonicalName() + " WHERE user.enabled= TRUE and (upper(firstName) LIKE :firstNameParam OR upper(lastName) LIKE :lastNameParam)";
        }
        Query searchQ = getEntityManager().createQuery(queryStr);
        searchQ.setParameter("firstNameParam", '%' + searchText.toUpperCase() + '%');
        searchQ.setParameter("lastNameParam", '%' + searchText.toUpperCase() + '%');
        searchQ.setFirstResult(start);
        searchQ.setMaxResults(limit);
        return searchQ.getResultList();
    }

    public List<Employee> searchByCompanyContact(Employee companyContact, int start, int limit) {
        Query query = getEntityManager().createQuery("select DISTINCT cc.employee FROM " + CompanyContact.class.getCanonicalName() + " cc WHERE cc.contact.id=:contactIdParam", Employee.class);
        query.setParameter("contactIdParam", companyContact.getId());
        query.setFirstResult(start);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    public Employee findByEmail(String email) {
        TypedQuery<Employee> qry = em.createQuery("from " + Employee.class.getCanonicalName() + " emails.email=:emailParam and user.enabled=true", Employee.class);
        qry.setParameter("emailParam", email);
        if (qry.getResultList().size() > 0) {
            return qry.getResultList().get(0);
        } else {
            return null;
        }
    }

    @Cacheable(value = OfficeCacheKeys.EMPLOYEES, key = "{#root.methodName,#employeeId}")
    public Employee findEmployeWithEmpId(String employeeId) {
        Query getEmployeQ = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " emp where emp.employeeId=:empIdParam and emp.user.enabled=true");
        getEmployeQ.setParameter("empIdParam", employeeId);
        try {
            return (Employee) getEmployeQ.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (NonUniqueResultException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    public Map<String, String> getEntityStringMapByParams(int start, int limit, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Employee.class.getCanonicalName(), params) + " where user.enabled=true", start, limit, params);
    }

    public Map<String, String> getEmployeeStringMapByType(int start, int limit, List<String> employeeType, String... params) {
        return QueryUtils.getEntityStringMapByParams(getEntityManager(), QueryUtils.getListBoxResultsQueryString(Employee.class.getCanonicalName(), params) + " where user.enabled=true and employeeType.name in ('" + Joiner.on("','").join(employeeType) + "')", start, limit, params);
    }

    public List<Employee> getEmployeesByType(String type) {
        TypedQuery<Employee> query = em.createQuery("from " + Employee.class.getCanonicalName() + " where user.enabled=true and employeeType.name=:employeeTypeParam order by firstName", Employee.class);
        query.setParameter("employeeTypeParam", type);
        return query.getResultList();
    }

    public List<Employee> getEmployeesByType(String... types) {
        TypedQuery<Employee> query = em.createQuery("from " + Employee.class.getCanonicalName() + " where user.enabled=true and employeeType.name in ('" + Joiner.on("','").join(types) + "') order by firstName", Employee.class);
        return query.getResultList();
    }

    public List<Employee> getAllEmployeesByType(String type) {
        TypedQuery<Employee> query = em.createQuery("from " + Employee.class.getCanonicalName() + " where employeeType.name=:employeeTypeParam order by firstName", Employee.class);
        query.setParameter("employeeTypeParam", type);
        return query.getResultList();
    }

    public Map<String, String> getEmpByRoleEntityMap(int start, int limit, String role) {
        Map<String, String> res = new HashMap<>();
        CRole crole = QueryUtils.findEntity(getEntityManager(), CRole.class, "rolename", role);
        Query q = getEntityManager().createNativeQuery("SELECT emp.id, emp.firstName,emp.lastName from CONTACT emp INNER JOIN CUSER cuser ON cuser.userId=emp.user_userId INNER JOIN USERROLES userRoles ON userRoles.UserId=cuser.userId where cuser.enabled= TRUE and userRoles.RoleId=" + crole.getRoleId());
        for (Object obj : q.getResultList()) {
            Object[] selects = (Object[]) obj;
            res.put(selects[0].toString(), selects[1].toString() + " " + selects[2].toString());
        }
        return res;
    }
//TODO cache this

    public String getPrimaryEmail(String employeeId) {
        return getPrimaryEmail(findEmployeWithEmpId(employeeId));
    }

    public String getPrimaryEmail(Long employeeId) {
        TypedQuery<String> query = getEntityManager().createQuery("select email.email from " + Employee.class.getCanonicalName() + " emp, " + Email.class.getCanonicalName() + " email where email.contact.id=emp.id and emp.id=:employeeIdParam and email.primaryEmail = true", String.class);
        query.setParameter("employeeIdParam", employeeId);
        if (query.getResultList().size() > 0) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }

    public String getPrimaryEmail(Employee emp) {
        if (emp != null && emp.getId() != null) {
            return getPrimaryEmail(emp.getId());
        } else {
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        Employee emp = findById(id);
        PrivacySettingDao.instance().deleteAll(PrivacySettingDao.instance().getPrivacySettings(emp));
        CompanyContactDao.instance().deleteAll(CompanyContactDao.instance().getEmployeeCompanyContacts(id));
        EmployeeDocumentDao.instance().deleteAll(EmployeeDocumentDao.instance().getDocuments(id));
        ServiceTicketDao.instance().deleteAll(ServiceTicketDao.instance().getTickets(emp, 0, 10000));
        ConsultantTimeSheetDao.instance().deleteAll(ConsultantTimeSheetDao.instance().getTimeSheetsEmployee(emp, null, null, 0, 10000));
        CorporateTimeSheetDao.instance().deleteAll(CorporateTimeSheetDao.instance().getTimeSheetsEmployee(emp, null, null, 0, 10000));
        AdvanceRequisitionDao.instance().deleteAll(AdvanceRequisitionDao.instance().queryForEmployee(emp.getId(), 0, 10000));
        /*
         Expenses
         AdjustmentHours
         TimeSheet
         */
        try {
            super.delete(emp);
        } catch (org.hibernate.exception.ConstraintViolationException cve) {
            throw new RuntimeException(cve.getConstraintName(), cve);
        } catch (Exception e) {
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

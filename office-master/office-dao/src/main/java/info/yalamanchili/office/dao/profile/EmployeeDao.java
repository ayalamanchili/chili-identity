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
import info.yalamanchili.office.dao.expense.AdvanceRequisitionDao;
import info.yalamanchili.office.dao.privacy.PrivacySettingDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.dao.selfserv.ServiceTicketDao;
import info.yalamanchili.office.dao.time.ConsultantTimeSheetDao;
import info.yalamanchili.office.dao.time.CorporateTimeSheetDao;
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
    public List<Employee> query(Employee emp, int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + Employee.class.getCanonicalName() + " where emp =:empParam order by  emp.firstName  ASC", entityCls);
        findAllQuery.setParameter("emp", emp);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();

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

    @Cacheable(value = OfficeCacheKeys.EMAILS, key = "{#root.methodName,#employeeId}")
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
        TypedQuery<Employee> query = em.createQuery("from " + Employee.class.getCanonicalName() + " where user.enabled=true and employeeType.name=:employeeTypeParam", Employee.class);
        query.setParameter("employeeTypeParam", type);
        return query.getResultList();
    }

    public Map<String, String> getEmpByRoleEntityMap(int start, int limit, String role) {
        Map<String, String> res = new HashMap<String, String>();
        CRole crole = QueryUtils.findEntity(getEntityManager(), CRole.class, "rolename", role);
        Query q = getEntityManager().createNativeQuery("SELECT emp.id, emp.firstName,emp.lastName from CONTACT emp INNER JOIN CUSER cuser ON cuser.userId=emp.user_userId INNER JOIN USERROLES userRoles ON userRoles.UserId=cuser.userId where cuser.enabled= TRUE and userRoles.RoleId=" + crole.getRoleId());
        for (Object obj : q.getResultList()) {
            Object[] selects = (Object[]) obj;
            res.put(selects[0].toString(), selects[1].toString() + " " + selects[2].toString());
        }
        return res;
    }

    @Override
    public void delete(Long id) {
        Employee emp = findById(id);
        PrivacySettingDao.instance().deleteAll(PrivacySettingDao.instance().getPrivacySettings(emp));
        CompanyContactDao.instance().deleteAll(CompanyContactDao.instance().getEmployeeCompanyContacts(id));
        EmployeeDocumentDao.instance().deleteAll(EmployeeDocumentDao.instance().getDocuments(id));
        ServiceTicketDao.instance().deleteAll(ServiceTicketDao.instance().getTickets(emp, 0, 1000));
        ConsultantTimeSheetDao.instance().deleteAll(ConsultantTimeSheetDao.instance().getTimeSheetsEmployee(emp, null, null, 0, 1000));
        CorporateTimeSheetDao.instance().deleteAll(CorporateTimeSheetDao.instance().getTimeSheetsEmployee(emp, null, null, 0, 1000));
        AdvanceRequisitionDao.instance().deleteAll(AdvanceRequisitionDao.instance().queryForEmployee(emp.getId(), 0, 1000));
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

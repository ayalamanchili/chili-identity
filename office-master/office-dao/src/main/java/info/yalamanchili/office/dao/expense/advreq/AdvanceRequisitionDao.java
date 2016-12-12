/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.advreq;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.company.CompanyContactDao;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.expense.CheckDao;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.expense.Transaction;
import info.yalamanchili.office.entity.profile.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author prasanthi.p
 */
@Repository
@Scope("prototype")
public class AdvanceRequisitionDao extends CRUDDao<AdvanceRequisition> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    @Cacheable(OfficeCacheKeys.ADVANCE_REQUSITON)
    public AdvanceRequisition findById(Long id) {
        AdvanceRequisition entity = super.findById(id);
        if (entity == null) {
            return null;
        }
        entity.setCheck(CheckDao.instance().find(entity));
        entity.setBankAccount(BankAccountDao.instance().find(entity));
        return entity;
    }

    @Override
    @CacheEvict(value = OfficeCacheKeys.ADVANCE_REQUSITON, allEntries = true)
    public AdvanceRequisition save(AdvanceRequisition entity) {
        Check check = entity.getCheck();
        BankAccount account = entity.getBankAccount();
        entity = super.save(entity);
        if (check != null) {
            CheckDao.instance().save(check, entity);
        }
        if (account != null) {
            BankAccountDao.instance().save(account, entity);
        }
        return entity;
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#start,#limit}")
    public List<AdvanceRequisition> queryAll(Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by dateRequested DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#employeeId,#start,#limit}")
    public List<AdvanceRequisition> queryForEmployee(Long employeeId, Integer start, Integer limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by dateRequested DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Override
    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName}")
    public Long size() {
        return super.size();
    }

    @Cacheable(value = OfficeCacheKeys.ADVANCE_REQUSITON, key = "{#root.methodName,#employeeId}")
    public Long size(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
    }

    public void acceccCheck(Employee employee) {
        Employee currentUser = OfficeSecurityService.instance().getCurrentUser();
        if (employee.getId().equals(currentUser.getId())) {
            return;
        }
        boolean isCorporateEmployee = false;
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
            isCorporateEmployee = true;
        }
        //this is a corp emp review
        if (isCorporateEmployee) {
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
                return;
            }
            Employee perfEvalMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Perf_Eval_Manager");
            if (perfEvalMgr != null && currentUser.getId().equals(perfEvalMgr.getId())) {
                return;
            }
            Employee reportsToMgr = CompanyContactDao.instance().getCompanyContactForEmployee(employee, "Reports_To");
            if (reportsToMgr != null && currentUser.getId().equals(reportsToMgr.getId())) {
                return;
            }
        } //Consultant employee review
        else {
            if (OfficeSecurityService.instance().hasAnyRole(OfficeRoles.OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name(), OfficeRoles.OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRoles.OfficeRole.ROLE_ADMIN.name())) {
                return;
            }
        }
        throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "permission.error", "you do not have permission to view this information");
    }

    public void addTransaction(Long id, Transaction transaction) {
        transaction = TransactionDao.instance().save(transaction);
        AdvanceRequisition entity = findById(id);
        entity.addTransaction(transaction);
    }

    public List<Transaction> getTransactions(Long id, int start, int limit) {
        AdvanceRequisition entity = findById(id);
        return entity.getTransactions();
    }

    public Long getTransactionsSize(Long id, int start, int limit) {
        AdvanceRequisition entity = findById(id);
        return (long) entity.getTransactions().size();
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public AdvanceRequisitionDao() {
        super(AdvanceRequisition.class);
    }

    public static AdvanceRequisitionDao instance() {
        return SpringContext.getBean(AdvanceRequisitionDao.class);
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.OfficeRoles.OfficeRole;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.dao.security.OfficeSecurityService;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.expense.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
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

    @Override
    @Transactional(readOnly = true)
    public List<AdvanceRequisition> query(int start, int limit) {
        if (OfficeSecurityService.instance().hasAnyRole(OfficeRole.ROLE_ACCOUNTS_PAYABLE.name(), OfficeRole.ROLE_PAYROLL_AND_BENIFITS.name())) {
            return queryAll(start, limit);
        } else {
            return queryForEmployee(OfficeSecurityService.instance().getCurrentUser().getId(), start, limit);
        }
    }

    protected List<AdvanceRequisition> queryAll(int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " order by dateRequested DESC", entityCls);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public List<AdvanceRequisition> queryForEmployee(Long employeeId, int start, int limit) {
        Query findAllQuery = getEntityManager().createQuery("from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam order by dateRequested DESC", entityCls);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        findAllQuery.setFirstResult(start);
        findAllQuery.setMaxResults(limit);
        return findAllQuery.getResultList();
    }

    public Long queryForEmployeeSize(Long employeeId) {
        TypedQuery<Long> findAllQuery = getEntityManager().createQuery("select count(*) from " + entityCls.getCanonicalName() + " where employee.id=:employeeIdParam", Long.class);
        findAllQuery.setParameter("employeeIdParam", employeeId);
        return findAllQuery.getSingleResult();
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

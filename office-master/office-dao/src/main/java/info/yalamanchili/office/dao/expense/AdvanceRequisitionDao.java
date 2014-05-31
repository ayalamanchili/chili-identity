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
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.expense.Transaction;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

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
        entity.setCheck(CheckDao.instance().find(entity));
        entity.setBankAccount(BankAccountDao.instance().find(entity));
        return entity;
    }

    @Override
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

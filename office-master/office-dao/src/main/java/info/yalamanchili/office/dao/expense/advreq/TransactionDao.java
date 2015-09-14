/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.advreq;

import info.chili.dao.CRUDDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.dao.expense.BankAccountDao;
import info.yalamanchili.office.dao.expense.CheckDao;
import info.yalamanchili.office.entity.expense.AdvanceRequisition;
import info.yalamanchili.office.entity.expense.BankAccount;
import info.yalamanchili.office.entity.expense.Check;
import info.yalamanchili.office.entity.expense.Transaction;
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
public class TransactionDao extends CRUDDao<Transaction> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Transaction findById(Long id) {
        Transaction entity = super.findById(id);
        entity.setCheck(CheckDao.instance().find(entity));
        entity.setBankAccount(BankAccountDao.instance().find(entity));
        return entity;
    }

    @Override
    public Transaction save(Transaction entity) {
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
    public EntityManager getEntityManager() {
        return em;
    }

    public TransactionDao() {
        super(Transaction.class);
    }

    public static TransactionDao instance() {
        return SpringContext.getBean(TransactionDao.class);
    }
}

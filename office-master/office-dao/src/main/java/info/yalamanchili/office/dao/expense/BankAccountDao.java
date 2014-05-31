/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.chili.dao.AbstractHandleEntityDao;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.entity.expense.BankAccount;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayalamanchili
 */
@Repository
@Scope("prototype")
public class BankAccountDao extends AbstractHandleEntityDao<BankAccount> {

    @PersistenceContext
    protected EntityManager em;

    public BankAccountDao() {
        super(BankAccount.class);
    }

    public static BankAccountDao instance() {
        return SpringContext.getBean(BankAccountDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

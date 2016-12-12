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
import javax.persistence.TypedQuery;
import org.jasypt.hibernate.encryptor.HibernatePBEStringEncryptor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
//TODO temp for existing data encryption

    @Transactional
    public void mergeAll() {
        TypedQuery<BankAccount> q = em.createQuery("from " + BankAccount.class.getCanonicalName(), BankAccount.class);
        HibernatePBEStringEncryptor e = (HibernatePBEStringEncryptor) SpringContext.getBean("hibernateStringEncryptor");
        for (BankAccount ba : q.getResultList()) {
            ba.setBankAccountNumber(e.encrypt(ba.getBankAccountNumber()));
            em.merge(ba);
        }
    }
    
//    @Transactional
//    public void mergeAll() {
//        TypedQuery<BankAccount> q = em.createQuery("from " + BankAccount.class.getCanonicalName(), BankAccount.class);
//        for (BankAccount ba : q.getResultList()) {
//            em.merge(ba);
//        }
//    }

    public static BankAccountDao instance() {
        return SpringContext.getBean(BankAccountDao.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}

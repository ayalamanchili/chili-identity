/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.expenserpt;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prashanthi
 */
@Repository
@Scope("prototype")
public class ExpenseCategoryDao extends CRUDDao<ExpenseCategory> {

    public ExpenseCategoryDao() {
        super(ExpenseCategory.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ExpenseCategoryDao instance() {
        return SpringContext.getBean(ExpenseCategoryDao.class);
    }
}

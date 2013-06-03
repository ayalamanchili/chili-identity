/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.chili.spring.SpringContext;
import info.chili.dao.CRUDDao;
import info.yalamanchili.office.entity.expense.Expense;
import info.yalamanchili.office.entity.expense.ExpenseCategory;
import info.yalamanchili.office.entity.profile.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author raghu
 */
@Component
@Scope("prototype")
public class ExpenseDao extends CRUDDao<Expense> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public Expense save(Expense entity) {
        entity.setCategory(getEntityManager().find(ExpenseCategory.class, entity.getCategory().getId()));
        entity.setEmployee(getEntityManager().find(Employee.class, entity.getEmployee().getId()));
        return super.save(entity);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ExpenseDao() {
        super(Expense.class);
    }

    public static ExpenseDao instance() {
        return SpringContext.getBean(ExpenseDao.class);
    }
}

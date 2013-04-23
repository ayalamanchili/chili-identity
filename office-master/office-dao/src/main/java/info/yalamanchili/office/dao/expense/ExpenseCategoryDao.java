/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense;

import info.yalamanchili.office.dao.CRUDDao;
import info.yalamanchili.office.entity.expense.ExpenseCategory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Prashanthi
 */
@Component
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
}

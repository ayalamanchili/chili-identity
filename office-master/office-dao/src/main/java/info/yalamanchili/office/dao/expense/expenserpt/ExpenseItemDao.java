/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.dao.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.chili.service.jrs.exception.ServiceException;
import info.chili.spring.SpringContext;
import info.yalamanchili.office.cache.OfficeCacheKeys;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseCategory;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Prasanthi.p
 */
@Repository
@Scope("prototype")
public class ExpenseItemDao extends CRUDDao<ExpenseItem> {

    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    @Override
    public ExpenseItem save(ExpenseItem entity) {
        entity.setCategory(em.find(ExpenseCategory.class, entity.getCategory().getId()));
        return super.save(entity);
    }

    @CacheEvict(value = OfficeCacheKeys.EXPENSE, allEntries = true)
    @Override
    public void delete(Long id) {
        ExpenseItem entity = findById(id);
        if (entity.getExpenseReport().getExpenseItems().size() == 1) {
            throw new ServiceException(ServiceException.StatusCode.INVALID_REQUEST, "SYSTEM", "expense.report.min.items", "Expense Report should hve atleast one item.");
        } else {
            delete(findById(id));
        }
    }

    public ExpenseItemDao() {
        super(ExpenseItem.class);
    }
    @PersistenceContext
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public static ExpenseItemDao instance() {
        return SpringContext.getBean(ExpenseItemDao.class);
    }
}

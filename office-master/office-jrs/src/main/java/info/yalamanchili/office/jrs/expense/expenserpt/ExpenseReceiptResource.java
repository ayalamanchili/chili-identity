/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.jrs.expense.expenserpt;

import info.chili.dao.CRUDDao;
import info.yalamanchili.office.dao.expense.expenserpt.ExpenseReceiptDao;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.jrs.CRUDResource;
import javax.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ayalamanchili
 */
@Path("secured/expense-receipt")
@Component
@Transactional
@Scope("request")
public class ExpenseReceiptResource extends CRUDResource<ExpenseItem> {

    @Autowired
    public ExpenseReceiptDao expenseReceiptDao;

    @Override
    public CRUDDao getDao() {
        return expenseReceiptDao;
    }

}

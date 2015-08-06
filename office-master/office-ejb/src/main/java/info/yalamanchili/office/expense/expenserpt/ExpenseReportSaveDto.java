/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense.expenserpt;

import info.yalamanchili.office.entity.expense.expenserpt.ExpenseItem;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReceipt;
import info.yalamanchili.office.entity.expense.expenserpt.ExpenseReport;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author ayalamanchili
 */
@XmlRootElement
@XmlType
public class ExpenseReportSaveDto extends ExpenseReport {

    protected List<ExpenseItem> expenseItems;

    protected List<ExpenseReceipt> expenseReceipts;

    @Override
    @XmlElement
    @Size(min = 1, message = "{expenseitem.min.size.msg}")
    @Valid
    public List<ExpenseItem> getExpenseItems() {
        if (this.expenseItems == null) {
            this.expenseItems = new ArrayList<>();
        }
        return expenseItems;
    }

    @Override
    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }

    @XmlElement
    @Override
    public List<ExpenseReceipt> getExpenseReceipts() {
        if (this.expenseReceipts == null) {
            this.expenseReceipts = new ArrayList();
        }
        return expenseReceipts;
    }

    @Override
    public void setExpenseReceipts(List<ExpenseReceipt> expenseReceipts) {
        this.expenseReceipts = expenseReceipts;
    }

}

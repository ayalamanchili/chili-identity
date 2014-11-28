/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.expense;

import info.yalamanchili.office.entity.expense.ExpenseItem;
import info.yalamanchili.office.entity.expense.ExpenseReport;
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
public class ExpeneseReportSaveDto extends ExpenseReport {

    protected List<ExpenseItem> expenseItems;

    @Override
    @XmlElement
    @Size(min = 1, message = "{expenseitem.min.size.msg}")
    @Valid
    public List<ExpenseItem> getExpenseItems() {
        if (this.expenseItems == null) {
            this.expenseItems = new ArrayList<ExpenseItem>();
        }
        return expenseItems;
    }

    @Override
    public void setExpenseItems(List<ExpenseItem> expenseItems) {
        this.expenseItems = expenseItems;
    }
}

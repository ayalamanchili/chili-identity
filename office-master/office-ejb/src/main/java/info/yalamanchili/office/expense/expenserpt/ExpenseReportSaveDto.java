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
import info.yalamanchili.office.entity.profile.Employee;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    protected Set<ExpenseReceipt> expenseReceipts;

    protected String comments;

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
    public Set<ExpenseReceipt> getExpenseReceipts() {
        if (this.expenseReceipts == null) {
            this.expenseReceipts = new HashSet();
        }
        return expenseReceipts;
    }

    @Override
    public void setExpenseReceipts(Set<ExpenseReceipt> expenseReceipts) {
        this.expenseReceipts = expenseReceipts;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

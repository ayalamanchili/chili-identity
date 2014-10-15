/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancerequisition.AdvanceRequisitionSidePanel;
import info.yalamanchili.office.client.advancerequisition.ReadAllAdvanceRequisitionPanel;
import info.yalamanchili.office.client.expensecategory.ExpenseCategorySidePanel;
import info.yalamanchili.office.client.expensecategory.ReadAllExpenseCategoryPanel;
import info.yalamanchili.office.client.transaction.ReadAllTransactionPanel;
import info.yalamanchili.office.client.transaction.TransactionSidePanel;

/**
 *
 * @author Prashanthi
 */
public class ExpenseMenu extends Composite {

    MenuBar expenseMenuBar = new MenuBar(false);

    public ExpenseMenu() {
        initWidget(expenseMenuBar);
        configureExpenseMenu();
    }

    protected void configureExpenseMenu() {

        expenseMenuBar.addItem("AdvanceRequisition", expensadvancerequisitionCmd);
        expenseMenuBar.addItem("Expense", expenseMaintainenceCmd);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {

            expenseMenuBar.addItem("ExpenseCategories", expenseCategoriesMaintainenceCmd);
            expenseMenuBar.addItem("ExpenseReports", expenseReportsMaintainenceCmd);
            expenseMenuBar.addItem("ExpenseItem", expenseItemMaintainenceCmd);
        }
//        expenseMenuBar.addItem("Transaction", expensTransactionCmd);
        expenseMenuBar.addStyleName("entityMenuBar");
    }
    Command expenseMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpensesPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ExpensesSidePanel());
        }
    };
    Command expenseCategoriesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpenseCategoryPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ExpenseCategorySidePanel());
        }
    };
    Command expensadvancerequisitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllAdvanceRequisitionPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new AdvanceRequisitionSidePanel());
        }
    };
    Command expensTransactionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTransactionPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new TransactionSidePanel());
        }
    };
    Command expenseReportsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
//            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTransactionPanel());
//            TabPanel.instance().getExpensePanel().sidePanelTop.add(new TransactionSidePanel());
        }
    };
    Command expenseItemMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
//            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTransactionPanel());
//            TabPanel.instance().getExpensePanel().sidePanelTop.add(new TransactionSidePanel());
        }
    };
}

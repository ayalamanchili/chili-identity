/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.ExpenseCategorySidePanel;
import info.yalamanchili.office.client.expensecategory.ReadAllExpenseCategoryPanel;

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
        MenuBar menu = new MenuBar(true);
        expenseMenuBar.addItem("Expense", expenseMaintainenceCmd);
        expenseMenuBar.addItem("ExpenseCategories", expenseCategoriesMaintainenceCmd);

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
}

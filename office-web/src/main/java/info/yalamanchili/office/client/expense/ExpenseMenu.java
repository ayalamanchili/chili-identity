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
import info.yalamanchili.office.client.expense.travelauthorization.ReadAllTravelExpensePanel;
import info.yalamanchili.office.client.expense.travelauthorization.TravelExpenseSidePanel;
import info.yalamanchili.office.client.expensecategory.ExpenseCategorySidePanel;
import info.yalamanchili.office.client.expensecategory.ReadAllExpenseCategoryPanel;
import info.yalamanchili.office.client.expensereports.ExpenseReportsSidePanel;
import info.yalamanchili.office.client.expensereports.ReadAllExpenseReportsPanel;

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
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_H1B_IMMIGRATION)) {
            expenseMenuBar.addItem("CheckRequisition", expensimmigrationcheckrequisitionCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            expenseMenuBar.addItem("ExpenseReports", expenseReportsMaintainenceCmd);
            expenseMenuBar.addItem("ExpenseCategories", expenseCategoriesMaintainenceCmd);
        }
        expenseMenuBar.addItem("Travel Expense", travelEcpenseMaintainenceCmd);
        expenseMenuBar.addStyleName("entityMenuBar");
    }
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
    Command expensimmigrationcheckrequisitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
        }
    };
    Command expenseReportsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpenseReportsPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ExpenseReportsSidePanel());

        }
    };
    Command travelEcpenseMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTravelExpensePanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new TravelExpenseSidePanel());
        }
    };
}

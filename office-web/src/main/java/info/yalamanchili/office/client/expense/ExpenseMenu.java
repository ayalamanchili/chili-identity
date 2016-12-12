/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import info.yalamanchili.office.client.expense.chkreq.ReadAllImmigrationCheckRequisitionPanel;
import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.advancerequisition.AdvanceRequisitionSidePanel;
import info.yalamanchili.office.client.advancerequisition.ReadAllAdvanceRequisitionPanel;
import info.yalamanchili.office.client.expense.chkreq.ImmigrationCheckRequisitionSidePanel;
import info.yalamanchili.office.client.expense.perdiem.ReadAllPerdiemPanel;
import info.yalamanchili.office.client.expense.travelauthorization.ReadAllTravelAuthorizationPanel;
import info.yalamanchili.office.client.expense.travelauthorization.TravelAuthorizationSidePanel;
import info.yalamanchili.office.client.expensecategory.ReadAllExpenseCategoryPanel;
import info.yalamanchili.office.client.expensereports.ExpenseReportsSidePanel;
import info.yalamanchili.office.client.expensereports.ReadAllExpenseReportsPanel;

/**
 *
 * @author Prashanthi
 */
public class ExpenseMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        addMenuItem("Advance Requisition", "Advance Requisition", expensadvancerequisitionCmd);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            addMenuItem("Expense Categories", "Expense Categories", expenseCategoriesMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            addMenuItem("Check Requisition", "Check Requisition", expensimmigrationcheckrequisitionCmd);
        }
        addMenuItem("Expense Reports", "Expense Reports", expenseReportsMaintainenceCmd);
        addMenuItem("Travel Authorization", "Travel Authorization", travelEcpenseMaintainenceCmd);
        addMenuItem("Per Diem", "Per Diem", perDiemRequestMaintainenceCmd);
    }

    static Command expenseCategoriesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpenseCategoryPanel());
        }
    };
    static Command perDiemRequestMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllPerdiemPanel());
        }
    };
    
    static Command expensadvancerequisitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllAdvanceRequisitionPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new AdvanceRequisitionSidePanel());
        }
    };
    static Command expensimmigrationcheckrequisitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllImmigrationCheckRequisitionPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ImmigrationCheckRequisitionSidePanel());
        }
    };
    static Command expenseReportsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllExpenseReportsPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new ExpenseReportsSidePanel());

        }
    };
    static Command travelEcpenseMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getExpensePanel().entityPanel.clear();
            TabPanel.instance().getExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getExpensePanel().entityPanel.add(new ReadAllTravelAuthorizationPanel());
            TabPanel.instance().getExpensePanel().sidePanelTop.add(new TravelAuthorizationSidePanel());
        }
    };
}

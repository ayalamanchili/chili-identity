/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.invoice.InvoiceSidePanel;
import info.yalamanchili.office.client.admin.groupemails.EmailGroupsSidePanel;
import info.yalamanchili.office.client.admin.invoice.ReadAllInvoicePanel;
import info.yalamanchili.office.client.contracts.ContractsSidePanel;
import info.yalamanchili.office.client.contracts.ReadAllContractsPanel;
import info.yalamanchili.office.client.employee.prbprdeval.ProbatioPeriodPerfEvaluationReportsSidePanel;
import info.yalamanchili.office.client.employee.prefeval.PerfEvaluationReportsSidePanel;

import info.yalamanchili.office.client.profile.reports.ProfileReportsSidePanel;
import info.yalamanchili.office.client.profile.reports.RetirementPlanOptInSidePanal;
import info.yalamanchili.office.client.profile.statusreport.CorporateStatusReportSidePanel;

/**
 *
 * @author prasanthi.p
 */
public class ReportsMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
            addMenuItem("Contracts", "Contracts", contractingMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_INVOICE_MANAGER)) {
            addMenuItem("Invoices", "Invoices", invoicereportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP,ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Profile Reports", "Profile Reports", profileReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Perf Evaluations", "Perf Evaluations", performanceEvaluationsReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CRP_STATUS_RPT_MGR, Auth.ROLE.ROLE_ADMIN)) {
            addMenuItem("Status Report", "Status Report", corporatestatusReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_HR, ROLE.ROLE_PRB_EVALUATIONS_MANAGER)) {
            addMenuItem("Probation Period", "Probation Period", probperformanceEvaluationsReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
            addMenuItem("Benefit Enrollment", "Benefit Enrollment", retirementPlanReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Email Groups", "Email Groups", emailMenuMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_BILLING_ADMIN, ROLE.ROLE_RECRUITER, ROLE.ROLE_CONTRACTS_ADMIN)) {
            addMenuItem("Contracts Reports", "Contracts Reports", contractReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Address Reports", "Address Reports", addressReportMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("PayRate Reports", "PayRate Reports", payRateCmd);
        }
    }
    public static Command contractingMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllContractsPanel());
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ContractsSidePanel());
        }
    };
    public static Command invoicereportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllInvoicePanel(true));
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new InvoiceSidePanel());
        }
    };

    public static Command contractReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_BILLING_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
                TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllBisContractsPanel());
            }
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new BISReportsSidePanel());
        }
    };
    static Command profileReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ProfileReportsSidePanel());
        }
    };
    static Command performanceEvaluationsReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new PerfEvaluationReportsSidePanel());
        }
    };
    static Command probperformanceEvaluationsReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ProbatioPeriodPerfEvaluationReportsSidePanel());
        }
    };
    static Command retirementPlanReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new RetirementPlanOptInSidePanal());
        }
    };
    static Command corporatestatusReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new CorporateStatusReportSidePanel());
        }
    };
    static Command emailMenuMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new EmailGroupsSidePanel());
        }
    };
    static Command addressReportMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new AddressReportSidePanel());
        }
    };
    static Command payRateCmd = new Command() {
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new PayRateSummaryReportSidePanel());
        }
    };

    @Override
    public void selectDefaultItem() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
            contractingMaintainenceCmd.execute();
        } else {
            super.selectDefaultItem();
        }
    }
}

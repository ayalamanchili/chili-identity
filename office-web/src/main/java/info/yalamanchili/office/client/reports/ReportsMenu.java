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
import info.yalamanchili.office.client.admin.groupemails.EmailGroupsSidePanel;
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
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            addMenuItem("Profile Reports", "Profile Reports", profileReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
            addMenuItem("Contracts", "Contracts", contractingMaintainenceCmd);
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
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Retirement Plan", "Retirement Plan", retirementPlanReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addMenuItem("Email Groups", "Email Groups", emailMenuMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
            addMenuItem("Contracts Reports", "Contracts Reports", contractReportsMaintainenceCmd);
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
    public static Command contractReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllBisContractsPanel());
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

    @Override
    public void selectDefaultItem() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_FULL_VIEW)) {
            contractingMaintainenceCmd.execute();
        } else {
            super.selectDefaultItem();
        }
    }
}

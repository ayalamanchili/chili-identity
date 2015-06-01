/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
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
public class ReportsMenu extends Composite {

    MenuBar reportsMenuBar = new MenuBar(false);

    public ReportsMenu() {
        initWidget(reportsMenuBar);
        configureReportsMenu();
    }

    protected void configureReportsMenu() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            reportsMenuBar.addItem("Profile Reports", profileReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_EXPENSE, ROLE.ROLE_TIME, ROLE.ROLE_ACCOUNT_VIEW)) {
            reportsMenuBar.addItem("Contracts", contractingMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            reportsMenuBar.addItem("Perf Evaluations", performanceEvaluationsReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_HR)) {
            reportsMenuBar.addItem("Status Report", corporatestatusReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_HR, ROLE.ROLE_PRB_EVALUATIONS_MANAGER)) {
            reportsMenuBar.addItem("Probation Period", probperformanceEvaluationsReportsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            reportsMenuBar.addItem("Retirement Plan", retirementPlanReportsMaintainenceCmd);
        }
        reportsMenuBar.addStyleName("entityMenuBar");
    }
    Command contractingMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().entityPanel.add(new ReadAllContractsPanel());
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ContractsSidePanel());
        }
    };
    Command profileReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ProfileReportsSidePanel());
        }
    };
    Command performanceEvaluationsReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new PerfEvaluationReportsSidePanel());
        }
    };
    Command probperformanceEvaluationsReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new ProbatioPeriodPerfEvaluationReportsSidePanel());
        }
    };
    Command retirementPlanReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new RetirementPlanOptInSidePanal());
        }
    };
    Command corporatestatusReportsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.add(new CorporateStatusReportSidePanel());
        }
    };
}

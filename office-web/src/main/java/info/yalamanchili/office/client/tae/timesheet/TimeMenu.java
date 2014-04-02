/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import info.yalamanchili.office.client.time.corp.CorporateTimeSummaryPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.tae.bonuspayment.AdjustmentHoursSidePanel;
import info.yalamanchili.office.client.tae.bonuspayment.ReadAllAdjustmentHoursPanel;
import info.yalamanchili.office.client.tae.timesheetperiod.TimeSheetPeriodSidePanel;
import info.yalamanchili.office.client.tae.timesheetperiod.ReadAllTimeSheetPeriodsPanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSidePanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummarySidePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.consultant.ReadCurrentConsultantLeavesPanel;
import info.yalamanchili.office.client.time.corp.CorpoateTimeSidePanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import info.yalamanchili.office.client.time.corp.ReadCurrentCorpLeavesPanel;

/**
 *
 * @author ayalamanchili
 */
public class TimeMenu extends Composite {

    MenuBar tAEMenuBar = new MenuBar(false);

    public TimeMenu() {
        initWidget(tAEMenuBar);
        configureTAEMenu();
    }

    protected void configureTAEMenu() {
        tAEMenuBar.addItem("Summary", summaryMaintainenceCmd);
        if (Auth.isCorporateEmployee()) {
            tAEMenuBar.addItem("Corporate Time", corpTimeMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CONSULTANT_TIME_REPORTS)) {
            tAEMenuBar.addItem("Employee Time", consultantTimeMaintainenceCmd);
        }
        tAEMenuBar.addStyleName("entityMenuBar");
    }
    Command summaryMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            if (Auth.isCorporateEmployee()) {
                TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentCorpLeavesPanel());
            } else {
                TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSummarySidePanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentConsultantLeavesPanel());
            }
        }
    };
    Command corpTimeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorpoateTimeSidePanel());
        }
    };

    Command consultantTimeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSidePanel());
        }
    };
    Command timeSheetPeriodsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().getTimePanel().entityPanel.add(new CurrentEmployeeTimeSummaryPanel());
            } else {
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllTimeSheetPeriodsPanel());
                TabPanel.instance().getTimePanel().sidePanelTop.add(new TimeSheetPeriodSidePanel());
            }
        }
    };
    Command timeSheetsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().getTimePanel().entityPanel.add(new CurrentEmployeeTimeSummaryPanel());
            } else {
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllTimesheetPanel());
                TabPanel.instance().getTimePanel().sidePanelTop.add(new TimeSheetSidePanel());
            }
        }
    };
    Command bonusPaymentsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllAdjustmentHoursPanel());
            TabPanel.instance().getTimePanel().sidePanelTop.add(new AdjustmentHoursSidePanel());
        }
    };
}

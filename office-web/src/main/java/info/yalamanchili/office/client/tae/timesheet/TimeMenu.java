/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import info.yalamanchili.office.client.time.corp.CorporateTimeSummaryPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.tae.bonuspayment.AdjustmentHoursSidePanel;
import info.yalamanchili.office.client.tae.bonuspayment.ReadAllAdjustmentHoursPanel;
import info.yalamanchili.office.client.tae.Attendence.AttendenceSidePanel;
import info.yalamanchili.office.client.tae.timesheetperiod.TimeSheetPeriodSidePanel;
import info.yalamanchili.office.client.tae.timesheetperiod.ReadAllTimeSheetPeriodsPanel;
import info.yalamanchili.office.client.time.CurrentWeekOutOfOfficeRequestsPanel;
import info.yalamanchili.office.client.time.OutOfOfficeSidePanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSidePanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummaryPanel;
import info.yalamanchili.office.client.time.consultant.ConsultantTimeSummarySidePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import info.yalamanchili.office.client.time.consultant.ReadCurrentConsultantLeavesPanel;
import info.yalamanchili.office.client.time.corp.CorporateTimeSidePanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;
import info.yalamanchili.office.client.time.corp.ReadCurrentCorpLeavesPanel;
import info.yalamanchili.office.client.time.ReadAllOutOfOfficePanel;

/**
 *
 * @author ayalamanchili
 */
public class TimeMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        addMenuItem("Summary", "Summary", summaryMaintainenceCmd);
        if (Auth.isCorporateEmployee()) {
            addMenuItem("Corporate Time", "Corporate Time", corpTimeMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CONSULTANT_TIME_REPORTS)) {
            addMenuItem("Employee Time", "Employee Time", consultantTimeMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CORPORATE_TIME_REPORTS, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_BULK_IMPORT)) {
            addMenuItem("Attendance", "Attendance", attendenceCmd);
        }
        if (Auth.isCorporateEmployee()) {
            addMenuItem("Remote Work", "Remote Work", outOfOfficeMaintainenceCmd);
        }
    }
    static Command summaryMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            if (Auth.isCorporateEmployee()) {
                TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentCorpLeavesPanel());
                if (Auth.hasAnyOfRoles(ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
                    TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentConsultantLeavesPanel());
                }
            } else if (Auth.isConsultantEmployee()) {
                TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSummarySidePanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel());
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel());
            }
        }
    };
    static Command corpTimeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSidePanel());
        }
    };
    static Command attendenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
//            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllTimeRecordsPanel("3"));
            TabPanel.instance().getTimePanel().sidePanelTop.add(new AttendenceSidePanel());
        }
    };
    static Command consultantTimeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSidePanel());
        }
    };
    static Command timeSheetPeriodsMaintainenceCmd = new Command() {
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
    static Command timeSheetsMaintainenceCmd = new Command() {
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
    static Command bonusPaymentsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllAdjustmentHoursPanel());
            TabPanel.instance().getTimePanel().sidePanelTop.add(new AdjustmentHoursSidePanel());
        }
    };
    static Command outOfOfficeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelBottom.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllOutOfOfficePanel());
            TabPanel.instance().getTimePanel().entityPanel.add(new CurrentWeekOutOfOfficeRequestsPanel());
            TabPanel.instance().getTimePanel().sidePanelTop.add(new OutOfOfficeSidePanel());
        }
    };
}

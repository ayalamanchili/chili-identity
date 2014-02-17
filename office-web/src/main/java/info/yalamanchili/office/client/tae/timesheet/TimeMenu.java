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
import info.yalamanchili.office.client.time.corp.CorpoateTimeSheetSidePanel;
import info.yalamanchili.office.client.time.corp.ReadAllCorporateTimeSheetPanel;

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
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_EXPENSE)) {
            tAEMenuBar.addItem("Corporate Time", corpTimeMaintainenceCmd);
        }
        tAEMenuBar.addStyleName("entityMenuBar");
    }
    Command summaryMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
            TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
        }
    };
    Command corpTimeMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.add(new CorpoateTimeSheetSidePanel());
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

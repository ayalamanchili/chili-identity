/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.tae.bonuspayment.AdjustmentHoursSidePanel;
import info.yalamanchili.office.client.tae.bonuspayment.ReadAllAdjustmentHoursPanel;
import info.yalamanchili.office.client.tae.timesheet.CurrentEmployeeTimeSummaryPanel;
import info.yalamanchili.office.client.tae.timesheet.ReadAllTimesheetPanel;
import info.yalamanchili.office.client.tae.timesheet.TimeSheetSidePanel;
import info.yalamanchili.office.client.tae.timesheetperiod.TimeSheetPeriodSidePanel;
import info.yalamanchili.office.client.tae.timesheetperiod.ReadAllTimeSheetPeriodsPanel;

/**
 *
 * @author ayalamanchili
 */
public class TAEMenu extends Composite {

    MenuBar tAEMenuBar = new MenuBar(false);

    public TAEMenu() {
        initWidget(tAEMenuBar);
        configureTAEMenu();
    }

    protected void configureTAEMenu() {
        if (Auth.isAdmin() || Auth.isPayroll()) {
            tAEMenuBar.addItem("Time Sheets", timeSheetsMaintainenceCmd);
            tAEMenuBar.addItem("Pay Periods", timeSheetPeriodsMaintainenceCmd);
            tAEMenuBar.addItem("Adjustment Hours", bonusPaymentsMaintainenceCmd);
        }
        tAEMenuBar.addStyleName("entityMenuBar");
    }
    Command timeSheetPeriodsMaintainenceCmd = new Command() {
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
        public void execute() {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().sidePanelTop.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllAdjustmentHoursPanel());
            TabPanel.instance().getTimePanel().sidePanelTop.add(new AdjustmentHoursSidePanel());
        }
    };
}

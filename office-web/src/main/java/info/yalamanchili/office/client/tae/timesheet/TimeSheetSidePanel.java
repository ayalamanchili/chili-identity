/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class TimeSheetSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(TimeSheetSidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    ClickableLink createtimeSheetlink = new ClickableLink("Enter TimeSheet");
    //View and Create Time sheets For Payperiod
    CaptionPanel timesheetsForPeriodCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForPeriodPanel = new FlowPanel();
    SelectTimesheetPeriodWidget timePeriodWidget = new SelectTimesheetPeriodWidget(false, false);
    Button showTimeSheetsForPeriodB = new Button("View");
    Button createMonthlyTimeSheetsB = new Button("Create");
    //View and Create Time sheets For Employee
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
    SelectEmployeeWidget empWidget = new SelectEmployeeWidget("Employee", false, false);
    Button showTimeSheetsForEmpB = new Button("View");
    Button createEmpTimeSheetsB = new Button("Create");

    public TimeSheetSidePanel() {
        init(timeSheetsidepanel);
    }

    @Override
    protected void addListeners() {
        createtimeSheetlink.addClickHandler(this);
        createMonthlyTimeSheetsB.addClickHandler(this);
        showTimeSheetsForPeriodB.addClickHandler(this);
        showTimeSheetsForEmpB.addClickHandler(this);
        createEmpTimeSheetsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        timesheetsForPeriodCaptionPanel.setCaptionHTML("TimeSheets");
        timesheetsForEmpCaptionPanel.setCaptionHTML("Time Summary");
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.hasContractsRole()) {
            timeSheetsidepanel.add(createtimeSheetlink);
            //payperiod
            timesheetsForPeriodPanel.add(timePeriodWidget);
            timesheetsForPeriodPanel.add(showTimeSheetsForPeriodB);
            timesheetsForPeriodPanel.add(createMonthlyTimeSheetsB);
            timesheetsForPeriodCaptionPanel.setContentWidget(timesheetsForPeriodPanel);
            timeSheetsidepanel.add(timesheetsForPeriodCaptionPanel);
            //employee
            timesheetsForEmpPanel.add(empWidget);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
//            timesheetsForEmpPanel.add(createEmpTimeSheetsB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            timeSheetsidepanel.add(timesheetsForEmpCaptionPanel);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtimeSheetlink)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateTimeSheetPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(createMonthlyTimeSheetsB)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateMonthlyTimeSheetPanel());
        }
        if (event.getSource().equals(showTimeSheetsForPeriodB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            if (timePeriodWidget.getSelectedObjectId() != null && !timePeriodWidget.getSelectedObjectId().isEmpty()) {
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllTimesheetPanel(timePeriodWidget.getSelectedObjectId()));
            }
        }
        if (event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new EmployeeTimeSummaryPanel(empWidget.getSelectedObjectId()));
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllEmployeeTimeSheets(empWidget.getSelectedObjectId()));
        }
        if (event.getSource().equals(createEmpTimeSheetsB)) {
            //create employee time sheet
        }
    }
}

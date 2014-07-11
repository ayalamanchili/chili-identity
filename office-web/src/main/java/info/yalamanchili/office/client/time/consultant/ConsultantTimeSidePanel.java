/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.SelectConsultantEmployeeWidget;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantTimeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel panel = new FlowPanel();
    ClickableLink createtimeSheetlink = new ClickableLink("Enter TimeSheet");
    //Timesheets for employee
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
    SelectConsultantEmployeeWidget empWidget = new SelectConsultantEmployeeWidget("Employee", false, false);
    EnumField categoryField = new EnumField(OfficeWelcome.constants, "category", "ConsultantTimeSheet",
            false, false, TimeSheetCategory.names());
    EnumField statusField = new EnumField(OfficeWelcome.constants, "status", "ConsultantTimeSheet",
            false, false, TimeSheetStatus.names());
    Button showTimeSheetsForEmpB = new Button("View");
    //Reports
    CaptionPanel reportsCaptionPanel = new CaptionPanel();
    FlowPanel reportsPanel = new FlowPanel();
    DateField startDateF = new DateField(OfficeWelcome.constants,
            "startDate", "ConsultantTimeSheet", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants,
            "endDate", "ConsultantTimeSheet", false, true);
    EnumField reportCategoryField = new EnumField(OfficeWelcome.constants, "category", "ConsultantTimeSheet",
            false, false, TimeSheetCategory.names());
    Button viewReportsB = new Button("View");
    FileField summaryReportL = new FileField("Summary Report", ChiliClientConfig.instance().getFileDownloadUrl() + "consultant-timesheet/all-cons-summary-report" + "&passthrough=true");
    protected static ConsultantTimeSidePanel instance;

    public static ConsultantTimeSidePanel instance() {
        return instance;
    }

    public ConsultantTimeSidePanel() {
        instance = this;
        init(panel);
    }

    @Override
    protected void addListeners() {
        createtimeSheetlink.addClickHandler(this);
        showTimeSheetsForEmpB.addClickHandler(this);
        viewReportsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        timesheetsForEmpCaptionPanel.setCaptionHTML("Time Summary");
        reportsCaptionPanel.setCaptionHTML("Reports");
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_RELATIONSHIP)) {
            panel.add(createtimeSheetlink);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_CONSULTANT_TIME_REPORTS)) {
            //employee
            timesheetsForEmpPanel.add(empWidget);
            timesheetsForEmpPanel.add(categoryField);
            timesheetsForEmpPanel.add(statusField);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            panel.add(timesheetsForEmpCaptionPanel);
            //reports panel
            reportsPanel.add(startDateF);
            reportsPanel.add(endDateF);
            reportsPanel.add(reportCategoryField);
            reportsPanel.add(viewReportsB);
            reportsCaptionPanel.setContentWidget(reportsPanel);
            panel.add(reportsCaptionPanel);
            panel.add(summaryReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtimeSheetlink)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateConsultantTimeSheetPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (empWidget.getSelectedObject() != null && event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel(empWidget.getSelectedObjectId()));
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel(empWidget.getSelectedObjectId()));
        }
        if (event.getSource().equals(viewReportsB)) {
            showReport();
        }

    }

    protected void showReport() {
        JSONObject search = new JSONObject();
        if ((startDateF.getDate() == null && endDateF.getDate() != null) || (startDateF.getDate() != null && endDateF.getDate() == null)) {
            startDateF.setMessage("required");
            endDateF.setMessage("required");
            return;
        }
        if (startDateF.getDate() != null) {
            search.put("startDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            search.put("endDate", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        if (reportCategoryField.getValue() != null) {
            search.put("category", new JSONString(reportCategoryField.getValue()));
        }
        HttpService.HttpServiceAsync.instance().doPut(getReportUrl(), search.toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                    new ResponseStatusWidget().show("no results");
                } else {
                    //TODO use size and entities attributes
                    JSONObject resObj = JSONParser.parseLenient(result).isObject();
                    String key = (String) resObj.keySet().toArray()[0];
                    JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                    TabPanel.instance().getTimePanel().entityPanel.clear();
                    TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel("Time Sheet Report Results", results));
                }

            }
        });
    }

    protected String getReportUrl() {
        return OfficeWelcome.instance().constants.root_url() + "consultant-timesheet/report/0/500";
    }
}

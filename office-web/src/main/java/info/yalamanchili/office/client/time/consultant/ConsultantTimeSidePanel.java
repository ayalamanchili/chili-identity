/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.common.base.Strings;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Anchor;
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
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.FileUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import info.yalamanchili.office.client.time.corp.CorporateTimeSummarySidePanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantTimeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel panel = new FlowPanel();
    //ClickableLink createtimeSheetlink = new ClickableLink("Enter TimeSheet");
    ClickableLink submitLeaveRequest = new ClickableLink("Submit Leave Request");
    //Timesheets for employee
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
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
    EnumField reportStatusField = new EnumField(OfficeWelcome.constants, "status", "ConsultantTimeSheet",
            false, false, true, TimeSheetStatus.names(), Alignment.VERTICAL);
    EnumField reportCategoryField = new EnumField(OfficeWelcome.constants, "category", "ConsultantTimeSheet",
            false, false, true, TimeSheetCategory.names(), Alignment.VERTICAL);

    Button viewReportsB = new Button("View");
    Button reportsB = new Button("Report");
    Anchor summaryReportL = new Anchor("Summary Report");
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
        submitLeaveRequest.addClickHandler(this);
        //createtimeSheetlink.addClickHandler(this);
        showTimeSheetsForEmpB.addClickHandler(this);
        viewReportsB.addClickHandler(this);
        reportsB.addClickHandler(this);
        summaryReportL.addClickHandler(this);
        employeeSB.addDomHandler(new Handler(), KeyPressEvent.getType());
    }

    final class Handler implements KeyPressHandler {

        @Override
        public void onKeyPress(KeyPressEvent event) {
            if (event.getCharCode() == KeyCodes.KEY_ENTER) {
                TabPanel.instance().getTimePanel().entityPanel.clear();
                TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel(employeeSB.getKey()));
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel(employeeSB.getKey()));
            }
        }

    }

    @Override
    protected void configure() {
        timesheetsForEmpCaptionPanel.setCaptionHTML("Time Summary");
        reportsCaptionPanel.setCaptionHTML("Reports");
        TabPanel.instance().timePanel.sidePanelTop.setHeight("100%");
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                logger.info(entityString);
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Employee";
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            //panel.add(createtimeSheetlink);
            panel.add(submitLeaveRequest);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_CONSULTANT_TIME_REPORTS)) {
            //employee
            timesheetsForEmpPanel.add(employeeSB);
            timesheetsForEmpPanel.add(categoryField);
            timesheetsForEmpPanel.add(statusField);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            panel.add(timesheetsForEmpCaptionPanel);
            //reports panel
            reportsPanel.add(startDateF);
            reportsPanel.add(endDateF);
            reportsPanel.add(reportCategoryField);
            reportsPanel.add(reportStatusField);
            reportsPanel.add(viewReportsB);
            reportsPanel.add(reportsB);
            reportsCaptionPanel.setContentWidget(reportsPanel);
            panel.add(reportsCaptionPanel);
            panel.add(summaryReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(submitLeaveRequest)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantEmpLeaveRequestPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        /*if (event.getSource().equals(createtimeSheetlink)) {
         TabPanel.instance().timePanel.entityPanel.clear();
         TabPanel.instance().timePanel.entityPanel.add(new CreateConsultantTimeSheetPanel(CreateComposite.CreateCompositeType.CREATE));
         }*/
        if (!Strings.isNullOrEmpty(employeeSB.getKey()) && event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel(employeeSB.getKey()));
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel(employeeSB.getKey()));
        }
        if (event.getSource().equals(viewReportsB)) {
            viewReport();
        }
        if (event.getSource().equals(reportsB)) {
            pdfReport();
        }
        if (event.getSource().equals(summaryReportL)) {
            processSummaryReports();
        }

    }

    protected void processSummaryReports() {
        HttpService.HttpServiceAsync.instance().doGet(getSummaryReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getSummaryReportUrl() {
        return OfficeWelcome.constants.root_url() + "consultant-timesheet/all-cons-summary-report";
    }

    protected void pdfReport() {
        FileUtils.openFile(getReportObject(), getPDFReportURL());
    }

    protected String getPDFReportURL() {
        return ChiliClientConfig.instance().getFileDownloadUrl() + "consultant-timesheet/report" + "&passthrough=true";
    }

    protected void viewReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
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
                                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel("Time Sheet Report Results", results, true));
                            }

                        }
                    });
        }
    }

    protected JSONObject getReportObject() {
        JSONObject search = new JSONObject();
        if ((startDateF.getDate() == null)) {
            startDateF.setMessage("required");
            return null;
        }
        if ((endDateF.getDate() == null)) {
            endDateF.setMessage("required");
            return null;
        }
        if (startDateF.getDate() != null) {
            search.put("startDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            search.put("endDate", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        if (reportCategoryField.getValues() != null) {
            search.put("category", JSONUtils.toJSONArray(reportCategoryField.getValues()));
        }
        if (reportStatusField.getValues() != null) {
            search.put("status", JSONUtils.toJSONArray(reportStatusField.getValues()));
        }
        logger.info("asdf" + search.toString());
        return search;
    }

    protected String getReportUrl() {
        return OfficeWelcome.instance().constants.root_url() + "consultant-timesheet/report/0/10000";
    }
}

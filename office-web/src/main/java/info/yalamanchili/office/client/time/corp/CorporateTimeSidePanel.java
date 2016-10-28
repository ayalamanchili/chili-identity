/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

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
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CorporateTimeSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    //ClickableLink createtimeSheetlink = new ClickableLink("Enter TimeSheet");
    ClickableLink submitLeaveRequest = new ClickableLink("Submit Leave Request");
    //Timesheets for employee
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
//    SelectCorpEmployeeWidget empWidget = new SelectCorpEmployeeWidget(false, false);
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    EnumField categoryField = new EnumField(OfficeWelcome.constants, "category", "CorporateTimeSheet",
            false, false, TimeSheetCategory.names());
    EnumField statusField = new EnumField(OfficeWelcome.constants, "status", "CorporateTimeSheet",
            false, false, TimeSheetStatus.names());
    Button showTimeSheetsForEmpB = new Button("View");
    //Reports
    CaptionPanel reportsCaptionPanel = new CaptionPanel();
    FlowPanel reportsPanel = new FlowPanel();
    DateField startDateF = new DateField(OfficeWelcome.constants,
            "startDate", "CorporateTimeSheet", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants,
            "endDate", "CorporateTimeSheet", false, true);
    EnumField reportStatusField = new EnumField(OfficeWelcome.constants, "status", "CorporateTimeSheet",
            false, false, true, TimeSheetStatus.names(), Alignment.VERTICAL);
    EnumField reportCategoryField = new EnumField(OfficeWelcome.constants, "category", "CorporateTimeSheet",
            false, false, true, TimeSheetCategory.names(), Alignment.VERTICAL);
    EnumField reportbranchField = new EnumField(OfficeWelcome.constants, "branch", "Employee",
            false, false, Branch.names(), Alignment.VERTICAL);
    EnumField roleF = new EnumField(OfficeWelcome.constants, "role", "Employee",
            false, false, Auth.getAllRoles());
    ClickableLink clearReportsL = new ClickableLink("clear");
    Button viewReportsB = new Button("View");
    Button reportsB = new Button("Report");
    Anchor summaryReportL = new Anchor("Summary Report");
    protected static CorporateTimeSidePanel instance;

    public static CorporateTimeSidePanel instance() {
        return instance;
    }

    public CorporateTimeSidePanel() {
        instance = this;
        init(timeSheetsidepanel);
    }

    @Override
    protected void addListeners() {
        submitLeaveRequest.addClickHandler(this);
        //createtimeSheetlink.addClickHandler(this);
        showTimeSheetsForEmpB.addClickHandler(this);
        viewReportsB.addClickHandler(this);
        clearReportsL.addClickHandler(this);
        reportsB.addClickHandler(this);
        summaryReportL.addClickHandler(this);
        employeeSB.addDomHandler(new Handler(), KeyPressEvent.getType());
    }
    final class Handler implements KeyPressHandler {

        @Override
        public void onKeyPress(KeyPressEvent event) {
            if (event.getCharCode()==KeyCodes.KEY_ENTER) {
                TabPanel.instance().getTimePanel().entityPanel.clear();
                TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel(employeeSB.getKey()));
                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel(employeeSB.getKey()));
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

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CORPORATE_TIME_ADMIN)) {
            //timeSheetsidepanel.add(createtimeSheetlink);
            timeSheetsidepanel.add(submitLeaveRequest);
        }
        if (Auth.isCorporateEmployee()) {
            //time sheets for emp panel
            timesheetsForEmpPanel.add(employeeSB);
            timesheetsForEmpPanel.add(categoryField);
            timesheetsForEmpPanel.add(statusField);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            timeSheetsidepanel.add(timesheetsForEmpCaptionPanel);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CORPORATE_TIME_ADMIN, ROLE.ROLE_CORPORATE_TIME_REPORTS)) {
            //reports panel
            reportsPanel.add(startDateF);
            reportsPanel.add(endDateF);
            reportsPanel.add(reportCategoryField);
            reportsPanel.add(reportbranchField);
            reportsPanel.add(reportStatusField);
            reportsPanel.add(roleF);
            reportsPanel.add(viewReportsB);
            reportsPanel.add(reportsB);
//            reportsPanel.add(clearReportsL);
            reportsCaptionPanel.setContentWidget(reportsPanel);
            timeSheetsidepanel.add(reportsCaptionPanel);
            timeSheetsidepanel.add(summaryReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        /* if (event.getSource().equals(createtimeSheetlink)) {
         TabPanel.instance().timePanel.entityPanel.clear();
         TabPanel.instance().timePanel.entityPanel.add(new CreateCorporateTimeSheetPanel(CreateComposite.CreateCompositeType.CREATE));
         }*/
        if (event.getSource().equals(submitLeaveRequest)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new CorpEmpLeaveRequestPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (employeeSB.getSelectedObject() != null && event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel(employeeSB.getKey()));
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel(employeeSB.getKey()));
        }
        if (event.getSource().equals(viewReportsB)) {
            viewReport();
        }
        if (event.getSource().equals(clearReportsL)) {
            clearReportsField();
        }
        if (event.getSource().equals(reportsB)) {
            pdfReport();
        }
        if (event.getSource().equals(summaryReportL)) {
            processSummaryReports();
        }

    }

    protected void pdfReport() {
        FileUtils.openFile(getReportObject(), getPDFReportURL());
    }

    protected String getPDFReportURL() {
        return ChiliClientConfig.instance().getFileDownloadUrl() + "corporate-timesheet/report" + "&passthrough=true";
    }

    protected void clearReportsField() {
        startDateF.setValue("");
        endDateF.setValue("");
        roleF.setSelectedIndex(0);
        TabPanel.instance().getTimePanel().entityPanel.clear();
    }

    protected void viewReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            HttpService.HttpServiceAsync.instance().doPut(getReportUrl(), search.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            TabPanel.instance().getTimePanel().entityPanel.clear();
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));

                                TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel("Time Sheet Report Results", results));
                            }
                        }
                    });
        }
    }

    protected JSONObject getReportObject() {
        JSONObject search = new JSONObject();
        if (startDateF.getDate() == null) {
            startDateF.setMessage("required");
            return null;
        }
        if (endDateF.getDate() == null) {
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
        if (reportbranchField.getValues() != null) {
            search.put("branch", JSONUtils.toJSONArray(reportbranchField.getValues()));
        }
        if (reportStatusField.getValues() != null) {
            search.put("status", JSONUtils.toJSONArray(reportStatusField.getValues()));
        }
        if (roleF.getValue() != null) {
            search.put("role", new JSONString(roleF.getValue()));
        }
        return search;
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
        return OfficeWelcome.constants.root_url() + "corporate-timesheet/all-emp-summary-report";
    }

    protected String getReportUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/report/0/500";
    }

    private String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee";
    }
}

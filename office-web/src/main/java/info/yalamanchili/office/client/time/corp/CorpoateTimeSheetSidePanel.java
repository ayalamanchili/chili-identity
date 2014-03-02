/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

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
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CorpoateTimeSheetSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CorporateTimeSummarySidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    ClickableLink createtimeSheetlink = new ClickableLink("Enter TimeSheet");

    //Timesheets for employee
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
    SelectCorpEmployeeWidget empWidget = new SelectCorpEmployeeWidget(false, false);
    //category
    EnumField categoryField = new EnumField(OfficeWelcome.constants, "category", "CorporateTimeSheet",
            false, false, TimeSheetCategory.names());
    //status
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
    Button viewReportsB = new Button("View");

    protected static CorpoateTimeSheetSidePanel instance;

    public static CorpoateTimeSheetSidePanel instance() {
        return instance;
    }

    public CorpoateTimeSheetSidePanel() {
        instance = this;
        init(timeSheetsidepanel);
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
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            timeSheetsidepanel.add(createtimeSheetlink);
        }
        if (Auth.isCorporateEmployee()) {
            //time sheets for emp panel
            timesheetsForEmpPanel.add(empWidget);
            timesheetsForEmpPanel.add(categoryField);
            timesheetsForEmpPanel.add(statusField);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            timeSheetsidepanel.add(timesheetsForEmpCaptionPanel);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            //reports panel
            reportsPanel.add(startDateF);
            reportsPanel.add(endDateF);
            reportsPanel.add(viewReportsB);
            reportsCaptionPanel.setContentWidget(reportsPanel);
            timeSheetsidepanel.add(reportsCaptionPanel);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtimeSheetlink)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new CreateCorporateTimeSheetPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (empWidget.getSelectedObject() != null && event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel(empWidget.getSelectedObjectId()));
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel(empWidget.getSelectedObjectId()));
        }
        if (event.getSource().equals(viewReportsB)) {
            showReport();
        }
    }

    protected void showReport() {
        JSONObject search = new JSONObject();
        search.put("startDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        search.put("endDate", new JSONString(DateUtils.toDateString(endDateF.getDate())));
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
                            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel("Time Sheet Report Results", results));
                        }

                    }
                });
    }

    protected String getReportUrl() {
        return OfficeWelcome.instance().constants.root_url() + "corporate-timesheet/report/0/500";
    }
}

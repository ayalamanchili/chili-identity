/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.Attendence;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class AttendenceSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AttendenceSidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    CaptionPanel timesheetsForEmpCaptionPanel = new CaptionPanel();
    FlowPanel timesheetsForEmpPanel = new FlowPanel();
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
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
    Button viewReportsB = new Button("View");
    protected static AttendenceSidePanel instance;

    public static AttendenceSidePanel instance() {
        return instance;
    }

    public AttendenceSidePanel() {
        instance = this;
        init(timeSheetsidepanel);
    }

    @Override
    protected void addListeners() {
        showTimeSheetsForEmpB.addClickHandler(this);
        viewReportsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        timesheetsForEmpCaptionPanel.setCaptionHTML("Attendance Summary");
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

        if (Auth.isCorporateEmployee()) {
            //time sheets for emp panel
            timesheetsForEmpPanel.add(employeeSB);
            timesheetsForEmpPanel.add(showTimeSheetsForEmpB);
            timesheetsForEmpCaptionPanel.setContentWidget(timesheetsForEmpPanel);
            timeSheetsidepanel.add(timesheetsForEmpCaptionPanel);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_CORPORATE_TIME_REPORTS)) {
            //reports panel
//            reportsPanel.add(startDateF);
//            reportsPanel.add(endDateF);
//            reportsPanel.add(reportStatusField);
//            reportsPanel.add(viewReportsB);
//            reportsCaptionPanel.setContentWidget(reportsPanel);
//            timeSheetsidepanel.add(reportsCaptionPanel);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (employeeSB.getSelectedObject() != null && event.getSource().equals(showTimeSheetsForEmpB)) {
            TabPanel.instance().getTimePanel().entityPanel.clear();
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllTimeRecordsPanel(employeeSB.getKey()));
        }
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee");
    }

    private JSONObject getReportObject() {
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
        if (reportStatusField.getValues() != null) {
            search.put("status", JSONUtils.toJSONArray(reportStatusField.getValues()));
        }
        return search;
    }

}

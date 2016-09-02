/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.insurance.HealthInsuranceYear;
import info.yalamanchili.office.client.profile.insurance.ReadAllHealthInsuranceReportPanel;
import java.util.Map;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chaitanya.k
 */
public class RetirementPlanOptInSidePanal extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(RetirementPlanOptInSidePanal.class.getName());

    protected FlowPanel panel = new FlowPanel();
    ClickableLink retirementplanReportL = new ClickableLink("RetirementPlan Report");

    protected Button generateRepB = new Button("Generate");
    protected Button viewRepB = new Button("View");
    EnumField yearsF = new EnumField(OfficeWelcome.constants2, "year", "InsuranceEnrollment", false, true, HealthInsuranceYear.getyears().toArray(new String[0]));

    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    ClickableLink reminderB = new ClickableLink("Send Reminder");

    public RetirementPlanOptInSidePanal() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        retirementplanReportL.addClickHandler(this);
        generateRepB.addClickHandler(this);
        viewRepB.addClickHandler(this);
        reminderB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
        retirementplanReportL.setTitle("report with name,comments");
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    private String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee");
    }

    @Override
    protected void addWidgets() {
        panel.add(retirementplanReportL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
            panel.add(yearsF);
            panel.add(employeeSB);
            panel.add(generateRepB);
            panel.add(viewRepB);
            panel.add(new HTML("<hr>"));
            panel.add(reminderB);
        }
    }

    protected JSONObject populateEntity() {
        JSONObject entity = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject().get("id"));
        }
        if (yearsF.getValue() != null) {
            entity.put("year", new JSONString(yearsF.getValue()));
        }
        return entity;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(retirementplanReportL)) {
            generateRetirementPlanReport();
        }
        if (event.getSource().equals(generateRepB)) {
            generateHealthInsuranceReport();
        }
        if (event.getSource().equals(viewRepB)) {
            viewHealthInsuranceReport();
        }
        if (event.getSource().equals(reminderB)) {
            sendRemainder();
        }
    }

    protected void sendRemainder() {
        HttpService.HttpServiceAsync.instance().doPut(sendRemainderUrl(), populateEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Remainder Email Sent");
                    }
                });
    }

    protected String sendRemainderUrl() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment/get/not-submitted-reminder";
    }

    protected void generateRetirementPlanReport() {
        HttpService.HttpServiceAsync.instance().doGet(getRetirementplanInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });

    }

    private String getRetirementplanInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "retirement-plan/opt-in-report";
    }

    protected void generateHealthInsuranceReport() {
        HttpService.HttpServiceAsync.instance().doGet(getHealthInsuranceReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("No Results");
                        } else {
                            new ResponseStatusWidget().show("Report will be emailed to your primary email");
                        }
                    }
                });
    }

    protected void viewHealthInsuranceReport() {
        HttpService.HttpServiceAsync.instance().doGet(getHealthInsuranceReportViewUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                            new ResponseStatusWidget().show("No Results");
                        } else {
                            TabPanel.instance().reportingPanel.entityPanel.clear();
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            TabPanel.instance().reportingPanel.entityPanel.clear();
                            TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllHealthInsuranceReportPanel(results));
                        }
                    }
                });
    }

    private String getHealthInsuranceReportUrl() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment/insurance-report?year=" + yearsF.getValue();
    }

    private String getHealthInsuranceReportViewUrl() {
        return OfficeWelcome.constants.root_url() + "insurance-enrollment/insurance-reportView?year=" + yearsF.getValue();
    }
}

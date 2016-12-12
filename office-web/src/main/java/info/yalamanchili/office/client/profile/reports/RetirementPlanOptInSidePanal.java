/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.utils.Utils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.benefits.YearType;
import info.yalamanchili.office.client.profile.insurance.ReadAllHealthInsuranceReportPanel;
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
    EnumField yearsF = new EnumField(OfficeWelcome.constants2, "year", "Benefit", false, true, YearType.names());

    ClickableLink reminderB = new ClickableLink("Send Reminder");

    DateField startDateF = new DateField(OfficeWelcome.constants, "CreatedDateFrom", "Benefit", false, false, Alignment.VERTICAL);
    DateField endDateF = new DateField(OfficeWelcome.constants, "CreatedDateTo", "Benefit", false, false, Alignment.VERTICAL);
    Button reportB = new Button("Report");

    public RetirementPlanOptInSidePanal() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        retirementplanReportL.addClickHandler(this);
        generateRepB.addClickHandler(this);
        viewRepB.addClickHandler(this);
        reminderB.addClickHandler(this);
        reportB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
        retirementplanReportL.setTitle("report with name,comments");
    }


    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
            panel.add(Utils.getLineSeperatorTag("Benefit Enrollment"));
            panel.add(yearsF);
            panel.add(generateRepB);
            panel.add(viewRepB);
            panel.add(new HTML("<hr>"));
            panel.add(reminderB);
            panel.add(Utils.getLineSeperatorTag("Benefit Enrollment Reports"));
            panel.add(startDateF);
            panel.add(endDateF);
            panel.add(reportB);

        }
    }

    protected JSONObject populateEntity() {
        JSONObject entity = new JSONObject();
        if (yearsF.getValue() != null) {
            entity.put("year", new JSONString(yearsF.getValue()));
        }
        return entity;
    }

    public JSONObject getObject() {
        JSONObject search = new JSONObject();
        if (startDateF.getDate() == null) {
            startDateF.setMessage("required");
            return null;
        }
        if (endDateF.getDate() == null) {
            endDateF.setMessage("required");
            return null;
        }
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be after Start Date");
            return null;
        }
        if (startDateF.getDate() != null) {
            search.put("startDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            search.put("endDate", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        return search;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(generateRepB)) {
            generateHealthInsuranceReport();
        }
        if (event.getSource().equals(viewRepB)) {
            viewHealthInsuranceReport();
        }
        if (event.getSource().equals(reminderB)) {
            sendRemainder();
        }
        if (event.getSource().equals(reportB)) {
            if (reportB.getParent().equals(panel)) {
                JSONObject search = getObject();
                if (search != null) {
                    TabPanel.instance().getReportingPanel().entityPanel.clear();
                    DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                    String reportUrl = OfficeWelcome.instance().constants.root_url() + "benefit/insurance-report-dates";
                    reportUrl = reportUrl.concat("?createdDateFrom=" + sdf.format(startDateF.getDate()));
                    reportUrl = reportUrl.concat("&createdDateTo=" + sdf.format(endDateF.getDate()));
                    HttpService.HttpServiceAsync.instance().doGet(reportUrl, OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                }
            }
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
        return OfficeWelcome.constants.root_url() + "benefit/get/not-submitted-reminder";
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
        return OfficeWelcome.constants.root_url() + "benefit/insurance-report?year=" + yearsF.getValue();
    }

    private String getHealthInsuranceReportViewUrl() {
        return OfficeWelcome.constants.root_url() + "benefit/insurance-reportView?year=" + yearsF.getValue();
    }
}

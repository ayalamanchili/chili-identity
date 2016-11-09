/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.Map;

/**
 *
 * @author ayalamanchili
 */
public class ProfileReportsSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false);
    protected FlowPanel panel = new FlowPanel();
    ClickableLink profileBasicReportL = new ClickableLink("Basic Profile Report");
    ClickableLink profileAdvanceReportL = new ClickableLink("Complete Profile Report");
    ClickableLink clientInfoReportL = new ClickableLink("Client Information Report");
    ClickableLink companyContactsReportL = new ClickableLink("Company Contact Report");
    DisclosurePanel projectSummaryL = new DisclosurePanel("Project Summary Report");
    FlowPanel projectSummaryPanel = new FlowPanel();
    Button searchB = new Button("Search");
    Button reportB = new Button("Report");

    public ProfileReportsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        profileBasicReportL.addClickHandler(this);
        profileAdvanceReportL.addClickHandler(this);
        clientInfoReportL.addClickHandler(this);
        companyContactsReportL.addClickHandler(this);
        projectSummaryL.addOpenHandler(this);
        searchB.addClickHandler(this);
        reportB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        profileAdvanceReportL.setTitle("report with name,email,phone, start date, address, emergency contact");
        profileBasicReportL.setTitle("report with name, email, phone, start date of all employees");
        clientInfoReportL.setTitle("report with employeeName, clientName, clientName, billingRate,startDate,endDate of all employees");
        companyContactsReportL.setTitle("report with first name, last name, company contact type, contact of all employees");
        HttpService.HttpServiceAsync.instance().doGet(getNameDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String entityString) {
                Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                if (values != null) {
                    employeeSB.loadData(values);
                }
            }
        });
    }

    @Override
    protected void addWidgets() {
        panel.add(projectSummaryL);
        panel.add(profileBasicReportL);
        panel.add(profileAdvanceReportL);
        panel.add(clientInfoReportL);
        panel.add(companyContactsReportL);
    }

    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(projectSummaryL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            projectSummaryPanel.add(employeeSB);
            projectSummaryPanel.add(searchB);
            projectSummaryPanel.add(reportB);
            projectSummaryL.setContent(projectSummaryPanel);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(profileBasicReportL)) {
            generateBasicInfoReport();
        }
        if (event.getSource().equals(profileAdvanceReportL)) {
            generateAdvanceInfoReport();
        }
        if (event.getSource().equals(clientInfoReportL)) {
            generateClientInfoReport();
        }
        if (event.getSource().equals(companyContactsReportL)) {
            generateCompanyContactReport();
        }
        if (event.getSource().equals(searchB)) {
            if (searchB.getParent().equals(projectSummaryPanel)) {
                TabPanel.instance().reportingPanel.entityPanel.clear();
                HttpService.HttpServiceAsync.instance().doPut(getUrl(), populateEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        if (result == null || JSONParser.parseLenient(result).isObject().size() == 0) {
                            new ResponseStatusWidget().show("No Results");
                        } else {
                            JSONObject resObj = JSONParser.parseLenient(result).isObject();
                            String key = (String) resObj.keySet().toArray()[0];
                            JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                            TabPanel.instance().reportingPanel.entityPanel.add(new ReadProjectSummaryReportPanel(results));
                            employeeSB.clearText();
                        }
                    }
                });
            }
        }

        if (event.getSource().equals(reportB)) {
            if (reportB.getParent().equals(projectSummaryPanel)) {
                HttpService.HttpServiceAsync.instance().doPut(reportUrl(), populateEntity().toString(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                        employeeSB.clearText();
                        TabPanel.instance().reportingPanel.entityPanel.clear();
                    }
                });
            }
        }
    }

    protected void generateBasicInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getBasicInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }

    protected void generateAdvanceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getAdvanceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }

    protected void generateClientInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getClientInformationReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }

    protected void generateCompanyContactReport() {
        HttpService.HttpServiceAsync.instance().doGet(getCompanyContactReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }

    protected JSONObject populateEntity() {
        JSONObject entity = new JSONObject();
        if (employeeSB.getSelectedObject() != null) {
            entity.put("employee", employeeSB.getSelectedObject());
        }
        return entity;
    }

    protected String getBasicInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-basic-info-report";
    }

    protected String getCompanyContactReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-company-contacts-report";
    }

    protected String getAdvanceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-advance-info-report";
    }

    protected String getClientInformationReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-client-info-report";
    }

    protected String getNameDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee&employee-type=Employee&employee-type=Subcontractor&employee-type=1099 Contractor&employee-type=W2 Contractor&includeAll=true";
    }

    protected String getUrl() {
        String url = OfficeWelcome.constants.root_url() + "projectsummary/associateCpdsSearch";
        url = url.concat("?empId=" + getKey());
        return url;
    }

    protected String getKey() {
        return employeeSB.getKey();
    }

    private String reportUrl() {
        String associateUrl = OfficeWelcome.instance().constants.root_url() + "projectsummary/associate-report";
        associateUrl = associateUrl.concat("?empId=" + getKey());
        return associateUrl;
    }

}

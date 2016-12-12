/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ClientSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    private static Logger logger = Logger.getLogger(ClientSidePanel.class.getName());
    public FlowPanel clientsidepanel = new FlowPanel();
    protected DisclosurePanel msaValidReportL = new DisclosurePanel("MSA Validity Date Report");    
    ClickableLink clientSummaryReportL = new ClickableLink("Client Summary Report");
    ClickableLink activeClientsReportL = new ClickableLink("Active Clients Report");
    FlowPanel msaValidReportsPanel = new FlowPanel();
    Button reportsB = new Button("Report");
    Button viewReportsB = new Button("View");
    Button clearFields = new Button("Clear");

    DateField startDateF = new DateField(OfficeWelcome.constants,
            "From Date", "", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants,
            "To Date", "", false, true);

    public ClientSidePanel() {
        init(clientsidepanel);
    }

    @Override
    protected void addListeners() {
        clientSummaryReportL.addClickHandler(this);
        activeClientsReportL.addClickHandler(this);
        msaValidReportL.addOpenHandler(this);
        viewReportsB.addClickHandler(this);
        clearFields.addClickHandler(this);
        reportsB.addClickHandler(this);        
    }

    @Override
    protected void configure() {
        clientSummaryReportL.setTitle("report with full information of clients");
    }

    @Override
    protected void addWidgets() {
        clientsidepanel.add(new SearchClientpanel());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            clientsidepanel.add(msaValidReportL);
        }        
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            clientsidepanel.add(clientSummaryReportL);
            clientsidepanel.add(activeClientsReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(clientSummaryReportL)) {
            generateClientInfoReport();
        }
        if (event.getSource().equals(activeClientsReportL)) {
            generateActiveClientInfoReport();
        }
        if (event.getSource().equals(viewReportsB)) {
            if (viewReportsB.getParent().equals(msaValidReportsPanel)) {
                viewMsaValidReport();
            }
        }
        if (event.getSource().equals(reportsB)) {
            if (reportsB.getParent().equals(msaValidReportsPanel)) {
                JSONObject search = getReportObject();
                if (search != null) {
                    TabPanel.instance().getAdminPanel().entityPanel.clear();
                    String reportUrl1 = OfficeWelcome.constants.root_url() + "client/msa-valid-reports";
                    HttpService.HttpServiceAsync.instance().doPut(reportUrl1, search.toString(), OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                }
            }
        }
        if (event.getSource().equals(clearFields)) {
            clearReportsField();
        }        
    }

    protected void viewMsaValidReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            String viewUrl1 = OfficeWelcome.constants.root_url() + "client/msa-valid-search/0/5000";
            HttpService.HttpServiceAsync.instance().doPut(viewUrl1, search.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            logger.info("the result issssssss:" + result);
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                TabPanel.instance().getAdminPanel().entityPanel.clear();
                                JSONObject entity = JSONParser.parseLenient(result).isObject();
                                String key = (String) entity.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(entity.get(key));
                                TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllClientsPanel(results));
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

    protected void clearReportsField() {
        startDateF.setValue("");
        endDateF.setValue("");
        startDateF.clearMessage();
        endDateF.clearMessage();
    }
    protected void generateClientInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getClientInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getClientInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "client/clientinfo-report";
    }

    protected void generateActiveClientInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getActiveClientInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getActiveClientInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "client/active-clientinfo-report";
    }
    
    @Override
    public void onOpen(OpenEvent event) {

        if (event.getSource().equals(msaValidReportL)) {
            TabPanel.instance().adminPanel.sidePanelTop.setHeight("100%");
            clearReportsField();
            startDateF.setLabelText("MSA Exp From Date*");
            endDateF.setLabelText("MSA Exp To Date*");
            msaValidReportsPanel.add(startDateF);
            msaValidReportsPanel.add(endDateF);
            msaValidReportsPanel.add(viewReportsB);
            msaValidReportsPanel.add(reportsB);
            msaValidReportsPanel.add(clearFields);
            msaValidReportL.setContent(msaValidReportsPanel);
        }
    }    
}
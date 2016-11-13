/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class SubcontractorSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SubcontractorSidePanel.class.getName());
    public FlowPanel subcontractorSidePanel = new FlowPanel();
    ClickableLink SubcontractorSummaryReportL = new ClickableLink("Subcontractor Summary Report");
    CaptionPanel reportsCaptionPanel = new CaptionPanel();
    ClickableLink activeSubcontractorReportL = new ClickableLink("Active Subcontractor Report");
    FlowPanel reportsPanel = new FlowPanel();
    Button reportsB = new Button("Report");
    Button viewReportsB = new Button("View");
    Button clearReportL = new Button("Clear");

    DateField startDateF = new DateField(OfficeWelcome.constants,
            "COI From EndDate", "", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants,
            "COI To EndDate", "", false, true);

    public SubcontractorSidePanel() {
        init(subcontractorSidePanel);
    }

    @Override
    protected void addListeners() {
        SubcontractorSummaryReportL.addClickHandler(this);
        viewReportsB.addClickHandler(this);
        clearReportL.addClickHandler(this);
        reportsB.addClickHandler(this);
        activeSubcontractorReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        SubcontractorSummaryReportL.setTitle("report with full information of subcontractor");
        reportsCaptionPanel.setCaptionHTML("COI End Date Report");
    }

    @Override
    protected void addWidgets() {
        subcontractorSidePanel.add(new SearchSubcontractorPanel());
        reportsPanel.add(startDateF);
        reportsPanel.add(endDateF);
        reportsPanel.add(viewReportsB);
        reportsPanel.add(reportsB);
        reportsPanel.add(clearReportL);
        reportsCaptionPanel.setContentWidget(reportsPanel);
        subcontractorSidePanel.add(reportsCaptionPanel);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            subcontractorSidePanel.add(SubcontractorSummaryReportL);
            subcontractorSidePanel.add(activeSubcontractorReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(SubcontractorSummaryReportL)) {
            generateSubcontractorInfoReport();
        }
        if (event.getSource().equals(viewReportsB)) {
            viewReport();
        }
        if (event.getSource().equals(activeSubcontractorReportL)) {
            generateActiveSubcontractorInfoReport();
        }
        if (event.getSource().equals(clearReportL)) {
            clearReportsField();
        }
        if (event.getSource().equals(reportsB)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String empUrl = OfficeWelcome.constants.root_url() + "subcontractor/reports";
            empUrl = empUrl.concat("?coiFromEndDate=" + sdf.format(startDateF.getDate()));
            empUrl = empUrl.concat("&coiToEndDate=" + sdf.format(endDateF.getDate()));
            HttpService.HttpServiceAsync.instance().doGet(empUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                        }
                    });
        }
    }

    protected void clearReportsField() {
        startDateF.setValue("");
        endDateF.setValue("");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
    }

    protected void viewReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String empUrl1 = OfficeWelcome.constants.root_url() + "subcontractor/report/0/1000";
            empUrl1 = empUrl1.concat("?coiFromEndDate=" + sdf.format(startDateF.getDate()));
            empUrl1 = empUrl1.concat("&coiToEndDate=" + sdf.format(endDateF.getDate()));
            HttpService.HttpServiceAsync.instance().doPut(empUrl1, search.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            TabPanel.instance().getAdminPanel().entityPanel.clear();
                            if (result == null || JSONParser.parseLenient(result).isObject().size() == 0) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                JSONObject entity = JSONParser.parseLenient(result).isObject();
                                String key = (String) entity.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(entity.get(key));
                                TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllSubcontractorsPanel(results));
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
            search.put("coiFromEndDate", new JSONString(DateUtils.toDateString(startDateF.getDate())));
        }
        if (endDateF.getDate() != null) {
            search.put("coiFromEndDate", new JSONString(DateUtils.toDateString(endDateF.getDate())));
        }
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be after Start Date");
            return null;
        }
        return search;
    }

    protected void generateSubcontractorInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getSubcontractorInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getSubcontractorInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "contract-report/subcontractors-summary-report";
    }

    private void generateActiveSubcontractorInfoReport() {
         HttpService.HttpServiceAsync.instance().doGet(getActiveSubcontractorInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }
    protected String getActiveSubcontractorInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "subcontractor/subcontractor-clientinfo-report";
    }
}

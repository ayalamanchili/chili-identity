/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

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
 * @author Prashanthi
 */
public class VendorsSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    private static Logger logger = Logger.getLogger(VendorsSidePanel.class.getName());
    public FlowPanel vendorsidepanel = new FlowPanel();
    protected DisclosurePanel coiEndDateReportsL = new DisclosurePanel("COI End Date Report");
    protected DisclosurePanel msaValidReportL = new DisclosurePanel("MSA Validity Exp Date Report");
    ClickableLink vendorSummaryReportL = new ClickableLink("Vendor Summary Report");
    ClickableLink activeVendorsReportL = new ClickableLink("Active Vendors Report");
    FlowPanel coiReportsPanel = new FlowPanel();
    FlowPanel msaValidReportsPanel = new FlowPanel();
    Button reportsB = new Button("Report");
    Button viewReportsB = new Button("View");
    Button clearFields = new Button("Clear");

    DateField startDateF = new DateField(OfficeWelcome.constants,
            "From Date", "", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants,
            "To Date", "", false, true);

    public VendorsSidePanel() {
        init(vendorsidepanel);
    }

    @Override
    protected void addListeners() {
        vendorSummaryReportL.addClickHandler(this);
        activeVendorsReportL.addClickHandler(this);
        coiEndDateReportsL.addOpenHandler(this);
        msaValidReportL.addOpenHandler(this);
        viewReportsB.addClickHandler(this);
        clearFields.addClickHandler(this);
        reportsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        vendorSummaryReportL.setTitle("report with full information of vendors");
    }

    @Override
    protected void addWidgets() {
        vendorsidepanel.add(new SearchVendorPanel());
        vendorsidepanel.add(coiEndDateReportsL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            vendorsidepanel.add(msaValidReportL);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            vendorsidepanel.add(vendorSummaryReportL);
            vendorsidepanel.add(activeVendorsReportL);
        }

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(vendorSummaryReportL)) {
            generateVendorInfoReport();
        }
        if (event.getSource().equals(activeVendorsReportL)) {
            generateActiveVendorInfoReport();
        }
        if (event.getSource().equals(viewReportsB)) {
            if (viewReportsB.getParent().equals(coiReportsPanel)) {
                viewCOIReport();
            }
            if (viewReportsB.getParent().equals(msaValidReportsPanel)) {
                viewMsaValidReport();
            }
        }
        if (event.getSource().equals(reportsB)) {
            if (reportsB.getParent().equals(coiReportsPanel)) {
                JSONObject search = getReportObject();
                if (search != null) {
                    TabPanel.instance().getAdminPanel().entityPanel.clear();
                    DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
                    String reportUrl = OfficeWelcome.constants.root_url() + "vendor/reports";
                    reportUrl = reportUrl.concat("?coiFromEndDate=" + sdf.format(startDateF.getDate()));
                    reportUrl = reportUrl.concat("&coiToEndDate=" + sdf.format(endDateF.getDate()));
                    HttpService.HttpServiceAsync.instance().doGet(reportUrl, OfficeWelcome.instance().getHeaders(), true,
                            new ALAsyncCallback<String>() {
                                @Override
                                public void onResponse(String result) {
                                    new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                                }
                            });
                }
            }
            if (reportsB.getParent().equals(msaValidReportsPanel)) {
                JSONObject search = getReportObject();
                if (search != null) {
                    TabPanel.instance().getAdminPanel().entityPanel.clear();
                    String reportUrl1 = OfficeWelcome.constants.root_url() + "vendor/msa-valid-reports";
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

    protected void viewCOIReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String viewUrl = OfficeWelcome.constants.root_url() + "vendor/coiSearch";
            viewUrl = viewUrl.concat("?coiFromEndDate=" + sdf.format(startDateF.getDate()));
            viewUrl = viewUrl.concat("&coiToEndDate=" + sdf.format(endDateF.getDate()));
            HttpService.HttpServiceAsync.instance().doPut(viewUrl, search.toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject().size() == 0) {
                                new ResponseStatusWidget().show("no results");
                            } else {
                                //TODO use size and entities attributes
                                TabPanel.instance().getAdminPanel().entityPanel.clear();
                                JSONObject entity = JSONParser.parseLenient(result).isObject();
                                String key = (String) entity.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(entity.get(key));
                                TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllVendorsPanel(results));
                            }
                        }
                    });
        }
    }

    protected void viewMsaValidReport() {
        JSONObject search = getReportObject();
        if (search != null) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            String viewUrl1 = OfficeWelcome.constants.root_url() + "vendor/msa-valid-search/0/5000";
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
                                TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllVendorsPanel(results));
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

    protected void generateVendorInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getVendorInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getVendorInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "vendor/vendorinfo-report";
    }

    protected void generateActiveVendorInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getActiveVendorInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getActiveVendorInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "vendor/active-vendorinfo-report";
    }

    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(coiEndDateReportsL)) {
            msaValidReportL.setOpen(false);
            TabPanel.instance().adminPanel.sidePanelTop.setHeight("100%");
            clearReportsField();
            startDateF.setLabelText("COI From End Date*");
            endDateF.setLabelText("COI To End Date*");
            coiReportsPanel.add(startDateF);
            coiReportsPanel.add(endDateF);
            coiReportsPanel.add(viewReportsB);
            coiReportsPanel.add(reportsB);
            coiReportsPanel.add(clearFields);
            coiEndDateReportsL.setContent(coiReportsPanel);
        }
        if (event.getSource().equals(msaValidReportL)) {
            coiEndDateReportsL.setOpen(false);
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

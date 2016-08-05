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
public class VendorsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(VendorsSidePanel.class.getName());
    public FlowPanel vendorsidepanel = new FlowPanel();
    ClickableLink vendorSummaryReportL = new ClickableLink("Vendor Summary Report");
    ClickableLink activeVendorsReportL = new ClickableLink("Active Vendors Report");
    CaptionPanel reportsCaptionPanel = new CaptionPanel();
    FlowPanel reportsPanel = new FlowPanel();
    Button reportsB = new Button("Report");
    Button viewReportsB = new Button("View");
    Button clearFields = new Button("Clear");

    DateField startDateF = new DateField(OfficeWelcome.constants2,
            "COI From EndDate", "", false, true);
    DateField endDateF = new DateField(OfficeWelcome.constants2,
            "COI To EndDate", "", false, true);

    public VendorsSidePanel() {
        init(vendorsidepanel);
    }

    @Override
    protected void addListeners() {
        vendorSummaryReportL.addClickHandler(this);
        activeVendorsReportL.addClickHandler(this);
        viewReportsB.addClickHandler(this);
        clearFields.addClickHandler(this);
        reportsB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        vendorSummaryReportL.setTitle("report with full information of vendors");
        reportsCaptionPanel.setCaptionHTML("COI End Date Report");
    }

    @Override
    protected void addWidgets() {
        vendorsidepanel.add(new SearchVendorPanel());
        reportsPanel.add(startDateF);
        reportsPanel.add(endDateF);
        reportsPanel.add(viewReportsB);
        reportsPanel.add(reportsB);
        reportsPanel.add(clearFields);
        reportsCaptionPanel.setContentWidget(reportsPanel);
        vendorsidepanel.add(reportsCaptionPanel);
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
            viewReport();
        }
        if (event.getSource().equals(clearFields)) {
            clearReportsField();
        }
        if (event.getSource().equals(reportsB)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String reportUrl = OfficeWelcome.constants.root_url() + "vendor/reports";
            reportUrl = reportUrl.concat("?coiFromEndDate=" + sdf.format(startDateF.getDate()));
            reportUrl = reportUrl.concat("&coiToEndDate=" + sdf.format(endDateF.getDate()));
            HttpService.HttpServiceAsync.instance().doGet(URL.encode(reportUrl), OfficeWelcome.instance().getHeaders(), true,
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
}

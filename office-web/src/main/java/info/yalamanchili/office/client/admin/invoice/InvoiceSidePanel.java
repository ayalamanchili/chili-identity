/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
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
 * @author Sudha
 */
public class InvoiceSidePanel extends ALComposite implements ClickHandler, OpenHandler {

    private static Logger logger = Logger.getLogger(InvoiceSidePanel.class.getName());
    public FlowPanel invoicesidepanel = new FlowPanel();
    ClickableLink invoiceSummaryReportL = new ClickableLink("Invoice Summary Report");
    ClickableLink activeSummaryReportL = new ClickableLink(" Active Invoices Report");
    protected DisclosurePanel missingInvoiceL = new DisclosurePanel("Missing Invoice Report");

    FlowPanel MissingInvoiceReport = new FlowPanel();
    DateField invoiceStartDate = new DateField(OfficeWelcome.constants, "Invoice Period Start Date", "", false, false);
    DateField invoiceEndDate = new DateField(OfficeWelcome.constants, "Invoice Period End Date", "", false, false);
    protected Button searchTasks = new Button("Search");
    protected Button reportTasks = new Button("Report");

    public InvoiceSidePanel() {
        init(invoicesidepanel);
    }

    @Override
    protected void addListeners() {
        missingInvoiceL.addOpenHandler(this);
        invoiceSummaryReportL.addClickHandler(this);
        activeSummaryReportL.addClickHandler(this);
        searchTasks.addClickHandler(this);
        reportTasks.addClickHandler(this);
    }

    @Override
    protected void configure() {
        TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
        invoiceSummaryReportL.setTitle("report with full information of invoices");
        activeSummaryReportL.setTitle("report with full information of invoices");
        missingInvoiceL.setTitle("report with missing invoices");
    }

    @Override
    protected void addWidgets() {
        invoicesidepanel.add(new SearchInvoicePanel());
        invoicesidepanel.add(missingInvoiceL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            invoicesidepanel.add(invoiceSummaryReportL);
            invoicesidepanel.add(activeSummaryReportL);

        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(invoiceSummaryReportL)) {
//            generateInvoiceInfoReport();
        }
        if (event.getSource().equals(activeSummaryReportL)) {
//            generateActiveInvoiceInfoReport();
        }
        if (event.getSource().equals(reportTasks)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String empUrl = OfficeWelcome.constants.root_url() + "invoice/missing-invoice-report";
            empUrl = empUrl.concat("?startDate=" + sdf.format(invoiceStartDate.getDate()));
            empUrl = empUrl.concat("&endDate=" + sdf.format(invoiceEndDate.getDate()));
            HttpService.HttpServiceAsync.instance().doGet(empUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                        }
                    });
        }
        if (event.getSource().equals(searchTasks)) {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            DateTimeFormat sdf = DateTimeFormat.getFormat("MM/dd/yyyy");
            String empUrl = OfficeWelcome.constants.root_url() + "invoice/search-missing-invoices/0/10000";
            empUrl = empUrl.concat("?startDate=" + sdf.format(invoiceStartDate.getDate()));
            empUrl = empUrl.concat("&endDate=" + sdf.format(invoiceEndDate.getDate()));
            HttpService.HttpServiceAsync.instance().doGet(empUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("No Results");
                            } else {
                                JSONObject resObj = JSONParser.parseLenient(result).isObject();
                                String key = (String) resObj.keySet().toArray()[0];
                                JSONArray results = JSONUtils.toJSONArray(resObj.get(key));
                                TabPanel.instance().reportingPanel.entityPanel.clear();
                                TabPanel.instance().reportingPanel.entityPanel.add(new ReadAllMissingInvoicesPanel(results));
                            }
                        }
                    });
        }

    }

    protected void generateInvoiceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getInvoiceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Invoice Summary Report will be emailed to your primary email");
                    }
                });
    }

    protected void generateActiveInvoiceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getActiveInvoiceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Active Invoice Summary Report will be emailed to your primary email");
                    }
                });
    }

    protected String getInvoiceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "invoice/invoice-summary-report";
    }

    protected String getActiveInvoiceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "invoice/active-clientinfo-report";
    }

    @Override
    public void onOpen(OpenEvent event) {
        if (event.getSource().equals(missingInvoiceL)) {
            TabPanel.instance().reportingPanel.sidePanelTop.setHeight("100%");
            MissingInvoiceReport.add(invoiceStartDate);
            MissingInvoiceReport.add(invoiceEndDate);
            MissingInvoiceReport.add(searchTasks);
            MissingInvoiceReport.add(reportTasks);
            missingInvoiceL.setContent(MissingInvoiceReport);
        }
    }

}

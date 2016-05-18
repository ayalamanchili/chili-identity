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
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;
/**
 *
 * @author Sudha
 */
public class InvoiceSidePanel extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(InvoiceSidePanel.class.getName());
    public FlowPanel invoicesidepanel = new FlowPanel();
    ClickableLink invoiceSummaryReportL = new ClickableLink("Invoice Summary Report");
    ClickableLink activeInvoicesReportL = new ClickableLink("Active Invoices Report");

    public InvoiceSidePanel() {
        init(invoicesidepanel);
    }

    @Override
    protected void addListeners() {
        invoiceSummaryReportL.addClickHandler(this);
        activeInvoicesReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        invoiceSummaryReportL.setTitle("report with full information of invoices");
    }

    @Override
    protected void addWidgets() {
        invoicesidepanel.add(new SearchInvoicePanel());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            invoicesidepanel.add(invoiceSummaryReportL);
            invoicesidepanel.add(activeInvoicesReportL);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(invoiceSummaryReportL)) {
            generateInvoiceInfoReport();
        }
        if (event.getSource().equals(activeInvoicesReportL)) {
            generateActiveInvoiceInfoReport();
        }
    }

    protected void generateInvoiceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getInvoiceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Invoice will be emailed to your primary email");
                    }
                });
    }

    protected String getInvoiceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "client/invoiceinfo-report";
    }

    protected void generateActiveInvoiceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getActiveInvoiceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Invoice will be emailed to your primary email");
                    }
                });
    }

    protected String getActiveInvoiceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "client/active-invoiceinfo-report";
    }
}

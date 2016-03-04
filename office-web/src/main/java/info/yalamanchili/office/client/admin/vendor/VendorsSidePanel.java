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
 * @author Prashanthi
 */
public class VendorsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(VendorsSidePanel.class.getName());
    public FlowPanel vendorsidepanel = new FlowPanel();
    ClickableLink vendorSummaryReportL = new ClickableLink("Vendor Summary Report");
    ClickableLink activeVendorsReportL = new ClickableLink("Active Vendors Report");

    public VendorsSidePanel() {
        init(vendorsidepanel);
    }

    @Override
    protected void addListeners() {
        vendorSummaryReportL.addClickHandler(this);
        activeVendorsReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        vendorSummaryReportL.setTitle("report with full information of vendors");
    }

    @Override
    protected void addWidgets() {
        vendorsidepanel.add(new SearchVendorPanel());
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
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
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ClientSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ClientSidePanel.class.getName());
    public FlowPanel clientsidepanel = new FlowPanel();
    ClickableLink createclientlink = new ClickableLink("Create Client");
    ClickableLink clientSummaryReportL = new ClickableLink("Client Summary Report");
    ClickableLink activeClientsReportL = new ClickableLink("Active Clients Report");

    public ClientSidePanel() {
        init(clientsidepanel);
    }

    @Override
    protected void addListeners() {
        createclientlink.addClickHandler(this);
        clientSummaryReportL.addClickHandler(this);
        activeClientsReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        clientSummaryReportL.setTitle("report with full information of clients");
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            clientsidepanel.add(createclientlink);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            clientsidepanel.add(clientSummaryReportL);
            clientsidepanel.add(activeClientsReportL);
        }
        clientsidepanel.add(new SearchClientpanel());

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createclientlink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateClientPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(clientSummaryReportL)) {
            generateClientInfoReport();
        }
        if (event.getSource().equals(activeClientsReportL)) {
            generateActiveClientInfoReport();
        }
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
        return OfficeWelcome.constants.root_url() + "contract/active-clientinfo-report";
    }

}

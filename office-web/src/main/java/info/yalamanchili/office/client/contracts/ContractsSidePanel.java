/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ContractsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ContractsSidePanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    ClickableLink clientBasicReportL = new ClickableLink("Client Information Report");

    public ContractsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        clientBasicReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        clientBasicReportL.setTitle("report with employeeName, clientName, vendorName, billingRate,startDate,endDate of all employees");

    }

    @Override
    protected void addWidgets() {
        panel.add(clientBasicReportL);

        panel.add(new SearchContractsPanel());

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(clientBasicReportL)) {
            generateBasicInfoReport();
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

    protected String getBasicInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "contract-report/employee-client-info-report";
    }
}

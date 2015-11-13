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
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.rpc.HttpService;

import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ContractsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ContractsSidePanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected Button generateRepB = new Button("Generate");
    protected Label formatL = new Label("Format");
    protected ListBox formatLB = new ListBox();

    public ContractsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        generateRepB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(formatL);
        formatLB.addItem("PDF", "pdf");
        formatLB.addItem("HTML", "html");
        formatLB.addItem("XML", "xml");
        formatLB.addItem("EXCEL","xls");
        panel.add(formatLB);
        panel.add(generateRepB);
        panel.add(new SearchContractsPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        HttpService.HttpServiceAsync.instance().doGet(getReportURL(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                Window.alert(arg0.getLocalizedMessage());
            }

            @Override
            public void onSuccess(String resp) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + resp, "_blank", "");
            }
        });
    }

    protected String getReportFormat() {
        return formatLB.getValue(formatLB.getSelectedIndex());
    }

    protected String getReportURL() {
        return OfficeWelcome.constants.root_url() + "contract/report" + "?format=" + getReportFormat();
    }
}

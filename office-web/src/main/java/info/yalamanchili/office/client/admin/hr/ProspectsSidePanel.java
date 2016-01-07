/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ProspectsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ProspectsSidePanel.class.getName());
    public FlowPanel sidepanel = new FlowPanel();
    ClickableLink prospectsReport = new ClickableLink("Prospects Reports");

    public ProspectsSidePanel() {
        init(sidepanel);
    }

    @Override
    protected void addListeners() {
        prospectsReport.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        sidepanel.add(new SearchProspectsPanel());
        sidepanel.add(prospectsReport);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(prospectsReport)) {
            String reportUrl = OfficeWelcome.instance().constants.root_url() + "prospect/report";
            HttpService.HttpServiceAsync.instance().doGet(reportUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            new ResponseStatusWidget().show("Report Will Be Emailed To Your Primary Email");
                        }
                    });
        }
    }
}

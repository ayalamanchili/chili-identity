/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Hemanth
 */
public class PayRateSummaryReportSidePanel extends ALComposite implements ClickHandler {
        
    protected FlowPanel panel = new FlowPanel();
    ClickableLink payrateSummaryReport = new ClickableLink("Pay Rate Summary Report");

    public PayRateSummaryReportSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        payrateSummaryReport.addClickHandler(this);
    }

    @Override
    protected void configure() {
       // probationPeriodReportL.setTitle("report with employeeName, startDate,stage of all employees");
    }

    @Override
    protected void addWidgets() {
        panel.add(payrateSummaryReport);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(payrateSummaryReport)) {
            String activePayRateUrl = OfficeWelcome.constants.root_url() + "contract-report/all-payrate-summary-report";
            HttpService.HttpServiceAsync.instance().doGet(activePayRateUrl, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String result) {
                            if (result == null || JSONParser.parseLenient(result).isObject() == null) {
                                new ResponseStatusWidget().show("Report Will be Emailed to your Primary Email");
                            }
                        }
                    });
        }
    }

    
}

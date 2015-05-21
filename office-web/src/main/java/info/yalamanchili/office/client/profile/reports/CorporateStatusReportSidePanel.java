/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.reports;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author benerji.v
 */
public class CorporateStatusReportSidePanel extends ALComposite implements ClickHandler{
    protected FlowPanel panel = new FlowPanel();
    ClickableLink corporatestatusReportL = new ClickableLink("Corporate Status Report");
    
    public CorporateStatusReportSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        corporatestatusReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        corporatestatusReportL.setTitle("report with reportStartDate,reportEndDate,report of all employees");

    }

    @Override
    protected void addWidgets() {
        panel.add(corporatestatusReportL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(corporatestatusReportL)) {
            generateCorporateStatusReport();
        }
    }
    protected void generateCorporateStatusReport() {
        HttpService.HttpServiceAsync.instance().doGet(getcorporatestatusReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                new ResponseStatusWidget().show("Report will be emailed to your primary email");
            }
        });
    }
    protected String getcorporatestatusReportUrl() {
        return OfficeWelcome.constants.root_url() + "corporate_status/corporate_status-report";
    }
    
}

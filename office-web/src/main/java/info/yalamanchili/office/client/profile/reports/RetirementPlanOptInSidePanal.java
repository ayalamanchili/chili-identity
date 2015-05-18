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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chaitanya.k
 */
public class RetirementPlanOptInSidePanal extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    ClickableLink retirementplanReportL = new ClickableLink("RetirementPlan Report");

    public RetirementPlanOptInSidePanal() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        retirementplanReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        retirementplanReportL.setTitle("report with name,comments");
    }

    @Override
    protected void addWidgets() {
        panel.add(retirementplanReportL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(retirementplanReportL)) {
            generateRetirementPlanReport();
        }

    }

    protected void generateRetirementPlanReport() {
        HttpService.HttpServiceAsync.instance().doGet(getRetirementplanInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });

    }

    private String getRetirementplanInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "retirementplan-reports/employee-retirementplan-info-report";
    }
}

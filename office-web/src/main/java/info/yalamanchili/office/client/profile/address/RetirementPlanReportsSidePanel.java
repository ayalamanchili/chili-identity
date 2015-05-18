/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

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
 * @author chaitanya.k
 */
public class RetirementPlanReportsSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    ClickableLink retirementplan = new ClickableLink("Retirement Plan Opt In Report");

    @Override
    protected void addListeners() {
        retirementplan.addClickHandler(this);
    }

    @Override
    protected void configure() {
        retirementplan.setTitle("report with employeeName, Comment");

    }

    @Override
    protected void addWidgets() {
        panel.add(retirementplan);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(retirementplan)) {
            generateRetirementPlanReport();
        }
    }

    protected void generateRetirementPlanReport() {
        HttpService.HttpServiceAsync.instance().doGet(getretirementplanReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getretirementplanReportUrl() {
        return OfficeWelcome.constants.root_url() + "probation-period-evaluation/probation-period-evaluation-report";
    }
}

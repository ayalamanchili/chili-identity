/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.statusreport;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.ReadAllPerformanceEvaluationPanel;

/**
 *
 * @author anuyalamanchili
 */
public class MyReportsStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink projectReportsL = new ClickableLink("Status Reports");
    protected ClickableLink perfEvalReportsL = new ClickableLink("Performance Evaluations");

    public MyReportsStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        projectReportsL.addClickHandler(this);
        perfEvalReportsL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(projectReportsL);
        mainPanel.add(perfEvalReportsL);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(projectReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllStatusReportPanel());
        }
        if (event.getSource().equals(perfEvalReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllPerformanceEvaluationPanel());
        }
    }
}

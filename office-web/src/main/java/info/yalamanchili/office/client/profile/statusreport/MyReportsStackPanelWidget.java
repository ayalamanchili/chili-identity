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
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prbprdeval.ReadAllProbationPeriodEvaluationsPanel;
import info.yalamanchili.office.client.employee.prefeval.ReadAllPerformanceEvaluationPanel;

/**
 *
 * @author anuyalamanchili
 */
public class MyReportsStackPanelWidget extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink weeklyStatusReportsL = new ClickableLink("Weekly Status Reports");
    protected ClickableLink projectReportsL = new ClickableLink("Status Reports");
    protected ClickableLink perfEvalReportsL = new ClickableLink("Performance Evaluations");
    protected ClickableLink probationPRDReportsL = new ClickableLink("Probation Evaluations");

    public MyReportsStackPanelWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        weeklyStatusReportsL.addClickHandler(this);
        projectReportsL.addClickHandler(this);
        perfEvalReportsL.addClickHandler(this);
        probationPRDReportsL.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isCorporateEmployee()) {
            mainPanel.add(weeklyStatusReportsL);
        }
        mainPanel.add(projectReportsL);
        mainPanel.add(perfEvalReportsL);
        mainPanel.add(probationPRDReportsL);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(weeklyStatusReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllCorporateStatusReportsPanel());
        }
        if (event.getSource().equals(projectReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllStatusReportPanel());
        }
        if (event.getSource().equals(perfEvalReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllPerformanceEvaluationPanel());
        }
        if (event.getSource().equals(probationPRDReportsL)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllProbationPeriodEvaluationsPanel());
        }
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.reports;

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
 * @author Ramana.Lukalapu
 */
public class SkillSetReportSidePanel extends ALComposite implements ClickHandler {
    
    public FlowPanel skillSetReportPanel = new FlowPanel();
    ClickableLink createSkillSetReportLink = new ClickableLink("Employee SkillSet Report");

    public SkillSetReportSidePanel() {
        init(skillSetReportPanel);
    }

    @Override
    protected void addListeners() {
        createSkillSetReportLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        skillSetReportPanel.add(createSkillSetReportLink);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createSkillSetReportLink)) {
            generateEmployeeSkillSetReport();
        }
    }

    protected void generateEmployeeSkillSetReport() {
        HttpService.HttpServiceAsync.instance().doGet(getEmployeeSkillSetReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getEmployeeSkillSetReportUrl() {
        return OfficeWelcome.constants.root_url() + "recruiting-reports/employee-skill-report";
    }
    
}

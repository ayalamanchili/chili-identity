/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.groupemails;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class EmailGroupsSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    protected Button generateRepB = new Button("Generate");
    protected Label employeeType = new Label("Employee Type");
    protected ListBox employeeTypeList = new ListBox();
    
    public EmailGroupsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        generateRepB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        employeeTypeList.addItem("All Employees", "All Employees");
        employeeTypeList.addItem("Corporate Employee", "Corporate Employee");
        employeeTypeList.addItem("Employee", "Employee");
        employeeTypeList.addItem("W2 Contractor", "W2 Contractor");
        employeeTypeList.addItem("1099 Contractor", "1099 Contractor");
        employeeTypeList.addItem("Subcontractor", "Subcontractor");
        employeeTypeList.addItem("Intern-Seasonal Employee", "Intern-Seasonal Employee");        
        employeeTypeList.addItem("Deactivated", "Deactivated");
    }

    @Override
    protected void addWidgets() {
        panel.add(employeeType);
        panel.add(employeeTypeList);
        panel.add(generateRepB);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(generateRepB)) {
            generateEmailMenuReport();
        }
    }

    protected void generateEmailMenuReport() {
        HttpService.HttpServiceAsync.instance().doGet(getEmailMenuReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    private String getEmailMenuReportUrl() {
        return OfficeWelcome.constants.root_url() + "email-groups/type?employee-type=" + employeeTypeList.getValue(employeeTypeList.getSelectedIndex());
    }
}

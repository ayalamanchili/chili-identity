/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author ayalamanchili
 */
public class ProfileReportsSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    ClickableLink profileBasicReportL = new ClickableLink("Basic Profile Report");
    ClickableLink profileAdvanceReportL = new ClickableLink("Complete Profile Report");
    ClickableLink clientInfoReportL = new ClickableLink("Client Information Report");
    ClickableLink companyContactsReportL = new ClickableLink("Company Contact Report");

    public ProfileReportsSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        profileBasicReportL.addClickHandler(this);
        profileAdvanceReportL.addClickHandler(this);
        clientInfoReportL.addClickHandler(this);
        companyContactsReportL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        profileAdvanceReportL.setTitle("report with name,email,phone, start date, address, emergency contact");
        profileBasicReportL.setTitle("report with name, email, phone, start date of all employees");
        clientInfoReportL.setTitle("report with employeeName, clientName, clientName, billingRate,startDate,endDate of all employees");
        companyContactsReportL.setTitle("report with first name, last name, company contact type, contact of all employees");
    }

    @Override
    protected void addWidgets() {
        panel.add(profileBasicReportL);
        panel.add(profileAdvanceReportL);
        panel.add(clientInfoReportL);
        panel.add(companyContactsReportL);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(profileBasicReportL)) {
            generateBasicInfoReport();
        }
        if (event.getSource().equals(profileAdvanceReportL)) {
            generateAdvanceInfoReport();
        }
        if (event.getSource().equals(clientInfoReportL)) {
            generateClientInfoReport();
        }
        if (event.getSource().equals(companyContactsReportL)) {
            generateCompanyContactReport();
        }
    }

    protected void generateBasicInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getBasicInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected void generateAdvanceInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getAdvanceInfoReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected void generateClientInfoReport() {
        HttpService.HttpServiceAsync.instance().doGet(getClientInformationReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected void generateCompanyContactReport() {
        HttpService.HttpServiceAsync.instance().doGet(getCompanyContactReportUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        new ResponseStatusWidget().show("Report will be emailed to your primary email");
                    }
                });
    }

    protected String getBasicInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-basic-info-report";
    }

    protected String getCompanyContactReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-company-contacts-report";
    }

    protected String getAdvanceInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-advance-info-report";
    }

    protected String getClientInformationReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-client-info-report";
    }
}

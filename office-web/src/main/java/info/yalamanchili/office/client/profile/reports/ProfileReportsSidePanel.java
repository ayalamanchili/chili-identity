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
    
    public ProfileReportsSidePanel() {
        init(panel);
    }
    
    @Override
    protected void addListeners() {
        profileBasicReportL.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
        profileBasicReportL.setTitle("report with name, email, phone, start date of all employees");
    }
    
    @Override
    protected void addWidgets() {
        panel.add(profileBasicReportL);
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(profileBasicReportL)) {
            generateBasicInfoReport();
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
    
    protected String getBasicInfoReportUrl() {
        return OfficeWelcome.constants.root_url() + "profile-reports/employee-basic-info-report";
    }
    
}

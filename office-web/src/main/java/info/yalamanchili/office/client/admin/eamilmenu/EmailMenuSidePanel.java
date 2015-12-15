/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.eamilmenu;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.OfficeWelcome.logger;

/**
 *
 * @author prasanthi.p
 */
public class EmailMenuSidePanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();
    protected Button generateRepB = new Button("Generate");
    protected Label employeeL = new Label("Employee");
    protected ListBox employee = new ListBox();

    public EmailMenuSidePanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        generateRepB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        employee.addItem("Corporate Employee", "Corporate Employee");
        employee.addItem("Employee", "Employee");
        employee.addItem("Subcontractor", "Subcontractor");
        employee.addItem("1099 Contractor", "1099 Contractor");
        employee.addItem("W2 Contractor", "W2 Contractor");
    }

    @Override
    protected void addWidgets() {
        panel.add(employeeL);
        panel.add(employee);
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
        return OfficeWelcome.constants.root_url() + "email-menu/email-menu-report?employee=" + employee.getValue(employee.getSelectedIndex());
    }
}

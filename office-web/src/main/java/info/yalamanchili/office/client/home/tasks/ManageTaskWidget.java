/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import info.yalamanchili.office.client.security.SelectRoleWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ManageTaskWidget extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ManageTaskWidget.class.getName());
    protected String taskId;
    CaptionPanel mainPanel = new CaptionPanel("Manage Task");
    FlowPanel panel = new FlowPanel();
    protected SelectCorpEmployeeWidget employeeF = new SelectCorpEmployeeWidget(false, true);
    protected SelectRoleWidget roleWidget = new SelectRoleWidget(false, true);
    Button addUserB = new Button("Add User");
    Button removeUserB = new Button("Remove User");
    Button assignToB = new Button("Assign To");
    Button addGroupB = new Button("Add Group");
    Button removeGroupB = new Button("Remove Group");

    public ManageTaskWidget(String taskId) {
        this.taskId = taskId;
        init(mainPanel);
    }

    @Override
    protected void addListeners() {
        addUserB.addClickHandler(this);
        removeUserB.addClickHandler(this);
        addGroupB.addClickHandler(this);
        removeGroupB.addClickHandler(this);
        assignToB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        mainPanel.setCaptionHTML("Manage Task");

    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin()) {
            panel.add(employeeF);
            panel.add(addUserB);
            panel.add(removeUserB);
            panel.add(assignToB);
            panel.add(roleWidget);
            panel.add(addGroupB);
            panel.add(removeGroupB);
        } else {
            panel.add(employeeF);
            panel.add(assignToB);
        }
        mainPanel.setContentWidget(panel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addUserB) && employeeF.getSelectedObject() != null) {
            prcessRequest("task/add-user/" + taskId + "/" + employeeF.getSelectedObjectId());
        }
        if (event.getSource().equals(removeUserB)) {
            prcessRequest("task/remove-user/" + taskId + "/" + employeeF.getSelectedObjectId());
        }
        if (event.getSource().equals(assignToB)) {
            prcessRequest("task/assign/" + taskId + "/" + employeeF.getSelectedObjectId());
        }
        if (event.getSource().equals(addGroupB) && roleWidget.getSelectedObjectId() != null) {
            prcessRequest("task/add-group/" + taskId + "/" + roleWidget.getSelectedObjectId());
        }
        if (event.getSource().equals(removeGroupB) && roleWidget.getSelectedObjectId() != null) {
            prcessRequest("task/remove-group/" + taskId + "/" + roleWidget.getSelectedObjectId());
        }
    }

    protected void prcessRequest(String str) {
        HttpService.HttpServiceAsync.instance().doPut(OfficeWelcome.constants.root_url() + "bpm/" + str, null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        new ResponseStatusWidget().show("Task Updated");
                        GenericPopup.hideIfOpen();
                    }
                });
    }

}

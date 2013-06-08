/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.StackPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.home.audit.AuditStackPanelWidget;
import info.yalamanchili.office.client.home.message.MessageStackPanelWidget;
import info.yalamanchili.office.client.home.tasks.TasksStackPanelWidget;
import info.yalamanchili.office.client.home.todo.TODOStackPanelWidget;

/**
 *
 * @author yphanikumar
 */
public class HomeStackPanel extends ALComposite implements ClickHandler {

    protected StackPanel panel = new StackPanel();
    TasksStackPanelWidget taskStackPanel = new TasksStackPanelWidget();
    MessageStackPanelWidget msgStackPanel = new MessageStackPanelWidget();
    TODOStackPanelWidget todoStackPanel = new TODOStackPanelWidget();
    AuditStackPanelWidget auditStackPanelWidget = new AuditStackPanelWidget();

    public HomeStackPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_EXPENSE, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RECRUITER)) {
            panel.add(taskStackPanel, "Tasks");
            panel.add(auditStackPanelWidget, "Audit");
        }
        panel.add(msgStackPanel, "Messages");
        panel.add(todoStackPanel, "TODO's");
    }

    @Override
    public void onClick(ClickEvent event) {
    }
}

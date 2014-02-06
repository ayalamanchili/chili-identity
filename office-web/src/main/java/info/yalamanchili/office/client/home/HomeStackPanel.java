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
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.audit.AuditStackPanelWidget;
import info.yalamanchili.office.client.home.message.MessageStackPanelWidget;
import info.yalamanchili.office.client.home.tasks.TasksStackPanelWidget;
import info.yalamanchili.office.client.home.todo.TODOStackPanelWidget;
import info.yalamanchili.office.client.profile.selfservice.CreateSelfServicePanel;
import info.yalamanchili.office.client.profile.selfservice.SelfServiceStackPanel;

/**
 *
 * @author yphanikumar
 */
public class HomeStackPanel extends ALComposite implements ClickHandler {

    protected StackPanel panel = new StackPanel();
    SelfServiceStackPanel selfServStackPanel = new SelfServiceStackPanel();
    TasksStackPanelWidget taskStackPanel = new TasksStackPanelWidget();
    MessageStackPanelWidget msgStackPanel = new MessageStackPanelWidget();
    TODOStackPanelWidget todoStackPanel = new TODOStackPanelWidget();
    AuditStackPanelWidget auditStackPanelWidget = new AuditStackPanelWidget();

    public HomeStackPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
//        selfServStackPanel.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.isCorporateEmployee()) {
            panel.add(taskStackPanel, "Tasks");
        }
        panel.add(selfServStackPanel, "Self Service");
        panel.add(msgStackPanel, "Messages");
        if (Auth.isCorporateEmployee()) {
            panel.add(auditStackPanelWidget, "Audit");
        }
        panel.add(todoStackPanel, "TODO's");
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(selfServStackPanel)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateSelfServicePanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}

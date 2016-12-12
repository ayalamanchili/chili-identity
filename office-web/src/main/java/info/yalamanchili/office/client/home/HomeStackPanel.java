/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.message.MessageStackPanelWidget;
import info.yalamanchili.office.client.home.tasks.TasksStackPanelWidget;
import info.yalamanchili.office.client.home.todo.TODOStackPanelWidget;
import info.yalamanchili.office.client.profile.selfservice.CreateServiceTicketPanel;
import info.yalamanchili.office.client.profile.selfservice.SelfServiceStackPanel;
import info.yalamanchili.office.client.profile.statusreport.MyReportsStackPanelWidget;

/**
 *
 * @author yphanikumar
 */
public class HomeStackPanel extends ALComposite implements ClickHandler {

    protected StackPanel panel = new StackPanel();
    SelfServiceStackPanel selfServStackPanel = new SelfServiceStackPanel();
    TasksStackPanelWidget taskStackPanel = new TasksStackPanelWidget();
    MessageStackPanelWidget msgStackPanel = new MessageStackPanelWidget();
    MyReportsStackPanelWidget projectsStackPanel = new MyReportsStackPanelWidget();
    TODOStackPanelWidget todoStackPanel = new TODOStackPanelWidget();

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
        panel.add(projectsStackPanel, "My Reports");
        panel.add(msgStackPanel, "Messages");
        panel.add(todoStackPanel, "Todo");
    }

//TODO this does not seem to be working
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(selfServStackPanel)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateServiceTicketPanel());
        }
    }
}

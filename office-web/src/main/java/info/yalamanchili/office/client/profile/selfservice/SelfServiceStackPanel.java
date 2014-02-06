/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;

/**
 *
 * @author anuyalamanchili
 */
public class SelfServiceStackPanel extends ALComposite implements ClickHandler {

    protected ScrollPanel panel = new ScrollPanel();
    protected FlowPanel mainPanel = new FlowPanel();
    protected ClickableLink myTickets = new ClickableLink("My Tickets");
    protected ClickableLink createServiceTicket = new ClickableLink("Open Ticket");

    public SelfServiceStackPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        myTickets.addClickHandler(this);
        createServiceTicket.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        mainPanel.add(myTickets);
        mainPanel.add(createServiceTicket);
        panel.add(mainPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(myTickets)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            //todo show read all panel
            String myTasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/currentuser/";
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(myTasksUrl));
        }
        if (event.getSource().equals(createServiceTicket)) {
            TabPanel.instance().getHomePanel().entityPanel.clear();
            //TODO show create ticket panel
            String completedTasksUrl = OfficeWelcome.constants.root_url() + "bpm/history/tasks/";
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTasks(completedTasksUrl));
        }
    }
}

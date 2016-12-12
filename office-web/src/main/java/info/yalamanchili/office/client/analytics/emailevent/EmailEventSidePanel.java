/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics.emailevent;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class EmailEventSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EmailEventSidePanel.class.getName());
    public FlowPanel eventsSidePanel = new FlowPanel();

    public EmailEventSidePanel() {
        init(eventsSidePanel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        eventsSidePanel.add(new SearchEmailEventPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllEmailEventsPanel());
    }
}

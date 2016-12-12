/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics.event;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author benerji.v
 */
public class EventsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(EventsSidePanel.class.getName());
    public FlowPanel eventsSidePanel = new FlowPanel();
    ClickableLink createactivitylink = new ClickableLink("Activity");

    public EventsSidePanel() {
        init(eventsSidePanel);
    }

    @Override
    protected void addListeners() {
        createactivitylink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        eventsSidePanel.add(new SearchEventPanel());
        eventsSidePanel.add(createactivitylink);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createactivitylink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllEventsPanel());
        }
    }
}
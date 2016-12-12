/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CurrentEmployeeTimeSummaryPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CurrentEmployeeTimeSummaryPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected ClickableLink overtimePayRequest = new ClickableLink("Submit Overtime Pay Request");
    protected ReadAllTimesheetPanel readAllTimeSheetsPanel = new ReadAllTimesheetPanel();

    public CurrentEmployeeTimeSummaryPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        overtimePayRequest.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(overtimePayRequest);
        panel.add(new EmployeeTimeSummaryPanel());
        panel.add(readAllTimeSheetsPanel);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(overtimePayRequest)) {
            TabPanel.instance().timePanel.entityPanel.clear();
            TabPanel.instance().timePanel.entityPanel.add(new OverTimePayRequestPanel());
        }
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class OverTimePayRequestPanel extends GenericBPMStartFormPanel {

    private static Logger logger = Logger.getLogger(OverTimePayRequestPanel.class.getName());

    public OverTimePayRequestPanel() {
        super("OvertimePayRequest", "overtime_hours_adjustment_process");
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Request Submited you will be notified via email");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new CurrentEmployeeTimeSummaryPanel());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;

/**
 *
 * @author anuyalamanchili
 */
public class EmpTimeSummaryPanel extends ALComposite {

    protected FlowPanel panel = new FlowPanel();
    protected ReadAllTimesheetPanel readAllTimeSheetsPanel = new ReadAllTimesheetPanel();

    public EmpTimeSummaryPanel() {
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
        panel.add(readAllTimeSheetsPanel);
    }
}

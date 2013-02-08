/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CurrentEmployeeTimeSummaryPanel extends ALComposite {

    private static Logger logger = Logger.getLogger(CurrentEmployeeTimeSummaryPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected ReadAllTimesheetPanel readAllTimeSheetsPanel = new ReadAllTimesheetPanel();

    public CurrentEmployeeTimeSummaryPanel() {
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
        panel.add(new EmployeeTimeSummaryPanel());
        panel.add(readAllTimeSheetsPanel);
    }
}

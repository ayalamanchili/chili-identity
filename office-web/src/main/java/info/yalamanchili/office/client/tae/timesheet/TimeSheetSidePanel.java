/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.tae.client.CreateClientPanel;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class TimeSheetSidePanel extends ALComposite implements ClickHandler {
    
    private static Logger logger = Logger.getLogger(TimeSheetSidePanel.class.getName());
    public FlowPanel timeSheetsidepanel = new FlowPanel();
    ClickableLink createtimeSheetlink = new ClickableLink("Create TimeSheet");
    //TimeSheet Period Dropdown
    SelectTimesheetPeriodWidget timePeriodWidget = new SelectTimesheetPeriodWidget(false, false);
    Button showTimeSheetsB = new Button("Show TimeSheet's");
    
    public TimeSheetSidePanel() {
        init(timeSheetsidepanel);
    }
    
    @Override
    protected void addListeners() {
        createtimeSheetlink.addClickHandler(this);
        showTimeSheetsB.addClickHandler(this);
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            timeSheetsidepanel.add(createtimeSheetlink);
            timeSheetsidepanel.add(timePeriodWidget);
            timeSheetsidepanel.add(showTimeSheetsB);
        }
    }
    
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createtimeSheetlink)) {
            TabPanel.instance().timeandExpensePanel.entityPanel.clear();
            TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateTimesheetPanel(CreateComposite.CreateCompositeType.CREATE));
        }
        if (event.getSource().equals(showTimeSheetsB)) {
            TabPanel.instance().getTimeandExpensePanel().entityPanel.clear();
            TabPanel.instance().getTimeandExpensePanel().entityPanel.add(new ReadAllTimesheetPanel(timePeriodWidget.getSelectedObjectId()));
        }
    }
}

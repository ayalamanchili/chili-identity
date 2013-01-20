/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateMonthlyTimeSheetPanel extends CreateTimeSheetPanel {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.tae.timesheet.CreateMonthlyTimeSheetPanel.class.getName());

    public CreateMonthlyTimeSheetPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("employee", entity);
        entity.put("timeSheetPeriod", SelectTimesheetPeriodWidget.instance().getSelectedObject());
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("adpHours", entity);
        assignEntityValueFromField("adpRate", entity);
        assignEntityValueFromField("quickBooksHours", entity);
        assignEntityValueFromField("quickBooksRate", entity);
        assignEntityValueFromField("notes", entity);
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Timesheet Successfully created");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new CreateMonthlyTimeSheetPanel());
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget(false, true));
        addField("adpHours", false, true, DataType.FLOAT_FIELD);
        addField("quickBooksHours", false, true, DataType.FLOAT_FIELD);
        addField("adpRate", false, false, DataType.CURRENCY_FIELD);
        addField("quickBooksRate", false, false, DataType.CURRENCY_FIELD);
        addField("startDate", false, false, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
    }
}

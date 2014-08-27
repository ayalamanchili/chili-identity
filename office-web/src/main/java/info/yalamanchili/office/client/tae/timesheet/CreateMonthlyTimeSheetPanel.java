/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
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
        new ResponseStatusWidget().show("Timesheet Successfully Created");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllTimesheetPanel(SelectTimesheetPeriodWidget.instance().getSelectedObjectId()));
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget("Employee", false, true));
        addField("adpHours", false, true, DataType.FLOAT_FIELD);
        addField("quickBooksHours", false, true, DataType.FLOAT_FIELD);
        addField("adpRate", false, false, DataType.CURRENCY_FIELD);
        addField("quickBooksRate", false, false, DataType.CURRENCY_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
        //prepopulate start and end dates
        HttpService.HttpServiceAsync.instance().doGet(getTimeSheetPeriodUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null && !response.isEmpty()) {
                            JSONObject timePeriod = (JSONObject) JSONParser.parseLenient(response);
                            DateField startDateF = (DateField) fields.get("startDate");
                            startDateF.setDate(DateUtils.toDate(JSONUtils.toString(timePeriod, "startDate")));
                            DateField endDateF = (DateField) fields.get("endDate");
                            endDateF.setDate(DateUtils.toDate(JSONUtils.toString(timePeriod, "endDate")));
                        }
                    }
                });
    }

    protected String getTimeSheetPeriodUrl() {
        JSONObject timePeriod = SelectTimesheetPeriodWidget.instance().getSelectedObject();
        return OfficeWelcome.constants.root_url() + "timesheetperiod/" + JSONUtils.toString(timePeriod, "id");
    }
}

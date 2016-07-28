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
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;

/**
 *
 * @author Prashanthi
 */
public class ReadTimeSheetPanel extends ReadComposite {

    private static ReadTimeSheetPanel instance;

    public static ReadTimeSheetPanel instance() {
        return instance;
    }

    public ReadTimeSheetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Timesheet", OfficeWelcome.constants);
    }

    public ReadTimeSheetPanel(String id) {
        initReadComposite(id, "Timesheet", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("adpRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("quickBooksRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("adpHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("quickBooksHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("timeSheetPeriod", entity, null);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget("Employee", true, false));
        addDropDown("timeSheetPeriod", new SelectTimesheetPeriodWidget(true, false));
        addField("adpHours", true, false, DataType.FLOAT_FIELD);
        addField("quickBooksHours", true, false, DataType.FLOAT_FIELD);
        addField("adpRate", true, false, DataType.CURRENCY_FIELD);
        addField("quickBooksRate", true, false, DataType.CURRENCY_FIELD);
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet/" + entityId;
    }
    
    @Override
    protected boolean enableBack() {
       return true;
    }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllTimesheetPanel.instance;
    }
}

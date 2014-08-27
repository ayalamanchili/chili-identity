/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class UpdateTimesheetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTimesheetPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidget = new SelectEmployeeWidget("Employee", true, false);
    SelectTimesheetPeriodWidget selectTimesheetPeriodWidget = new SelectTimesheetPeriodWidget(true, false);
    protected String payPeriodId;

    public UpdateTimesheetPanel(String payPeriodId, JSONObject entity) {
        this.payPeriodId = payPeriodId;
        initUpdateComposite(entity, "Timesheet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("adpRate", entity);
        assignEntityValueFromField("quickBooksRate", entity);
        assignEntityValueFromField("adpHours", entity);
        assignEntityValueFromField("quickBooksHours", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("notes", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
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
        //TODO has some issue with read only not being correctly set need to call it again
        selectEmployeeWidget.setReadOnly(true);
        selectTimesheetPeriodWidget.setReadOnly(true);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllTimesheetPanel(payPeriodId));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", selectEmployeeWidget);
        addDropDown("timeSheetPeriod", selectTimesheetPeriodWidget);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("adpHours", false, true, DataType.FLOAT_FIELD);
        addField("adpRate", false, false, DataType.CURRENCY_FIELD);
        addField("quickBooksHours", false, true, DataType.FLOAT_FIELD);
        addField("quickBooksRate", false, false, DataType.CURRENCY_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet";
    }
}

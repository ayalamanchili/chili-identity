/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.sow.SelectSOWWidget;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class UpdateTimesheetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTimesheetPanel.class.getName());

    public UpdateTimesheetPanel(JSONObject entity) {
        initUpdateComposite(entity, "Timesheet", OfficeWelcome.constants);
        logger.info("0000" + entity.toString());
    }

    @Override
    protected JSONObject populateEntityFromFields() {

        assignEntityValueFromField("paidRate", entity);
        assignEntityValueFromField("billedRate", entity);
        assignEntityValueFromField("mondayPaidHours", entity);
        assignEntityValueFromField("mondayBilledHours", entity);
        assignEntityValueFromField("tuesdayPaidHours", entity);
        assignEntityValueFromField("tuesdayBilledHours", entity);
        assignEntityValueFromField("wednesdayPaidHours", entity);
        assignEntityValueFromField("wednesdayBilledHours", entity);
        assignEntityValueFromField("thursdayPaidHours", entity);
        assignEntityValueFromField("thursdayBilledHours", entity);
        assignEntityValueFromField("fridayPaidHours", entity);
        assignEntityValueFromField("fridayBilledHours", entity);
        assignEntityValueFromField("saturdayPaidHours", entity);
        assignEntityValueFromField("saturdayBilledHours", entity);
        assignEntityValueFromField("sundayPaidHours", entity);
        assignEntityValueFromField("sundayBilledHours", entity);
        assignEntityValueFromField("notes", entity);
        entity.put("timeSheetStatus", new JSONString("Approved"));
        entity.put("timeSheetCategory", new JSONString("Regular"));
        assignEntityValueFromField("statementOfWork", entity);
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("timeSheetPeriod", entity);
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
        assignFieldValueFromEntity("paidRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billedRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("mondayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("mondayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("tuesdayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("tuesdayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("wednesdayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("wednesdayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("thursdayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("thursdayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("fridayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("fridayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("saturdayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("saturdayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("sundayPaidHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("sundayBilledHours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("statementOfWork", entity, null);
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("timeSheetPeriod", entity, null);
        assignFieldValueFromEntity("notes", entity, null);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated Employee Time Sheet Information");
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllTimesheetPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("paidRate", false, true, DataType.CURRENCY_FIELD);
        addField("billedRate", false, true, DataType.CURRENCY_FIELD);
        addField("mondayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("mondayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("tuesdayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("tuesdayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("wednesdayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("wednesdayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("thursdayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("thursdayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("fridayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("fridayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("saturdayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("saturdayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("sundayPaidHours", false, true, DataType.FLOAT_FIELD);
        addField("sundayBilledHours", false, true, DataType.FLOAT_FIELD);
        addField("notes", false, true, DataType.STRING_FIELD);
        addDropDown("statementOfWork", new SelectSOWWidget(false, false));
        addDropDown("employee", new SelectEmployeeWidget(false, false));
        addDropDown("timeSheetPeriod", new SelectTimesheetPeriodWidget(false, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet";
    }
}

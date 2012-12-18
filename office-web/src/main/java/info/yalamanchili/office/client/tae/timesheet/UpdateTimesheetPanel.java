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

        assignEntityValueFromField("adpRate", entity);
        assignEntityValueFromField("quickBooksRate", entity);
        assignEntityValueFromField("adpHours", entity);
        assignEntityValueFromField("quickBooksHours", entity);
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("timeSheetPeriod", entity);
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
        assignFieldValueFromEntity("notes", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated Employee Time Sheet Information");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllTimesheetPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget(false, true));
         addDropDown("timeSheetPeriod", new SelectTimesheetPeriodWidget(false, true));
         addField("startDate", false, true, DataType.DATE_FIELD);
         addField("endDate", false, true, DataType.DATE_FIELD);
         addField("adpHours", false, true, DataType.FLOAT_FIELD);
         addField("adpRate", false, true, DataType.CURRENCY_FIELD);
         addField("quickBooksHours", false, true, DataType.FLOAT_FIELD);
         addField("quickBooksRate", false, true, DataType.CURRENCY_FIELD);
         addField("notes", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet";
    }
}

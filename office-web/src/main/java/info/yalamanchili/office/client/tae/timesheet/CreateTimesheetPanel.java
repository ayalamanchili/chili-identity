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
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.rpc.HttpService;
import info.yalamanchili.office.client.tae.sow.SelectSOWWidget;
import info.yalamanchili.office.client.tae.timesheetperiod.SelectTimesheetPeriodWidget;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateTimesheetPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(info.yalamanchili.office.client.tae.timesheet.CreateTimesheetPanel.class.getName());

    public CreateTimesheetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Timesheet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {

        JSONObject entity = new JSONObject();
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
        entity.put("timeSheetStatus", new JSONString("Approved"));
        entity.put("timeSheetCategory", new JSONString("Regular"));
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("statementOfWork", entity);
        assignEntityValueFromField("timeSheetPeriod",entity);
        assignEntityValueFromField("notes",entity);
        logger.info("99999999999" + entity);
        return entity;

    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Timesheet Successfully created");
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
         addDropDown("statementOfWork", new SelectSOWWidget(false, true));
         addDropDown("employee", new SelectEmployeeWidget(false, true));
         addDropDown("timeSheetPeriod", new SelectTimesheetPeriodWidget(false, true));

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet";
    }
}

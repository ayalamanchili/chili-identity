/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.tae.sow.SelectSOWWidget;


/**
 *
 * @author raghu
 */
public class CreateTimesheetPanel extends CreateComposite {

    public CreateTimesheetPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Timesheet", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
         JSONObject ts = new JSONObject();
        assignEntityValueFromField("paidRate", ts);
        assignEntityValueFromField("billedRate", ts);
        assignEntityValueFromField("mondayPaidHours", ts);
        assignEntityValueFromField("mondayBilledHours", ts);
        assignEntityValueFromField("tuesdayPaidHours", ts);
        assignEntityValueFromField("tuesdayBilledHours", ts);
        assignEntityValueFromField("wednesdayPaidHours", ts);
        assignEntityValueFromField("wednesdayBilledHours", ts);
        assignEntityValueFromField("thursdayPaidHours", ts);
        assignEntityValueFromField("thursdayBilledHours", ts);
        assignEntityValueFromField("fridayPaidHours", ts);
        assignEntityValueFromField("fridayBilledHours", ts);
        assignEntityValueFromField("saturdayPaidHours", ts);
        assignEntityValueFromField("saturdayBilledHours", ts);
        assignEntityValueFromField("sundayPaidHours", ts);
        assignEntityValueFromField("sundayBilledHours", ts);
        assignEntityValueFromField("notes", ts);
        return ts;
    }

    @Override
    protected void createButtonClicked() {
        
    }

    @Override
    protected void addButtonClicked() {
        
    }

    @Override
    protected void postCreateSuccess(String result) {
        
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
         addDropDown("StatementofWork", new SelectSOWWidget(false, false));
//         addDropDown("project", new SelectProjectWidget(false, false));
//         addDropDown("project", new SelectProjectWidget(false, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
//         addField("name", false, true, DataType.STRING_FIELD);
//        addField("description", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "timesheet" ;
    }
    
}

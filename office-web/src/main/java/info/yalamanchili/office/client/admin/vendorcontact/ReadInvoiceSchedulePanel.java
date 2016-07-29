/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadInvoiceSchedulePanel extends ReadComposite {

    private static ReadInvoiceSchedulePanel instance;

    public static ReadInvoiceSchedulePanel instance() {
        return instance;
    }

    public ReadInvoiceSchedulePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "InvoiceSchedule", OfficeWelcome.constants2);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reminderDays", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("notifyEmployees", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("startDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reminderDays", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("notifyEmployees", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invoice-schedule/" + entityId;
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    protected void addListeners() {
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllInvoiceSchedulePanel.instance;
     }
}

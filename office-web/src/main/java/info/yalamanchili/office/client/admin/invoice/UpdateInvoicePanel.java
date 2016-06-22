/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.invoice;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.contracts.ReadContractsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateInvoicePanel extends UpdateComposite {

    private Logger logger = Logger.getLogger(UpdateInvoicePanel.class.getName());

    protected static UpdateInvoicePanel instance;
    protected String id;
    protected boolean isUpdate;
    protected JSONObject invoice;
    protected String clientInfoId;

    public static UpdateInvoicePanel instance() {
        return instance;
    }

    public UpdateInvoicePanel(JSONObject entity) {
        instance = this;
        this.invoice = entity;
        initUpdateComposite(entity, "Invoice", OfficeWelcome.constants2);
    }

    public UpdateInvoicePanel(String id, JSONObject entity, boolean isUpdate) {
        instance = this;
        this.id = id;
        this.isUpdate = isUpdate;
        this.invoice = entity;
        initUpdateComposite(entity, "Invoice", OfficeWelcome.constants2);
    }

    public UpdateInvoicePanel(String id, boolean isUpdate) {
        this.id = id;
        instance = this;
        this.isUpdate = isUpdate;
        initUpdateComposite(id, "Invoice", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("itemNumber", entity);
        assignEntityValueFromField("invoiceNumber", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("invoiceDate", entity);
        assignEntityValueFromField("invoicePeriodEndDate", entity);        
        assignEntityValueFromField("invoiceSentDate", entity);
        assignEntityValueFromField("billingRate", entity);
        assignEntityValueFromField("overTimeBillingRate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("invoiceFrequency", entity);
        assignEntityValueFromField("invoiceStatus", entity);
        assignEntityValueFromField("timeSheetStatus", entity);
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
        if (entity.containsKey("clientInformation")) {
            JSONObject clientInformation = entity.get("clientInformation").isObject();
            JSONObject employee = clientInformation.get("employee").isObject();
            String empName = employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue();
            StringField empF = (StringField) fields.get("employee");
            empF.setValue(empName);
            assignFieldValueFromEntity("billingRate", clientInformation, DataType.CURRENCY_FIELD);
        } else if (entity.get("employee") instanceof JSONObject) {
            JSONObject employee = entity.get("employee").isObject();
            String name = employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue();
            StringField field = (StringField) fields.get("employee");
            field.setValue(name);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        } else {
            assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invoiceNumber", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("invoiceDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("invoicePeriodEndDate", entity, DataType.DATE_FIELD);        
        assignFieldValueFromEntity("invoiceSentDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("timeSheetStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Invoice Information");
        TabPanel.instance().reportingPanel.entityPanel.clear();
        GenericPopup.instance().hide();
        TabPanel.instance().reportingPanel.entityPanel.add(new ReadContractsPanel(id));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("itemNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("invoiceNumber", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("startDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("invoiceDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("invoicePeriodEndDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);                
        addField("invoiceSentDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("billingRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimeBillingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("hours", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("invoiceStatus", false, true, InvoiceStatus.names(), Alignment.HORIZONTAL);
        addEnumField("timeSheetStatus", false, true, TimeStatus.names(), Alignment.HORIZONTAL);
        addField("notes", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        if (isUpdate == true) {
            return OfficeWelcome.constants.root_url() + "invoice/update-Invoice/" + invoice.get("id").isString().stringValue();
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/save/" + id;
        }
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject entity1 = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity1);
                    }
                });
    }

    protected String getReadURI() {
        if (isUpdate == false) {
            return OfficeWelcome.constants.root_url() + "clientinformation/read/" + id;
        } else {
            return OfficeWelcome.constants.root_url() + "invoice/read/" + invoice.get("id").isString().stringValue();
        }
    }
}

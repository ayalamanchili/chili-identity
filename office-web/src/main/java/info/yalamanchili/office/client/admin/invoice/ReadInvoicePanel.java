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
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadInvoicePanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadInvoicePanel.class.getName());
    private static ReadInvoicePanel instance;

    public static ReadInvoicePanel instance() {
        return instance;
    }

    public ReadInvoicePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Invoice", OfficeWelcome.constants2);
    }

    public ReadInvoicePanel(String id) {
        initReadComposite(id, "Invoice", OfficeWelcome.constants2);
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
        JSONObject clientInformation = entity.get("clientInformation").isObject();
        JSONObject vendor = clientInformation.get("vendor").isObject();
        JSONObject employee = clientInformation.get("employee").isObject();
        String empName = employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue();
        StringField empF = (StringField) fields.get("employee");
        empF.setValue(empName);
        StringField vendorF = (StringField) fields.get("vendor");
        vendorF.setValue(vendor.get("name").isString().stringValue());
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invoiceNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("invoiceDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("invoiceSentDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("invoiceStatus", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("timeSheetStatus", entity, DataType.ENUM_FIELD);
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
        addField("vendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("itemNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("invoiceNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("startDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("invoiceDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);  
        addField("invoiceSentDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);  
        addField("billingRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("hours", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("invoiceStatus", true, true, InvoiceStatus.names(), Alignment.HORIZONTAL);
        addEnumField("timeSheetStatus", true, true, TimeStatus.names(), Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invoice/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS_FULL_VIEW);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.client.Invoice" + "/" + getEntityId();
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllInvoicePanel.instance;
    }
}

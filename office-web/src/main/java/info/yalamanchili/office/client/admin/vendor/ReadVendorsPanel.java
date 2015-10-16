/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.admin.client.InvoiceFrequency;

/**
 *
 * @author Prashanthi
 */
public class ReadVendorsPanel extends ReadComposite {

    private static ReadVendorsPanel instance;

    public static ReadVendorsPanel instance() {
        return instance;
    }

    public ReadVendorsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Vendors", OfficeWelcome.constants);
    }

    public ReadVendorsPanel(String id) {
        initReadComposite(id, "Vendors", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorType", entity, DataType.ENUM_FIELD);
//        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("vendorinvFrequency", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("description", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorType", false, false, VendorType.names(), Alignment.HORIZONTAL);
//        addField("website", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addField("paymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addEnumField("vendorinvFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/" + entityId;
    }
}

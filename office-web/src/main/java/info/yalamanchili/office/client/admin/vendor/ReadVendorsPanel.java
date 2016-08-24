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
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.InvoiceFrequency;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;

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
        initReadComposite(entity, "Vendors", OfficeWelcome.constants2);
    }

    public ReadVendorsPanel(String id) {
        initReadComposite(id, "Vendors", OfficeWelcome.constants2);
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
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorinvFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("vendorinvDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("vendorFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("maxFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("minFees", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("coiEndDate", entity, DataType.DATE_FIELD);
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
        addField("website", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorType", true, false, VendorType.names(), Alignment.HORIZONTAL);
        addField("paymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("vendorinvFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("vendorinvDeliveryMethod", true, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("vendorFees", true, true, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("maxFees", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("minFees", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addField("description", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("coiEndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllVendorsPanel.instance;
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.client.Vendor" + "/" + getEntityId();
    }
}

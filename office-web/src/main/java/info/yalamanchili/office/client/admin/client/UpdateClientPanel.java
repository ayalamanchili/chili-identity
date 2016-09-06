/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;

/**
 *
 * @author raghu
 */
public class UpdateClientPanel extends UpdateComposite {

    public UpdateClientPanel(JSONObject entity) {
        initUpdateComposite(entity, "Client", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
//        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("website", entity);
        assignEntityValueFromField("directClient", entity);
        assignEntityValueFromField("paymentTerms", entity);
        assignEntityValueFromField("clientinvFrequency", entity);
        assignEntityValueFromField("clientFee", entity);
//        assignEntityValueFromField("maxClientFee", entity);
//        assignEntityValueFromField("minClientFee", entity);
        assignEntityValueFromField("msaValDate", entity);
        assignEntityValueFromField("msaExpDate", entity);
        assignEntityValueFromField("clientInvDeliveryMethod", entity);
        assignEntityValueFromField("terminationNoticePeriod", entity);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("directClient", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientinvFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("clientFee", entity, DataType.FLOAT_FIELD);
//        assignFieldValueFromEntity("maxClientFee", entity, DataType.FLOAT_FIELD);
//        assignFieldValueFromEntity("minClientFee", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("clientInvDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("terminationNoticePeriod", entity, DataType.INTEGER_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientsPanel());
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new ClientSidePanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
//        addField("description", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("directClient", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientinvFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("clientInvDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("clientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("maxClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("minClientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        DateField msaValDate = (DateField) fields.get("msaValDate");
        DateField msaExpDate = (DateField) fields.get("msaExpDate");
        if (msaValDate.getDate() != null && msaExpDate.getDate() != null && msaValDate.getDate().after(msaExpDate.getDate())) {
            msaExpDate.setMessage("To Date must be after From Date");
            return false;
        }
        return valid;
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client";
    }
}

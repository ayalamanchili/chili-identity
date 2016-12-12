/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.AccountType;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateBankAccountPanel extends UpdateComposite {

    public UpdateBankAccountPanel(JSONObject entity) {
        initUpdateComposite(entity, "BankAccount", OfficeWelcome.constants);
    }

    protected static UpdateBankAccountPanel instance;

    public static UpdateBankAccountPanel instance() {
        return instance;
    }

    public UpdateBankAccountPanel(String parentId) {
        instance = this;
        initUpdateComposite(parentId, "BankAccount", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(entityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    protected String getReadURI(String entityId) {
        return OfficeWelcome.constants.root_url() + "employee-forms/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("accountFirstName", entity);
        assignEntityValueFromField("accountLastName", entity);
        assignEntityValueFromField("bankName", entity);
        assignEntityValueFromField("bankRoutingNumber", entity);
        assignEntityValueFromField("bankAccountNumber", entity);
        assignEntityValueFromField("bankAddress1", entity);
        assignEntityValueFromField("bankAddress2", entity);
        assignEntityValueFromField("accountType", entity);
        assignEntityValueFromField("achBlocked", entity);
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
        assignFieldValueFromEntity("accountFirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountLastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankRoutingNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAccountNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAddress1", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAddress2", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("achBlocked", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated BankAccount");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllBankAcctWidget(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("accountFirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        addField("achBlocked", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-forms/update";
    }
}

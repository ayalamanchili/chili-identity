/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

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
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.ClientStatus;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;

/**
 *
 * @author raghu
 */
public class ReadClientPanel extends ReadComposite {

    private static ReadClientPanel instance;

    public static ReadClientPanel instance() {
        return instance;
    }

    public ReadClientPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Client", OfficeWelcome.constants2);
    }

    public ReadClientPanel(String id) {
        initReadComposite(id, "Client", OfficeWelcome.constants2);
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
    
    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.client.Client"));
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
        assignFieldValueFromEntity("clientStatus", entity, DataType.ENUM_FIELD);
        populateComments();
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
//        addField("description", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("website", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("directClient", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientinvFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("clientInvDeliveryMethod", true, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("clientFee", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("maxClientFee", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        addField("minClientFee", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("clientStatus", true, false, ClientStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.client.Client" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.add(new ClientSidePanel());
        return ReadAllClientsPanel.instance;
    }
    
    @Override
    protected boolean enableEdit() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            return true;
        } else
        return false;
    }

    @Override
    protected void onEditClicked() {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(entity));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateClientPanel(entity));
    }
}

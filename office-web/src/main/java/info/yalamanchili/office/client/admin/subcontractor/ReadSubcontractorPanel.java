/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.SubcontractorStatus;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceDeliveryMethod;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;

/**
 *
 * @author anuyalamanchili
 */
public class ReadSubcontractorPanel extends ReadComposite {

    private static ReadSubcontractorPanel instance;

    public static ReadSubcontractorPanel instance() {
        return instance;
    }

    public ReadSubcontractorPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Subcontractor", OfficeWelcome.constants);
    }

    public ReadSubcontractorPanel(String id) {
        initReadComposite(id, "Subcontractor", OfficeWelcome.constants2);
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
//        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("website", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("paymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("coiEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaValDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("msaExpDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("terminationNoticePeriod", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("subcontractorStatus", entity, DataType.ENUM_FIELD);
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
//      addField("description", true, false, DataType.STRING_FIELD);
        addField("website", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("paymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        addEnumField("invoiceDeliveryMethod", true, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
        addField("coiEndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaValDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("msaExpDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("terminationNoticePeriod", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("subcontractorStatus", true, false, SubcontractorStatus.names(), Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.client.Subcontractor" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.add(new SubcontractorSidePanel());
        return ReadAllSubcontractorsPanel.instance;
    }

    @Override
    protected boolean enableEdit() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onEditClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateSubcontractorPanel(entity));
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeSubcontractorPanel(entity));
    }
}

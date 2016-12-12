/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.office.client.profile.contact.Sex;

public class UpdateEmergencyContactPanel extends UpdateComposite {

    public UpdateEmergencyContactPanel(JSONObject entity) {
        initUpdateComposite(entity, "EmergencyContact", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("relation", entity);
        assignEntityValueFromField("ecPrimary", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Emergency Contact Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(
                TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("relation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ecPrimary", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addEnumField("sex", false, false, Sex.names());
        addField("relation", false, true, DataType.STRING_FIELD);
        addField("ecPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("email", false, false, DataType.STRING_FIELD);
        addField("countryCode", false, false, DataType.STRING_FIELD);
        addField("phoneNumber", false, true, DataType.STRING_FIELD);
        addField("extension", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "emergencycontact";
    }
}

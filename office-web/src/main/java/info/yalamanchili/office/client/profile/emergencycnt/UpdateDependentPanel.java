/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.onboarding.Relationship;
import info.yalamanchili.office.client.profile.contact.Salutation;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateDependentPanel extends UpdateComposite {

    protected String targetClassName;
    
    public UpdateDependentPanel(JSONObject entity) {
        initUpdateComposite(entity, "Dependent", OfficeWelcome.constants2);
    }
    
    public UpdateDependentPanel(JSONObject entity,String targetClassName) {
        this.targetClassName = targetClassName;
        initUpdateComposite(entity, "Dependent", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("salutation", entity);
        assignEntityValueFromField("dfirstName", entity);
        assignEntityValueFromField("dmiddleName", entity);
        assignEntityValueFromField("dlastName", entity);
        assignEntityValueFromField("ddateOfBirth", entity);
        assignEntityValueFromField("relationship", entity);
        assignEntityValueFromField("gender", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("phoneNumber", entity);
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
        new ResponseStatusWidget().show("Successfully Updated Dependent Information");
        if(targetClassName != null){
            GenericPopup.instance().hide();
            ReadAllDependentsPanel.instance().preFetchTable(0);
        }
        else{
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllDependentsPanel(
                TreeEmployeePanel.instance().getEntityId()));
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("salutation", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("dfirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dmiddleName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dlastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ddateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("relationship", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("gender", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
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
        addEnumField("salutation", false, false, Salutation.names(), Alignment.HORIZONTAL);
        addField("dfirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dmiddleName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", false, true, Relationship.names(), Alignment.HORIZONTAL);
        addEnumField("gender", false, false, Sex.names(), Alignment.HORIZONTAL);
        addField("email", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "dependent/update";
    }
}

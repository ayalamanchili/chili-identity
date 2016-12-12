/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Sudha
 */
public class UpdateEducationRecordPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdateEducationRecordPanel.class.getName());

    public UpdateEducationRecordPanel(JSONObject entity) {
        initUpdateComposite(entity, "EducationRecord", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("degreeOfStudy", entity);
        assignEntityValueFromField("fieldOfStudy", entity);
        assignEntityValueFromField("nameOfSchool", entity);
        assignEntityValueFromField("address", entity);
        assignEntityValueFromField("dateDegreeAwarded", entity);
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
        assignFieldValueFromEntity("degreeOfStudy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("fieldOfStudy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("nameOfSchool", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("address", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateDegreeAwarded", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated EducationRecord");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEducationRecordPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("degreeOfStudy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("fieldOfStudy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nameOfSchool", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("address", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateDegreeAwarded", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "educationrecord/save/" + TreeEmployeePanel.instance().getEntityId();
    }
}
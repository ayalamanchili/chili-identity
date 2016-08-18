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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
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
public class CreateEducationRecordPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateEducationRecordPanel.class.getName());
    public CreateEducationRecordPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("EducationRecord", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject educationRecord = new JSONObject();
        assignEntityValueFromField("degreeOfStudy", educationRecord);
        assignEntityValueFromField("fieldOfStudy", educationRecord);
        assignEntityValueFromField("nameOfSchool", educationRecord);
        assignEntityValueFromField("address", educationRecord);
        assignEntityValueFromField("dateDegreeAwarded", educationRecord);
        educationRecord.put("targetEntityName", new JSONString("targetEntityName"));
        educationRecord.put("targetEntityId", new JSONString("0"));
        return educationRecord;
    }

    @Override
    public void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added EducationRecord");
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
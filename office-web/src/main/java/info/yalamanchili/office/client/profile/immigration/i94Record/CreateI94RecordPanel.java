/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.i94Record;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateI94RecordPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateI94RecordPanel.class.getName());

    public CreateI94RecordPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("i94Record", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject I94Record = new JSONObject();
        //Added new fields for I-94 by Sudha #SSTO-3063        
        assignEntityValueFromField("i94RecordNumber", I94Record);
        assignEntityValueFromField("fullName", I94Record);
        assignEntityValueFromField("portOfEntry", I94Record);        
        assignEntityValueFromField("dateofEntry", I94Record);
        assignEntityValueFromField("arrivalMethod", I94Record);
        assignEntityValueFromField("modeOfTravel", I94Record); 
        assignEntityValueFromField("i94ValidFromDate", I94Record); 
        assignEntityValueFromField("admitUntilDate", I94Record);
        assignEntityValueFromField("durationValidityInd", I94Record);
        assignEntityValueFromField("expirationAlertInd", I94Record);
        assignEntityValueFromField("reentryExpiryDate", I94Record);
        assignEntityValueFromField("coApplicantTravel", I94Record);
        assignEntityValueFromField("classOfAdmission", I94Record);
        assignEntityValueFromField("comments", I94Record);     
        I94Record.put("targetEntityName", new JSONString("targetEntityName"));
        I94Record.put("targetEntityId", new JSONString("0"));
        return I94Record;
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
        new ResponseStatusWidget().show("Successfully Added I94Record");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllI94RecordPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        //Added new fields for I-94 by Sudha #SSTO-3063
        addField("i94RecordNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("fullName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("portOfEntry", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateofEntry", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);        
        addField("arrivalMethod", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("modeOfTravel", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("i94ValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("admitUntilDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("durationValidityInd", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("expirationAlertInd", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("reentryExpiryDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("coApplicantTravel", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("classOfAdmission", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);        
        addField("comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);        
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "i94record/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}

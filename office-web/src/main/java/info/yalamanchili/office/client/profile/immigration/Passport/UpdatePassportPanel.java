/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.Passport;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdatePassportPanel extends UpdateComposite implements ChangeHandler, ClickHandler {

    private static Logger logger = Logger.getLogger(UpdatePassportPanel.class.getName());

    public UpdatePassportPanel(JSONObject entity) {

        initUpdateComposite(entity, "Passport", OfficeWelcome.constants2);
    }

    protected EnumField countriesF;
    protected EnumField statesF;

    protected EnumField countriesS;
    protected EnumField stateF;

    protected BooleanField haveYouEverLostPassport;

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("passportNumber", entity);
        assignEntityValueFromField("passportIssuedDate", entity);
        assignEntityValueFromField("passportExpiryDate", entity);
        assignEntityValueFromField("passportCountryOfIssuance", entity);
        assignEntityValueFromField("passportStateOfIssuance", entity);
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("countryOfBirth", entity);
        assignEntityValueFromField("stateOfBirth", entity);
        assignEntityValueFromField("placeOfBirth", entity);
        assignEntityValueFromField("nationality", entity);
        assignEntityValueFromField("countryOfNationality", entity);
        assignEntityValueFromField("identificationMarks", entity);
        assignEntityValueFromField("haveYouEverLostPassport", entity);
        assignEntityValueFromField("reason", entity);
        assignEntityValueFromField("travelDocumentNumber", entity);
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
        assignFieldValueFromEntity("passportNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("passportIssuedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportExpiryDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportCountryOfIssuance", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("passportStateOfIssuance", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("countryOfBirth", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("stateOfBirth", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("placeOfBirth", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("nationality", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryOfNationality", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("identificationMarks", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("haveYouEverLostPassport", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("reason", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("travelDocumentNumber", entity, DataType.STRING_FIELD);
        populateComments();
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Passport");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPassportsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
        if (countriesS != null) {
            countriesS.listBox.addChangeHandler(this);
        }
        haveYouEverLostPassport.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    TextAreaField reasonF;

    @Override
    protected void addWidgets() {
        addField("passportNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpiryDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        JSONValue service = entity.get("passportCountryOfIssuance");
        addEnumField("passportCountryOfIssuance", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        populateValues(service);
        addField("passportStateOfIssuance", false, true, DataType.ENUM_FIELD);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        JSONValue service1 = entity.get("countryOfBirth");
        addEnumField("countryOfBirth", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        if (service1 != null) {
            populateValues1(service1);
            addField("stateOfBirth", false, true, DataType.ENUM_FIELD);
        } else {
            addEnumField("stateOfBirth", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        }
        addField("placeOfBirth", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nationality", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfNationality", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("identificationMarks", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("haveYouEverLostPassport", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("reason", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("travelDocumentNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        countriesF = (EnumField) fields.get("passportCountryOfIssuance");
        statesF = (EnumField) fields.get("passportStateOfIssuance");
        countriesS = (EnumField) fields.get("countryOfBirth");
        stateF = (EnumField) fields.get("stateOfBirth");
        reasonF = (TextAreaField) fields.get("reason");
        reasonF.setVisible(false);
        haveYouEverLostPassport = (BooleanField) fields.get("haveYouEverLostPassport");
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected void populateValues(JSONValue value) {
        switch (value.isString().stringValue()) {
            case "USA":
                addEnumField("passportStateOfIssuance", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "INDIA":
                addEnumField("passportStateOfIssuance", false, true, IndiaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "CANADA":
                addEnumField("passportStateOfIssuance", false, true, CanadaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
        }
    }

    protected void populateValues1(JSONValue value) {
        switch (value.isString().stringValue()) {
            case "USA":
                addEnumField("stateOfBirth", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "INDIA":
                addEnumField("stateOfBirth", false, true, IndiaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "CANADA":
                addEnumField("stateOfBirth", false, true, CanadaStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
        }
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "passport/save/" + TreeEmployeePanel.instance().getEntityId();
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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.immigration.Passport"));
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField passportIssuedDate = (DateField) fields.get("passportIssuedDate");
        DateField passportExpiryDate = (DateField) fields.get("passportExpiryDate");
        if (passportIssuedDate.getDate() != null && passportExpiryDate.getDate() != null && passportIssuedDate.getDate().after(passportExpiryDate.getDate())) {
            passportExpiryDate.setMessage("Passport Expiry Date Should Be After Issued date");
            return false;
        }
        return true;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(haveYouEverLostPassport.getBox()) && haveYouEverLostPassport.getValue()) {
            logger.info("dddddddddddddddd");
            reasonF.setVisible(true);
        } else {
            reasonF.setVisible(false);
        }
        super.onClick(event);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(countriesF.listBox)) {
            switch (countriesF.getValue()) {
                case "USA":
                    statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        } else if (event.getSource().equals(countriesS.listBox)) {
            switch (countriesS.getValue()) {
                case "USA":
                    stateF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    stateF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    stateF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
    }
}

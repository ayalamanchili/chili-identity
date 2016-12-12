/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.Passport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadPassportPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadPassportPanel.class.getName());
    
   

    public ReadPassportPanel(JSONObject entity) {
        initReadComposite(entity, "Passport", OfficeWelcome.constants2);
    }
    

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("passportNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("passportIssuedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportExpiryDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportCountryOfIssuance", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("passportStateOfIssuance", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("countryOfBirth", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("stateOfBirth", entity, DataType.STRING_FIELD);
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
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("passportNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpiryDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("passportCountryOfIssuance", true, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("passportStateOfIssuance", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfBirth", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("stateOfBirth", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("placeOfBirth", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nationality", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfNationality", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("identificationMarks", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("haveYouEverLostPassport", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("reason", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("travelDocumentNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "passport/" + entityId;
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllPassportsPanel.instance;
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

}

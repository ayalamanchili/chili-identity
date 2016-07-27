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
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.onboarding.Relationship;
import info.yalamanchili.office.client.profile.contact.Salutation;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadDependentPanel extends ReadComposite {

    private static ReadDependentPanel instance;
    private static Logger logger = Logger.getLogger(ReadDependentPanel.class.getName());

    public static ReadDependentPanel instance() {
        return instance;
    }

    public ReadDependentPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Dependent", OfficeWelcome.constants2);
    }

    public ReadDependentPanel(String id) {
        instance = this;
        initReadComposite(id, "Dependent", OfficeWelcome.constants2);
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
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("salutation", true, false, Salutation.names(), Alignment.HORIZONTAL);
        addField("dfirstName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dmiddleName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", true, false, Relationship.names(), Alignment.HORIZONTAL);
        addEnumField("gender", true, false, Sex.names(), Alignment.HORIZONTAL);
        addField("email", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllDependentsPanel.instance();
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "dependent/" + entityId;
    }
}

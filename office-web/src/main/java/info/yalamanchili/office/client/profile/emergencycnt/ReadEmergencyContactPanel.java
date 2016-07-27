/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.emergencycnt;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.profile.contact.Sex;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadEmergencyContactPanel extends ReadComposite {

    private static ReadEmergencyContactPanel instance;
    private static Logger logger = Logger.getLogger(ReadEmergencyContactPanel.class.getName());

    public static ReadEmergencyContactPanel instance() {
        return instance;
    }

    public ReadEmergencyContactPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "EmergencyContact", OfficeWelcome.constants);
    }

    public ReadEmergencyContactPanel(String id) {
        initReadComposite(id, "EmergencyContact", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("relation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ecPrimary", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, false, DataType.STRING_FIELD);
        addField("middleInitial", true, false, DataType.STRING_FIELD);
        addField("lastName", true, false, DataType.STRING_FIELD);
        addEnumField("sex", true, false, Sex.names());
        addField("relation", true, false, DataType.STRING_FIELD);
        addField("ecPrimary", true, false, DataType.BOOLEAN_FIELD);
        addField("email", true, false, DataType.STRING_FIELD);
        addField("countryCode", true, false, DataType.LONG_FIELD);
        addField("phoneNumber", true, false, DataType.LONG_FIELD);
        addField("extension", true, false, DataType.LONG_FIELD);
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
        return ReadAllEmergencyContactsPanel.instance();
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "emergencycontact/" + entityId;
    }
}

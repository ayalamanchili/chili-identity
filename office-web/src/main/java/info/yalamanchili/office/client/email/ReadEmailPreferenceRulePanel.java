/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.email;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadEmailPreferenceRulePanel extends ReadComposite {

    private static ReadEmailPreferenceRulePanel instance;
    private static Logger logger = Logger.getLogger(ReadEmailPreferenceRulePanel.class.getName());

    public static ReadEmailPreferenceRulePanel instance() {
        return instance;
    }

    public ReadEmailPreferenceRulePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "EmailPreferenceRule", OfficeWelcome.constants);
    }

    public ReadEmailPreferenceRulePanel(String id) {
        instance = this;
        initReadComposite(id, "EmailPreferenceRule", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("ruleId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("taskId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("eventName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("actionName", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("ruleId", true, false, DataType.STRING_FIELD);
        addField("name", true, false, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
        addField("processId", true, false, DataType.STRING_FIELD);
        addField("taskId", true, false, DataType.STRING_FIELD);
        addField("eventName", true, false, DataType.STRING_FIELD);
        addEnumField("actionName", true, false, EmailPreferenceType.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "email_preferencerule/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmailPreferenceRulePanel.instance;
     }
}

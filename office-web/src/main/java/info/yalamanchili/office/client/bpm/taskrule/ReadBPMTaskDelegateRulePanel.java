/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.bpm.taskrule;

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
public class ReadBPMTaskDelegateRulePanel extends ReadComposite {

    private static ReadBPMTaskDelegateRulePanel instance;
    private static Logger logger = Logger.getLogger(ReadBPMTaskDelegateRulePanel.class.getName());

    public static ReadBPMTaskDelegateRulePanel instance() {
        return instance;
    }

    public ReadBPMTaskDelegateRulePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "BPMTaskDelegateRule", OfficeWelcome.constants);
    }

    public ReadBPMTaskDelegateRulePanel(String id) {
        instance = this;
        initReadComposite(id, "BPMTaskDelegateRule", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("bpmProcessId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bpmTaskId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ruleName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ruleExpression", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("attributeData", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("bpmProcessId", true, false, DataType.STRING_FIELD);
        addField("bpmTaskId", true, false, DataType.STRING_FIELD);
        addField("ruleName", true, false, DataType.STRING_FIELD);
        addField("ruleExpression", true, false, DataType.STRING_FIELD);
        addField("attributeData", true, false, DataType.TEXT_AREA_FIELD);
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
        return ReadAllBPMTaskDelegateRulePanel.instance;
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpmtask_delegaterule/" + entityId;
    }
}

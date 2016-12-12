/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.bpm.taskrule;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateBPMTaskDelegatePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateBPMTaskDelegatePanel.class.getName());

    public UpdateBPMTaskDelegatePanel(JSONObject entity) {
        initUpdateComposite(entity, "BPMTaskDelegateRule", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("bpmProcessId", entity);
        assignEntityValueFromField("bpmTaskId", entity);
        assignEntityValueFromField("ruleName", entity);
        assignEntityValueFromField("ruleExpression", entity);
        assignEntityValueFromField("attributeData", entity);
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
        assignFieldValueFromEntity("bpmProcessId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bpmTaskId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ruleName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ruleExpression", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("attributeData", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated BPMTaskDelegateRule");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllBPMTaskDelegateRulePanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("bpmProcessId", false, true, DataType.STRING_FIELD);
        addField("bpmTaskId", false, true, DataType.STRING_FIELD);
        addField("ruleName", false, true, DataType.STRING_FIELD);
        addField("ruleExpression", false, true, DataType.STRING_FIELD);
        addField("attributeData", false, true, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bpmtask_delegaterule";
    }
}

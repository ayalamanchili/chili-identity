/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.email;

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
public class UpdateEmailPreferenceRulePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmailPreferenceRulePanel.class.getName());

    public UpdateEmailPreferenceRulePanel(JSONObject entity) {
        initUpdateComposite(entity, "EmailPreferenceRule", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("ruleId", entity);
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("processId", entity);
        assignEntityValueFromField("taskId", entity);
        assignEntityValueFromField("eventName", entity);
        assignEntityValueFromField("actionName", entity);
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
        assignFieldValueFromEntity("ruleId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("taskId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("eventName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("actionName", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Email Preference Rule");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllEmailPreferenceRulePanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("ruleId", false, true, DataType.STRING_FIELD);
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("processId", false, true, DataType.STRING_FIELD);
        addField("taskId", false, true, DataType.STRING_FIELD);
        addField("eventName", false, true, DataType.STRING_FIELD);
        addEnumField("actionName", false, true, EmailPreferenceType.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "email_preferencerule";
    }
}

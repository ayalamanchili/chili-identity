/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;

/**
 *
 * @author Prashanthi
 */
public class ReadCommunicationActivityPanel extends ReadComposite {

    SelectIssueTypeWidget issueTypeF = new SelectIssueTypeWidget(true, false);
    private static ReadCommunicationActivityPanel instance;

    public static ReadCommunicationActivityPanel instance() {
        return instance;
    }

    public ReadCommunicationActivityPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "CommunicationActivity", OfficeWelcome.constants);
    }

    public ReadCommunicationActivityPanel(String id) {
        initReadComposite(id, "CommunicationActivity", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("mode", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("subject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("issueType", entity, DataType.DROPDOWN_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        String[] typeStrs = {"INBOUND", "OUTBOUND", "OTHER"};
        addEnumField("type", true, false, typeStrs);
        String[] modeStrs = {"EMAIL", "PHONE", "SYSTEM", "OTHER"};
        addEnumField("mode", true, false, modeStrs);
        addField("subject", true, false, DataType.STRING_FIELD);
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
        addDropDown("issueType", issueTypeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "communication_activity/" + entityId;
    }
}

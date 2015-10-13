/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.project.offboarding;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author radhika.mukkala
 */
public class ReadProjectEndDetailsPanel extends ReadComposite{
    private static ReadProjectEndDetailsPanel instance;
    public static ReadProjectEndDetailsPanel instance() {
        return instance;
    }

    public ReadProjectEndDetailsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ProjectEndDetails", OfficeWelcome.constants);
    }

    public ReadProjectEndDetailsPanel(String id) {
        initReadComposite(id, "ProjectEndDetails", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("clientName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("clientName", true, false, DataType.STRING_FIELD);
        addField("vendorName", true, false, DataType.STRING_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "project-end-details/" + entityId;
    }
    
}

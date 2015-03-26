/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author ayalamanchili
 */
public class ReadBulkImportPanel extends ReadComposite {

    private static ReadBulkImportPanel instance;
    protected SelectImportAdapterComposite employeeSelectWidget = new SelectImportAdapterComposite(true, false);

    public static ReadBulkImportPanel instance() {
        return instance;
    }
     public ReadBulkImportPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "BulkImport", OfficeWelcome.constants);
    }

    public ReadBulkImportPanel(String id) {
        initReadComposite(id, "BulkImport", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bulkImport", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
         addDropDown("adapter", new SelectImportAdapterComposite(false, true));
        addField("name", true, false, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bulkimport/" + entityId;
    }
}

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
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class ReadBulkImportEntitiesPanel extends ReadComposite {

    private static ReadBulkImportEntitiesPanel instance;

    public static ReadBulkImportEntitiesPanel instance() {
        return instance;
    }

    public ReadBulkImportEntitiesPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "BulkImportEntity", OfficeWelcome.constants);
    }

    public ReadBulkImportEntitiesPanel(String id) {
        initReadComposite(id, "BulkImportEntity", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("entityId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("entityType", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("entityId", true, false, DataType.STRING_FIELD);
        addField("entityType", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bulkimport/entities/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllBulkImportEntitiesPanel.instance;
    }
}

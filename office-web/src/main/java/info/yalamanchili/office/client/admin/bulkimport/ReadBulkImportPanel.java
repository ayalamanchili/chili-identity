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
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.TabPanel;

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
        assignFieldValueFromEntity("adapter", entity, null);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("adapter", new SelectImportAdapterComposite(true, false));
        addField("name", true, false, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableAudit() {
        return true;
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.bulkimport.BulkImport" + "/" + getEntityId();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bulkimport/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        return ReadAllBulkImportsPanel.instance;
    }    
}

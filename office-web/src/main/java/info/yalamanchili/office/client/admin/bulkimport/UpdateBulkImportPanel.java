/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.FileuploadField;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateBulkImportPanel extends UpdateComposite {

    public static Logger loggar = Logger.getLogger(UpdateBulkImportPanel.class.getName());
    FileuploadField bulkImportUploadPanel = new FileuploadField(OfficeWelcome.constants, "BulkImport", "fileUrl", "BulkImport/fileUrl", false) {
        @Override
        public void onUploadComplete() {
            postUpdateSuccess(null);
        }
    };

    public UpdateBulkImportPanel(JSONObject entity) {
        initUpdateComposite(entity, "Client", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        SelectComposite adapterSC = (SelectComposite) fields.get("adapter");
        if (adapterSC.getSelectedObject() != null) {
            JSONString adapter = adapterSC.getSelectedObject().get("value").isString();
            entity.put("adapter", adapter);
        }
        entity.put("fileUrl", bulkImportUploadPanel.getFileName());
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
                uploadImage(arg0);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
    }

    protected void uploadImage(String entityId) {
        bulkImportUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated BulkImport");
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new BulkImportSidePanel());
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportsPanel());
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
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(bulkImportUploadPanel);
        //just show name description and fileuplaod fields
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bulkimport/save";
    }
}

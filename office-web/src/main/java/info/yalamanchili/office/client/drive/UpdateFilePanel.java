/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class UpdateFilePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateFilePanel.class.getName());
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "File", "fileUrl", "File/fileUrl", true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };

    public UpdateFilePanel(JSONObject entity) {
        initUpdateComposite(entity, "File", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        entity.put("fileUrl", fileUploadPanel.getFileName());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadFile(arg0);
                    }
                });
    }

    protected void uploadFile(String entityId) {
        fileUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated File");
        GenericPopup.instance().hide();
        TabPanel.instance().drivePanel.entityPanel.clear();
        TabPanel.instance().drivePanel.entityPanel.add(new ReadAllFiles(DriveTreePanel.instance().getSelectedNode().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        entityFieldsPanel.add(fileUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "drive/update-file";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (fileUploadPanel.isEmpty()) {
            fileUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.empdoc;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.ProfileHome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateEmpDocPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdateEmpDocPanel.class.getName());
    FileuploadField documentUploadPanel = new FileuploadField(OfficeWelcome.constants, "EmployeeDocument", "fileUrl", "EmployeeDocument/fileUrl", true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };
    
    public UpdateEmpDocPanel(JSONObject entity) {
        initUpdateComposite(entity, "EmployeeDocument", OfficeWelcome.constants);
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        entity.put("fileUrl", documentUploadPanel.getFileName());
        entity.put("documentType", new JSONString("ON_BOARDING"));
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
        documentUploadPanel.upload(getEntityId());
    }
    
    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated File");
        GenericPopup.instance().hide();
        if (TabPanel.instance().profilePanel.isVisible() && ProfileHome.instance() != null) {
            ProfileHome.instance().refreshEmpDocs();
        }
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
    }
    
    @Override
    protected void addListeners() {
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        String[] docTypes = {"I9", "ON_BOARDING"};
        addEnumField("documentType", false, true, docTypes);
        entityFieldsPanel.add(documentUploadPanel);
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-document";
    }
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (documentUploadPanel.isEmpty()) {
            documentUploadPanel.setMessage("Please select a file");
            return false;
        }
        return true;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.empdoc;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateEmpDocPanel extends CreateComposite {
    
    protected String employeeId;
    private static Logger logger = Logger.getLogger(CreateEmpDocPanel.class.getName());
    
    FileuploadField documentUploadPanel = new FileuploadField(OfficeWelcome.constants, "EmployeeDocument", "fileUrl", "EmployeeDocument/fileUrl", true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(null);
        }
    };
    
    public CreateEmpDocPanel(String employeeId) {
        super(CreateComposite.CreateCompositeType.CREATE);
        this.employeeId = employeeId;
        initCreateComposite("EmployeeDocument", OfficeWelcome.constants);
    }
    
    public CreateEmpDocPanel(CreateCompositeType type) {
        super(type);
        this.employeeId = employeeId;
        initCreateComposite("EmployeeDocument", OfficeWelcome.constants);
    }
    
    EnumField docType;
    
    @Override
    protected void addWidgets() {
        addEnumField("documentType", false, true, DocumentType.names());
        entityFieldsPanel.add(documentUploadPanel);
        docType = (EnumField) fields.get("documentType");
    }
    
    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                logger.info(arg0.getMessage());
                handleErrorResponse(arg0);
            }
            
            @Override
            public void onSuccess(String arg0) {
                uploadDoc(arg0);
            }
        });
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("documentType", entity);
        entity.put("fileUrl", documentUploadPanel.getFileName());
        return entity;
    }
    
    @Override
    protected void addButtonClicked() {
    }
    
    protected void uploadDoc(String entityId) {
        documentUploadPanel.upload(entityId.trim());
    }
    
    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully saved document");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmpDocsPanel(employeeId));
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee-document/" + employeeId;
    }
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        if (documentUploadPanel.isEmpty()) {
            documentUploadPanel.setMessage("Please select a file");
            return false;
        }
        if (docType.getValue() == null) {
            docType.setMessage("Please select type");
            return false;
        }
        return true;
    }
}

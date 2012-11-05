/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileuploadField;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
public class CreateFilePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateFilePanel.class.getName());
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "File", "fileUrl", "File/fileUrl", true) {
        @Override
        public void onUploadComplete() {
            postCreateSuccess(null);
        }
    };

    public CreateFilePanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("File", OfficeWelcome.constants);
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        entityDisplayWidget.add(fileUploadPanel);
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
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadFile(arg0);
                    }
                });
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject file = new JSONObject();
        assignEntityValueFromField("name", file);
        file.put("fileUrl", fileUploadPanel.getFileName());
        return file;
    }

    @Override
    protected void addButtonClicked() {
    }

    protected void uploadFile(String entityId) {
        fileUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully created file");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "drive/addfile/" + DriveTreePanel.instance().getSelectedNode().getEntityId();
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
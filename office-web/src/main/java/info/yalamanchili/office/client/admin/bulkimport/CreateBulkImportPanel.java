/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileuploadField;
import info.yalamanchili.office.client.gwt.SelectComposite;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateBulkImportPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateBulkImportPanel.class.getName());
    FileuploadField bulkImportUploadPanel = new FileuploadField(OfficeWelcome.constants, "BulkImport", "fileUrl", "BulkImport/fileUrl", false) {
        @Override
        public void onUploadComplete() {
            postCreateSuccess(null);
        }
    };

    public CreateBulkImportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("BulkImport", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        SelectComposite adapterSC = (SelectComposite) fields.get("adapter");
        if (adapterSC.getSelectedObject() != null) {
            JSONString adapter = adapterSC.getSelectedObject().get("value").isString();
            entity.put("adapter", adapter);
        }
        entity.put("fileUrl", bulkImportUploadPanel.getFileName());
        logger.info("ddd" + entity);
        return entity;
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
                        uploadImage(arg0);
                    }
                });
    }

    protected void uploadImage(String entityId) {
        bulkImportUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Client Created");
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
        entityDisplayWidget.add(bulkImportUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "bulkimport/save";
    }
}

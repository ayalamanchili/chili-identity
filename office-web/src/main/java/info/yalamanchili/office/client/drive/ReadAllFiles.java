/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllFiles extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllFiles.class.getName());
    public static ReadAllFiles instance;

    public ReadAllFiles(JSONArray array) {
        instance = this;
        initTable("File", array, OfficeWelcome.constants);
    }

    public ReadAllFiles(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Files", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getreadallfilesURL(parentId, start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getreadallfilesURL(String folderId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "drive/files/" + folderId + "/" + start + "/" + limit;

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("File"));
        table.setText(0, 3, getKeyValue("Updated Time Stamp"));
        table.setText(0, 4, getKeyValue("Updated By"));
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 2, fileField);
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTs"), DateTimeFormat.PredefinedFormat.DATE_LONG));
            table.setText(i, 4, JSONUtils.toString(entity, "updatedBy"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_DRIVE)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField("Download", fileURL);
            table.setWidget(row, 0, fileField);
        }
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {

        if (Window.confirm("Are you sure? All Files details will be deleted")) {
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            postDeleteSuccess();
                        }
                    });
        }
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Files Information");
        TabPanel.instance().drivePanel.entityPanel.clear();
        TabPanel.instance().drivePanel.entityPanel.add(new ReadAllFiles(DriveTreePanel.instance().getSelectedNode().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        new GenericPopup(new UpdateFilePanel(getEntity(entityId))).show();
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "drive/files/delete/" + entityId;
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "drive.html";
    }
}

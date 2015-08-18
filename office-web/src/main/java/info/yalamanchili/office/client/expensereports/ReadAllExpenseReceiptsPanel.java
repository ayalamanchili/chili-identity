/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expensereports;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.drive.ReadAllFiles;
import info.yalamanchili.office.client.drive.UpdateFilePanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllExpenseReceiptsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllFiles.class.getName());
    public static ReadAllFiles instance;

    public ReadAllExpenseReceiptsPanel(JSONArray array) {
        initTable("ExpenseReceipt", array, OfficeWelcome.constants);
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
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            logger.info(entity.toString());
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileURL") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 2, fileField);
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_DRIVE)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileURL") + "&entityId=" + JSONUtils.toString(entity, "id");
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
        new ResponseStatusWidget().show("Successfully Deleted Receipt Information");
        refresh();
    }

    @Override
    public void updateClicked(String entityId) {
        new GenericPopup(new UpdateFilePanel(getEntity(entityId))).show();
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "e/files/delete/" + entityId;
    }

}

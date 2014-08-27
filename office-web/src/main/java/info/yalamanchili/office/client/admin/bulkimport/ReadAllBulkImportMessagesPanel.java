/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import static info.yalamanchili.office.client.admin.bulkimport.ReadAllBulkImportsPanel.instance;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllBulkImportMessagesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBulkImportMessagesPanel.class.getName());
    public static ReadAllBulkImportMessagesPanel instance;
    protected String messageType;

    public ReadAllBulkImportMessagesPanel(String bulkImportId, String messageType) {
        instance = this;
        this.parentId = bulkImportId;
        this.messageType = messageType;
        initTable("BulkImportMessage", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getMessagesURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getMessagesURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "bulkimport/messages/" + parentId + "/" + start.toString() + "/"
                + limit.toString() + "?messageType=" + messageType;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Code"));
        table.setText(0, 2, getKeyValue("Description"));
        table.setText(0, 3, getKeyValue("Message Type"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "code"));
            table.setText(i, 2, JSONUtils.toString(entity, "description"));
            table.setText(i, 3, JSONUtils.toString(entity, "messageType"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isAccountant() || Auth.hasContractsRole()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    protected String getDeleteURL(String entityId) {
        return null;
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }
}

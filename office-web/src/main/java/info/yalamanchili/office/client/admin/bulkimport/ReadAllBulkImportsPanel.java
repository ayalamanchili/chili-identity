/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth.ROLE;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllBulkImportsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllBulkImportsPanel.class.getName());
    public static ReadAllBulkImportsPanel instance;

    public ReadAllBulkImportsPanel() {
        instance = this;
        initTable("BulkImport", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getclientsURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getclientsURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "bulkimport/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Adapter"));
        table.setText(0, 2, getKeyValue("Name"));
        table.setText(0, 3, getKeyValue("Status"));
        table.setText(0, 4, getKeyValue("Date"));
        table.setText(0, 5, getKeyValue("File"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "adapter"));
            table.setText(i, 2, JSONUtils.toString(entity, "name"));
            table.setText(i, 3, JSONUtils.toString(entity, "status"));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity,"importTimeStamp")));
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 5, fileField);
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN) && (JSONUtils.toString(entity, "status").equals("NEW") || JSONUtils.toString(entity, "status").equals("ERROR"))) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BULK_IMPORT)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_DELETE, row, JSONUtils.toString(entity, "id"));
        } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BULK_IMPORT)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeBulkImportPanel(entityId));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadBulkImportPanel(entityId));

    }

    @Override
    public void deleteClicked(String entityId) {
        if (Window.confirm("Are you sure? All Imports related to this bulk import entities will be deleted")) {
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            postDeleteSuccess();
                        }
                    });
        }
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "bulkimport/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Bulk Import Information");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllBulkImportsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateBulkImportPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_BULK_IMPORT)) {
            createButton.setText("Create Bulk Import");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().sidePanelTop.clear();
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new CreateBulkImportPanel(CreateComposite.CreateCompositeType.CREATE));
    }
    
}

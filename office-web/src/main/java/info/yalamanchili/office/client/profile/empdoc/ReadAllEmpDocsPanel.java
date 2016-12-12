/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.empdoc;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.FileField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllEmpDocsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmpDocsPanel.class.getName());
    public static ReadAllEmpDocsPanel instance;

    public ReadAllEmpDocsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("EmployeeDocument", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllFilesURL(parentId, start, OfficeWelcome.constants.tableSize()),
                OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getReadAllFilesURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee-document/" + employeeId + "/" + start + "/" + limit;

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("DocumentType"));
        table.setText(0, 2, getKeyValue("File"));
        table.setText(0, 3, getKeyValue("Updated Time Stamp"));
        table.setText(0, 4, getKeyValue("Updated By"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.formatEnumString(entity, "documentType"));
            String fileURL = ChiliClientConfig.instance().getFileDownloadUrl() + JSONUtils.toString(entity, "fileUrl") + "&entityId=" + JSONUtils.toString(entity, "id");
            FileField fileField = new FileField(fileURL);
            table.setWidget(i, 2, fileField);
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "updatedTs")));
            table.setText(i, 4, JSONUtils.toString(entity, "updatedBy"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "employee-document/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Emp Doc Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmpDocsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {

    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "documetns.html";
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ON_BOARDING_MGR)) {
            createButton.setText("Add Document");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateEmpDocPanel(TreeEmployeePanel.instance().getEntityId()));
    }
}

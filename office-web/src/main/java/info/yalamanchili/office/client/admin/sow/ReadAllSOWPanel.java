/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.sow;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllSOWPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSOWPanel.class.getName());
    public static ReadAllSOWPanel instance;

    public ReadAllSOWPanel() {
        instance = this;
        initTable("StatementOfWork", OfficeWelcome.constants);
    }

    public ReadAllSOWPanel(JSONArray array) {
        instance = this;
        initTable("StatementOfWork", array, OfficeWelcome.constants);
    }

    public ReadAllSOWPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("StatementOfWork", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllSOWPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllSOWPanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "statementofwork/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Project"));
        table.setText(0, 2, getKeyValue("Name"));
        table.setText(0, 3, getKeyValue("Description"));
        table.setText(0, 4, getKeyValue("SowUrl"));
        table.setText(0, 5, getKeyValue("StartDate"));
        table.setText(0, 6, getKeyValue("EndDate"));
        table.setText(0, 7, getKeyValue("BillRate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("project"), "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "name"));
            table.setText(i, 3, JSONUtils.toString(entity, "description"));
            table.setText(i, 4, JSONUtils.toString(entity, "sowUrl"));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 6, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            table.setText(i, 7, JSONUtils.toString(entity, "billRate"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_EXPENSE, Auth.ROLE.ROLE_TIME)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
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
        return OfficeWelcome.instance().constants.root_url() + "statementofwork/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted StatementOfWork Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSOWPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateSOWPanel(getEntity(entityId)));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateSOWPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.isAdmin() || Auth.isHR() || Auth.hasContractsRole()) {
            createButton.setText("Create SOW");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }
}

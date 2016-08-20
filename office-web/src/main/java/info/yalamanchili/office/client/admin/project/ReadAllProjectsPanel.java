/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

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
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAllProjectsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllProjectsPanel.class.getName());
    public static ReadAllProjectsPanel instance;

    public ReadAllProjectsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Project", OfficeWelcome.constants);
    }

    public ReadAllProjectsPanel() {
        instance = this;
        initTable("Project", OfficeWelcome.constants);
    }

    public ReadAllProjectsPanel(JSONArray array) {
        instance = this;
        initTable("Project", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllProjectsPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Client"));
        table.setText(0, 2, getKeyValue("Name"));
        table.setText(0, 4, getKeyValue("StartDate"));
        table.setText(0, 5, getKeyValue("EndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("client"), "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "name"));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 5, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
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
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadProjectPanel(entityId));
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
        return OfficeWelcome.instance().constants.root_url() + "project/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {

        new ResponseStatusWidget().show("Successfully Deleted Projects Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        if (parentId != null) {
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel(TreeClientPanel.instance().getEntityId()));
            TabPanel.instance().adminPanel.entityPanel.add(new ProjectOptionsPanel());
        } else {
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel());
        }
    }

    @Override
    public void updateClicked(String entityId) {
//        TabPanel.instance().adminPanel.sidePanelTop.clear();
//        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeClientPanel(entityId));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateProjectPanel(getEntity(entityId)));
    }

    public String getReadAllProjectsPanelURL(Integer start, String limit) {
        if (parentId != null) {
            return OfficeWelcome.constants.root_url() + "client/projects/" + parentId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "project/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
            createButton.setText("Create Project");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new info.yalamanchili.office.client.profile.employee.CreateProjectPanel(CreateComposite.CreateCompositeType.CREATE));
    }
}
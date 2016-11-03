/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllSubcontractorsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllSubcontractorsPanel.class.getName());
    public static ReadAllSubcontractorsPanel instance;

    public ReadAllSubcontractorsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Subcontractor", OfficeWelcome.constants);
    }

    public ReadAllSubcontractorsPanel() {
        instance = this;
        initTable("Subcontractor", OfficeWelcome.constants);
    }

    public ReadAllSubcontractorsPanel(JSONArray array) {
        instance = this;
        initTable("Subcontractor", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllSubcontractorPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                postFetchTable(result);
            }
        });
    }

    private String getReadAllSubcontractorPanelURL(Integer start, String tableSize) {
        return OfficeWelcome.constants.root_url() + "subcontractor/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        // table.setText(0, 2, getKeyValue("WebSite"));
        table.setText(0, 2, getKeyValue("MSA Exp Date"));
        table.setText(0, 3, getKeyValue("COI End Date"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "msaExpDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "coiEndDate")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeSubcontractorPanel(getEntity(entityId)));
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadSubcontractorPanel(entityId));
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

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "subcontractor/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Subcontractor Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new UpdateSubcontractorPanel(getEntity(entityId)));
        TabPanel.instance().adminPanel.sidePanelTop.clear();
        TabPanel.instance().adminPanel.sidePanelTop.add(new TreeSubcontractorPanel(getEntity(entityId)));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateSubcontractorPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            createButton.setText("Create Subcontractor");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }
}

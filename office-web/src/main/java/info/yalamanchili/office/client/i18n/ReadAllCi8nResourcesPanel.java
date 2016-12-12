/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.i18n;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllCi8nResourcesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCi8nResourcesPanel.class.getName());
    public static ReadAllCi8nResourcesPanel instance;

    public ReadAllCi8nResourcesPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Recources", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getResourcesUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });

    }

    public String getResourcesUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "i18n/bundle/resources/" + parentId + "/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Key"));
        table.setText(0, 2, getKeyValue("Value"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "key"));
            table.setText(i, 2, JSONUtils.toString(entity, "value"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new Readci18nResourcePanel(getEntity(entityId)));
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

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Resource Information");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllCi8nResourcesPanel(Ci18nBundleTreePanel.instance().getEntityId()));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new Readci18nResourcePanel(getEntity(entityId)));
    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "i18n/bundle/resource/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Resource");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.add(new Createi18nResourcePanel());
    }
}

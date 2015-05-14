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
public class ReadAllci18nResourceBundlesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllci18nResourceBundlesPanel.class.getName());
    public static ReadAllci18nResourceBundlesPanel instance;

    public ReadAllci18nResourceBundlesPanel() {
        instance = this;
        initTable("Recource Bundle", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getResourceBundlesUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });

    }

    public String getResourceBundlesUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "i18n/bundle/" + start.toString() + "/"
                + limit;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Language"));
        table.setText(0, 3, getKeyValue("Country"));
        table.setText(0, 4, getKeyValue("Variant"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            if (entity.get("resourceLocale") != null) {
                JSONObject locale = entity.get("resourceLocale").isObject();
                if (locale != null) {
                    table.setText(i, 2, JSONUtils.toString(locale, "language"));
                    table.setText(i, 3, JSONUtils.toString(locale, "country"));
                    table.setText(i, 4, JSONUtils.toString(locale, "variant"));
                }
            }
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.sidePanelTop.add(new Ci18nBundleTreePanel(entityId));

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
        new ResponseStatusWidget().show("Successfully Deleted Resource Bundle Information");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllci18nResourceBundlesPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new UpdateCi18nResourceBundlePanel(getEntity(entityId)));

    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.constants.root_url() + "i18n/bundle/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        createButton.setText("Create Resource Bundle");
        createButton.setVisible(true);
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
        TabPanel.instance().getChiliAdminPanel().entityPanel.add(new Createi18nResourceBundlePanel());
    }
}

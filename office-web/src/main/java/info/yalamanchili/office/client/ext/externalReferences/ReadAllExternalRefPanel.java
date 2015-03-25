/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.logging.Logger;

/**
 *
 * @author chaitanya.k
 */
public class ReadAllExternalRefPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCommentsPanel.class.getName());
    protected String targetClassName;
    private static ReadAllExternalRefPanel instance;

    public static ReadAllExternalRefPanel instance() {
        return instance;
    }

    public ReadAllExternalRefPanel() {
        instance = this;
        initTable("External Referance", OfficeWelcome.constants);
    }

    public ReadAllExternalRefPanel(String parentId, String targetClassName) {
        instance = this;
        this.parentId = parentId;
        this.targetClassName = targetClassName;
        initTable("External Referance", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(final int start) {
        HttpService.HttpServiceAsync.instance().doGet(getExternalRefsUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                true, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info(result);
                        postFetchTable(result);
                    }
                });
    }

    protected String getExternalRefsUrl(Integer start, String limit) {
        return OfficeWelcome.instance().constants.root_url() + "external-ref/" + start.toString() + "/" + limit;
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteUrl(entityId), "", OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                postDeleteSuccess();
            }
        });
    }

    protected String getDeleteUrl(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "external-ref/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllExternalRefPanel());
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("Source"));
        table.setText(0, 2, getKeyValue("External Id"));
        table.setText(0, 3, getKeyValue("Target Entity Name"));
        table.setText(0, 4, getKeyValue("Target Entity Id"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "source"));
            table.setText(i, 2, JSONUtils.toString(entity, "externalId"));
            table.setText(i, 3, JSONUtils.toString(entity, "targetEntityName"));
            table.setText(i, 4, JSONUtils.toString(entity, "targetEntityId"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateExternalReferencesPanel(parentId, targetClassName));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.isAdmin()) {
            createButton.setText("Create External Reference");
            createButton.setVisible(true);
        }
    }

}

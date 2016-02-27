/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadAllLCAPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllLCAPanel.class.getName());
    public static ReadAllLCAPanel instance;
    protected String url;

    public ReadAllLCAPanel() {
        instance = this;
        initTable("LCA", OfficeWelcome.constants);
    }

    public ReadAllLCAPanel(JSONArray array) {
        instance = this;
        initTable("LCA", array, OfficeWelcome.constants);
    }

    public ReadAllLCAPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("LCA", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        logger.info(getReadAllLCAsURL(start, OfficeWelcome.constants.tableSize()));
        HttpService.HttpServiceAsync.instance().doGet(getReadAllLCAsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                postFetchTable(result);
            }
        });
    }

    private String getReadAllLCAsURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "lca/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("LCA Number"));
        table.setText(0, 2, getKeyValue("Classification"));
        table.setText(0, 3, getKeyValue("LCA Valid From Date"));
        table.setText(0, 4, getKeyValue("LCA Valid To Date"));
        table.setText(0, 5, getKeyValue("LCA Filed Date"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "lcaNumber"));
            setEnumColumn(i, 2, entity, VisaClassificationType.class.getSimpleName(), "visaClassification");
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "lcaFiledDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 4, DateUtils.getFormatedDate(JSONUtils.toString(entity, "lcaValidFromDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 5, DateUtils.getFormatedDate(JSONUtils.toString(entity, "lcaValidToDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadLCAPanel(getEntity(entityId)));
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
        return OfficeWelcome.instance().constants.root_url() + "lca/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted LCA Information");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new UpdateLCAPanel(getEntity(entityId)));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createButton.setText("Add LCA");
            createButton.setVisible(true);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new CreateLCAPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }

    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        if (!id.isEmpty()) {
            new GenericPopup(new ReadLCAPanel(getEntity(id))).show();
        }
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }

}

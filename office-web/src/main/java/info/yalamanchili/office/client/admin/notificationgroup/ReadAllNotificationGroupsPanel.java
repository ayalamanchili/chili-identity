/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.notificationgroup;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
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
 * @author anuyalamanchili
 */
public class ReadAllNotificationGroupsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllNotificationGroupsPanel.class.getName());
    public static ReadAllNotificationGroupsPanel instance;

    public ReadAllNotificationGroupsPanel() {
        instance = this;
        initTable("NotificationGroup", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllNotificationGroupsURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    public String getReadAllNotificationGroupsURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "notification/groups/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
        }

    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin()) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadNotificationGroupPanel(getEntity(entityId)));
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
        return OfficeWelcome.instance().constants.root_url() + "notification/group/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Notification Group Information");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllNotificationGroupsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new UpdateNotificationGroupPanel(getEntity(entityId)));
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new CreateNotificationGroupPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.isAdmin() || Auth.isHR()) {
            createButton.setText("Create Notification Group");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }
}

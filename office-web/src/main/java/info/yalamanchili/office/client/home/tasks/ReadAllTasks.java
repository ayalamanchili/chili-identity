/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.EntityLayout;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllTasks extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTasks.class.getName());
    public static ReadAllTasks instance;
    protected String url;
    boolean openInPopup = false;
    public EntityLayout panel;

    public ReadAllTasks(String url, boolean openInPopup) {
        instance = this;
        this.url = url;
        this.openInPopup = openInPopup;
        initTable("Task", OfficeWelcome.constants);
    }

    public ReadAllTasks(String url, boolean openInPopup, EntityLayout panel) {
        instance = this;
        this.url = url;
        this.openInPopup = openInPopup;
        this.panel = panel;
        initTable("Task", OfficeWelcome.constants);
    }

    public ReadAllTasks() {
        instance = this;
        initTable("Task", OfficeWelcome.constants);
    }

    public ReadAllTasks(JSONArray array) {
        instance = this;
        initTable("Task", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTasksUrl(start, getPageSize().toString()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    @Override
    protected Integer getPageSize() {
        return 1000;
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Owner"));
        table.setText(0, 3, getKeyValue("Assignee"));
        table.setText(0, 4, getKeyValue("CreatedDate"));
    }

    @Override
    public void fillData(JSONArray entities) {
        logger.info(entities.toString());
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, JSONUtils.toString(entity, "owner"));
            table.setText(i, 3, JSONUtils.toString(entity, "assignee"));
            table.setText(i, 4, DateUtils.formatDate(JSONUtils.toString(entity, "createTime")));
            //TODO add due date
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    public String getReadAllTasksUrl(Integer start, String limit) {
        if (url != null) {
            return url + start.toString() + "/" + limit;
        } else {
            return OfficeWelcome.constants.root_url() + "bpm/tasks/currentuser/" + start.toString() + "/" + limit;
        }
    }

    @Override
    public void viewClicked(String entityId) {
        if (openInPopup) {
            new GenericPopup(new ReadTaskPanel(getEntity(entityId), false)).show();
            this.table.clear(true);
            return;
        }
        if (!openInPopup && panel != null) {
            this.tablePanel.clear();
            this.tablePanel.add(new ReadTaskPanel(getEntity(entityId), false, this.tablePanel));
        }
        TabPanel.instance().getHomePanel().entityPanel.clear();
        if (url != null && url.contains("history")) {
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadTaskPanel(getEntity(entityId), true));
        } else {
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadTaskPanel(getEntity(entityId), false));
        }
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    protected boolean enableQuickView() {
        return true;
    }

    @Override
    protected void onQuickView(int row, String id) {
        new GenericPopup(new ReadTaskPanel(getEntity(id), false)).show();
    }

    @Override
    protected boolean enablePersistedQuickView() {
        return true;
    }
}

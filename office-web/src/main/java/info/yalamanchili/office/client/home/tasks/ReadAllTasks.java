/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.tasks;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllTasks extends ReadAllTasksComposite {

    private static Logger logger = Logger.getLogger(ReadAllTasks.class.getName());
    public static ReadAllTasks instance;

    public ReadAllTasks(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Task", OfficeWelcome.constants);
    }

    public ReadAllTasks() {
        instance = this;
        initTable("Task", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTasksUrl(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info("dddd" + result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("Assignee"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TaskTableRowOptionsWidget.OptionsType.CLAIM_RESOLVE_COMPLETE, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void claimClicked(String entityId) {
    }

    @Override
    public void resolveClicked(String entityId) {
    }

    @Override
    public void completedClicked(String entityId) {
    }

    public String getReadAllTasksUrl(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "bpm/tasks/currentuser/" + start.toString() + "/" + limit.toString();
    }
}
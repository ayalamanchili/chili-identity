/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.CRUDReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadAllCommunicationActivityPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllCommunicationActivityPanel.class.getName());
    public static ReadAllCommunicationActivityPanel instance;

    public ReadAllCommunicationActivityPanel(String employeeId) {
        instance = this;
        this.parentId = employeeId;
        initTable("Activity", OfficeWelcome.constants);
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "communication_activity/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllPracticeURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    private String getReadAllPracticeURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "communication_activity/" + parentId + "/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Type"));
        table.setText(0, 2, getKeyValue("Mode"));
        table.setText(0, 3, getKeyValue("Subject"));
        table.setText(0, 4, getKeyValue("Notes"));
        table.setText(0, 5, getKeyValue("IssueType"));
        table.setText(0, 6, getKeyValue("AddedBy"));
        table.setText(0, 7, getKeyValue("Last Updated"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "type"));
            table.setText(i, 2, JSONUtils.toString(entity, "mode"));
            table.setText(i, 3, JSONUtils.toString(entity, "subject"));
            table.setText(i, 4, JSONUtils.toString(entity, "notes"));
            table.setText(i, 5, JSONUtils.toString(entity, "issueType"));
            table.setText(i, 6, JSONUtils.toString(entity, "createdBy"));
            table.setText(i, 7, DateUtils.getFormatedDate(JSONUtils.toString(entity, "updatedTimeStamp"), DateTimeFormat.PredefinedFormat.DATE_TIME_LONG));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
    }
}

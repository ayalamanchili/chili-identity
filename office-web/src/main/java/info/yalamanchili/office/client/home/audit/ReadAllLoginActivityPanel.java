/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.audit;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class ReadAllLoginActivityPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllLoginActivityPanel.class.getName());

    public ReadAllLoginActivityPanel() {
        initTable("LoginActivity", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadlAllLoginActivityURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("EmployeeID"));
        table.setText(0, 3, getKeyValue("TimeStamp"));
        table.setText(0, 4, getKeyValue("Login Count"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setHTML(i, 2, JSONUtils.toString(entity, "employeeId"));
            table.setText(i, 3, DateUtils.getFormatedDate(JSONUtils.toString(entity, "loginTimeStamp"), DateTimeFormat.PredefinedFormat.DATE_TIME_MEDIUM));
            table.setText(i, 4, JSONUtils.toString(entity, "loginCount"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
    }

    @Override
    public void deleteClicked(String entityId) {
    }

    @Override
    public void updateClicked(String entityId) {
    }

    private String getReadlAllLoginActivityURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "audit/resent_loginactivity/" + start.toString() + "/" + limit.toString();
    }

    @Override
    public void postDeleteSuccess() {
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheetperiod;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author bala
 */
public class ReadAllTimeSheetPeriodsPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTimeSheetPeriodsPanel.class.getName());
    public static ReadAllTimeSheetPeriodsPanel instance;

    public ReadAllTimeSheetPeriodsPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("TimeSheetPeriod", OfficeWelcome.constants);
    }

    public ReadAllTimeSheetPeriodsPanel() {
        instance = this;
        initTable("TimeSheetPeriod", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTimeSheetPeriodsPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
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
        table.setText(0, 2, getKeyValue("StartDate"));
        table.setText(0, 3, getKeyValue("EndDate"));
    }

    @Override
    public void fillData(JSONArray entities) {

        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity, "name"));
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
    }

    @Override
    public void viewClicked(String entityId) {
    }

    public String getReadAllTimeSheetPeriodsPanelURL(Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "timesheetperiod/" + start.toString() + "/" + limit.toString();
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
}

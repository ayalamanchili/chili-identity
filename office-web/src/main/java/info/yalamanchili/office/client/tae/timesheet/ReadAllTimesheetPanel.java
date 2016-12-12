/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.timesheet;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class ReadAllTimesheetPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllTimesheetPanel.class.getName());
    public static ReadAllTimesheetPanel instance;
    protected String timeSheetPeriodId = null;

    public ReadAllTimesheetPanel(String timeSheetPeriodId) {
        instance = this;
        this.timeSheetPeriodId = timeSheetPeriodId;
        initTable("Timesheet", OfficeWelcome.constants);
    }

    public ReadAllTimesheetPanel() {
        instance = this;
        initTable("Timesheet", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllTimesheetPanelURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });
    }

    public String getReadAllTimesheetPanelURL(Integer start, String limit) {
        if (timeSheetPeriodId != null) {
            return OfficeWelcome.constants.root_url() + "timesheet/payperiod/" + timeSheetPeriodId + "/" + start.toString() + "/" + limit.toString();
        } else {
            return OfficeWelcome.constants.root_url() + "timesheet/currentuser/" + start.toString() + "/" + limit.toString();
        }
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("ADPHours"));
        table.setText(0, 3, getKeyValue("QBHours"));
        table.setText(0, 4, getKeyValue("ADPRate"));
        table.setText(0, 5, getKeyValue("QBRate"));
        table.setText(0, 6, getKeyValue("StartDate"));
        table.setText(0, 7, getKeyValue("EndDate"));
        table.setText(0, 8, getKeyValue("PayPeriod"));
        table.setText(0, 9, getKeyValue("Status"));

    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            table.setText(i, 2, JSONUtils.toString(entity, "adpHours"));
            table.setText(i, 3, JSONUtils.toString(entity, "quickBooksHours"));
            table.setText(i, 4, JSONUtils.toString(entity, "adpRate"));
            table.setText(i, 5, JSONUtils.toString(entity, "quickBooksRate"));
            table.setText(i, 6, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 7, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            table.setText(i, 8, JSONUtils.toString(entity.get("timeSheetPeriod"), "name"));
            table.setText(i, 9, JSONUtils.toString(entity, "versionStatus"));

        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN)) {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(TableRowOptionsWidget.OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadTimeSheetPanel(entityId));
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
        return OfficeWelcome.instance().constants.root_url() + "timesheet/delete/" + entityId;
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllTimesheetPanel(timeSheetPeriodId));
    }

    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new UpdateTimesheetPanel(timeSheetPeriodId, getEntity(entityId)));
    }
}

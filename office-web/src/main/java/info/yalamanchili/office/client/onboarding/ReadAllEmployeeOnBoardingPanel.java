/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadAllEmployeeOnBoardingPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllEmployeeOnBoardingPanel.class.getName());
    public static ReadAllEmployeeOnBoardingPanel instance;
    protected String url;

    public ReadAllEmployeeOnBoardingPanel() {
        instance = this;
        initTable("OnBoarding", OfficeWelcome.constants);
    }

    public ReadAllEmployeeOnBoardingPanel(JSONArray array) {
        instance = this;
        initTable("OnBoarding", array, OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getReadAllExpenseReportURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(), false,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        logger.info("Info:" + result);
                        postFetchTable(result);
                    }
                });
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Name"));
        table.setText(0, 1, getKeyValue("StartDate"));
        table.setText(0, 2, getKeyValue("EmployeeType"));
        table.setText(0, 3, getKeyValue("Branch"));
        table.setText(0, 4, getKeyValue("Email"));
        table.setText(0, 5, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            JSONObject emp = (JSONObject) entity.get("employee");
            JSONObject empType = (JSONObject) emp.get("employeeType");
            table.setText(i, 0, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            table.setText(i, 1, DateUtils.getFormatedDate(JSONUtils.toString(entity, "startedDate"), DateTimeFormat.PredefinedFormat.DATE_MEDIUM));
            table.setText(i, 2, JSONUtils.toString(empType, "name"));
            table.setText(i, 3, JSONUtils.toString(emp, "branch"));
            table.setText(i, 4, JSONUtils.toString(entity, "email"));
            setEnumColumn(i, 5, entity, OnBoardingStatus.class.getSimpleName(), "status");

        }
    }

    private String getReadAllExpenseReportURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "on-board-employee/" + start.toString() + "/" + tableSize.toString();
    }

    @Override
    public void viewClicked(String entityId) {

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
    protected void addOptionsWidget(int row, JSONObject entity) {

    }

}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
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
        table.setText(0, 0, getKeyValue("Table Action"));
        table.setText(0, 1, getKeyValue("Name"));
        table.setText(0, 2, getKeyValue("StartDate"));
        table.setText(0, 3, getKeyValue("EmployeeType"));
        table.setText(0, 4, getKeyValue("Branch"));
        table.setText(0, 5, getKeyValue("Email"));
        table.setText(0, 6, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp;
            if (entity.containsKey("employee")) {
                emp = (JSONObject) entity.get("employee");
            } else {
                emp = new JSONObject();
            }
            JSONObject empType = (JSONObject) emp.get("employeeType");
            if (entity.containsKey("employee")) {
                table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
                table.setText(i, 3, JSONUtils.toString(empType, "name"));
            } else if (entity.containsKey("empName")) {
                String[] empDetails = entity.get("empName").isString().stringValue().split("-");
                table.setText(i, 1, empDetails[0]);
                table.setText(i, 3, empDetails[1]);
            }
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "startedDate")));
            table.setText(i, 4, JSONUtils.toString(emp, "branch"));
            table.setText(i, 5, JSONUtils.toString(entity, "email"));
            setEnumColumn(i, 6, entity, OnBoardingStatus.class.getSimpleName(), "status");
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
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeeOnboardingPanel(entityId));
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
        createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
    }

    @Override
    protected void configureCreateButton() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR, Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            createButton.setText("Create Employee Onboarding");
            createButton.setVisible(true);
        } else {
            createButton.setVisible(false);
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new InitiateOnBoardingPanel());
    }
}

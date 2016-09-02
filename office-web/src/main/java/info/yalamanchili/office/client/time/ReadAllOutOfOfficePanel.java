/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDReadAllComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.TableRowOptionsWidget;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class ReadAllOutOfOfficePanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllOutOfOfficePanel.class.getName());
    public static ReadAllOutOfOfficePanel instance;
    protected String url;
    JSONArray array = new JSONArray();
    boolean isOnCurrent = false;

    public ReadAllOutOfOfficePanel() {
        instance = this;
        initTable("Remote Work Requests", OfficeWelcome.constants2);
    }

    public ReadAllOutOfOfficePanel(String url) {
        instance = this;
        this.url = url;
        initTable("Remote Work Requests", OfficeWelcome.constants2);
    }

    public ReadAllOutOfOfficePanel(JSONArray result) {
        instance = this;
        initTable("Remote Work Requests", result, OfficeWelcome.constants2);
    }

    public ReadAllOutOfOfficePanel(String title, JSONArray array) {
        instance = this;
        isOnCurrent = true;
        initTable(title, array, OfficeWelcome.constants2);
    }
    protected boolean isEmployeesOnCurrentWeekPanel = false;

    public ReadAllOutOfOfficePanel(String title, JSONArray array, boolean isEmployeesOnCurrentWeekPanel) {
        instance = this;
        isOnCurrent = true;
        this.isEmployeesOnCurrentWeekPanel = isEmployeesOnCurrentWeekPanel;
        initTable(title, array, OfficeWelcome.constants2);
    }

    @Override
    public void viewClicked(String entityId) {
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadOutOfOfficePanel(entityId));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess(entityId);
                    }
                });
    }

    public void postDeleteSuccess(String entityId) {
        JSONObject entity = getEntity(entityId);
        if (entity.get("outOfOfficeType").isString().stringValue().equalsIgnoreCase("OUT_OF_OFFICE")) {
            new ResponseStatusWidget().show("Successfully Deleted Out Of Office Request Information");
        } else {
            new ResponseStatusWidget().show("Successfully Deleted Work From Home Request Information");
        }
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllOutOfOfficePanel());
        TabPanel.instance().timePanel.entityPanel.add(new CurrentWeekOutOfOfficeRequestsPanel());
    }

    @Override
    public void updateClicked(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(OfficeWelcome.constants.root_url() + "out-of-office/update-valid/" + entityId, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        TabPanel.instance().timePanel.entityPanel.clear();
                        TabPanel.instance().timePanel.entityPanel.add(new UpdateOutOfOfficePanel(entityId));
                    }
                });

    }

    @Override
    public void preFetchTable(int start) {
        HttpService.HttpServiceAsync.instance().doGet(getWorkFromCheckURL(start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String result) {
                        postFetchTable(result);
                    }
                });

    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Employee"));
        table.setText(0, 2, getKeyValue("Start Date"));
        table.setText(0, 3, getKeyValue("End Date"));
        table.setText(0, 4, getKeyValue("Type"));
        table.setText(0, 5, getKeyValue("Status"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            JSONObject emp = (JSONObject) entity.get("employee");
            if (emp != null) {
                table.setText(i, 1, JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName"));
            }
            table.setText(i, 2, DateUtils.formatDate(JSONUtils.toString(entity, "startDate")));
            table.setText(i, 3, DateUtils.formatDate(JSONUtils.toString(entity, "endDate")));
            setEnumColumn(i, 4, entity, OutOfOfficeType.class.getSimpleName(), "outOfOfficeType");
            setEnumColumn(i, 5, entity, OutOfOfficeRequestStatus.class.getSimpleName(), "status");
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        String status = JSONUtils.toString(entity, "status");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE, TableRowOptionsWidget.OptionsType.DELETE);
        } else if (status.equalsIgnoreCase(OutOfOfficeRequestStatus.Pending_Manager_Approval.name())) {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ, TableRowOptionsWidget.OptionsType.UPDATE);
        } else {
            createOptionsWidget(JSONUtils.toString(entity, "id"), row, TableRowOptionsWidget.OptionsType.READ);
        }
    }

    private String getWorkFromCheckURL(Integer start, String tableSize) {
        if (url != null) {
            return url;
        }
        return OfficeWelcome.constants.root_url() + "out-of-office/" + start.toString() + "/" + tableSize.toString();
    }

    private String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "out-of-office/delete/" + entityId;
    }

    @Override
    protected void configureCreateButton() {
        if (isOnCurrent != true) {
            createButton.setText("Create Remote Work Request");
        } else {
            createButton.removeFromParent();
        }
    }

    @Override
    protected void createButtonClicked() {
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.add(new CreateOutOffOfficeRequestPanel(CreateComposite.CreateCompositeType.CREATE));
    }

    @Override
    public void postDeleteSuccess() {
    }
}

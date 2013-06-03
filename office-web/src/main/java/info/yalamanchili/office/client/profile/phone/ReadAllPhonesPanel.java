/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.phone;

import info.chili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.gwt.CRUDReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.widgets.ResponseStatusWidget;

public class ReadAllPhonesPanel extends CRUDReadAllComposite {

    private static Logger logger = Logger.getLogger(ReadAllPhonesPanel.class.getName());
    public static ReadAllPhonesPanel instance;

    public ReadAllPhonesPanel(String parentId) {
        instance = this;
        this.parentId = parentId;
        initTable("Phone", OfficeWelcome.constants);
    }

    @Override
    public void preFetchTable(int start) {
        HttpServiceAsync.instance().doGet(getEmployeePhonesURL(parentId, start, OfficeWelcome.constants.tableSize()), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                postFetchTable(result);
            }
        });

    }

    public String getEmployeePhonesURL(String employeeId, Integer start, String limit) {
        return OfficeWelcome.constants.root_url() + "employee/phones/" + employeeId + "/" + start.toString() + "/"
                + limit.toString();
    }

    @Override
    public void createTableHeader() {
        table.setText(0, 0, getKeyValue("Table_Action"));
        table.setText(0, 1, getKeyValue("Type"));
        table.setText(0, 2, getKeyValue("PhoneNumber"));
        table.setText(0, 3, getKeyValue("extension"));
        table.setText(0, 4, getKeyValue("countryCode"));
    }

    @Override
    public void fillData(JSONArray entities) {
        for (int i = 1; i <= entities.size(); i++) {
            JSONObject entity = (JSONObject) entities.get(i - 1);
            addOptionsWidget(i, entity);
            table.setText(i, 1, JSONUtils.toString(entity.get("phoneType"), "phoneType"));
            table.setText(i, 2, JSONUtils.toString(entity, "phoneNumber"));
            table.setText(i, 3, JSONUtils.toString(entity, "extension"));
            table.setText(i, 4, JSONUtils.toString(entity, "countryCode"));
        }
    }

    @Override
    protected void addOptionsWidget(int row, JSONObject entity) {
        if (Auth.isAdmin() || Auth.isHR()) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        } else {
            createOptionsWidget(OptionsType.READ, row, JSONUtils.toString(entity, "id"));
        }
    }

    @Override
    public void viewClicked(String entityId) {
        // TODO Auto-generated method stub
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadPhonePanel(getEntity(entityId)));
    }

    @Override
    public void deleteClicked(String entityId) {
        HttpServiceAsync.instance().doPut(getDeleteURL(entityId), null, OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        postDeleteSuccess();
                    }
                });
    }

    @Override
    public void postDeleteSuccess() {
        new ResponseStatusWidget().show("Successfully Deleted Phone Contact Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());

    }

    // TODO Auto-generated method stub
    @Override
    public void updateClicked(String entityId) {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdatePhonePanel(getEntity(entityId)));

    }

    protected String getDeleteURL(String entityId) {
        return OfficeWelcome.instance().constants.root_url() + "phone/delete/" + entityId;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.notificationgroup;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class UpdateNotificationGroupPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateNotificationGroupPanel.class.getName());
    protected MultiSelectEmployeeWidget employeeSelectWidget;

    public UpdateNotificationGroupPanel(JSONObject entity) {
        logger.info(entity.toString());
        initUpdateComposite(entity, "NotificationGroup", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        JSONArray employees = new JSONArray();
        int i = 0;
        for (String empId : employeeSelectWidget.getMultiSelectBox().getAllSelectedIds()) {
            JSONObject emp = new JSONObject();
            emp.put("id", new JSONString(empId));
            employees.set(i, emp);
            i++;
        }
        entity.put("employees", employees);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Notification Group");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllNotificationGroupsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        employeeSelectWidget = new MultiSelectEmployeeWidget("Employees", getEntityId(), false, false);
        addField("name", false, true, DataType.STRING_FIELD);
        entityFieldsPanel.add(employeeSelectWidget);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "notification/group/save";
    }
}

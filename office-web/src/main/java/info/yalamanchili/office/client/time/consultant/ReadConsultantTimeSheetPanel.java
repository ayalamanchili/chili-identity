/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectConsultantEmployeeWidget;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;

/**
 *
 * @author prasanthi.p
 */
public class ReadConsultantTimeSheetPanel extends ReadComposite {

    private static ReadConsultantTimeSheetPanel instance;

    public static ReadConsultantTimeSheetPanel instance() {
        return instance;
    }

    public ReadConsultantTimeSheetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "EmployeeTimeSheet", OfficeWelcome.constants);
    }

    public ReadConsultantTimeSheetPanel(String id) {
        initReadComposite(id, "EmployeeTimeSheet", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.time.ConsultantTimeSheet"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("createdTimeStamp", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectConsultantEmployeeWidget(true, false));
        addEnumField("category", true, false, TimeSheetCategory.names());
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addEnumField("status", true, false, TimeSheetStatus.names());
        addField("hours", true, false, DataType.FLOAT_FIELD);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD);
        addField("approvedBy", true, false, DataType.STRING_FIELD);
        addField("createdTimeStamp", true, false, DataType.DATE_FIELD);
        addField("approvedDate", true, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "consultant-timesheet/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION);
    }
     @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION,Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN,Auth.ROLE.ROLE_HR);
    }
    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.time.ConsultantTimeSheet" + "/" + getEntityId();
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllConsultantTimeSheetsPanel.instance;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import info.yalamanchili.office.client.time.TimeSheetStatus;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;

/**
 *
 * @author prasanthi.p
 */
public class ReadCorporateTimeSheetPanel extends ReadComposite {

    private static ReadCorporateTimeSheetPanel instance;

    public static ReadCorporateTimeSheetPanel instance() {
        return instance;
    }

    public ReadCorporateTimeSheetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "CorporateTimeSheet", OfficeWelcome.constants);
    }

    public ReadCorporateTimeSheetPanel(String id) {
        initReadComposite(id, "CorporateTimeSheet", OfficeWelcome.constants);
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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.time.CorporateTimeSheet"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectCorpEmployeeWidget(true, false));
        addEnumField("category", true, false, TimeSheetCategory.names());
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        addEnumField("status", true, false, TimeSheetStatus.names());
        addField("hours", true, false, DataType.FLOAT_FIELD);
        addField("approvedBy", true, false, DataType.STRING_FIELD);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "corporate-timesheet/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return true;
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CORPORATE_TIME_ADMIN,Auth.ROLE.ROLE_CORPORATE_TIME_REPORTS);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.time.CorporateTimeSheet" + "/" + getEntityId();
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllCorporateTimeSheetPanel.instance;
    }
}

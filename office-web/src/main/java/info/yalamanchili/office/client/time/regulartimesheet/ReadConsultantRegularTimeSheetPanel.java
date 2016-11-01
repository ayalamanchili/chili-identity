/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.regulartimesheet;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectConsultantEmployeeWidget;
import info.yalamanchili.office.client.time.TimeSheetStatus;

/**
 *
 * @author prasanthi.p
 */
public class ReadConsultantRegularTimeSheetPanel extends ReadComposite {

    private static ReadConsultantRegularTimeSheetPanel instance;

    public static ReadConsultantRegularTimeSheetPanel instance() {
        return instance;
    }

    public ReadConsultantRegularTimeSheetPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "RegularTimeSheet", OfficeWelcome.constants2);
    }

    public ReadConsultantRegularTimeSheetPanel(String id) {
        initReadComposite(id, "RegularTimeSheet", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateTimeSheets();
                        populateComments();

                    }
                });
    }

    protected void populateTimeSheets() {
        OfficeWelcome.logger.info("populate time sheets");
        HttpService.HttpServiceAsync.instance().doGet(getRegualrTimeSheetsUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        OfficeWelcome.logger.info("response is .... " + response);
                        if (!response.trim().toString().equals("null")) {
                            JSONArray docs = JSONUtils.toJSONArray(JSONParser.parseLenient(response).isObject().get("timeSheetFile"));
                            entityFieldsPanel.add(new ReadAllTimeSheetsPanel(getEntityId(), docs));
                        }
                    }
                });
    }

    protected String getRegualrTimeSheetsUrl() {
        return OfficeWelcome.constants.root_url() + "timesheet-file/time-sheets/" + getEntityId();
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.time.ConsultantTimeSheet"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("createdTimeStamp", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        //populateTimeSheets();
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
        return OfficeWelcome.constants.root_url() + "regular-timesheet/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION);
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN, Auth.ROLE.ROLE_HR);
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
}

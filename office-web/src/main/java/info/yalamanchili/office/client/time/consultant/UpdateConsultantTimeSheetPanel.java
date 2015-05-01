/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectConsultantEmployeeWidget;
import info.yalamanchili.office.client.time.TimeSheetCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateConsultantTimeSheetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateConsultantTimeSheetPanel.class.getName());
    SelectConsultantEmployeeWidget employeeF = new SelectConsultantEmployeeWidget(true, true);

    public UpdateConsultantTimeSheetPanel(JSONObject entity) {
        initUpdateComposite(entity, "EmployeeTimeSheet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("employee", employeeF.getSelectedObject());
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("status", entity);
        assignEntityValueFromField("notes", entity);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONSULTANT_TIME_REPORTS, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP)) {
            assignEntityValueFromField("approvedBy", entity);
            assignEntityValueFromField("createdTimeStamp", entity);
            assignEntityValueFromField("approvedDate", entity);
        }
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
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("category", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONSULTANT_TIME_REPORTS, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("approvedBy", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("createdTimeStamp", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("approvedDate", entity, DataType.DATE_FIELD);
        }
        employeeF.getListBox().setEnabled(false);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Consultant Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel(employeeF.getSelectedObjectId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", employeeF);
        addEnumField("category", false, true, TimeSheetCategory.names());
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addEnumField("status", false, true, TimeSheetStatus.names());
        addField("notes", false, true, DataType.TEXT_AREA_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_CONSULTANT_TIME_REPORTS, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP)) {
            addField("approvedBy", false, true, DataType.STRING_FIELD);
            addField("createdTimeStamp", false, true, DataType.DATE_FIELD);
            addField("approvedDate", false, true, DataType.DATE_FIELD);
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
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
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "consultant-timesheet";
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "timesheets/employee-leave-request.html";
    }
}

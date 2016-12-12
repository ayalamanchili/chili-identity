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
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateCorporateTimeSheetPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateCorporateTimeSheetPanel.class.getName());
    SelectCorpEmployeeWidget employeeF = new SelectCorpEmployeeWidget(true, true);
    protected String status = null;
    protected String newCategory = null;
    protected String oldCategory = null;

    public UpdateCorporateTimeSheetPanel(JSONObject entity) {
        logger.info("entity is .... " + entity);
        JSONValue get = entity.get("status");
        this.oldCategory = entity.get("category").isString().stringValue();
        initUpdateComposite(entity, "CorporateTimeSheet", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("employee", employeeF.getSelectedObject());
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("status", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("notes", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        this.newCategory = entity.get("category").isString().stringValue();
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
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hours", entity, DataType.FLOAT_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        employeeF.getListBox().setEnabled(false);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Corporate Time Sheet Information");
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel(employeeF.getSelectedObjectId()));
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel(employeeF.getSelectedObjectId()));
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
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_BULK_IMPORT)) && (entity.get("status").isString().stringValue().equals("Pending"))) {
            addEnumField("category", false, true, TimeSheetCategory.names());
        } else {
            addEnumField("category", true, true, TimeSheetCategory.names());
        }
        addEnumField("status", false, true, TimeSheetStatus.names());
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        FloatField hourF = (FloatField) fields.get("hours");
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        if (hourF.getFloat() != null && hourF.getFloat() % 4 != 0) {
            hourF.setMessage("Leave request can only be applied for half or full days");
            return false;
        }
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CORPORATE_TIME_ADMIN, Auth.ROLE.ROLE_CORPORATE_TIME_REPORTS);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getURI() {
        if (newCategory.equals(oldCategory)) {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet";
        } else {
            return OfficeWelcome.constants.root_url() + "corporate-timesheet/category-leave-update-request";
        }
    }
}

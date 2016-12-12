/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.consultant;

import com.google.common.base.Strings;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.time.LeaveRequestTimeCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ConsultantEmpLeaveRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(ConsultantEmpLeaveRequestPanel.class.getName());

    public ConsultantEmpLeaveRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("EmpLeaveRequest", OfficeWelcome.constants);
    }

    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false, Alignment.HORIZONTAL);

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("createdTimeStamp", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("notes", entity);
        entity.put("status", new JSONString(TimeSheetStatus.Pending.name()));
        if (fields.containsKey("employee")) {
            assignEntityValueFromField("employee", entity);
        } else {
            entity.put("employee", new JSONObject());
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Request Submited, please wait for email notification within 48 hours");
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.add(new ConsultantTimeSummarySidePanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ConsultantTimeSummaryPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllConsultantTimeSheetsPanel());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentConsultantLeavesPanel());
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    logger.info(entityString);
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        employeeSB.loadData(values);
                    }
                }
            });
        }
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN)) {
            addSuggestField("employee", employeeSB);
        }
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hours", false, true, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        addEnumField("category", false, true, LeaveRequestTimeCategory.names(), Alignment.HORIZONTAL);
        addField("createdTimeStamp", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Employee";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        TextAreaField notesF = (TextAreaField) fields.get("notes");
        if (Strings.isNullOrEmpty(notesF.getValue())) {
            notesF.setMessage("Please enter notes");
            return false;
        }
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "consultant-timesheet/submit-leave-request";
    }
}

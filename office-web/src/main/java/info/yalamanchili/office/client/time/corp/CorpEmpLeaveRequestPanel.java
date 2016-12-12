/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time.corp;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import info.yalamanchili.office.client.time.LeaveRequestTimeCategory;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import info.yalamanchili.office.client.time.LeaveRequestAdminTimeCategory;
import info.yalamanchili.office.client.time.TimeSheetStatus;
import info.yalamanchili.office.client.time.consultant.ReadCurrentConsultantLeavesPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CorpEmpLeaveRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CorpEmpLeaveRequestPanel.class.getName());

    public CorpEmpLeaveRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("CorpEmpLeaveRequest", OfficeWelcome.constants);
    }
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, false, Alignment.HORIZONTAL);

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("notes", entity);
        entity.put("status", new JSONString(TimeSheetStatus.Pending.name()));
        if (fields.containsKey("employee")) {
            assignEntityValueFromField("employee", entity);
        } else {
            entity.put("employee", new JSONObject());
        }
        JSONArray notifyEmployeesList = employeesMSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            entity.put("notifyEmployees", notifyEmployeesList);
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
        TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentCorpLeavesPanel());
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
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CORPORATE_TIME_ADMIN)) {
            HttpService.HttpServiceAsync.instance().doGet(getIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
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
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CORPORATE_TIME_ADMIN)) {
            addSuggestField("employee", employeeSB);
        }
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("hours", false, true, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CORPORATE_TIME_ADMIN)) {
            addEnumField("category", false, true, LeaveRequestAdminTimeCategory.names(), Alignment.HORIZONTAL);
        } else {
            addEnumField("category", false, true, LeaveRequestTimeCategory.names(), Alignment.HORIZONTAL);
        }
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add team members to be notified"));
        entityFieldsPanel.add(employeesMSB);
        alignFields();
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
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "corporate-timesheet/submit-leave-request";
    }
    MultiSelectSuggestBox employeesMSB = new MultiSelectSuggestBox() {
        @Override
        public void initTosSuggesBox() {
            HttpService.HttpServiceAsync.instance().doGet(getEmployeeIdsDropDownUrl(), OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String entityString) {
                    logger.info(entityString);
                    Map<String, String> values = JSONUtils.convertKeyValueStringPairs(entityString);
                    if (values != null) {
                        suggestionsBox.loadData(values);
                    }
                }
            });
        }
    };

    protected String getIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=id&column=firstName&column=lastName&employee-type=Corporate Employee";
    }

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=employeeId&column=firstName&column=lastName&employee-type=Corporate Employee";
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "timesheets/submit-leave-request.html";
    }
}

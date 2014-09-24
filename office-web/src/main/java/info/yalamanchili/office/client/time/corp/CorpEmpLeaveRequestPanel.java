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
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import info.yalamanchili.office.client.time.TimeSheetStatus;
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

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("hours", entity);
        assignEntityValueFromField("category", entity);
        assignEntityValueFromField("notes", entity);
        entity.put("status", new JSONString(TimeSheetStatus.Pending.name()));
        entity.put("employee", new JSONObject());
        JSONArray notifyEmployeesList = employeesSB.getValues();
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
        GenericPopup.instance().hide();
        TabPanel.instance().getTimePanel().entityPanel.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.clear();
        TabPanel.instance().getTimePanel().sidePanelTop.add(new CorporateTimeSummarySidePanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new CorporateTimeSummaryPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadAllCorporateTimeSheetPanel());
        TabPanel.instance().getTimePanel().entityPanel.add(new ReadCurrentCorpLeavesPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgets() {
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, true, DataType.DATE_FIELD);
        addField("hours", false, true, DataType.FLOAT_FIELD);
        addEnumField("category", false, true, LeaveRequestTimeCategory.names());
        addField("notes", false, false, DataType.TEXT_AREA_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Add team members to be notified"));
        entityFieldsPanel.add(employeesSB);
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
        if (hourF.getFloat() != null || hourF.getFloat() % 4 == 0) {
            hourF.setMessage("Check if the intiger is multiple of 4");
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
    MultiSelectSuggestBox employeesSB = new MultiSelectSuggestBox() {
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

    protected String getEmployeeIdsDropDownUrl() {
        return URL.encode(OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=employeeId&column=firstName&column=lastName&employee-type=Corporate Employee");
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

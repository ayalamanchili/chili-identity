/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.time;

import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class CreateOutOffOfficeRequestPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateOutOffOfficeRequestPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();

    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "employee", "Employee", false, true, Alignment.HORIZONTAL);
    HTML tacHelpText = new HTML("<p>Please provide the details of your request in the fields below.</p>\n"
            + "<p>For example, if you are requesting to work from home for part of a work day, please indicate the time and date for which you are requesting to do so (i.e. 10:00 am &ndash; 2:00 pm on 7/22/2016).</p>\n"
            + "<p>If your request is recurring, please enter the times and days for which you are requesting to work from home, and, if applicable, the duration of your request (i.e. 8:30 am &ndash; 12:00 pm every Monday, Wednesday, and Friday beginning 7/22/2016 until 8/30/2016.</p>");

    public CreateOutOffOfficeRequestPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("OutOfOfficeRequest", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject outOfOffice = new JSONObject();
        assignEntityValueFromField("outOfOfficeType", outOfOffice);
        assignEntityValueFromField("startDate", outOfOffice);
        assignEntityValueFromField("endDate", outOfOffice);
        assignEntityValueFromField("time", outOfOffice);
        assignEntityValueFromField("recurring", outOfOffice);
        assignEntityValueFromField("reason", outOfOffice);
        assignEntityValueFromField("notes", outOfOffice);
        JSONArray notifyEmployeesList = employeesMSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            outOfOffice.put("notifyEmployees", notifyEmployeesList);
        }
        return outOfOffice;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
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
        if (entity.get("outOfOfficeType").isString().stringValue().equalsIgnoreCase("OUT_OF_OFFICE")) {
            new ResponseStatusWidget().show("Out Of Office Request Submitted Successfully");
        } else {
            new ResponseStatusWidget().show("Work From Home Request Submitted Successfully");
        }
        TabPanel.instance().timePanel.entityPanel.clear();
        TabPanel.instance().timePanel.entityPanel.add(new ReadAllOutOfOfficePanel());
        TabPanel.instance().timePanel.entityPanel.add(new CurrentWeekOutOfOfficeRequestsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
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

    protected String getIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-role/dropdown/" + Auth.ROLE.ROLE_USER.name() + "/0/10000";
    }

    @Override
    protected void addWidgets() {
        //addSuggestField("employee", employeeSB);
        addEnumField("outOfOfficeType", false, true, OutOfOfficeType.names(), Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("recurring", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(tacHelpText);
        addField("time", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("reason", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add members to be notified"));
        entityFieldsPanel.add(employeesMSB);
        alignFields();
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

    protected String getEmployeeIdsDropDownUrl() {
        return OfficeWelcome.constants.root_url() + "employee/employees-by-type/dropdown/0/10000?column=employeeId&column=firstName&column=lastName&employee-type=Corporate Employee";
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField startDateF = (DateField) fields.get("startDate");
        DateField endDateF = (DateField) fields.get("endDate");
        if (startDateF.getDate() != null && endDateF.getDate() != null && startDateF.getDate().after(endDateF.getDate())) {
            endDateF.setMessage("End Date must be equal to or after Start Date");
            return false;
        }
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/submit-request";
    }

}

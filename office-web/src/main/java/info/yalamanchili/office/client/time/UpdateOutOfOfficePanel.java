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
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.MultiSelectSuggestBox;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Ramana.Lukalapu
 */
public class UpdateOutOfOfficePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateOutOfOfficePanel.class.getName());
    protected FlowPanel panel = new FlowPanel();

    HTML tacHelpText = new HTML("<h4 style=\"color:#888\">" + "If You Work For Partital or If you need recurring please enter the details in below field.. for Eg: for partial work you have to enter something like 05/08/2016 10 am to 1 pm.. for Recurring you have to mention like every wed,tue 9am to 4pm</h4>");

    public UpdateOutOfOfficePanel(String entityId) {
        initUpdateComposite(entityId, "OutOfOfficeRequest", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("outOfOfficeType", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("time", entity);
        assignEntityValueFromField("recurring", entity);
        assignEntityValueFromField("reason", entity);
        assignEntityValueFromField("notes", entity);
        JSONArray notifyEmployeesList = employeesMSB.getValues();
        if (notifyEmployeesList.size() > 0) {
            entity.put("notifyEmployees", notifyEmployeesList);
        }
        logger.info(entity.toString());
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
    public void populateFieldsFromEntity(JSONObject outOfOffice) {
        assignFieldValueFromEntity("outOfOfficeType", outOfOffice, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", outOfOffice, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", outOfOffice, DataType.DATE_FIELD);
        assignFieldValueFromEntity("recurring", outOfOffice, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("reason", outOfOffice, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("notes", outOfOffice, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("time", outOfOffice, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        if (entity.get("outOfOfficeType").isString().stringValue().equalsIgnoreCase("OUT_OF_OFFICE")) {
            new ResponseStatusWidget().show("Out Of Office Request Updated Successfully");
        } else {
            new ResponseStatusWidget().show("Work From Home Request Updated Successfully");
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
    }

    @Override
    protected void addWidgets() {
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
    protected void addWidgetsBeforeCaptionPanel() {
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
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/update-request";
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "out-of-office/" + getEntityId();
    }

}

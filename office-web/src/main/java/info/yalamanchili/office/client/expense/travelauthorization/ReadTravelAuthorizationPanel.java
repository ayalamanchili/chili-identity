/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadTravelAuthorizationPanel extends ReadComposite {

    private static ReadTravelAuthorizationPanel instance;
    private static Logger logger = Logger.getLogger(ReadTravelAuthorizationPanel.class.getName());
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true, Alignment.HORIZONTAL);
    protected static HTML tripInfoHelpText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Trip Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML estimatedExpensesHelpText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222)\">"
            + "<strong style=\"color:#555555\">Estimated Expenses</strong></p>\n"
            + "\n");
    HTML tacHelpText = new HTML("<h4 style=\"color:#888\">" + "Estimate all expenses to be incurred and indicate method of payment.</h4>");
    HTML transportation = new HTML("<h4 style=\"color:#427fed\">" + "Transportation</h4>");
    HTML lodging = new HTML("<h4 style=\"color:#427fed\">  " + "Accommodation</h4>");
    HTML meals = new HTML("<h4 style=\"color:#427fed\"> " + "Food</h4>");

    public static ReadTravelAuthorizationPanel instance() {
        return instance;
    }

    public ReadTravelAuthorizationPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "TravelAuthorization", OfficeWelcome.constants);
        populateComments();
    }
     public ReadTravelAuthorizationPanel(String id) {
        instance = this;
        initReadComposite(id, "TravelAuthorization", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                });
    }

    protected final void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EMPLOYEE, entity, null);
        assignFieldValueFromEntity(TRAVEL_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DEPARTURE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(RETURN_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(TRAVEL_ORIGIN, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(TRAVEL_DESTINATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(REASON_FOR_TRAVEL, entity, DataType.STRING_FIELD);
        entityFieldsPanel.add(transportation);
        if (entity.get(TRAVEL_TRANSPORTATION) != null) {
            entityFieldsPanel.add(new TravelTransportationPanel(entity.get(TRAVEL_TRANSPORTATION).isObject(), true));
        }
        entityFieldsPanel.add(lodging);
        if (entity.get(TRAVEL_ACCOMMODATION) != null) {
            entityFieldsPanel.add(new TravelAccommodationPanel(entity.get(TRAVEL_ACCOMMODATION).isObject(), true));
        }
        entityFieldsPanel.add(meals);
        if (entity.get(TRAVEL_FOOD) != null) {
            entityFieldsPanel.add(new TravelFoodPanel(entity.get(TRAVEL_FOOD).isObject(), true));
        }
        assignFieldValueFromEntity(TOTAL_ESTIMATED_TRIP_EXPENCES, entity, DataType.CURRENCY_FIELD);
        alignFields(DEFAULT_FIELD_WIDTH);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown(EMPLOYEE, selectEmployeeWidgetF);
        addEnumField(TRAVEL_TYPE, true, false, TravelType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(tripInfoHelpText);
        addField(DEPARTURE_DATE, true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField(RETURN_DATE, true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField(TRAVEL_ORIGIN, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(TRAVEL_DESTINATION, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(REASON_FOR_TRAVEL, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(estimatedExpensesHelpText);
        entityFieldsPanel.add(tacHelpText);
        addField(TOTAL_ESTIMATED_TRIP_EXPENCES, true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        alignFields(DEFAULT_FIELD_WIDTH);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ACCOUNTS_PAYABLE, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization" + "/" + getEntityId();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travel-authorization/" + entityId;
    }
    
    @Override
    protected boolean enableBack() {
       return true;
    }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllTravelAuthorizationPanel.instance;
    }
}

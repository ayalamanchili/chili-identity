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
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
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
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Trip Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML estimatedExpensesHelpText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238)\">"
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
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(EMPLOYEE, entity, null);
        assignFieldValueFromEntity(TRAVEL_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DEPARTURE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(RETURN_DATE, entity, DataType.DATE_FIELD);
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
        addField(TRAVEL_DESTINATION, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(REASON_FOR_TRAVEL, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(estimatedExpensesHelpText);
        entityFieldsPanel.add(tacHelpText);
        alignFields(DEFAULT_FIELD_WIDTH);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travel-authorization/" + entityId;
    }
}

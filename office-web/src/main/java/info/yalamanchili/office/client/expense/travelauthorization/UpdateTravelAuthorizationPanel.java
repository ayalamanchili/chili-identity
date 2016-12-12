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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import static info.yalamanchili.office.client.expense.travelauthorization.UpdateTravelAuthorizationPanel.tripInfoHelpText;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateTravelAuthorizationPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTravelAuthorizationPanel.class.getName());
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
    HTML emptyLine = new HTML("<br/>");
    TravelTransportationPanel travelTransportationItem = new TravelTransportationPanel(false);
    TravelAccommodationPanel lodgingItemPanel = new TravelAccommodationPanel(false);
    TravelFoodPanel mealsItemPanel = new TravelFoodPanel(false);

    public UpdateTravelAuthorizationPanel(String entityId) {
        initUpdateComposite(entityId, "TravelAuthorization", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "travel-authorization/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField(TRAVEL_TYPE, entity);
        assignEntityValueFromField(DEPARTURE_DATE, entity);
        assignEntityValueFromField(RETURN_DATE, entity);
        assignEntityValueFromField(TRAVEL_ORIGIN, entity);
        assignEntityValueFromField(TRAVEL_DESTINATION, entity);
        assignEntityValueFromField(REASON_FOR_TRAVEL, entity);
        entity.put(TRAVEL_TRANSPORTATION, travelTransportationItem.getObject());
        entity.put(TRAVEL_ACCOMMODATION, lodgingItemPanel.getObject());
        entity.put(TRAVEL_FOOD, mealsItemPanel.getObject());
        entity.put(TOTAL_ESTIMATED_TRIP_EXPENCES, new JSONString((calculateTotalCost(travelTransportationItem, lodgingItemPanel, mealsItemPanel)).abs().toString()));
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
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info(entity.toString());
        assignFieldValueFromEntity(TRAVEL_TYPE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DEPARTURE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(RETURN_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(TRAVEL_ORIGIN, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(TRAVEL_DESTINATION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(REASON_FOR_TRAVEL, entity, DataType.TEXT_AREA_FIELD);
        if (entity.get(TRAVEL_TRANSPORTATION) != null) {
            travelTransportationItem = new TravelTransportationPanel(entity.get(TRAVEL_TRANSPORTATION).isObject(), false);
            entityFieldsPanel.add(travelTransportationItem);
        }
        entityFieldsPanel.add(lodging);
        if (entity.get(TRAVEL_ACCOMMODATION) != null) {
            lodgingItemPanel = new TravelAccommodationPanel(entity.get(TRAVEL_ACCOMMODATION).isObject(), false);
            entityFieldsPanel.add(lodgingItemPanel);
        }
        entityFieldsPanel.add(meals);
        if (entity.get(TRAVEL_FOOD) != null) {
            mealsItemPanel = new TravelFoodPanel(entity.get(TRAVEL_FOOD).isObject(), false);
            entityFieldsPanel.add(mealsItemPanel);
        }
        populateComments();
    }

    protected BigDecimal calculateTotalCost(TravelTransportationPanel transportation, TravelAccommodationPanel lodging, TravelFoodPanel meals) {
        BigDecimal totalEstimatedTripExpences = BigDecimal.ZERO;
        if (transportation.totalTransportationCost.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(transportation.totalTransportationCost.getCurrency());
        }
        if (lodging.totalLodgingCost.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(lodging.totalLodgingCost.getCurrency());
        }
        if (meals.totalCostOfFood.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(meals.totalCostOfFood.getCurrency());
        }
        if (meals.totalCostOfBanquet.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(meals.totalCostOfBanquet.getCurrency());
        }
        if (meals.conferenceFee.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(meals.conferenceFee.getCurrency());
        }
        if (meals.otherExpences.getCurrency() != null) {
            totalEstimatedTripExpences = totalEstimatedTripExpences.add(meals.otherExpences.getCurrency());
        }
        return totalEstimatedTripExpences;
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Travel Authorization Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTravelAuthorizationPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    protected final void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.travelauthorization.TravelAuthorization"));
    }

    @Override
    protected void addWidgets() {
        addEnumField(TRAVEL_TYPE, false, true, TravelType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(tripInfoHelpText);
        addField(DEPARTURE_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField(RETURN_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField(TRAVEL_ORIGIN, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(TRAVEL_DESTINATION, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField(REASON_FOR_TRAVEL, false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(estimatedExpensesHelpText);
        entityFieldsPanel.add(tacHelpText);
        entityFieldsPanel.add(transportation);
        alignFields(DEFAULT_FIELD_WIDTH);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travel-authorization/";
    }
}

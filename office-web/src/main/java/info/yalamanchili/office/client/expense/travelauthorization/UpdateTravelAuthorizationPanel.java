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
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.DEFAULT_FIELD_WIDTH;
import static info.yalamanchili.office.client.expense.travelauthorization.UpdateTravelAuthorizationPanel.tripInfoHelpText;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateTravelAuthorizationPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTravelAuthorizationPanel.class.getName());
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
        assignEntityValueFromField("travelType", entity);
        assignEntityValueFromField("departureDate", entity);
        assignEntityValueFromField("returnDate", entity);
        assignEntityValueFromField("travelDestination", entity);
        assignEntityValueFromField("reasonForTravel", entity);
        entity.put("travelTransportation", travelTransportationItem.getObject());
        entity.put("travelAccommodation", lodgingItemPanel.getObject());
        entity.put("travelFood", mealsItemPanel.getObject());
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
        assignFieldValueFromEntity("travelType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("departureDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("returnDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("travelDestination", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("reasonForTravel", entity, DataType.TEXT_AREA_FIELD);
        if (entity.get("travelTransportation") != null) {
            travelTransportationItem = new TravelTransportationPanel(entity.get("travelTransportation").isObject(), false);
            entityFieldsPanel.add(travelTransportationItem);
        }
        entityFieldsPanel.add(lodging);
        if (entity.get("travelAccommodation") != null) {
            lodgingItemPanel = new TravelAccommodationPanel(entity.get("travelAccommodation").isObject(), false);
            entityFieldsPanel.add(lodgingItemPanel);
        }
        entityFieldsPanel.add(meals);
        if (entity.get("travelFood") != null) {
            mealsItemPanel = new TravelFoodPanel(entity.get("travelFood").isObject(), false);
            entityFieldsPanel.add(mealsItemPanel);
        }

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

    @Override
    protected void addWidgets() {
        addEnumField("travelType", false, true, TravelType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(tripInfoHelpText);
        addField("departureDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("returnDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("travelDestination", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("reasonForTravel", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
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

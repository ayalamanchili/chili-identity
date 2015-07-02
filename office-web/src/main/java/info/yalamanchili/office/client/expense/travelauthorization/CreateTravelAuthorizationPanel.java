/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.DEFAULT_FIELD_WIDTH;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class CreateTravelAuthorizationPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(CreateTravelAuthorizationPanel.class.getName());
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

    public CreateTravelAuthorizationPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("TravelAuthorization", OfficeWelcome.constants);
    }

    public CreateTravelAuthorizationPanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("TravelAuthorization", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        assignEntityValueFromField("travelType", entity);
        assignEntityValueFromField("departureDate", entity);
        assignEntityValueFromField("returnDate", entity);
        assignEntityValueFromField("travelDestination", entity);
        assignEntityValueFromField("reasonForTravel", entity);
        entity.put("travelTransportation", travelTransportationItem.getObject());
        entity.put("travelAccommodation", lodgingItemPanel.getObject());
        entity.put("travelFood", mealsItemPanel.getObject());
        entity.put("travelExpenseRequisitionStatus", new JSONString("Open"));
        logger.info(entity.toString());
        return entity;

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
        entityFieldsPanel.add(travelTransportationItem);
        entityFieldsPanel.add(lodging);
        entityFieldsPanel.add(lodgingItemPanel);
        entityFieldsPanel.add(meals);
        entityFieldsPanel.add(mealsItemPanel);
        entityFieldsPanel.add(emptyLine);
        alignFields(DEFAULT_FIELD_WIDTH);
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
        new ResponseStatusWidget().show("Request Submitted, please wait for Email notification within 48 hours of Email confirmation");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTravelAuthorizationPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travel-authorization/submit-travel-expense-request";
    }
}

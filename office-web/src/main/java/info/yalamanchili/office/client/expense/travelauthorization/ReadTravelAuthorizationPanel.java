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
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.ExpensePaymentType;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.TravelRentalVehicleType;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.TravelTransportationType;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.TravelType;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
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
    protected static HTML employeetripinfo = new HTML("<hr />\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\"><strong style=\"color:#819FF7\">Employee and Trip Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML estimatedexpenses = new HTML("<hr />\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\"><strong style=\"color:#819FF7\">Estimated Expenses</strong></p>\n"
            + "\n");
    HTML tac = new HTML("<h5> "
            + "Estimate all expenses to be incurred and indicate method of payment.</h5>");
    HTML transportation = new HTML("<h4 style=\"color:#819FF7\">" + "Transportation</h4>");
    HTML lodging = new HTML("<h4 style=\"color:#819FF7\">  " + "Accommodation</h4>");
    HTML meals = new HTML("<h4 style=\"color:#819FF7\"> " + "Food</h4>");
    HTML comment = new HTML("<h5> "
            + " *Applicable only when RENTAL_VEHICALE selected as transpotation type.*</h5>");

    public static ReadTravelAuthorizationPanel instance() {
        return instance;
    }

    public ReadTravelAuthorizationPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "TravelExpense", OfficeWelcome.constants);
    }

    public ReadTravelAuthorizationPanel(String id) {
        instance = this;
        initReadComposite(id, "TravelExpense", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
                populateComments();
            }
        });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.travelauthorization.TravelExpenseRequisition"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("travelType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("departureDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("returnDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("department", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("travelDestination", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("reasonForTravel", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("travelTransportationType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("totalMiles", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("costPerMile", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("travelRentalVehicleType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("estimatedCostOfOtherTransportation", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("rentalVehicleJustification", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("otherVehicleTypeJustification", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("numberOfLodgingNights", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("lodgingCostPerNight", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("totalCostOfFood", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("conferenceFee", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("otherExpences", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("expenseAccommodationPaymentType", entity, DataType.INTEGER_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", selectEmployeeWidgetF);
        addEnumField("travelType", true, false, TravelType.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(employeetripinfo);
        addField("departureDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("returnDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("department", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("travelDestination", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("reasonForTravel", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(estimatedexpenses);
        addEnumField("travelTransportationType", true, false, TravelTransportationType.names(), Alignment.HORIZONTAL);
        addField("totalMiles", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("costPerMile", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("totalTransportationCost", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(comment);
        addEnumField("travelRentalVehicleType", true, false, TravelRentalVehicleType.names(), Alignment.HORIZONTAL);
        addField("estimatedCostOfOtherTransportation", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("rentalVehicleJustification", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("otherVehicleTypeJustification", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(lodging);
        addField("numberOfLodgingNights", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("lodgingCostPerNight", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("totalLodgingCost", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(meals);
        addField("totalCostOfFood", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("conferenceFee", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("totalCostOfBanquet", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("otherExpences", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addEnumField("expenseAccommodationPaymentType", true, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "travelexpense/" + entityId;
    }
}

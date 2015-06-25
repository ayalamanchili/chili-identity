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
            + "<strong style=\"color:#e16802\">Employee and Trip Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML estimatedexpenses = new HTML("<hr />\n"
            + "<strong style=\"color:#e16802\">Estimated Expenses</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

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

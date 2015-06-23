/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadTravelExpensePanel extends ReadComposite {

    private static ReadTravelExpensePanel instance;
    private static Logger logger = Logger.getLogger(ReadTravelExpensePanel.class.getName());

    public static ReadTravelExpensePanel instance() {
        return instance;
    }

    public ReadTravelExpensePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "TravelExpense", OfficeWelcome.constants);
    }

    public ReadTravelExpensePanel(String id) {
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
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.expense.AdvanceRequisition"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("departureDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("returnDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("department", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("departureDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("returnDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("department", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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

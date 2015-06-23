/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class UpdateTravelExpensePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateTravelExpensePanel.class.getName());

    public UpdateTravelExpensePanel(String entityId) {
        initUpdateComposite(entityId, "TravelExpense", OfficeWelcome.constants);
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
        return OfficeWelcome.constants.root_url() + "travelexpense/" + entityId;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("departureDate", entity);
        assignEntityValueFromField("returnDate", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("department", entity);
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
        assignFieldValueFromEntity("departureDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("returnDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("department", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Travel Expense Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllTravelExpensePanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
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
        return OfficeWelcome.constants.root_url() + "travelexpense/save" + entityId;
    }
}

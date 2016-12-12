/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.perdiem;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdatePerDiemPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePerDiemPanel.class.getName());
    protected boolean isAmountPresent = false;

    public UpdatePerDiemPanel(String entityId) {
        initUpdateComposite(entityId, "PerDiem", OfficeWelcome.constants2);
    }

    public UpdatePerDiemPanel(JSONObject entity, boolean isAmountPresent) {
        this.isAmountPresent = isAmountPresent;
        initUpdateComposite(entity, "PerDiem", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("live50MilesAway", entity);
        if (isAmountPresent == true) {
            assignEntityValueFromField("amount", entity);
        } else {
            assignEntityValueFromField("percentage", entity);
        }
        assignEntityValueFromField("perDiemStartDate", entity);
        assignEntityValueFromField("perDiemEndDate", entity);
        logger.info("asdf" + entity);
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
        JSONObject employee = entity.get("employee").isObject();
        StringField field = (StringField) fields.get("employee");
        String empName = employee.get("firstName").isString().stringValue() + " " + employee.get("lastName").isString().stringValue();
        field.setValue(empName);
        assignFieldValueFromEntity("live50MilesAway", entity, DataType.BOOLEAN_FIELD);
        if (isAmountPresent == true) {
            assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        } else {
            assignFieldValueFromEntity("percentage", entity, DataType.CURRENCY_FIELD);
        }
        assignFieldValueFromEntity("perDiemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("perDiemEndDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Perdiem Request");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllPerdiemPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD);
        addField("live50MilesAway", true, false, DataType.BOOLEAN_FIELD);
        if (isAmountPresent == true) {
            addField("amount", false, false, DataType.CURRENCY_FIELD);
        } else {
            addField("percentage", false, false, DataType.CURRENCY_FIELD);
        }
        addField("perDiemStartDate", false, false, DataType.DATE_FIELD);
        addField("perDiemEndDate", false, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "perdiem/update";
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

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "perdiem/" + getEntityId();
    }
}

/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadExpensePanel extends ReadComposite {

    private static ReadExpensePanel instance;
    private static Logger logger = Logger.getLogger(ReadExpensePanel.class.getName());

    public static ReadExpensePanel instance() {
        return instance;
    }

    public ReadExpensePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Expenses", OfficeWelcome.constants);
    }

    public ReadExpensePanel(String id) {
        initReadComposite(id, "Expenses", OfficeWelcome.constants);
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
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("expenseDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("category", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("employee", new SelectEmployeeWidget(false, true));
        addField("name", true, true, DataType.STRING_FIELD);
        addField("amount", true, true, DataType.CURRENCY_FIELD);
        addDropDown("category", new SelectExpenseCategoryWidget(false, true));
        addField("expenseDate", true, true, DataType.DATE_FIELD);
        addField("description", true, false, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expense";
    }
}

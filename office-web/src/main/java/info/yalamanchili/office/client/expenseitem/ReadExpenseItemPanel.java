/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import info.yalamanchili.office.client.expensereports.SelectExpenseReportsWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseItemPanel extends ReadComposite {

    private static ReadExpenseItemPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    SelectExpenseReportsWidget selectExpenseReportsWidgetF = new SelectExpenseReportsWidget(false, true);

    public static ReadExpenseItemPanel instance() {
        return instance;
    }

    public ReadExpenseItemPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    public ReadExpenseItemPanel(String id) {
        initReadComposite(id, "ExpenseItem", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("expenseReport", entity, null);
        assignFieldValueFromEntity("category", entity, null);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("remarks", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("category", new SelectExpenseCategoryWidget(false, true));
        addDropDown("expenseReport", new SelectExpenseReportsWidget(false, true));
        addField("description", false, false, DataType.STRING_FIELD);
        addField("amount", false, true, DataType.INTEGER_FIELD);
        addField("purpose", false, false, DataType.STRING_FIELD);
        addField("itemStartDate", false, true, DataType.DATE_FIELD);
        addField("itemEndDate", false, false, DataType.DATE_FIELD);
        addField("remarks", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
}

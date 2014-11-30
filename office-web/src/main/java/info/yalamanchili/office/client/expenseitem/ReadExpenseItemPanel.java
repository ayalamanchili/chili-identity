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
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseItemPanel extends ReadComposite {

    private static ReadExpenseItemPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);

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
        assignFieldValueFromEntity("category", entity, null);
        assignFieldValueFromEntity("description", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("itemStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purpose", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("remarks", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addDropDown("category", new SelectExpenseCategoryWidget(true, true));
        addField("description", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("amount", true, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("itemStartDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("itemEndDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purpose", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("remarks", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem/" + entityId;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class ReadExpenseItemPanel extends ReadComposite {

    private static ReadExpenseItemPanel instance;
    private static Logger logger = Logger.getLogger(ReadExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    EnumField expensePaymentMode;
    DateField expenseDate;
    StringField purpose;
    StringField description;
    CurrencyField amount;
//    TextAreaField remark;
    CurrencyField expenseMiles;

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
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity(CATEGORY, entity, null);
        assignFieldValueFromEntity(EXPENSE_PAYMENT_MODE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DESCRIPTION, entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity(EXPENSE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(EXPENSE_MILES, entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity(AMOUNT, entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity(PURPOSE, entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity(REMARK, entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        expensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        expenseDate.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
//        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        expenseMiles.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        amount.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        selectCategoryWidgetF.getLabel().getElement().getStyle().setWidth(DEFAULT_CAT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        addField(EXPENSE_DATE, true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        expenseDate = (DateField) fields.get(EXPENSE_DATE);
        addField(PURPOSE, true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        purpose = (StringField) fields.get(PURPOSE);
        addDropDown(CATEGORY, selectCategoryWidgetF);
        addField(EXPENSE_MILES, true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        expenseMiles = (CurrencyField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        amount = (CurrencyField) fields.get(AMOUNT);
        addEnumField(EXPENSE_PAYMENT_MODE, true, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(DESCRIPTION, true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        description = (StringField) fields.get(DESCRIPTION);
//        addField(REMARK, true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
//        remark = (TextAreaField) fields.get(REMARK);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllEpenseItemPanel.instance;
     }
}

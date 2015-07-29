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
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import java.math.BigDecimal;
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
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;

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
        assignFieldValueFromEntity(CATEGORY, entity, null);
        if (entity.get(EXPENSE_PAYMENT_MODE) != null) {
            expensePaymentMode.selectValue(entity.get(EXPENSE_PAYMENT_MODE).isString().stringValue());
        }
        if (entity.get(DESCRIPTION) != null) {
            description.setValue(entity.get(DESCRIPTION).isString().stringValue());
        }
        if (entity.get(EXPENSE_DATE) != null) {
            expenseDate.setValue(entity.get(EXPENSE_DATE).isString().stringValue());
        }
        if (entity.get(AMOUNT) != null) {
            amount.setValue(new BigDecimal(entity.get(AMOUNT).isString().stringValue()), false);
        }
        if (entity.get(PURPOSE) != null) {
            purpose.setValue(entity.get(PURPOSE).isString().stringValue());
        }
        if (entity.get(REMARK) != null) {
            remark.setValue(entity.get(REMARK).isString().stringValue());
        }
        logger.info("dddddd");
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        expensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        expenseDate.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DESC_FIELD_WIDTH, Style.Unit.PX);
        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        amount.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        selectCategoryWidgetF.getLabel().getElement().getStyle().setWidth(DEFAULT_CAT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        expensePaymentMode = new EnumField(OfficeWelcome.constants,
                EXPENSE_PAYMENT_MODE, EXPENSE_ITEM, true, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expenseDate = new DateField(OfficeWelcome.constants, EXPENSE_DATE, EXPENSE_ITEM, true, true, Alignment.HORIZONTAL);
        purpose = new TextAreaField(OfficeWelcome.constants, PURPOSE, EXPENSE_ITEM, true, true, Alignment.HORIZONTAL);
        description = new TextAreaField(OfficeWelcome.constants, DESCRIPTION, EXPENSE_ITEM, true, false, Alignment.HORIZONTAL);
        remark = new TextAreaField(OfficeWelcome.constants, REMARK, EXPENSE_ITEM, true, false, Alignment.HORIZONTAL);
        amount = new CurrencyField(OfficeWelcome.constants, AMOUNT, EXPENSE_ITEM, true, true, Alignment.HORIZONTAL);
        expenseDate.getElement().getStyle().setProperty("float", "left");
        purpose.getElement().getStyle().setProperty("float", "left");
        amount.getElement().getStyle().setProperty("float", "left");
        entityFieldsPanel.add(expenseDate);
        addDropDown(CATEGORY, selectCategoryWidgetF);
        entityFieldsPanel.add(amount);
        entityFieldsPanel.add(expensePaymentMode);
        entityFieldsPanel.add(purpose);
        entityFieldsPanel.add(description);
        entityFieldsPanel.add(remark);
        alignFields();
        logger.info("ccccccc");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem/" + entityId;
    }
}

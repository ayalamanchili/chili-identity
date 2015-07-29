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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import java.math.BigDecimal;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseItemPanel extends UpdateComposite {

    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);

    EnumField expensePaymentMode;
    DateField expenseDate;
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;

    public UpdateExpenseItemPanel(JSONObject entity) {
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
        if (expensePaymentMode.getValue() != null) {
            entity.put(EXPENSE_PAYMENT_MODE, new JSONString(expensePaymentMode.getValue()));
        }
        if (expenseDate.getDate() != null) {
            entity.put(EXPENSE_DATE, new JSONString(DateUtils.toDateString(expenseDate.getDate())));
        }
        if (description.getValue() != null) {
            entity.put(PURPOSE, new JSONString(description.getValue()));
        }
        if (purpose.getValue() != null) {
            entity.put(DESCRIPTION, new JSONString(purpose.getValue()));
        }
        if (remark.getValue() != null) {
            entity.put(REMARK, new JSONString(remark.getValue()));
        }
        if (amount.getCurrency() != null) {
            entity.put(AMOUNT, new JSONString(amount.getCurrency().toString()));
        }
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
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee ExpenseItem Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        update.setVisible(false);
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
                EXPENSE_PAYMENT_MODE, EXPENSE_ITEM, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expenseDate = new DateField(OfficeWelcome.constants, EXPENSE_DATE, EXPENSE_ITEM, false, true, Alignment.HORIZONTAL);
        purpose = new TextAreaField(OfficeWelcome.constants, PURPOSE, EXPENSE_ITEM, false, true, Alignment.HORIZONTAL);
        description = new TextAreaField(OfficeWelcome.constants, DESCRIPTION, EXPENSE_ITEM, false, false, Alignment.HORIZONTAL);
        remark = new TextAreaField(OfficeWelcome.constants, REMARK, EXPENSE_ITEM, false, false, Alignment.HORIZONTAL);
        amount = new CurrencyField(OfficeWelcome.constants, AMOUNT, EXPENSE_ITEM, false, true, Alignment.HORIZONTAL);
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
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
}

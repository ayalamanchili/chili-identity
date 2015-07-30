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
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
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
        assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        assignEntityValueFromField(EXPENSE_DATE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        assignEntityValueFromField(DESCRIPTION, entity);
        assignEntityValueFromField(REMARK, entity);
        assignEntityValueFromField(AMOUNT, entity);
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
        assignFieldValueFromEntity(EXPENSE_PAYMENT_MODE, entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity(DESCRIPTION, entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity(EXPENSE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(AMOUNT, entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity(PURPOSE, entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity(REMARK, entity, DataType.TEXT_AREA_FIELD);
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
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        amount.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        selectCategoryWidgetF.getLabel().getElement().getStyle().setWidth(DEFAULT_CAT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        addField(EXPENSE_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        expenseDate = (DateField) fields.get(EXPENSE_DATE);
        addField(PURPOSE, false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        purpose = (TextAreaField) fields.get(PURPOSE);
        addDropDown(CATEGORY, selectCategoryWidgetF);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        amount = (CurrencyField) fields.get(AMOUNT);
        addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(DESCRIPTION, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        description = (TextAreaField) fields.get(DESCRIPTION);
        addField(REMARK, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        remark = (TextAreaField) fields.get(REMARK);
//        expenseDate.getElement().getStyle().setProperty("float", "left");
//        purpose.getElement().getStyle().setProperty("float", "left");
//        amount.getElement().getStyle().setProperty("float", "left");
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

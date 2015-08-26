/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expensecategory.SelectExpenseCategoryWidget;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import info.yalamanchili.office.client.expensereports.UpdateExpenseReportPanel;
import java.math.BigDecimal;

/**
 *
 * @author Prasanthi.p
 */
public class UpdateExpenseItemPanel extends UpdateComposite implements BlurHandler {

    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    EnumField expensePaymentMode;
    DateField expenseDate;
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;
    CurrencyField expenseMiles;
    UpdateExpenseReportPanel parentPanel;
    ClickableLink deleteB = new ClickableLink("Remove Item");

    public UpdateExpenseItemPanel(UpdateExpenseReportPanel parent, JSONObject entity) {
        this.parentPanel = parent;
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    public JSONObject populateEntityFromFields() {
//        if (selectCategoryWidgetF.getSelectedObject().get("value").isString().stringValue().trim().equals("Personal Auto")) {
//            amount.setValue(new BigDecimal(expenseMiles.getValue()).multiply(new BigDecimal("0.50")).setScale(2), false);
//        }
        entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
        assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        assignEntityValueFromField(EXPENSE_DATE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        assignEntityValueFromField(DESCRIPTION, entity);
        assignEntityValueFromField(REMARK, entity);
        assignEntityValueFromField(EXPENSE_MILES, entity);
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
        assignFieldValueFromEntity(EXPENSE_MILES, entity, DataType.CURRENCY_FIELD);
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
        deleteB.addClickHandler(this);
        expenseMiles.getTextbox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        update.setVisible(false);
        expensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        expenseDate.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        expenseMiles.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
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
        addField(EXPENSE_MILES, false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        expenseMiles = (CurrencyField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        amount = (CurrencyField) fields.get(AMOUNT);
        addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(DESCRIPTION, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        description = (TextAreaField) fields.get(DESCRIPTION);
        addField(REMARK, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        remark = (TextAreaField) fields.get(REMARK);
        alignFields();
        entityActionsPanel.add(deleteB);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(expenseMiles.getTextbox())) {
            amount.setValue(new BigDecimal(expenseMiles.getValue()).multiply(new BigDecimal("0.50")).setScale(2), false);
        }
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }

    protected String getDeleteURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem/delete/" + getEntityId();
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            if (Window.confirm("Are you sure to delete the expense item?")) {
                parentPanel.removePanel();
                HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                        OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

                            @Override
                            public void onResponse(String arg0) {
                                new ResponseStatusWidget().show("Successfully Deleted ExpenseItem Information");
                            }
                        });
            }
        }
        super.onClick(event);
    }

}

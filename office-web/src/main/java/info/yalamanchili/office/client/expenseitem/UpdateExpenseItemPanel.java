/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expenseitem;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
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
public class UpdateExpenseItemPanel extends TUpdateComposite implements BlurHandler, ChangeHandler {

//  SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true, Alignment.VERTICAL);
    public EnumField expensePaymentMode;
    DateField expenseDate;
    StringField purpose;
    StringField description;
    public CurrencyField amount;
    CurrencyField expenseMiles;
    public ClickableLink deleteB = new ClickableLink("Remove Item");
    protected String parentId;
    boolean isGeneralExpenseItem = false;
    boolean displayFieldNames = true;

    public UpdateExpenseItemPanel(String parentId, JSONObject entity, boolean isGeneralExpense) {
        this.parentId = parentId;
        this.isGeneralExpenseItem = isGeneralExpense;
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("");
    }

    public UpdateExpenseItemPanel(String parentId, JSONObject entity, boolean isGeneralExpense, boolean displayFieldNames) {
        this.parentId = parentId;
        this.isGeneralExpenseItem = isGeneralExpense;
        this.displayFieldNames = displayFieldNames;
        initUpdateComposite(entity, "ExpenseItem", OfficeWelcome.constants2);
        entityCaptionPanel.setCaptionHTML("");
    }

    @Override
    public JSONObject populateEntityFromFields() {
        assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        assignEntityValueFromField(EXPENSE_DATE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        if (!isGeneralExpenseItem) {
            entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
        }
        if (isGeneralExpenseItem) {
            assignEntityValueFromField(DESCRIPTION, entity);
        }
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
        OfficeWelcome.logger.info("populate fields from entity .... " + entity);
        if (entity.containsKey("category") == true && !entity.get("category").isObject().get("name").isString().stringValue().equals("General")) {
            assignFieldValueFromEntity(CATEGORY, entity, null);
        }
        assignFieldValueFromEntity(EXPENSE_PAYMENT_MODE, entity, DataType.ENUM_FIELD);
        if (isGeneralExpenseItem) {
            assignFieldValueFromEntity(DESCRIPTION, entity, DataType.STRING_FIELD);
        }
        if (entity.containsKey("category") == true && entity.get("category").isObject().get("name").isString().stringValue().equalsIgnoreCase("Personal Auto")) {
            expenseMiles.setVisible(true);
            assignFieldValueFromEntity(EXPENSE_MILES, entity, DataType.CURRENCY_FIELD);
        } else {
            expenseMiles.setVisible(false);
        }
        assignFieldValueFromEntity(EXPENSE_DATE, entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity(AMOUNT, entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity(PURPOSE, entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee ExpenseItem Information");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected void addListeners() {
        if (!isGeneralExpenseItem) {
            selectCategoryWidgetF.getListBox().addChangeHandler(this);
        }
        deleteB.addClickHandler(this);
        expenseMiles.getTextbox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        update.setVisible(false);
        configureLabel(expensePaymentMode.getLabel(), displayFieldNames);
        configureLabel(expenseDate.getLabel(), displayFieldNames);
        configureLabel(purpose.getLabel(), displayFieldNames);
        if (isGeneralExpenseItem) {
            configureLabel(description.getLabel(), displayFieldNames);
        }
        configureLabel(expenseMiles.getLabel(), displayFieldNames);
        configureLabel(amount.getLabel(), displayFieldNames);
        if (!isGeneralExpenseItem) {
            configureLabel(selectCategoryWidgetF.getLabel(), displayFieldNames);
        }
        expenseMiles.setVisible(false);
    }

    protected void configureLabel(Label l, boolean displayFieldNames) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(displayFieldNames);
    }

    @Override
    protected void addWidgets() {
        addField(EXPENSE_DATE, false, true, DataType.DATE_FIELD, Alignment.VERTICAL, 1, 1);
        expenseDate = (DateField) fields.get(EXPENSE_DATE);
        addField(PURPOSE, false, true, DataType.STRING_FIELD, Alignment.VERTICAL, 1, 2);
        purpose = (StringField) fields.get(PURPOSE);
        if (!isGeneralExpenseItem) {
            addDropDown(CATEGORY, selectCategoryWidgetF, 1, 3);
        }
        addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.VERTICAL, 1, 4);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(EXPENSE_MILES, false, false, DataType.CURRENCY_FIELD, Alignment.VERTICAL, 1, 5);
        expenseMiles = (CurrencyField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.VERTICAL, 1, 6);
        amount = (CurrencyField) fields.get(AMOUNT);
        if (isGeneralExpenseItem) {
            addField(DESCRIPTION, false, false, DataType.STRING_FIELD, Alignment.VERTICAL, 1, 7);
            description = (StringField) fields.get(DESCRIPTION);
        }
        entityFieldsPanel.setWidget(1, 8, deleteB);
        entityActionsPanel.setVisible(false);
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
            if (getEntityId() == null || getEntityId().isEmpty()) {
                this.removeFromParent();
                UpdateExpenseReportPanel.instance().updateItemPanels.remove(this);
            } else if (Window.confirm("Are you sure to delete the expense item?")) {
                HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                        OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String arg0) {
                                new ResponseStatusWidget().show("Successfully Deleted ExpenseItem Information");
                                TabPanel.instance().expensePanel.entityPanel.clear();
                                TabPanel.instance().expensePanel.entityPanel.add(new UpdateExpenseReportPanel(parentId));
                            }
                        });
            }
        }
        super.onClick(event);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(selectCategoryWidgetF.getListBox())) {
            if (selectCategoryWidgetF.getSelectedObject().get("value").isString().stringValue().trim().equals("Personal Auto")) {
                expenseMiles.setVisible(true);
            } else {
                expenseMiles.setVisible(false);
            }
        }

    }

}

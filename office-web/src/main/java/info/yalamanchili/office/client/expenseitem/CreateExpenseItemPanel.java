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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
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
import info.yalamanchili.office.client.expensereports.CreateExpenseReportPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseItemPanel extends CreateComposite implements ChangeHandler, BlurHandler, ClickHandler {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    EnumField expensePaymentMode;
    DateField expenseDate;
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;
    boolean isGeneralExpenseItem = false;
    CurrencyField expenseMiles;
    CreateExpenseReportPanel parentPanel;
    ClickableLink deleteB = new ClickableLink("Remove Item");

    public CreateExpenseItemPanel(CreateExpenseReportPanel parent) {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
        this.parentPanel = parent;
    }

    public CreateExpenseItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }

    public CreateExpenseItemPanel(CreateExpenseReportPanel parent, boolean isGeneralExpenseItem) {
        super(CreateComposite.CreateCompositeType.CREATE);
        this.isGeneralExpenseItem = isGeneralExpenseItem;
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
        this.parentPanel = parent;
    }
    
    public CreateExpenseItemPanel(boolean isGeneralExpenseItem) {
        super(CreateComposite.CreateCompositeType.CREATE);
        this.isGeneralExpenseItem = isGeneralExpenseItem;
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        addField(EXPENSE_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        expenseDate = (DateField) fields.get(EXPENSE_DATE);
        addField(PURPOSE, false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        purpose = (TextAreaField) fields.get(PURPOSE);
        if (!isGeneralExpenseItem) {
            addDropDown(CATEGORY, selectCategoryWidgetF);
            addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
            expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        }
        addField(EXPENSE_MILES, false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        expenseMiles = (CurrencyField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        amount = (CurrencyField) fields.get(AMOUNT);
        addField(DESCRIPTION, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        description = (TextAreaField) fields.get(DESCRIPTION);
        addField(REMARK, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        remark = (TextAreaField) fields.get(REMARK);
        alignFields();
        entityActionsPanel.add(deleteB);
    }

    @Override
    protected void configure() {
        create.setVisible(false);
        if (!isGeneralExpenseItem) {
            expensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
            selectCategoryWidgetF.getLabel().getElement().getStyle().setWidth(DEFAULT_CAT_FIELD_WIDTH, Style.Unit.PX);
        }
        expenseDate.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DIFF_FIELD_WIDTH, Style.Unit.PX);
        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        expenseMiles.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        amount.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        expenseMiles.setVisible(false);
    }

    @Override
    protected void addListeners() {
        if (!isGeneralExpenseItem) {
            expensePaymentMode.listBox.addChangeHandler(this);
            selectCategoryWidgetF.getListBox().addChangeHandler(this);
        }
        expenseMiles.getTextbox().addBlurHandler(this);
        deleteB.addClickHandler(this);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        if (isGeneralExpenseItem) {
            entity.put(CATEGORY, new JSONString("General"));
            assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
            entity.put(EXPENSE_PAYMENT_MODE, new JSONString(ExpensePaymentMode.PERSONAL_CARD.name()));
        } else {
            entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
            assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        }
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
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Expense Item Successfully Created");
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
    
    protected String getDeleteURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem/delete/" + getEntityId();
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(selectCategoryWidgetF.getListBox())) {
            if (selectCategoryWidgetF.getSelectedObject().get("value").isString().stringValue().trim().equals("Personal Auto")) {
                logger.info("on change");
                logger.info(selectCategoryWidgetF.getSelectedObject().get("value").isString().stringValue());
                expenseMiles.setVisible(true);
            } else {
                expenseMiles.setVisible(false);
            }
        }

    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(expenseMiles.getTextbox())) {
            amount.setValue(new BigDecimal(expenseMiles.getValue()).multiply(new BigDecimal("0.50")).setScale(2), false);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(deleteB)) {
            parentPanel.removePanel();
            HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                    OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

                        @Override
                        public void onResponse(String arg0) {
                            new ResponseStatusWidget().show("Successfully Deleted Employee ExpenseItem Information");
                        }
                    });
        }
        super.onClick(event);
    }

}

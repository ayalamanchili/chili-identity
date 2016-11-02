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
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.TCreateComposite;
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
import info.yalamanchili.office.client.expensereports.CreateExpenseReportPanel;
import static info.yalamanchili.office.client.expensereports.ExpenseFormConstants.*;
import info.yalamanchili.office.client.expensereports.ExpensePaymentMode;
import info.yalamanchili.office.client.expensereports.UpdateExpenseReportPanel;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseItemPanel extends TCreateComposite implements ChangeHandler, BlurHandler, ClickHandler {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    public EnumField expensePaymentMode;
    DateField expenseDate;
    StringField purpose;
    StringField description;
    public CurrencyField amount;
    boolean isGeneralExpenseItem = false;
    CurrencyField expenseMiles;
    public ClickableLink deleteB = new ClickableLink("Remove Item");
    CRUDComposite parent;

    public CreateExpenseItemPanel(CRUDComposite parent, boolean isGeneralExpenseItem) {
        super(TCreateComposite.CreateCompositeType.CREATE);
        this.parent = parent;
        this.isGeneralExpenseItem = isGeneralExpenseItem;
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        addField(EXPENSE_DATE, false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 1, 1);
        expenseDate = (DateField) fields.get(EXPENSE_DATE);
        addField(PURPOSE, false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        purpose = (StringField) fields.get(PURPOSE);
        if (!isGeneralExpenseItem) {
            addDropDown(CATEGORY, selectCategoryWidgetF, 1, 3);
        }
        addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL, 1, 4);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(EXPENSE_MILES, false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 1, 5);
        expenseMiles = (CurrencyField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 1, 6);
        amount = (CurrencyField) fields.get(AMOUNT);
        if (isGeneralExpenseItem) {
            addField(DESCRIPTION, false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 7);
            description = (StringField) fields.get(DESCRIPTION);
        }
        entityFieldsPanel.setWidget(1, 8, deleteB);
        entityActionsPanel.setVisible(false);
    }

    @Override
    protected void configure() {
        create.setVisible(false);
        if (!isGeneralExpenseItem) {
            configureLabel(selectCategoryWidgetF.getLabel());
        }
        if (isGeneralExpenseItem) {
            configureLabel(description.getLabel());
        }
        configureLabel(expensePaymentMode.getLabel());
        configureLabel(expenseDate.getLabel());
        configureLabel(purpose.getLabel());
        configureLabel(expenseMiles.getLabel());
        configureLabel(amount.getLabel());
        expenseMiles.setVisible(false);
        setBackgroundText();
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(false);
    }

    @Override
    protected void addListeners() {
        if (!isGeneralExpenseItem) {
            selectCategoryWidgetF.getListBox().addChangeHandler(this);
        }
        expensePaymentMode.listBox.addChangeHandler(this);
        expenseMiles.getTextbox().addBlurHandler(this);
        deleteB.addClickHandler(this);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        if (isGeneralExpenseItem) {
            entity.put(CATEGORY, new JSONString("General"));
        } else {
            entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
            assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        }
        assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        assignEntityValueFromField(EXPENSE_DATE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        if (isGeneralExpenseItem) {
            assignEntityValueFromField(DESCRIPTION, entity);
        }
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
            this.removeFromParent();
            if (parent instanceof CreateExpenseReportPanel) {
                CreateExpenseReportPanel.instance().expenseItemPanels.remove(this);
                CreateExpenseReportPanel.instance().onChange();
            } else if (parent instanceof UpdateExpenseReportPanel) {
                UpdateExpenseReportPanel.instance().updateItemPanels.remove(this);
                UpdateExpenseReportPanel.instance().onChange();
            }
            if (getEntityId() != null && !getEntityId().isEmpty()) {
                HttpService.HttpServiceAsync.instance().doPut(getDeleteURI(), entity.toString(),
                        OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

                            @Override
                            public void onResponse(String arg0) {
                                new ResponseStatusWidget().show("Successfully Deleted Employee ExpenseItem Information");
                            }
                        });
            }

        }
    }
}

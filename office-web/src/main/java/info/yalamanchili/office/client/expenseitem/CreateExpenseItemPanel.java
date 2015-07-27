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
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.CurrencyField;
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
import java.util.logging.Logger;

/**
 *
 * @author Prasanthi.p
 */
public class CreateExpenseItemPanel extends CreateComposite {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, false);

    EnumField expensePaymentMode;
    DateField expenseDate;
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;

    public CreateExpenseItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("ExpenseItem", OfficeWelcome.constants);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void addWidgets() {
        expensePaymentMode = new EnumField(OfficeWelcome.constants,
                EXPENSE_PAYMENT_MODE, "TravelExpense", false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expenseDate = new DateField(OfficeWelcome.constants, "expenseDate", "TravelExpense", false, true, Alignment.HORIZONTAL);
        purpose = new TextAreaField(OfficeWelcome.constants, "purpose", "TravelExpense", false, true, Alignment.HORIZONTAL);
        description = new TextAreaField(OfficeWelcome.constants, "description", "TravelExpense", false, false, Alignment.HORIZONTAL);
        remark = new TextAreaField(OfficeWelcome.constants, "remark", "TravelExpense", false, false, Alignment.HORIZONTAL);
        amount = new CurrencyField(OfficeWelcome.constants, "amount", "TravelExpense", false, true, Alignment.HORIZONTAL);
        expenseDate.getElement().getStyle().setProperty("float", "left");
        purpose.getElement().getStyle().setProperty("float", "left");
        amount.getElement().getStyle().setProperty("float", "left");
        entityFieldsPanel.add(expenseDate);
        addDropDown("category", selectCategoryWidgetF);
        entityFieldsPanel.add(amount);
        entityFieldsPanel.add(expensePaymentMode);
        entityFieldsPanel.add(purpose);
        entityFieldsPanel.add(description);
        entityFieldsPanel.add(remark);
        alignFields();
    }

    @Override
    protected void configure() {
        create.setVisible(false);
        expensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_PMT_FIELD_WIDTH, Style.Unit.PX);
        expenseDate.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        purpose.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        description.getLabel().getElement().getStyle().setWidth(DEFAULT_DES_FIELD_WIDTH, Style.Unit.PX);
        remark.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        amount.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
        selectCategoryWidgetF.getLabel().getElement().getStyle().setWidth(DEFAULT_ITEM_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        entity.put("category", selectCategoryWidgetF.getSelectedObject());
        if (expensePaymentMode.getValue() != null) {
            entity.put("expensePaymentMode", new JSONString(expensePaymentMode.getValue()));
        }
        if (expenseDate.getDate() != null) {
            entity.put("expenseDate", new JSONString(DateUtils.toDateString(expenseDate.getDate())));
        }
        if (description.getValue() != null) {
            entity.put("description", new JSONString(description.getValue()));
        }
        if (purpose.getValue() != null) {
            entity.put("purpose", new JSONString(purpose.getValue()));
        }
        if (remark.getValue() != null) {
            entity.put("remark", new JSONString(remark.getValue()));
        }
        if (amount.getCurrency() != null) {
            entity.put("amount", new JSONString(amount.getCurrency().toString()));
        }
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
        new ResponseStatusWidget().show("Successfully ExpenseItem Created");
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new ExpenseItemSidePanel());
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }
}

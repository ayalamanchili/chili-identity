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
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
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
public class CreateExpenseItemPanel extends CreateComposite implements ChangeHandler, BlurHandler, ClickHandler {

    private Logger logger = Logger.getLogger(CreateExpenseItemPanel.class.getName());
    SelectExpenseCategoryWidget selectCategoryWidgetF = new SelectExpenseCategoryWidget(false, true);
    EnumField expensePaymentMode;
    DateField expenseDate;
    TextAreaField purpose;
    TextAreaField description;
    CurrencyField amount;
    TextAreaField remark;
    IntegerField expenseMiles;

    public CreateExpenseItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
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
        addDropDown(CATEGORY, selectCategoryWidgetF);
        addEnumField(EXPENSE_PAYMENT_MODE, false, true, ExpensePaymentMode.names(), Alignment.HORIZONTAL);
        expensePaymentMode = (EnumField) fields.get(EXPENSE_PAYMENT_MODE);
        addField(EXPENSE_MILES, false, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        expenseMiles = (IntegerField) fields.get(EXPENSE_MILES);
        addField(AMOUNT, false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        amount = (CurrencyField) fields.get(AMOUNT);
        addField(DESCRIPTION, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        description = (TextAreaField) fields.get(DESCRIPTION);
        addField(REMARK, false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        remark = (TextAreaField) fields.get(REMARK);
        alignFields();
    }

    @Override
    protected void configure() {
        create.setVisible(false);
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
    protected void addListeners() {
        expensePaymentMode.listBox.addChangeHandler(this);
        expenseMiles.getTextbox().addBlurHandler(this);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        entity = new JSONObject();
        entity.put(CATEGORY, selectCategoryWidgetF.getSelectedObject());
        assignEntityValueFromField(EXPENSE_PAYMENT_MODE, entity);
        assignEntityValueFromField(EXPENSE_DATE, entity);
        assignEntityValueFromField(PURPOSE, entity);
        assignEntityValueFromField(DESCRIPTION, entity);
        assignEntityValueFromField(REMARK, entity);
        assignEntityValueFromField(AMOUNT, entity);
        assignEntityValueFromField(EXPENSE_MILES, entity);
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
        TabPanel.instance().expensePanel.sidePanelTop.clear();
        TabPanel.instance().expensePanel.sidePanelTop.add(new ExpenseItemSidePanel());
        TabPanel.instance().expensePanel.entityPanel.clear();
        TabPanel.instance().expensePanel.entityPanel.add(new ReadAllEpenseItemPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "expenseitem";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (expensePaymentMode.getValue().equals(ExpensePaymentMode.PERSONAL_CARD.name())) {
            renderMiles(true);
        }
        if (expensePaymentMode.getValue().equals(ExpensePaymentMode.CORPORATE_CARD.name())) {
            renderMiles(false);
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(expensePaymentMode.listBox)) {
            if (expensePaymentMode.getValue().equals(ExpensePaymentMode.PERSONAL_CARD.name())) {
                renderMiles(true);
            }
            if (expensePaymentMode.getValue().equals(ExpensePaymentMode.CORPORATE_CARD.name())) {
                renderMiles(false);
            }
        }
    }

    protected void renderMiles(boolean render) {
        expenseMiles.setVisible(render);
    }

    @Override
    public void onBlur(BlurEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

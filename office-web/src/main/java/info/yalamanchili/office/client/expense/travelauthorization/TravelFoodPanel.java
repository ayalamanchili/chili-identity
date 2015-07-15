/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class TravelFoodPanel extends ALComposite implements ClickHandler, BlurHandler {

    protected FlowPanel panel = new FlowPanel();

    CurrencyField totalCostOfFood;
    CurrencyField conferenceFee;
    CurrencyField totalCostOfBanquet;
    CurrencyField otherExpences;
    EnumField foodExpensePaymentMode;
    EnumField conferenceExpensePaymentMode;
    EnumField banquetExpensePaymentMode;
    EnumField otherExpensePaymentMode;

    boolean readyOnly;
    JSONObject entity;

    public TravelFoodPanel(boolean readOnly) {
        this.readyOnly = readOnly;
        init(panel);
    }

    public TravelFoodPanel(JSONObject entity, boolean readOnly) {
        this.readyOnly = readOnly;
        this.entity = entity;
        init(panel);
        populateFields();
    }

    @Override
    protected void addListeners() {
        totalCostOfFood.getTextbox().addBlurHandler(this);
        conferenceFee.getTextbox().addBlurHandler(this);
        totalCostOfBanquet.getTextbox().addBlurHandler(this);
        otherExpences.getTextbox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        totalCostOfFood.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        conferenceFee.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        totalCostOfBanquet.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        otherExpences.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        foodExpensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        conferenceExpensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        banquetExpensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        otherExpensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        totalCostOfFood = new CurrencyField(OfficeWelcome.constants,
                TOTAL_COST_OF_FOOD, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        foodExpensePaymentMode = new EnumField(OfficeWelcome.constants,
                FOOD_EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        conferenceFee = new CurrencyField(OfficeWelcome.constants,
                CONFERENCE_FEE, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        conferenceExpensePaymentMode = new EnumField(OfficeWelcome.constants,
                CONFERENCE_EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        totalCostOfBanquet = new CurrencyField(OfficeWelcome.constants,
                TOTAL_COST_OF_BANQUET, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        banquetExpensePaymentMode = new EnumField(OfficeWelcome.constants,
                BANQUET_EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        otherExpences = new CurrencyField(OfficeWelcome.constants,
                OTHER_EXPENCES, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        otherExpensePaymentMode = new EnumField(OfficeWelcome.constants,
                OTHER_EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        totalCostOfFood.getElement().getStyle().setProperty("float", "left");
        conferenceFee.getElement().getStyle().setProperty("float", "left");
        totalCostOfBanquet.getElement().getStyle().setProperty("float", "left");
        otherExpences.getElement().getStyle().setProperty("float", "left");
        panel.add(totalCostOfFood);
        panel.add(foodExpensePaymentMode);
        panel.add(conferenceFee);
        panel.add(conferenceExpensePaymentMode);
        panel.add(totalCostOfBanquet);
        panel.add(banquetExpensePaymentMode);
        panel.add(otherExpences);
        panel.add(otherExpensePaymentMode);
    }

    protected final void populateFields() {
        if (entity.get(TOTAL_COST_OF_FOOD) != null) {
            totalCostOfFood.setValue(new BigDecimal(entity.get(TOTAL_COST_OF_FOOD).isString().stringValue()), false);
        }
        if (entity.get(CONFERENCE_FEE) != null) {
            conferenceFee.setValue(new BigDecimal(entity.get(CONFERENCE_FEE).isString().stringValue()), false);
        }
        if (entity.get(TOTAL_COST_OF_BANQUET) != null) {
            totalCostOfBanquet.setValue(new BigDecimal(entity.get(TOTAL_COST_OF_BANQUET).isString().stringValue()), false);
        }
        if (entity.get(OTHER_EXPENCES) != null) {
            otherExpences.setValue(new BigDecimal(entity.get(OTHER_EXPENCES).isString().stringValue()), false);
        }
        if (entity.get(FOOD_EXPENSE_PAYMENT_TYPE) != null) {
            foodExpensePaymentMode.selectValue(entity.get(FOOD_EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
        if (entity.get(CONFERENCE_EXPENSE_PAYMENT_TYPE) != null) {
            conferenceExpensePaymentMode.selectValue(entity.get(CONFERENCE_EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
        if (entity.get(BANQUET_EXPENSE_PAYMENT_TYPE) != null) {
            banquetExpensePaymentMode.selectValue(entity.get(BANQUET_EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
        if (entity.get(OTHER_EXPENSE_PAYMENT_TYPE) != null) {
            otherExpensePaymentMode.selectValue(entity.get(OTHER_EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (totalCostOfFood.getCurrency() != null) {
            entity.put(TOTAL_COST_OF_FOOD, new JSONString(totalCostOfFood.getCurrency().toString()));
        }
        if (conferenceFee.getCurrency() != null) {
            entity.put(CONFERENCE_FEE, new JSONString(conferenceFee.getCurrency().toString()));
        }
        if (totalCostOfBanquet.getCurrency() != null) {
            entity.put(TOTAL_COST_OF_BANQUET, new JSONString(totalCostOfBanquet.getCurrency().toString()));
        }
        if (otherExpences.getCurrency() != null) {
            entity.put(OTHER_EXPENCES, new JSONString(otherExpences.getCurrency().toString()));
        }
        if (foodExpensePaymentMode.getValue() != null) {
            entity.put(FOOD_EXPENSE_PAYMENT_TYPE, new JSONString(foodExpensePaymentMode.getValue()));
        }
        if (conferenceExpensePaymentMode.getValue() != null) {
            entity.put(CONFERENCE_EXPENSE_PAYMENT_TYPE, new JSONString(conferenceExpensePaymentMode.getValue()));
        }
        if (banquetExpensePaymentMode.getValue() != null) {
            entity.put(BANQUET_EXPENSE_PAYMENT_TYPE, new JSONString(banquetExpensePaymentMode.getValue()));
        }
        if (otherExpensePaymentMode.getValue() != null) {
            entity.put(OTHER_EXPENSE_PAYMENT_TYPE, new JSONString(otherExpensePaymentMode.getValue()));
        }
        return entity;
    }

    @Override
    public void onClick(ClickEvent event) {
    }

    @Override
    public void onBlur(BlurEvent event) {
        onChange();
    }

    protected void onChange() {

    }

}

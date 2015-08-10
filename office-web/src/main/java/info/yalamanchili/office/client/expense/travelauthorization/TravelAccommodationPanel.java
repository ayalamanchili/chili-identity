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
public class TravelAccommodationPanel extends ALComposite implements ClickHandler, BlurHandler {

    protected FlowPanel panel = new FlowPanel();

    CurrencyField numberOfLodgingNights;
    CurrencyField lodgingCostPerNight;
    CurrencyField totalLodgingCost;
    //
    EnumField expenseAccommodationPaymentType;

    boolean readyOnly;
    JSONObject entity;

    public TravelAccommodationPanel(boolean readOnly) {
        this.readyOnly = readOnly;
        init(panel);
    }

    public TravelAccommodationPanel(JSONObject entity, boolean readOnly) {
        this.readyOnly = readOnly;
        this.entity = entity;
        init(panel);
        populateFields();
    }

    @Override
    protected void addListeners() {
        numberOfLodgingNights.getTextbox().addBlurHandler(this);
        lodgingCostPerNight.getTextbox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        numberOfLodgingNights.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        lodgingCostPerNight.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        totalLodgingCost.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        expenseAccommodationPaymentType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        numberOfLodgingNights = new CurrencyField(OfficeWelcome.constants,
                NUM_OF_LODGING_NIGHTS, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        lodgingCostPerNight = new CurrencyField(OfficeWelcome.constants,
                LODGING_COST_PER_NIGHT, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalLodgingCost = new CurrencyField(OfficeWelcome.constants,
                TOTAL_LODGING_COST, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        expenseAccommodationPaymentType = new EnumField(OfficeWelcome.constants,
                EXPENSE_ACCOMMODATION_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        totalLodgingCost.getElement().getStyle().setProperty("float", "left");
        panel.add(numberOfLodgingNights);
        panel.add(lodgingCostPerNight);
        panel.add(totalLodgingCost);
        panel.add(expenseAccommodationPaymentType);
    }

    protected final void populateFields() {
        if (entity.get(NUM_OF_LODGING_NIGHTS) != null) {
            numberOfLodgingNights.setValue(new BigDecimal(entity.get(NUM_OF_LODGING_NIGHTS).isString().stringValue()), false);
        }
        if (entity.get(LODGING_COST_PER_NIGHT) != null) {
            lodgingCostPerNight.setValue(new BigDecimal(entity.get(LODGING_COST_PER_NIGHT).isString().stringValue()), false);
        }
        if (entity.get(TOTAL_LODGING_COST) != null) {
            totalLodgingCost.setValue(new BigDecimal(entity.get(TOTAL_LODGING_COST).isString().stringValue()), false);
        }
        if (entity.get(EXPENSE_ACCOMMODATION_PAYMENT_TYPE) != null) {
            expenseAccommodationPaymentType.selectValue(entity.get(EXPENSE_ACCOMMODATION_PAYMENT_TYPE).isString().stringValue());
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (numberOfLodgingNights.getCurrency() != null) {
            entity.put(NUM_OF_LODGING_NIGHTS, new JSONString(numberOfLodgingNights.getCurrency().toString()));
        }
        if (lodgingCostPerNight.getCurrency() != null) {
            entity.put(LODGING_COST_PER_NIGHT, new JSONString(lodgingCostPerNight.getCurrency().toString()));
        }
        if (totalLodgingCost.getCurrency() != null) {
            entity.put(TOTAL_LODGING_COST, new JSONString(totalLodgingCost.getCurrency().toString()));
        }
        if (expenseAccommodationPaymentType.getValue() != null) {
            entity.put(EXPENSE_ACCOMMODATION_PAYMENT_TYPE, new JSONString(expenseAccommodationPaymentType.getValue()));
        }
        return entity;
    }

    @Override
    public void onClick(ClickEvent event) {

    }

    @Override
    public void onBlur(BlurEvent event) {
        if (numberOfLodgingNights.getCurrency() != null && lodgingCostPerNight.getCurrency() != null) {
            totalLodgingCost.setValue(lodgingCostPerNight.getCurrency().multiply(numberOfLodgingNights.getCurrency()).setScale(2), readyOnly);
        }
        onChange();
    }

    protected void onChange() {

    }
}

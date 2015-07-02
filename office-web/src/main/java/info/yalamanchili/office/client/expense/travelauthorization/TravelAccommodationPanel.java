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
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class TravelAccommodationPanel extends ALComposite implements ClickHandler, BlurHandler {

    protected FlowPanel panel = new FlowPanel();

    IntegerField noOfLodgingDays;
    CurrencyField lodgingCostPerDay;
    CurrencyField totalLodgingCost;
    //
    EnumField lodgingExpensePaymentMode;
    
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
        noOfLodgingDays.getTextbox().addBlurHandler(this);
        lodgingCostPerDay.getTextbox().addBlurHandler(this);
    }

    @Override
    protected void configure() {
        noOfLodgingDays.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        lodgingCostPerDay.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        totalLodgingCost.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        lodgingExpensePaymentMode.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        noOfLodgingDays = new IntegerField(OfficeWelcome.constants,
                NUM_OF_LODGING_NIGHTS, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        lodgingCostPerDay = new CurrencyField(OfficeWelcome.constants,
                LODGING_COST_PER_NIGHT, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalLodgingCost = new CurrencyField(OfficeWelcome.constants,
                TOTAL_LODGING_COST, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        lodgingExpensePaymentMode = new EnumField(OfficeWelcome.constants,
                EXPENSE_PAYMENT_TYPE, "TravelAuthorizationLodging", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        totalLodgingCost.getElement().getStyle().setProperty("float", "left");
        panel.add(noOfLodgingDays);
        panel.add(lodgingCostPerDay);
        panel.add(totalLodgingCost);
        panel.add(lodgingExpensePaymentMode);
    }

    protected final void populateFields() {
        if (entity.get(NUM_OF_LODGING_NIGHTS) != null) {
            noOfLodgingDays.setInteger(Integer.valueOf(entity.get(NUM_OF_LODGING_NIGHTS).isString().stringValue()));
        }
        if (entity.get(NUM_OF_LODGING_NIGHTS) != null) {
            lodgingCostPerDay.setValue(new BigDecimal(entity.get(LODGING_COST_PER_NIGHT).isString().stringValue()), true);
        }
        if (entity.get(TOTAL_LODGING_COST) != null) {
            totalLodgingCost.setValue(new BigDecimal(entity.get(TOTAL_LODGING_COST).isString().stringValue()), true);
        }
        if (entity.get(EXPENSE_PAYMENT_TYPE) != null) {
            lodgingExpensePaymentMode.selectValue(entity.get(EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (noOfLodgingDays.getInteger() != null) {
            entity.put(NUM_OF_LODGING_NIGHTS, new JSONString(noOfLodgingDays.getInteger().toString()));
        }
        if (lodgingCostPerDay.getCurrency() != null) {
            entity.put(NUM_OF_LODGING_NIGHTS, new JSONString(lodgingCostPerDay.getCurrency().toString()));
        }
        if (totalLodgingCost.getCurrency() != null) {
            entity.put(TOTAL_LODGING_COST, new JSONString(totalLodgingCost.getCurrency().toString()));
        }
        if (lodgingExpensePaymentMode.getValue() != null) {
            entity.put(EXPENSE_PAYMENT_TYPE, new JSONString(lodgingExpensePaymentMode.getValue()));
        }
        return entity;
    }

    @Override
    public void onClick(ClickEvent event) {

    }
    
    @Override
    public void onBlur(BlurEvent event) {
        if (noOfLodgingDays.getInteger() != null && lodgingCostPerDay.getCurrency() != null) {
            totalLodgingCost.setValue(lodgingCostPerDay.getCurrency().multiply(BigDecimal.valueOf(noOfLodgingDays.getInteger())), readyOnly);
        }
    }
}

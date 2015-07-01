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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.OfficeWelcome;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class TravelFoodPanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();

    CurrencyField totalCostOfFood;
    CurrencyField conferenceFee;
    CurrencyField totalCostOfBanquet;
    CurrencyField otherExpences;

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
        updateFoodPaymentType.addClickHandler(this);
        updateConferencePaymentType.addClickHandler(this);
        updateBanquetPaymentType.addClickHandler(this);
        updateOtherExpencesPaymentType.addClickHandler(this);
    }

    @Override
    protected void configure() {
        totalCostOfFood.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        conferenceFee.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        totalCostOfBanquet.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        otherExpences.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        totalCostOfFood = new CurrencyField(OfficeWelcome.constants,
                TravelAuthConstants.TOTAL_COST_OF_FOOD, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        conferenceFee = new CurrencyField(OfficeWelcome.constants,
                "conferenceFee", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalCostOfBanquet = new CurrencyField(OfficeWelcome.constants,
                "totalCostOfBanquet", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        otherExpences = new CurrencyField(OfficeWelcome.constants,
                "otherExpences", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        renderUpdatePaymentTypeLink();
        panel.add(totalCostOfFood);
        panel.add(conferenceFee);
        panel.add(totalCostOfBanquet);
        panel.add(otherExpences);
    }

    protected final void populateFields() {
        if (entity.get(TravelAuthConstants.TOTAL_COST_OF_FOOD) != null) {
            totalCostOfFood.setValue(new BigDecimal(entity.get(TravelAuthConstants.TOTAL_COST_OF_FOOD).isString().stringValue()), true);
        }
        if (entity.get("conferenceFee") != null) {
            conferenceFee.setValue(new BigDecimal(entity.get("conferenceFee").isString().stringValue()), true);
        }
        if (entity.get("totalCostOfBanquet") != null) {
            totalCostOfBanquet.setValue(new BigDecimal(entity.get("totalCostOfBanquet").isString().stringValue()), true);
        }
        if (entity.get("otherExpences") != null) {
            otherExpences.setValue(new BigDecimal(entity.get("otherExpences").isString().stringValue()), true);
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (totalCostOfFood.getCurrency() != null) {
            entity.put(TravelAuthConstants.TOTAL_COST_OF_FOOD, new JSONString(totalCostOfFood.getCurrency().toString()));
        }
        if (conferenceFee.getCurrency() != null) {
            entity.put("conferenceFee", new JSONString(conferenceFee.getCurrency().toString()));
        }
        if (totalCostOfBanquet.getCurrency() != null) {
            entity.put("totalCostOfBanquet", new JSONString(totalCostOfBanquet.getCurrency().toString()));
        }
        if (otherExpences.getCurrency() != null) {
            entity.put("otherExpences", new JSONString(otherExpences.getCurrency().toString()));
        }
        return entity;
    }

    ClickableImage updateFoodPaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());
    ClickableImage updateConferencePaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());
    ClickableImage updateBanquetPaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());
    ClickableImage updateOtherExpencesPaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());

    protected void renderUpdatePaymentTypeLink() {
        BaseField paymentTypeField = totalCostOfFood;
        paymentTypeField.addWidgetToFieldPanel(updateFoodPaymentType);
        paymentTypeField = conferenceFee;
        paymentTypeField.addWidgetToFieldPanel(updateConferencePaymentType);
        paymentTypeField = totalCostOfBanquet;
        paymentTypeField.addWidgetToFieldPanel(updateBanquetPaymentType);
        paymentTypeField = otherExpences;
        paymentTypeField.addWidgetToFieldPanel(updateOtherExpencesPaymentType);
    }

    @Override
    public void onClick(ClickEvent event) {
        if ((event.getSource().equals(updateFoodPaymentType)) || (event.getSource().equals(updateConferencePaymentType))
                || (event.getSource().equals(updateBanquetPaymentType)) || (event.getSource().equals(updateOtherExpencesPaymentType))) {
            new GenericPopup(new ExpensePaymentModePanel(false)).show();
        }
    }
}

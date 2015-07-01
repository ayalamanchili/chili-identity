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
import info.chili.gwt.fields.IntegerField;
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
public class TravelAccommodationPanel extends ALComposite implements ClickHandler {

    protected FlowPanel panel = new FlowPanel();

    IntegerField noOfLodgingDays;
    CurrencyField lodgingCostPerDay;
    CurrencyField totalLodgingCost;

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
        updatePaymentType.addClickHandler(this);
    }

    @Override
    protected void configure() {
        noOfLodgingDays.getLabel().getElement().getStyle().setWidth(340, Style.Unit.PX);
        lodgingCostPerDay.getLabel().getElement().getStyle().setWidth(340, Style.Unit.PX);
        totalLodgingCost.getLabel().getElement().getStyle().setWidth(340, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        noOfLodgingDays = new IntegerField(OfficeWelcome.constants,
                "numberOfLodgingNights", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        lodgingCostPerDay = new CurrencyField(OfficeWelcome.constants,
                "lodgingCostPerNight", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalLodgingCost = new CurrencyField(OfficeWelcome.constants,
                TravelAuthConstants.TOTAL_LODGING_COST, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        renderUpdatePaymentTypeLink();
        panel.add(noOfLodgingDays);
        panel.add(lodgingCostPerDay);
        panel.add(totalLodgingCost);
    }

    protected final void populateFields() {
        if (entity.get("noOfLodgingDays") != null) {
            noOfLodgingDays.setInteger(Integer.valueOf(entity.get("noOfLodgingDays").isString().stringValue()));
        }
        if (entity.get("lodgingCostPerNight") != null) {
            lodgingCostPerDay.setValue(new BigDecimal(entity.get("lodgingCostPerNight").isString().stringValue()), true);
        }
        if (entity.get(TravelAuthConstants.TOTAL_LODGING_COST) != null) {
            totalLodgingCost.setValue(new BigDecimal(entity.get(TravelAuthConstants.TOTAL_LODGING_COST).isString().stringValue()), true);
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (noOfLodgingDays.getInteger() != null) {
            entity.put("noOfLodgingDays", new JSONString(noOfLodgingDays.getInteger().toString()));
        }
        if (lodgingCostPerDay.getCurrency() != null) {
            entity.put("lodgingCostPerNight", new JSONString(lodgingCostPerDay.getCurrency().toString()));
        }
        if (totalLodgingCost.getCurrency() != null) {
            entity.put(TravelAuthConstants.TOTAL_LODGING_COST, new JSONString(totalLodgingCost.getCurrency().toString()));
        }
        return entity;
    }

    ClickableImage updatePaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());

    protected void renderUpdatePaymentTypeLink() {
        BaseField paymentTypeField = totalLodgingCost;
        paymentTypeField.addWidgetToFieldPanel(updatePaymentType);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updatePaymentType)) {
            new GenericPopup(new ExpensePaymentModePanel(false)).show();
        }
    }
}

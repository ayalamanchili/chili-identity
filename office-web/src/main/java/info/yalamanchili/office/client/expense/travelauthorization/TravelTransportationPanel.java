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
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
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
import info.chili.gwt.fields.StringField;
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
public class TravelTransportationPanel extends ALComposite implements ChangeHandler, BlurHandler, ClickHandler{

    protected FlowPanel panel = new FlowPanel();
    EnumField travelTransportationType;
    IntegerField totalMiles;
    CurrencyField costPerMile;
    CurrencyField totalTransportationCost;
    CurrencyField estimatedCostOfOtherTransportation;
    StringField rentalVehicleJustification;
    EnumField travelRentalVehicleType;
    StringField otherVehicleTypeJustification;

    boolean readyOnly;
    JSONObject entity;
    TravelTransportationType type;

    public TravelTransportationPanel(boolean readOnly) {
        this.readyOnly = readOnly;
        init(panel);
    }

    public TravelTransportationPanel(JSONObject entity, boolean readOnly) {
        this.readyOnly = readOnly;
        this.entity = entity;
        init(panel);
        populateFields();
    }

    @Override
    protected void addListeners() {
        travelTransportationType.listBox.addChangeHandler(this);
        costPerMile.getTextbox().addBlurHandler(this);
        totalMiles.getTextbox().addBlurHandler(this);
        estimatedCostOfOtherTransportation.getTextbox().addBlurHandler(this);
        rentalVehicleJustification.getTextbox().addBlurHandler(this);
        travelRentalVehicleType.listBox.addChangeHandler(this);
        otherVehicleTypeJustification.getTextbox().addBlurHandler(this);
        updatePaymentType.addClickHandler(this);
    }

    @Override
    protected void configure() {
        travelTransportationType.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        totalMiles.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        costPerMile.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        totalTransportationCost.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        estimatedCostOfOtherTransportation.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        rentalVehicleJustification.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        travelRentalVehicleType.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        otherVehicleTypeJustification.getLabel().getElement().getStyle().setWidth(TravelAuthConstants.defaultFieldWidth, Style.Unit.PX);
        if (!readyOnly) {
            renderMiles(false);
            renderRentalJustification(false);
        }
    }

    @Override
    protected void addWidgets() {
        travelTransportationType = new EnumField(OfficeWelcome.constants, 
                "travelTransportationType", "TravelAuthorization", readyOnly, false, TravelTransportationType.names(), Alignment.HORIZONTAL);
        totalMiles = new IntegerField(OfficeWelcome.constants,
                "totalMiles", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        costPerMile = new CurrencyField(OfficeWelcome.constants,
                "costPerMile", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalTransportationCost = new CurrencyField(OfficeWelcome.constants,
                TravelAuthConstants.TOTAL_TRANSPORTATION_COST, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        renderUpdatePaymentTypeLink();
        estimatedCostOfOtherTransportation = new CurrencyField(OfficeWelcome.constants,
                "estimatedCostOfOtherTransportation", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        rentalVehicleJustification = new StringField(OfficeWelcome.constants,
                "rentalVehicleJustification", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        travelRentalVehicleType = new EnumField(OfficeWelcome.constants, 
                "travelRentalVehicleType", "TravelAuthorization", readyOnly, false, TravelRentalVehicleType.names(), Alignment.HORIZONTAL);
        otherVehicleTypeJustification = new StringField(OfficeWelcome.constants,
                "otherVehicleTypeJustification", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        panel.add(travelTransportationType);
        panel.add(totalMiles);
        panel.add(costPerMile);
        panel.add(totalTransportationCost);
        panel.add(estimatedCostOfOtherTransportation);
        panel.add(rentalVehicleJustification);
        panel.add(travelRentalVehicleType);
        panel.add(otherVehicleTypeJustification);
    }

    protected final void populateFields() {
        if (entity.get("totalMiles") != null) {
            totalMiles.setInteger(Integer.valueOf(entity.get("totalMiles").isString().stringValue()));
        }
        if (entity.get("costPerMile") != null) {
            costPerMile.setValue(new BigDecimal(entity.get("costPerMile").isString().stringValue()), true);
        }
        if (entity.get(TravelAuthConstants.TOTAL_TRANSPORTATION_COST) != null) {
            totalTransportationCost.setValue(new BigDecimal(entity.get(TravelAuthConstants.TOTAL_TRANSPORTATION_COST).isString().stringValue()), true);
        }
        if (entity.get("estimatedCostOfOtherTransportation") != null) {
            estimatedCostOfOtherTransportation.setValue(new BigDecimal(entity.get("estimatedCostOfOtherTransportation").isString().stringValue()), true);
        }
        if (entity.get("rentalVehicleJustification") != null) {
            rentalVehicleJustification.setValue("rentalVehicleJustification");
        }
        if (entity.get("otherVehicleTypeJustification") != null) {
            otherVehicleTypeJustification.setValue("otherVehicleTypeJustification");
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (travelTransportationType.getValue() != null) {
            entity.put("travelTransportationType", new JSONString(travelTransportationType.getValue()));
        }
        if (totalMiles.getInteger() != null) {
            entity.put("totalMiles", new JSONString(totalMiles.getInteger().toString()));
        }
        if (costPerMile.getCurrency() != null) {
            entity.put("costPerMile", new JSONString(costPerMile.getCurrency().toString()));
        }
        if (totalTransportationCost.getCurrency() != null) {
            entity.put(TravelAuthConstants.TOTAL_TRANSPORTATION_COST, new JSONString(totalTransportationCost.getCurrency().toString()));
        }
        if (estimatedCostOfOtherTransportation.getCurrency() != null) {
            entity.put("estimatedCostOfOtherTransportation", new JSONString(estimatedCostOfOtherTransportation.getCurrency().toString()));
        }
        if (rentalVehicleJustification.getValue() != null) {
            entity.put("rentalVehicleJustification", new JSONString(rentalVehicleJustification.getValue()));
        }
        if (travelRentalVehicleType.getValue() != null) {
            entity.put("travelRentalVehicleType", new JSONString(travelRentalVehicleType.getValue()));
        }
        if (otherVehicleTypeJustification.getValue() != null) {
            entity.put("otherVehicleTypeJustification", new JSONString(otherVehicleTypeJustification.getValue()));
        }
        return entity;
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (travelTransportationType.getValue().equals(TravelTransportationType.AIR.name())) {
            renderMiles(false);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.BUS.name())) {
            renderMiles(false);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.RAILWAY.name())) {
            renderMiles(false);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.COMPANY_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.PRIVATE_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.RENTAL_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(true);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.OTHER.name())) {
            renderMiles(false);
            renderRentalJustification(false);
        }
    }

    protected void renderMiles(boolean render) {
        costPerMile.setVisible(render);
        totalMiles.setVisible(render);
    }
    
    protected void renderRentalJustification(boolean render) {
        estimatedCostOfOtherTransportation.setVisible(render);
        rentalVehicleJustification.setVisible(render);
        travelRentalVehicleType.setVisible(render);
        otherVehicleTypeJustification.setVisible(render);
    }
    
    ClickableImage updatePaymentType = new ClickableImage("Select Expense Payment Type", ChiliImages.INSTANCE.updateIcon_16_16());

    protected void renderUpdatePaymentTypeLink() {
        BaseField paymentTypeField = totalTransportationCost;
        paymentTypeField.addWidgetToFieldPanel(updatePaymentType);
    }
    

    @Override
    public void onClick(ClickEvent event) {
//        super.onClick(event);
        if (event.getSource().equals(updatePaymentType)) {
            new GenericPopup(new ExpensePaymentTypePanel(false)).show();
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (totalMiles.getInteger() != null && costPerMile.getCurrency() != null) {
            totalTransportationCost.setValue(costPerMile.getCurrency().multiply(BigDecimal.valueOf(totalMiles.getInteger())), readyOnly);
        }
    }
}

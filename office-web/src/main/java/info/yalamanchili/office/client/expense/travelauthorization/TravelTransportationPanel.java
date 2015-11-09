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
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import static info.yalamanchili.office.client.expense.travelauthorization.TravelAuthConstants.*;
import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TravelTransportationPanel extends ALComposite implements ChangeHandler, BlurHandler, ClickHandler {

    private static Logger logger = Logger.getLogger(TravelTransportationPanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    BooleanField showAllTransportationOptions = new BooleanField(OfficeWelcome.constants, "showAllTravalTransportationOptions", "TravelAuthorization", false, false, Alignment.HORIZONTAL);
    EnumField travelTransportationType;
    CurrencyField totalMiles;
    CurrencyField costPerMile;
    CurrencyField totalTransportationCost;
    CurrencyField estimatedCostOfOtherTransportation;
    TextAreaField rentalVehicleJustification;
    EnumField travelRentalVehicleType;
    TextAreaField otherVehicleTypeJustification;
    //
    EnumField expensePaymentType;
    EnumField expenseRentalPaymentType;
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
        showAllTransportationOptions.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        travelTransportationType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        totalMiles.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        costPerMile.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        totalTransportationCost.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        estimatedCostOfOtherTransportation.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        rentalVehicleJustification.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        travelRentalVehicleType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        otherVehicleTypeJustification.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        expensePaymentType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        expenseRentalPaymentType.getLabel().getElement().getStyle().setWidth(DEFAULT_FIELD_WIDTH, Style.Unit.PX);
        if (entity == null && !showAllTransportationOptions.getValue()) {
            renderMiles(false);
            renderRentalJustification(false);
        }
    }

    @Override
    protected void addWidgets() {
        travelTransportationType = new EnumField(OfficeWelcome.constants,
                TRAVEL_TRANSPORTATION_TYPE, "TravelAuthorization", readyOnly, false, TravelTransportationType.names(), Alignment.HORIZONTAL);
        totalMiles = new CurrencyField(OfficeWelcome.constants,
                TOTAL_MILES, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        costPerMile = new CurrencyField(OfficeWelcome.constants,
                COST_PER_MILE, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalTransportationCost = new CurrencyField(OfficeWelcome.constants,
                TOTAL_TRANSPORTATION_COST, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        expensePaymentType = new EnumField(OfficeWelcome.constants,
                EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        estimatedCostOfOtherTransportation = new CurrencyField(OfficeWelcome.constants,
                ESTIMATED_COST_OF_OTHER_TRANSPORTATION, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        rentalVehicleJustification = new TextAreaField(OfficeWelcome.constants,
                RENTAL_VEHICLE_JUSTIFICATION, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        travelRentalVehicleType = new EnumField(OfficeWelcome.constants,
                TRAVEL_RENTAL_VEHICLE_TYPE, "TravelAuthorization", readyOnly, false, TravelRentalVehicleType.names(), Alignment.HORIZONTAL);
        expenseRentalPaymentType = new EnumField(OfficeWelcome.constants,
                RENTAL_EXPENSE_PAYMENT_TYPE, "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        otherVehicleTypeJustification = new TextAreaField(OfficeWelcome.constants,
                OTHER_VEHICLE_TYPE_JUSTIFICATION, "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalTransportationCost.getElement().getStyle().setProperty("float", "left");
        estimatedCostOfOtherTransportation.getElement().getStyle().setProperty("float", "left");
        panel.add(travelTransportationType);
        panel.add(totalMiles);
        panel.add(costPerMile);
        panel.add(totalTransportationCost);
        panel.add(expensePaymentType);
        panel.add(rentalVehicleJustification);
        panel.add(estimatedCostOfOtherTransportation);
        panel.add(expenseRentalPaymentType);
        panel.add(travelRentalVehicleType);
        panel.add(otherVehicleTypeJustification);
        panel.add(showAllTransportationOptions);
    }

    protected final void populateFields() {
        logger.info(entity.toString());
        if (entity.get(TRAVEL_TRANSPORTATION_TYPE) != null) {
            travelTransportationType.selectValue(entity.get(TRAVEL_TRANSPORTATION_TYPE).isString().stringValue());
        }
        if (entity.get(TOTAL_MILES) != null) {
            totalMiles.setValue(new BigDecimal(entity.get(TOTAL_MILES).isString().stringValue()), false);
        }
        if (entity.get(COST_PER_MILE) != null) {
            costPerMile.setValue(new BigDecimal(entity.get(COST_PER_MILE).isString().stringValue()), false);
        }
        if (entity.get(TOTAL_TRANSPORTATION_COST) != null) {
            totalTransportationCost.setValue(new BigDecimal(entity.get(TOTAL_TRANSPORTATION_COST).isString().stringValue()), false);
        }
        if (entity.containsKey(TRAVEL_RENTAL_VEHICLE_JUSTIFICATION)) {
            JSONObject rentalVehicleJustificationObj = entity.get(TravelAuthConstants.TRAVEL_RENTAL_VEHICLE_JUSTIFICATION).isObject();
            if (rentalVehicleJustificationObj.get(ESTIMATED_COST_OF_OTHER_TRANSPORTATION) != null) {
                estimatedCostOfOtherTransportation.setValue(new BigDecimal(rentalVehicleJustificationObj.get(ESTIMATED_COST_OF_OTHER_TRANSPORTATION).isString().stringValue()), false);
            }
            if (rentalVehicleJustificationObj.get(RENTAL_VEHICLE_JUSTIFICATION) != null) {
                rentalVehicleJustification.setValue(rentalVehicleJustificationObj.get(RENTAL_VEHICLE_JUSTIFICATION).isString().stringValue());
            }
            if (rentalVehicleJustificationObj.get(RENTAL_EXPENSE_PAYMENT_TYPE) != null) {
                expenseRentalPaymentType.selectValue(rentalVehicleJustificationObj.get(RENTAL_EXPENSE_PAYMENT_TYPE).isString().stringValue());
            }
            if (rentalVehicleJustificationObj.get(TRAVEL_RENTAL_VEHICLE_TYPE) != null) {
                travelRentalVehicleType.selectValue(rentalVehicleJustificationObj.get(TRAVEL_RENTAL_VEHICLE_TYPE).isString().stringValue());
            }
            if (rentalVehicleJustificationObj.get(OTHER_VEHICLE_TYPE_JUSTIFICATION) != null) {
                otherVehicleTypeJustification.setValue(rentalVehicleJustificationObj.get(OTHER_VEHICLE_TYPE_JUSTIFICATION).isString().stringValue());
            }
            if (travelRentalVehicleType.getValue().equals(TravelRentalVehicleType.OTHER.name())) {
                otherVehicleTypeJustification.setVisible(true);
            } else {
                otherVehicleTypeJustification.setVisible(false);
            }
        }
        if (entity.get(EXPENSE_PAYMENT_TYPE) != null) {
            expensePaymentType.selectValue(entity.get(EXPENSE_PAYMENT_TYPE).isString().stringValue());
        }
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (travelTransportationType.getValue() != null) {
            entity.put(TRAVEL_TRANSPORTATION_TYPE, new JSONString(travelTransportationType.getValue()));
        }
        if (totalMiles.getCurrency() != null) {
            entity.put(TOTAL_MILES, new JSONString(totalMiles.getCurrency().toString()));
        }
        if (costPerMile.getCurrency() != null) {
            entity.put(COST_PER_MILE, new JSONString(costPerMile.getCurrency().toString()));
        }
        if (totalTransportationCost.getCurrency() != null) {
            entity.put(TOTAL_TRANSPORTATION_COST, new JSONString(totalTransportationCost.getCurrency().toString()));
        }
        if ((showAllTransportationOptions.getValue())
                || (estimatedCostOfOtherTransportation.getCurrency() != null)
                || (rentalVehicleJustification.getValue() != null)
                || (expenseRentalPaymentType.getValue() != null)
                || (travelRentalVehicleType.getValue() != null)
                || (otherVehicleTypeJustification.getValue() != null)) {
            entity.put(TRAVEL_RENTAL_VEHICLE_JUSTIFICATION, getRentalVehicalObj());
        }

        if (travelTransportationType.getValue().equals(TravelTransportationType.RENTAL_VEHICLE.name())) {
            entity.put(TRAVEL_RENTAL_VEHICLE_JUSTIFICATION, getRentalVehicalObj());
        }
        if (expensePaymentType.getValue() != null) {
            entity.put(EXPENSE_PAYMENT_TYPE, new JSONString(expensePaymentType.getValue()));
        }
        return entity;
    }

    public JSONObject getRentalVehicalObj() {
        JSONObject rentalVehicalObj = new JSONObject();
        if (estimatedCostOfOtherTransportation.getCurrency() != null) {
            rentalVehicalObj.put(ESTIMATED_COST_OF_OTHER_TRANSPORTATION, new JSONString(estimatedCostOfOtherTransportation.getCurrency().toString()));
        }
        if (rentalVehicleJustification.getValue() != null) {
            rentalVehicalObj.put(RENTAL_VEHICLE_JUSTIFICATION, new JSONString(rentalVehicleJustification.getValue()));
        }
        if (expenseRentalPaymentType.getValue() != null) {
            rentalVehicalObj.put(RENTAL_EXPENSE_PAYMENT_TYPE, new JSONString(expenseRentalPaymentType.getValue()));
        }
        if (travelRentalVehicleType.getValue() != null) {
            rentalVehicalObj.put(TRAVEL_RENTAL_VEHICLE_TYPE, new JSONString(travelRentalVehicleType.getValue()));
        }
        if (otherVehicleTypeJustification.getValue() != null) {
            rentalVehicalObj.put(OTHER_VEHICLE_TYPE_JUSTIFICATION, new JSONString(otherVehicleTypeJustification.getValue()));
        }
        return rentalVehicalObj;
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(travelTransportationType.listBox)) {
            if (travelTransportationType.getValue().equals(TravelTransportationType.AIR.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(false);
                renderRentalJustification(false);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.BUS.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(false);
                renderRentalJustification(false);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.RAILWAY.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(false);
                renderRentalJustification(false);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.COMPANY_VEHICLE.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(true);
                renderRentalJustification(false);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.PRIVATE_VEHICLE.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(true);
                renderRentalJustification(false);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.RENTAL_VEHICLE.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(true);
                renderRentalJustification(true);
            }
            if (travelTransportationType.getValue().equals(TravelTransportationType.OTHER.name()) && !showAllTransportationOptions.getValue()) {
                renderMiles(false);
                renderRentalJustification(false);
            }
        } else if (event.getSource().equals(travelRentalVehicleType.listBox) || showAllTransportationOptions.getValue()) {
            if (travelRentalVehicleType.getValue().equals(TravelRentalVehicleType.OTHER.name())) {
                otherVehicleTypeJustification.setVisible(true);
            } else {
                otherVehicleTypeJustification.setVisible(false);
            }
        }

    }

    protected void renderMiles(boolean render) {
        costPerMile.setVisible(render);
        totalMiles.setVisible(render);
    }

    protected void renderRentalJustification(boolean render) {
        estimatedCostOfOtherTransportation.setVisible(render);
        rentalVehicleJustification.setVisible(render);
        expenseRentalPaymentType.setVisible(render);
        travelRentalVehicleType.setVisible(render);
        otherVehicleTypeJustification.setVisible(false);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(showAllTransportationOptions.getBox())) {
            renderAllOptions(showAllTransportationOptions.getValue());
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.RENTAL_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(true);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.COMPANY_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.PRIVATE_VEHICLE.name())) {
            renderMiles(true);
            renderRentalJustification(false);
        }
    }

    protected void renderAllOptions(boolean render) {
        totalMiles.setVisible(render);
        costPerMile.setVisible(render);
        estimatedCostOfOtherTransportation.setVisible(render);
        rentalVehicleJustification.setVisible(render);
        expenseRentalPaymentType.setVisible(render);
        travelRentalVehicleType.setVisible(render);
        otherVehicleTypeJustification.setVisible(false);
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (totalMiles.getCurrency() != null && costPerMile.getCurrency() != null) {
            totalTransportationCost.setValue(costPerMile.getCurrency().multiply(totalMiles.getCurrency()).setScale(2), readyOnly);
        }
        onChange();
    }

    protected void onChange() {

    }
}

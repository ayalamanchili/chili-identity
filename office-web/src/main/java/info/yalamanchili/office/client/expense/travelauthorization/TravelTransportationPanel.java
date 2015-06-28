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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.TravelTransportationType;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class TravelTransportationPanel extends ALComposite implements ChangeHandler, BlurHandler {

    protected FlowPanel panel = new FlowPanel();
    EnumField travelTransportationType;
    IntegerField totalMiles;
    CurrencyField costPerMile;
    CurrencyField totalTransportationCost;

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
    }

    @Override
    protected void configure() {
        travelTransportationType.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        totalMiles.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        costPerMile.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        totalTransportationCost.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        if (!readyOnly) {
            renderMiles(false);
        }
    }

    @Override
    protected void addWidgets() {
        travelTransportationType = new EnumField(OfficeWelcome.constants, "travelTransportationType", "TravelAuthorization", readyOnly, false, TravelTransportationType.names(), Alignment.HORIZONTAL);
        totalMiles = new IntegerField(OfficeWelcome.constants,
                "totalMiles", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        costPerMile = new CurrencyField(OfficeWelcome.constants,
                "costPerMile", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalTransportationCost = new CurrencyField(OfficeWelcome.constants,
                "totalTransportationCost", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        panel.add(travelTransportationType);
        panel.add(totalMiles);
        panel.add(costPerMile);
        panel.add(totalTransportationCost);
    }

    protected final void populateFields() {
        if (entity.get("totalMiles") != null) {
            totalMiles.setInteger(Integer.valueOf(entity.get("totalMiles").isString().stringValue()));
        }
        if (entity.get("costPerMile") != null) {
            costPerMile.setValue(new BigDecimal(entity.get("costPerMile").isString().stringValue()), true);
        }
        if (entity.get("totalTransportationCost") != null) {
            totalTransportationCost.setValue(new BigDecimal(entity.get("totalTransportationCost").isString().stringValue()), true);
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
            entity.put("totalTransportationCost", new JSONString(totalTransportationCost.getCurrency().toString()));
        }
        return entity;
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (travelTransportationType.getValue().equals(TravelTransportationType.AIR.name())) {
            renderMiles(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.BUS.name())) {
            renderMiles(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.RAILWAY.name())) {
            renderMiles(false);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.COMPANY_VEHICLE.name())) {
            renderMiles(true);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.PRIVATE_VEHICLE.name())) {
            renderMiles(true);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.RENTAL_VEHICLE.name())) {
            renderMiles(true);
        }
        if (travelTransportationType.getValue().equals(TravelTransportationType.OTHER.name())) {
            renderMiles(false);
        }
    }

    protected void renderMiles(boolean render) {
        costPerMile.setVisible(render);
        totalMiles.setVisible(render);
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (totalMiles.getInteger() != null && costPerMile.getCurrency() != null) {
            totalTransportationCost.setValue(costPerMile.getCurrency().multiply(BigDecimal.valueOf(totalMiles.getInteger())), readyOnly);
        }
    }
}

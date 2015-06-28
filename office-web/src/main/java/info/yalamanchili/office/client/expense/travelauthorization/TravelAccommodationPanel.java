/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.math.BigDecimal;

/**
 *
 * @author ayalamanchili
 */
public class TravelAccommodationPanel extends ALComposite {

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

    }

    @Override
    protected void configure() {
        noOfLodgingDays.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        lodgingCostPerDay.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
        totalLodgingCost.getLabel().getElement().getStyle().setWidth(240, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        noOfLodgingDays = new IntegerField(OfficeWelcome.constants,
                "numberOfLodgingNights", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        lodgingCostPerDay = new CurrencyField(OfficeWelcome.constants,
                "lodgingCostPerNight", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);
        totalLodgingCost = new CurrencyField(OfficeWelcome.constants,
                "totalLodgingCost", "TravelAuthorization", readyOnly, false, Alignment.HORIZONTAL);

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
        if (entity.get("totalLodgingCost") != null) {
            totalLodgingCost.setValue(new BigDecimal(entity.get("totalLodgingCost").isString().stringValue()), true);
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
            entity.put("totalLodgingCost", new JSONString(totalLodgingCost.getCurrency().toString()));
        }
        return entity;
    }
}

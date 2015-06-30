/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.travelauthorization;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.travelauthorizationtransactions.ExpensePaymentType;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ExpensePaymentTypePanel extends ALComposite implements ChangeHandler {

    protected FlowPanel panel = new FlowPanel();
    EnumField expensePaymentType;

    boolean readyOnly;
    JSONObject entity;
    ExpensePaymentType type;

    public ExpensePaymentTypePanel(boolean readOnly) {
        this.readyOnly = readOnly;
        init(panel);
    }

    public ExpensePaymentTypePanel(JSONObject entity, boolean readOnly) {
        this.readyOnly = readOnly;
        this.entity = entity;
        init(panel);
    }

    @Override
    protected void addListeners() {
        expensePaymentType.listBox.addChangeHandler(this);
    }

    @Override
    protected void configure() {
        expensePaymentType.getLabel().getElement().getStyle().setWidth(340, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        expensePaymentType = new EnumField(OfficeWelcome.constants,
                "expensePaymentType", "TravelAuthorization", readyOnly, false, ExpensePaymentType.names(), Alignment.HORIZONTAL);
        panel.add(expensePaymentType);
    }

    public JSONObject getObject() {
        entity = new JSONObject();
        if (expensePaymentType.getValue() != null) {
            entity.put("expensePaymentType", new JSONString(expensePaymentType.getValue()));
        }

        return entity;
    }

    @Override
    public void onChange(ChangeEvent event) {
    }

}

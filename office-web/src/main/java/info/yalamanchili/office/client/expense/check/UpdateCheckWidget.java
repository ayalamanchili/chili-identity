/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.check;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.address.UpdateAddressWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateCheckWidget extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateCheckWidget.class.getName());

    public enum UpdateCheckWidgetType {

        CHECK_MAILING_INFO, CHECK_PAYMENT_INFO
    }
    UpdateCheckWidgetType type;

    UpdateAddressWidget updateAddressWidget;

    public UpdateCheckWidget(UpdateCheckWidgetType type, JSONObject entity) {
        this.type = type;
        initUpdateComposite(entity, "Check", OfficeWelcome.constants);
        update.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        assignEntityValueFromField("payableTo", entity);
        assignEntityValueFromField("checkAmount", entity);
        assignEntityValueFromField("checkDate", entity);
        if (UpdateCheckWidgetType.CHECK_PAYMENT_INFO.equals(type)) {
            assignEntityValueFromField("bankName", entity);
            assignEntityValueFromField("bankRoutingNumber", entity);
            assignEntityValueFromField("bankAccountNumber", entity);
            assignEntityValueFromField("checkNumber", entity);
        }
        assignEntityValueFromField("notes", entity);
        if (updateAddressWidget != null) {
            entity.put("checkMalingAddress", updateAddressWidget.populateEntityFromFields());
        }
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
    }

    @Override
    protected void postUpdateSuccess(String result) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("payableTo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("checkAmount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("checkDate", entity, DataType.CURRENCY_FIELD);
        if (UpdateCheckWidgetType.CHECK_PAYMENT_INFO.equals(type)) {
            assignFieldValueFromEntity("bankName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("bankRoutingNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("bankAccountNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("checkNumber", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        if (entity.containsKey("checkMalingAddress")) {
            updateAddressWidget = new UpdateAddressWidget(entity.get("checkMalingAddress").isObject(), UpdateAddressPanel.UpdateAddressPanelType.MIN);
            entityFieldsPanel.add(updateAddressWidget);
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("payableTo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("checkAmount", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("checkDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (UpdateCheckWidgetType.CHECK_PAYMENT_INFO.equals(type)) {
            addField("bankName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("bankRoutingNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("bankAccountNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("checkNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return "";
    }
}

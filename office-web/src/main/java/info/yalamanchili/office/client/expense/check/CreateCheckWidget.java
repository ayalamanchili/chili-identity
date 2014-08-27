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
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class CreateCheckWidget extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreateCheckWidget.class.getName());

    public enum CreateCheckWidgetType {

        CHECK_MAILING_INFO, CHECK_PAYMENT_INFO
    }
    CreateCheckWidgetType type;
    CreateAddressWidget createAddressWidget = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);

    public CreateCheckWidget(CreateCheckWidgetType type) {
        super(CreateCompositeType.CREATE);
        this.type = type;
        initCreateComposite("Check", OfficeWelcome.constants);
        create.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("payableTo", entity);
        assignEntityValueFromField("checkAmount", entity);
        assignEntityValueFromField("checkDate", entity);
        if (CreateCheckWidgetType.CHECK_PAYMENT_INFO.equals(type)) {
            assignEntityValueFromField("bankName", entity);
            assignEntityValueFromField("bankRoutingNumber", entity);
            assignEntityValueFromField("bankAccountNumber", entity);
            assignEntityValueFromField("checkNumber", entity);
        }
        assignEntityValueFromField("notes", entity);
        entity.put("checkMalingAddress", createAddressWidget.populateEntityFromFields());
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {

    }

    @Override
    protected void postCreateSuccess(String result) {
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
        addField("payableTo", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("checkAmount", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("checkDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (CreateCheckWidgetType.CHECK_PAYMENT_INFO.equals(type)) {
            addField("bankName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("bankRoutingNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("bankAccountNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("checkNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(createAddressWidget);
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

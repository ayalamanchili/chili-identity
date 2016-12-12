/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.bnkacct;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateBankAcctWidget extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateBankAcctWidget.class.getName());

    public UpdateBankAcctWidget(JSONObject entity) {
        initUpdateComposite(entity, "BankAccount", OfficeWelcome.constants);
        update.setVisible(false);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        assignEntityValueFromField("accountFirstName", entity);
        assignEntityValueFromField("accountLastName", entity);
        assignEntityValueFromField("bankName", entity);
        assignEntityValueFromField("bankRoutingNumber", entity);
        assignEntityValueFromField("bankAccountNumber", entity);
        assignEntityValueFromField("accountType", entity);
        assignEntityValueFromField("achBlocked", entity);
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
        assignFieldValueFromEntity("accountFirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountLastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankRoutingNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAccountNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountType", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("achBlocked", entity, DataType.STRING_FIELD);
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
        addField("accountFirstName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        addField("achBlocked", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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

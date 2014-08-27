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
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadBankAcctWidget extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadBankAcctWidget.class.getName());

    public ReadBankAcctWidget(JSONObject entity) {
        initReadComposite(entity, "BankAccount", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("accountFirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountLastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankRoutingNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("bankAccountNumber", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("accountFirstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }
}

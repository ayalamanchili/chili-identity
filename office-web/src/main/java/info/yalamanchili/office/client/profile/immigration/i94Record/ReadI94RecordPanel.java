/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.i94Record;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadI94RecordPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadI94RecordPanel.class.getName());

    public ReadI94RecordPanel(JSONObject entity) {
        initReadComposite(entity, "i94Record", OfficeWelcome.constants2);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("i94RecordNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateofEntry", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("admitUntilDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("portOfEntry", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("classOfAdmission", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("i94RecordNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateofEntry", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("admitUntilDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("portOfEntry", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("classOfAdmission", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return null;
    }

    @Override
    public void loadEntity(String entityId) {

    }
}

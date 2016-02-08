/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadLCAPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadPassportPanel.class.getName());

    public ReadLCAPanel(JSONObject entity) {
        initReadComposite(entity, "LCA", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("entity ree: " + entity);
        assignFieldValueFromEntity("lcaNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidToDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        if (entity.get("lcaAddress1") != null) {
            JSONObject lcaAddress1 = entity.get("lcaAddress1").isObject();
            assignFieldValueFromEntity("street1", lcaAddress1, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", lcaAddress1, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", lcaAddress1, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", lcaAddress1, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", lcaAddress1, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", lcaAddress1, DataType.LONG_FIELD);
        }
        if (entity.get("lcaAddress2") != null) {
            JSONObject lcaAddress2 = entity.get("lcaAddress2").isObject();
            assignFieldValueFromEntity("street1", lcaAddress2, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", lcaAddress2, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", lcaAddress2, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", lcaAddress2, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", lcaAddress2, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", lcaAddress2, DataType.LONG_FIELD);
        }
        assignFieldValueFromEntity("lcaCurrWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaCurrMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaCurrMaxWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaPrevMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevMaxWage", entity, DataType.CURRENCY_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("lcaNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidFromDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("LCA Location-1"));
        addField("street1", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", true, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Add LCA Location-2"));
        addField("street1", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", true, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Wages Information"));
        addEnumField("lcaCurrWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("lcaPrevWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaPrevMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaPrevMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
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

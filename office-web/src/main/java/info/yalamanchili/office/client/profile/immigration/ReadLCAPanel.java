/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.ReadComposite;
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
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    ReadLCAAddressWidget readAddressWidget1;
    ReadLCAAddressWidget readAddressWidget2;

    public ReadLCAPanel(JSONObject entity) {
        initReadComposite(entity, "LCA", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("lcaNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidToDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("withdrawnLCANumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaCurrWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaCurrMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaCurrMaxWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaPrevMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaPrevMaxWage", entity, DataType.CURRENCY_FIELD);
        if (entity.containsKey("lcaAddress1")) {
            entityFieldsPanel.add(lcaAddress1);
            readAddressWidget1 = new ReadLCAAddressWidget(entity.get("lcaAddress1").isObject());
            entityFieldsPanel.add(readAddressWidget1);
        }
        if (entity.containsKey("lcaAddress2")) {
            entityFieldsPanel.add(lcaAddress2);
            readAddressWidget2 = new ReadLCAAddressWidget(entity.get("lcaAddress2").isObject());
            entityFieldsPanel.add(readAddressWidget2);
        }
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
        addField("withdrawnLCANumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(wagesInfo);
        addEnumField("lcaCurrWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("lcaPrevWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaPrevMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaPrevMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
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

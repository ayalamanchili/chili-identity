/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.check;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.ReadAddressPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadCheckWidget extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadCheckWidget.class.getName());

    public ReadCheckWidget(JSONObject entity) {
        initReadComposite(entity, "Check", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info(entity.toString());
        assignFieldValueFromEntity("payableTo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("checkAmount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        if (entity.containsKey("checkMalingAddress")) {
            logger.info(entity.get("checkMalingAddress").isObject().toString());
            entityFieldsPanel.add(new ReadAddressPanel(entity.get("checkMalingAddress").isObject()));
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
        addField("payableTo", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("checkAmount", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
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

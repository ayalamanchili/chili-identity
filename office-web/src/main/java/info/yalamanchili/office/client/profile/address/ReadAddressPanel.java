/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadAddressPanel extends ReadComposite {

    private static ReadAddressPanel instance;
    private static Logger logger = Logger.getLogger(ReadAddressPanel.class.getName());

    public static ReadAddressPanel instance() {
        return instance;
    }

    public ReadAddressPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Address", OfficeWelcome.constants);
    }

    public ReadAddressPanel(String id) {
        initReadComposite(id, "Address", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("street1", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("state", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("country", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("zip", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("addressType", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("street1", true, false, DataType.STRING_FIELD);
        addField("street2", true, false, DataType.STRING_FIELD);
        addField("city", true, false, DataType.STRING_FIELD);
        addEnumField("state", true, false, USAStatesFactory.getStates().toArray(new String[0]));
        addEnumField("country", true, false, CountryFactory.getCountries().toArray(new String[0]));
        addField("zip", true, false, DataType.LONG_FIELD);
        addDropDown("addressType", new SelectAddressTypeWidget(true, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "address/" + entityId;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phone;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.phonetype.SelectPhoneTypeWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadPhonePanel extends ReadComposite {

    private static ReadPhonePanel instance;
    private static Logger logger = Logger.getLogger(ReadPhonePanel.class.getName());

    public static ReadPhonePanel instance() {
        return instance;
    }

    public ReadPhonePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Phone", OfficeWelcome.constants);
    }

    public ReadPhonePanel(String id) {
        initReadComposite(id, "Phone", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("phoneType", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("countryCode", true, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", true, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("extension", true, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addDropDown("phoneType", new SelectPhoneTypeWidget(false, false, Alignment.HORIZONTAL));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllPhonesPanel.instance;
    }    
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "phone";
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics.event;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadEventPanel extends ReadComposite {

    private static ReadEventPanel instance;
    private static Logger logger = Logger.getLogger(ReadEventPanel.class.getName());

    public static ReadEventPanel instance() {
        return instance;
    }

    public ReadEventPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Event", OfficeWelcome.constants);
    }

    public ReadEventPanel(String id) {
        initReadComposite(id, "Event", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("name", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("user", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("evenTimeStamp", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("input", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("output", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("userAgentInfo", entity, DataType.TEXT_AREA_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("user", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("evenTimeStamp", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("input", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("output", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("userAgentInfo", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "analytics/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllEventsPanel.instance;
     }
}

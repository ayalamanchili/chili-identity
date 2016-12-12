/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.analytics.emailevent;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadEmailEventPanel extends ReadComposite {

    private static ReadEmailEventPanel instance;
    private static Logger logger = Logger.getLogger(ReadEmailEventPanel.class.getName());

    public static ReadEmailEventPanel instance() {
        return instance;
    }

    public ReadEmailEventPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "EventService", OfficeWelcome.constants);
    }

    public ReadEmailEventPanel(String id) {
        instance = this;
        initReadComposite(id, "EventService", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        logger.info("load entity");
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("subject", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("body", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("to", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("subject", true, false, DataType.RICH_TEXT_AREA);
        addField("body", true, false, DataType.RICH_TEXT_AREA);
        addField("to", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "analytics/email/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmailEventsPanel.instance;
     }
}

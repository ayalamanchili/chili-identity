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
        assignFieldValueFromEntity("subject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("body", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("tos", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("subject", true, false, DataType.STRING_FIELD);
        addField("body", true, false, DataType.STRING_FIELD);
        addField("tos", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "analytics/email/" + entityId;
    }
}

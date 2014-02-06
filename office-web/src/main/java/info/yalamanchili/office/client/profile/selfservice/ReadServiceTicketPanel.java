/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author prasanthi.p
 */
public class ReadServiceTicketPanel extends ReadComposite implements ClickHandler {

    protected ClickableLink resolveTicket = new ClickableLink("Resolve Ticket");
    protected ClickableLink startTicket = new ClickableLink("Start Work");
    protected ClickableLink rejectTicket = new ClickableLink("Reject Ticket");

    private static ReadServiceTicketPanel instance;

    public static ReadServiceTicketPanel instance() {
        return instance;
    }

    public ReadServiceTicketPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "SelfService", OfficeWelcome.constants);
    }

    public ReadServiceTicketPanel(String id) {
        initReadComposite(id, "SelfService", OfficeWelcome.constants);
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
        entityFieldsPanel.add(new ReadAllTicketComments(getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("subject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {
        startTicket.addClickHandler(this);
        resolveTicket.addClickHandler(this);
        rejectTicket.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(startTicket);
        entityFieldsPanel.add(resolveTicket);
        entityFieldsPanel.add(rejectTicket);
        addField("subject", true, true, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
        addEnumField("type", true, true, TicketType.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "selfservice/" + entityId;
    }

    @Override
    public void onClick(ClickEvent event) {

    }
}

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
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadServiceTicketPanel extends ReadComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ReadServiceTicketPanel.class.getName());
    protected ClickableLink resolveTicket = new ClickableLink("Resolve Ticket");
    protected ClickableLink startTicket = new ClickableLink("Start Work");
    protected ClickableLink rejectTicket = new ClickableLink("Reject Ticket");
    protected Button updateB = new Button("Update Status");
    private static ReadServiceTicketPanel instance;
    protected EnumField statusF;

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
        statusF.setValues(TicketStatus.validStatusFor(TicketStatus.valueOf(JSONUtils.toString(entity, "status"))));
    }

    @Override
    protected void addListeners() {
        updateB.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("subject", true, true, DataType.STRING_FIELD);
        addField("description", true, false, DataType.STRING_FIELD);
        addEnumField("type", true, true, TicketType.names());
        addEnumField("status", false, false, TicketStatus.names());
        statusF = (EnumField) fields.get("status");
        entityFieldsPanel.add(updateB);
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
        if (event.getSource().equals(updateB)) {
            updateStatus(statusF.getValue());
        }
    }

    protected void updateStatus(String status) {
        if (processClientSideValidations()) {
            HttpService.HttpServiceAsync.instance().doPut(getUpdateURI(status), CreateTicketCommentPanel.instance().getComment().toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            new ResponseStatusWidget().show("Updated Service Ticket");
                            CreateTicketCommentPanel.instance().clear();
                        }
                    });
        }
    }

    protected String getUpdateURI(String status) {
        return OfficeWelcome.constants.root_url() + "selfservice/update-ticket/" + status + "/" + getEntityId();
    }

    protected boolean processClientSideValidations() {
        boolean valid = true;
        if (CreateTicketCommentPanel.instance().getCommentText().isEmpty()) {
            new ResponseStatusWidget().show("Please enter a Comment");
            return false;
        }
        return valid;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.isCorporateEmployee();
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.selfserv.ServiceTicket" + "/" + getEntityId();
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.selfservice;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.Button;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.SelectCorpEmployeeWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.security.SelectRoleWidget;
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
    protected SelectRoleWidget roleWidget = new SelectRoleWidget(false, true);
    protected SelectCorpEmployeeWidget assignedToF = new SelectCorpEmployeeWidget("AssignedTo", false, false);
    SelectEmployeeWidget selectEmployeeWidgetF = new SelectEmployeeWidget("Employee", false, true);
    protected Button updateB = new Button("Update");
    private static ReadServiceTicketPanel instance;
    protected EnumField statusF;
    protected EnumField typeF;
    protected boolean readOnly = false;

    public static ReadServiceTicketPanel instance() {
        return instance;
    }

    public ReadServiceTicketPanel(String id) {
        instance = this;
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
        //TODO this should be checking self emp
        if (Auth.isConsultantEmployee()) {
            readOnly = true;
        }
        assignedToF.setReadOnly(readOnly);
        roleWidget.setReadOnly(readOnly);
        typeF.setReadOnly(readOnly);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, null);
        assignFieldValueFromEntity("subject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("type", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("assignedTo", entity, null);
        roleWidget.setSelectedValue(entity.get("departmentAssigned").isObject(), "roleId");
        statusF.setValues(TicketStatus.validStatusFor(TicketStatus.valueOf(JSONUtils.toString(entity, "status"))));
    }

    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("employee", entity);
        assignEntityValueFromField("subject", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("type", entity);
        assignEntityValueFromField("status", entity);
        //assigned to dept
        JSONObject assignedToDept = new JSONObject();
        assignedToDept.put("roleId", roleWidget.getSelectedObject().get("id"));
        assignedToDept.put("rolename", roleWidget.getSelectedObject().get("value"));
        entity.put("departmentAssigned", assignedToDept);
        //Assigned to 
        entity.put("assignedTo", assignedToF.getSelectedObject());
        //comment
        JSONArray comments = new JSONArray();
        JSONObject comment = new JSONObject();
        assignEntityValueFromField("comment", comment);
        comments.set(0, comment);
        entity.put("comments", comments);
        return entity;
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
        addDropDown("employee", selectEmployeeWidgetF);
        addField("subject", true, true, DataType.STRING_FIELD);
        addField("description", true, false, DataType.RICH_TEXT_AREA);
        addEnumField("type", false, true, TicketType.names());
        addEnumField("status", false, false, TicketStatus.names());
        addDropDown("departmentAssigned", roleWidget);
        addDropDown("assignedTo", assignedToF);
        addField("comment", false, true, DataType.TEXT_AREA_FIELD);
        statusF = (EnumField) fields.get("status");
        typeF = (EnumField) fields.get("type");
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
            update(statusF.getValue());
        }
    }

    protected void update(String status) {
        if (processClientSideValidations()) {
            HttpService.HttpServiceAsync.instance().doPut(getUpdateURI(), populateEntityFromFields().toString(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                @Override
                public void onResponse(String arg0) {
                    new ResponseStatusWidget().show("Updated Service Ticket");
                    if (TabPanel.instance().myOfficePanel.isVisible()) {
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllServiceTicketsPanel(TreeEmployeePanel.instance().getEntityId()));
                    }
                    if (TabPanel.instance().homePanel.isVisible()) {
                        TabPanel.instance().homePanel.entityPanel.clear();
                        TabPanel.instance().homePanel.entityPanel.add(new ReadAllServiceTicketsPanel());
                    }
                }
            });
        }
    }

    protected String getUpdateURI() {
        return OfficeWelcome.constants.root_url() + "selfservice/update-ticket";
    }

    protected boolean processClientSideValidations() {
        boolean valid = true;
        TextAreaField commentF = (TextAreaField) fields.get("comment");
        if (commentF.getValue() == null || commentF.getValue().isEmpty()) {
            commentF.setMessage("Please enter a commnet about your change");
            valid = false;
        }
        if (roleWidget.getSelectedObject() == null) {
            roleWidget.setMessage("Please select a Department");
            valid = false;
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

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "selfservice/open-ticket.html";
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.FormatUtils;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class ReadProspectsPanel extends ReadComposite {

    private Logger logger = Logger.getLogger(ReadProspectsPanel.class.getName());

    private static ReadProspectsPanel instance;
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", true, false, Alignment.HORIZONTAL);
    SuggestBox caseManagerSb = new SuggestBox(OfficeWelcome.constants, "caseManager", "Employee", true, true, Alignment.HORIZONTAL);
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);

    public static ReadProspectsPanel instance() {
        return instance;
    }

    public ReadProspectsPanel() {
    }

    public ReadProspectsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Prospect", OfficeWelcome.constants2);
    }

    public ReadProspectsPanel(String id) {
        initReadComposite(id, "Prospect", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
                            addProspectWonFields();
                        }
                        populateFieldsFromEntity(entity);
                        JSONArray resumeURL = JSONUtils.toJSONArray(entity.get("resumeURL"));
                        if (resumeURL != null) {
                            populateExpenseReceipt(resumeURL);
                        }
                        populateComments();
                        if (entity.containsKey("cpds")) {
                            if (entity.get("cpds") instanceof JSONObject) {
                                JSONArray cpdArray = new JSONArray();
                                cpdArray.set(0, entity.get("cpds").isObject());
                                entityActionsPanel.add(new ReadAllClientInfoPanel(cpdArray, true));
                            } else if (entity.get("cpds") instanceof JSONArray) {
                                entityActionsPanel.add(new ReadAllClientInfoPanel(entity.get("cpds").isArray(), true));
                            }
                        }
                    }
                });
    }

    protected void populateExpenseReceipt(JSONArray items) {
        entityFieldsPanel.add(new ReadAllResumePanel(items));
    }

    protected void populateComments() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER)) {
            entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.hr.Prospect"));
        }
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        JSONObject emp = (JSONObject) entity.get("assignedTo");
        if (emp != null) {
            employeeSB.setValue(emp.get("firstName").isString().stringValue());
        }
        JSONObject employee = (JSONObject) entity.get("caseManager");
        if (employee != null) {
            caseManagerSb.setValue(employee.get("firstName").isString().stringValue());
        }
        if (entity.get("address") != null) {
            JSONObject address = entity.get("address").isObject();
            assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", address, DataType.LONG_FIELD);
        }
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("screenedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        String phoneNumber = FormatUtils.formatPhoneNumber(entity.get("phoneNumber").isString().stringValue());
        entity.put("phoneNumber", new JSONString(phoneNumber));
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("referredBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processDocSentDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        if (ProspectStatus.CLOSED_WON.name().equals(JSONUtils.toString(getEntity(), "status"))) {
            assignFieldValueFromEntity("petitionFiledFor", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("trfEmpType", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("placedBy", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("dateOfJoining", entity, DataType.DATE_FIELD);
            assignFieldValueFromEntity("company", entity, null);
        }
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
        caseManagerSb.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
    }

    @Override
    protected void addWidgets() {
        addField("firstName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("referredBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("email", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("countryCode", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("street1", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", true, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", true, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("screenedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(employeeSB);
        entityFieldsPanel.add(caseManagerSb);
        addField("processDocSentDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Status Information"));
        addEnumField("status", true, false, ProspectStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    public String getURI() {
        return OfficeWelcome.constants.root_url() + "prospect/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.hr.Prospect" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PROSPECTS_MANAGER);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        if (!JSONUtils.toString(getEntity(), "bpmProcessId").isEmpty()) {
            tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
        }
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllProspectsPanel.instance;
    }

    protected void addProspectWonFields() {
        if (!fields.containsKey("petitionFiledFor")) {
            addDropDown("company", selectCompnayWidget);
            addEnumField("petitionFiledFor", true, false, PetitionFor.names(), Alignment.HORIZONTAL);
            addEnumField("trfEmpType", true, false, TransferEmployeeType.names(), Alignment.HORIZONTAL);
            addEnumField("placedBy", true, false, PlacedBy.names(), Alignment.HORIZONTAL);
            addField("dateOfJoining", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
            alignFields();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.dom.client.Style;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.SuggestBox;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
class ReadEmployeeOnboardingPanel extends ReadComposite {
    
    private Logger logger = Logger.getLogger(ReadEmployeeOnboardingPanel.class.getName());
    
    private static ReadEmployeeOnboardingPanel instance;
    SuggestBox employeeSB = new SuggestBox(OfficeWelcome.constants, "assignedTo", "Employee", true, false, Alignment.HORIZONTAL);
    
    public static ReadEmployeeOnboardingPanel instance() {
        return instance;
    }
    
    public ReadEmployeeOnboardingPanel() {
    }
    
    public ReadEmployeeOnboardingPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "InitiateOnBoarding", OfficeWelcome.constants);
    }
    
    public ReadEmployeeOnboardingPanel(String id) {
        initReadComposite(id, "InitiateOnBoarding", OfficeWelcome.constants);
    }
    
    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                        populateComments();
                    }
                });
    }
    
    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding"));
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        logger.info("employee onboarding .... "+entity);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("company", entity, null);
        assignFieldValueFromEntity("branch", entity, DataType.ENUM_FIELD);
        if (entity.get("employeeType") != null) {
            JSONObject empType = entity.get("employeeType").isObject();
            JSONValue name = empType.get("name");
            entity.put("employeeType", name);
        }
        assignFieldValueFromEntity("workStatus", entity, DataType.ENUM_FIELD);
    }
    
    @Override
    protected void addListeners() {
        
    }
    
    @Override
    protected void configure() {
        employeeSB.getLabel().getElement().getStyle().setWidth(193, Style.Unit.PX);
    }
    
    @Override
    protected void addWidgets() {
        addField("email", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("employeeType", new SelectEmployeeTypeWidget(false, true));
        addDropDown("company", new SelectCompanyWidget(false, true, Alignment.HORIZONTAL));
        addField("startDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", true, false, Branch.names(), Alignment.HORIZONTAL);
        addEnumField("workStatus", true, false, WorkStatus.names(), Alignment.HORIZONTAL);
        alignFields();
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }
    
    @Override
    public String getURI() {
        return OfficeWelcome.constants.root_url() + "on-board-employee/" + entityId;
    }
    
    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR);
    }
    
    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.onboarding.EmployeeOnBoarding" + "/" + getEntityId();
    }
}

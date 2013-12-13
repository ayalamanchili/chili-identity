/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

public class ReadEmployeePanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadEmployeePanel.class.getName());
    private static ReadEmployeePanel instance;
    protected SelectEmployeeTypeWidget employeeSelectWidget = new SelectEmployeeTypeWidget(true, false);

    public static ReadEmployeePanel instance() {
        return instance;
    }

    public ReadEmployeePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Employee", OfficeWelcome.constants);
    }

    public ReadEmployeePanel(String id) {
        initReadComposite(id, "Employee", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info("this is the response from the server" + response);
                entity = (JSONObject) JSONParser.parseLenient(response);
                populateFieldsFromEntity(entity);
            }
        });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        if (canViewDOBField()) {
            assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        }
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("employeeId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        if (Auth.isAdmin()) {
            assignFieldValueFromEntity("ssn", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("employeeType", entity, null);
        if (Auth.isAdmin()) {
            assignFieldValueFromEntity("status", entity, DataType.BOOLEAN_FIELD);
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addDropDown("employeeType", employeeSelectWidget);
        addField("firstName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeId", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (canViewDOBField()) {
            addField("dateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", true, false, strs, Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (Auth.isAdmin()) {
            addField("ssn", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.isAdmin()) {
            addField("status", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        alignFields();
    }

    protected boolean canViewDOBField() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/" + entityId;
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Employee" + "/" + getEntityId();
    }
}

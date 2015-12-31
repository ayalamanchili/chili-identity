/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import java.util.logging.Logger;

public class ReadEmployeePanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadEmployeePanel.class.getName());
    private static ReadEmployeePanel instance;
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(true, false, Alignment.HORIZONTAL);
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
        logger.info("ddd" + entity);
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
        assignFieldValueFromEntity("branch", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hoursPerWeek", entity, DataType.INTEGER_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignFieldValueFromEntity("workStatus", entity, DataType.ENUM_FIELD);
        }
        assignFieldValueFromEntity("company", entity, null);
        if (Auth.isAdmin()) {
            assignFieldValueFromEntity("ssn", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("employeeType", entity, null);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("status", entity, DataType.BOOLEAN_FIELD);
        }
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
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
        addEnumField("sex", true, false, Sex.names(), Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("jobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", true, false, Branch.names(), Alignment.HORIZONTAL);
        addField("hoursPerWeek", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addEnumField("workStatus", true, false, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        addDropDown("company", selectCompnayWidget);
        if (Auth.isAdmin()) {
            addField("ssn", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_RELATIONSHIP)) {
            addField("status", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    protected boolean canViewDOBField() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP);
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
        return Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CORPORATE_TIME_REPORTS);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Employee" + "/" + getEntityId();
    }
}

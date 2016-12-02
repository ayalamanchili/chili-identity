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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.ImageField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.Company;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.logging.Logger;

public class ReadEmployeePanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadEmployeePanel.class.getName());
    private static ReadEmployeePanel instance;
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(true, false, Alignment.HORIZONTAL);
    protected SelectEmployeeTypeWidget employeeSelectWidget = new SelectEmployeeTypeWidget(true, false);
    HorizontalPanel hpanel = new HorizontalPanel();
    VerticalPanel vPanel = new VerticalPanel();
    DateField endDate = new DateField(OfficeWelcome.constants, "endDate", "Employee", true, false, Alignment.HORIZONTAL);

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
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.Employee"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        if (entity.containsKey("status") && entity.get("status").isString().stringValue().equals("true")) {
            entityFieldsPanel.remove(endDate);
        }
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        if (canViewDOBField()) {
            assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        }
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION)) {
            assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        }
        assignFieldValueFromEntity("employeeId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("branch", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("hoursPerWeek", entity, DataType.INTEGER_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignFieldValueFromEntity("workStatus", entity, DataType.ENUM_FIELD);
        }
        assignFieldValueFromEntity("company", entity, null);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            assignFieldValueFromEntity("ssn", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("employeeType", entity, null);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_HR_ADMINSTRATION)) {
            assignFieldValueFromEntity("status", entity, DataType.BOOLEAN_FIELD);
        }
        if (entity.containsKey("status") && entity.get("status").isString().stringValue().equals("false")) {
            endDate.setValue(JSONUtils.toString(entity, "endDate"));
        }
        populateComments();
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
        fields.put("employeeType", employeeSelectWidget);
        StringField stringField = new StringField(OfficeWelcome.constants,
                "firstName", "Employee", true, true, Alignment.HORIZONTAL);
        stringField.addEnterKeyPressesListener(this);
        fields.put("firstName", stringField);
        StringField mistringField = new StringField(OfficeWelcome.constants,
                "middleInitial", "Employee", true, true, Alignment.HORIZONTAL);
        stringField.addEnterKeyPressesListener(this);
        fields.put("middleInitial", mistringField);
        StringField lnstringField = new StringField(OfficeWelcome.constants,
                "lastName", "Employee", true, true, Alignment.HORIZONTAL);
        stringField.addEnterKeyPressesListener(this);
        fields.put("lastName", lnstringField);
        vPanel.add(employeeSelectWidget);
        vPanel.add(stringField);
        vPanel.add(mistringField);
        vPanel.add(lnstringField);
        hpanel.add(vPanel);
        hpanel.add(new ImageField("Picture", JSONUtils.toString(entity, "imageURL"), JSONUtils.toString(entity, "id"), 100, 100, false));
        if (entity != null && entity.get("company").isObject() != null) {
            String companyName = entity.get("company").isObject().get("name").isString().stringValue();
            if (companyName.equalsIgnoreCase(Company.CGS_INC)) {
                hpanel.add(new ImageField("Logo", OfficeImages.INSTANCE.cgsLogo(), 277, 50, false));
            } else if (companyName.equalsIgnoreCase(Company.TECHPILLARS)) {
                hpanel.add(new ImageField("Logo", OfficeImages.INSTANCE.techPillarsLogo(), 277, 37, false));
            } else if (companyName.equalsIgnoreCase(Company.SSTECH_INC) || companyName.equalsIgnoreCase(Company.SSTECH_LLC)) {
                hpanel.add(new ImageField("Logo", OfficeImages.INSTANCE.logo(), 277, 37, false));
            }
        } else {
            hpanel.add(new ImageField("Logo", OfficeImages.INSTANCE.logo(), 277, 37, false));
        }
        entityFieldsPanel.add(hpanel);
        addField("employeeId", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (canViewDOBField()) {
            addField("dateOfBirth", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        addEnumField("sex", true, false, Sex.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_CONTRACTS_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_GC_IMMIGRATION)) {
            addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        addField("jobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", true, false, Branch.names(), Alignment.HORIZONTAL);
        addField("hoursPerWeek", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addEnumField("workStatus", true, false, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        addDropDown("company", selectCompnayWidget);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addField("ssn", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_HR_ADMINSTRATION)) {
            addField("status", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(endDate);
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

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new EmployeeSidePanel());
        return ReadAllEmployeesPanel.instance;
    }
}

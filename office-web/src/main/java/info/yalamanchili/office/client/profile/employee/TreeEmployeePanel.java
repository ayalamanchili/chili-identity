/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPanel;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.profile.role.MultiSelectRoleWidget;
import info.yalamanchili.office.client.profile.skillset.SkillSetPanel;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.benefits.ReadAllBenefitsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.TreeEmpProjectInformationPanel;
import info.yalamanchili.office.client.profile.selfservice.ReadAllServiceTicketsPanel;
import java.util.logging.Logger;

public class TreeEmployeePanel extends TreePanelComposite {

    private static TreeEmployeePanel instance;

    public static TreeEmployeePanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeEmployeePanel.class.getName());
    protected static final String ADDRESS_NODE = "address";
    protected static final String EMAIL_NODE = "email";
    protected static final String PHONE_NODE = "phone";
    protected static final String SKILL_SET_NODE = "skillset";
    protected static final String IMMIGRATION_NODE = "immigration";
    protected static final String PROJECT_NODE = "projectInformation";
    protected static final String SETTINGS_NODE = "settings";
    protected static final String REPORTS_NODE = "reports";
    protected static final String SELF_SERVICE_NODE = "selfService";
    protected static final String ROLES_NODE = "roles";
    protected static final String EMPLOYEE_FORMS = "employeeForms";
    protected static final String EMPLOYEE_CONTACTS = "employeeContacts";
    protected static final String BENEFITS_NODE = "Benefits";
    protected SkillSetPanel skillSetPanel;
    protected TreeEmpReportsPanel empReportsPanel;
    protected TreeEmpFormsPanel empDocsPanel;
    protected TreeEmpContactsPanel empContactsPanel;
    protected TreeEmpSettingsPanel empSettingsPanel;
    protected TreeEmployeeImmigrationPanel empImmigrationPanel;
    protected TreeEmpProjectInformationPanel projectInformationPanel;

    public TreeEmployeePanel(JSONObject emp) {
        super();
        instance = this;
        this.entity = emp;
        skillSetPanel = new SkillSetPanel(getEntityId());
        empReportsPanel = new TreeEmpReportsPanel(getEntityId());
        empImmigrationPanel = new TreeEmployeeImmigrationPanel(getEntityId());
        projectInformationPanel = new TreeEmpProjectInformationPanel(getEntity());
        empDocsPanel = new TreeEmpFormsPanel(emp);
        empSettingsPanel = new TreeEmpSettingsPanel(emp);
        empContactsPanel = new TreeEmpContactsPanel(emp);
        String name = JSONUtils.toString(emp, "firstName") + " " + JSONUtils.toString(emp, "lastName");
        init(name, OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
    }

    @Override
    public boolean expandTree() {
        return true;
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Addresses", ADDRESS_NODE);
        addFirstChildLink("Emails", EMAIL_NODE);
        addFirstChildLink("Phones", PHONE_NODE);
        addFirstChildLink("Client Project ", PROJECT_NODE, projectInformationPanel);
        addFirstChildLink("Contacts", EMPLOYEE_CONTACTS, empContactsPanel);
        if (Auth.isEmployee(entity)) {
            addFirstChildLink("Skill Set", SKILL_SET_NODE, skillSetPanel);
        }
        if (Auth.isCorporateEmployee()) {
            addFirstChildLink("Self Service", SELF_SERVICE_NODE);
        }
        if (Auth.isAdmin()) {
            addFirstChildLink("Roles", ROLES_NODE);
        }
        addFirstChildLink("Reports", REPORTS_NODE, empReportsPanel);
        addFirstChildLink("Forms & Docs", EMPLOYEE_FORMS, empDocsPanel);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HEALTH_INSURANCE_MANAGER)) {
            addFirstChildLink("Benefits", BENEFITS_NODE);
        }
        if (Auth.isCorporateEmployee() || (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN, ROLE.ROLE_CONSULTANT_TIME_ADMIN))) {
            addFirstChildLink("Settings", SETTINGS_NODE, empSettingsPanel);
        }
        if (Auth.isAdmin()) {
            addFirstChildLink("Immigration", IMMIGRATION_NODE, empImmigrationPanel);
        }
        this.rootItem.setState(true);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ADDRESS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel(getEntityId()));
        }
        if (BENEFITS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBenefitsPanel(getEntityId()));
        }
        if (EMAIL_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(getEntityId()));
        }
        if (PHONE_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(getEntityId()));
        }
        if (projectInformationPanel != null) {
            projectInformationPanel.treeNodeSelected(entityNodeKey);
        }
        if (SKILL_SET_NODE.equals(entityNodeKey)) {
            //TODO mode this to comp
            skillSetPanel.loadEntity();
        }
        if (SELF_SERVICE_NODE.equals(entityNodeKey)) {
            //TODO ADD READ ALL Serviceticketspanel
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllServiceTicketsPanel(getEntityId()));
        }

        if (ROLES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectRoleWidget(getEntityId()));
        }

        if (empReportsPanel != null) {
            empReportsPanel.treeNodeSelected(entityNodeKey);
        }
        if (empDocsPanel != null) {
            empDocsPanel.treeNodeSelected(entityNodeKey);
        }
        if (empContactsPanel != null) {
            empContactsPanel.treeNodeSelected(entityNodeKey);
        }
        if (empImmigrationPanel != null) {
            empImmigrationPanel.treeNodeSelected(entityNodeKey);
        }
        if (empSettingsPanel != null) {
            empSettingsPanel.treeNodeSelected(entityNodeKey);
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(getEntityId()));
    }
}

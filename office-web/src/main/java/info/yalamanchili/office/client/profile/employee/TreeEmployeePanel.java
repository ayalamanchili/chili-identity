/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.email.EmailOptionsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.phone.PhoneOptionsPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInfoOptionsPanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.password.ResetPasswordPanel;
import info.yalamanchili.office.client.profile.role.MultiSelectRoleWidget;
import info.yalamanchili.office.client.profile.skillset.SkillSetPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.password.DeactivatationPanel;
import info.yalamanchili.office.client.profile.preferences.PreferencesPanel;
import info.yalamanchili.office.client.profile.privacy.PrivacyOptionsPanel;
import info.yalamanchili.office.client.profile.privacy.ReadAllPrivacySettngsPanel;
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
    protected static final String CLIENT_INFO_NODE = "clientInfo";
    protected static final String PRIVACY_NODE = "privacy";
    protected static final String SKILL_SET_NODE = "skillset";
    protected static final String IMMIGRATION_NODE = "immigration";
    protected static final String REPORTS_NODE = "reports";
    protected static final String SELF_SERVICE_NODE = "selfService";
    protected static final String PREFERENCES_NODE = "preferences";
    protected static final String ROLES_NODE = "roles";
    protected static final String RESET_PASSWORD_NODE = "resetpassword";
    protected static final String DEACTIVATION_USER_NODE = "deactivation";
    protected static final String EMPLOYEE_FORMS = "employeeForms";
    protected static final String EMPLOYEE_CONTACTS = "employeeContacts";
    protected SkillSetPanel skillSetPanel;
    protected TreeEmpReportsPanel empReportsPanel;
    protected TreeEmpFormsPanel empDocsPanel;
    protected TreeEmpContactsPanel empContactsPanel;
    protected TreeEmployeeImmigrationPanel empImmigrationPanel;

    public TreeEmployeePanel(JSONObject emp) {
        super();
        instance = this;
        this.entity = emp;
        skillSetPanel = new SkillSetPanel(getEntityId());
        empReportsPanel = new TreeEmpReportsPanel(getEntityId());
        empImmigrationPanel = new TreeEmployeeImmigrationPanel(getEntityId());
        empDocsPanel = new TreeEmpFormsPanel(emp);
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
        addFirstChildLink("Client Information", CLIENT_INFO_NODE);
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
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ON_BOARDING_MGR, ROLE.ROLE_HR_ADMINSTRATION)) {
            addFirstChildLink("Forms & Docs", EMPLOYEE_FORMS, empDocsPanel);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP) && Auth.isEmployee(entity)) {
            addFirstChildLink("Reset Password", RESET_PASSWORD_NODE);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            addFirstChildLink("Preferences", PREFERENCES_NODE);
        }
        if (Auth.isCorporateEmployee()) {
            addFirstChildLink("Privacy", PRIVACY_NODE);
        }
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN) && Auth.isCorporateEmployee(entity)) || (Auth.isConsultantEmployee(entity) || Auth.isW2Contractor(entity) || Auth.is1099(entity) || Auth.isSubContractor(entity) && Auth.hasAnyOfRoles(ROLE.ROLE_CONSULTANT_TIME_ADMIN, ROLE.ROLE_ADMIN, ROLE.ROLE_HR_ADMINSTRATION, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN))) {
            addFirstChildLink("Deactivation", DEACTIVATION_USER_NODE);
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
        if (EMAIL_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new EmailOptionsPanel());
        }
        if (PHONE_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());
        }
        if (CLIENT_INFO_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
        }
        if (PRIVACY_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPrivacySettngsPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new PrivacyOptionsPanel());
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
        if (DEACTIVATION_USER_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new DeactivatationPanel(CreateComposite.CreateCompositeType.CREATE));

        }
        if (PREFERENCES_NODE.equals(entityNodeKey)) {
            HttpService.HttpServiceAsync.instance().doGet(getPreferencesURI(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            JSONObject preferences = JSONParser.parseLenient(arg0).isObject();
                            if (arg0 != null && preferences != null) {
                                TabPanel.instance().myOfficePanel.entityPanel.clear();
                                TabPanel.instance().myOfficePanel.entityPanel.add(new PreferencesPanel(preferences));
                            }
                        }
                    });

        }
        if (ROLES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectRoleWidget(getEntityId()));
        }
        if (RESET_PASSWORD_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ResetPasswordPanel(CreateComposite.CreateCompositeType.CREATE));
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
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(getEntityId()));
    }

    protected String getPreferencesURI() {
        return OfficeWelcome.constants.root_url() + "employee/preferences/" + getEntityId();
    }

    protected String getDeactivateuserURL() {
        return OfficeWelcome.constants.root_url() + "admin/deactivateuser/" + getEntityId();
    }
}

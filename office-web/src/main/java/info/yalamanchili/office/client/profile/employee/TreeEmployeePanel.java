/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.email.EmailOptionsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.EmergencyContactOptionsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPanel;
import info.yalamanchili.office.client.profile.phone.PhoneOptionsPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInfoOptionsPanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.Window;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.password.ResetPasswordPanel;
import info.yalamanchili.office.client.profile.preferences.UpdatePreferencesPanel;
import info.yalamanchili.office.client.profile.role.MultiSelectRoleWidget;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPanel;
import info.yalamanchili.office.client.profile.skillset.TreeSkillSetPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.activity.TreeActivityPanel;
import info.yalamanchili.office.client.companycontact.CompanyContactOptionsPanel;
import info.yalamanchili.office.client.companycontact.ReadAllCompanyContactPanel;
import info.yalamanchili.office.client.profile.privacy.PrivacyOptionsPanel;
import info.yalamanchili.office.client.profile.privacy.ReadAllPrivacySettngsPanel;
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
    protected static final String REPORTS_TO_NODE = "clientInfo";
    protected static final String EMERGENCY_CONTACT_NODE = "emergencyContact";
    protected static final String COMPANY_CONTACT_NODE = "companyContact";
    protected static final String PRIVACY_NODE = "privacy";
    protected static final String SKILL_SET_NODE = "skillset";
    protected static final String ACTIVITY_NODE = "activity";
    protected static final String PREFERENCES_NODE = "preferences";
    protected static final String ROLES_NODE = "roles";
    protected static final String RESET_PASSWORD_NODE = "resetpassword";
    protected static final String DEACTIVATION_USER_NODE = "deactivation";
    protected TreeSkillSetPanel skillSetTreePanel;
    protected TreeActivityPanel activityTreePanel = new TreeActivityPanel(getEntityId());

    public TreeEmployeePanel(JSONObject emp) {
        super();
        instance = this;
        this.entity = emp;
        skillSetTreePanel = new TreeSkillSetPanel(getEntityId());
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
        addFirstChildLink("Client Information", REPORTS_TO_NODE);
        addFirstChildLink("Emergency Contacts", EMERGENCY_CONTACT_NODE);
        addFirstChildLink("Company Contacts", COMPANY_CONTACT_NODE);
        addFirstChildLink("Skill Set", SKILL_SET_NODE, skillSetTreePanel);
        if (Auth.hasNonUserRoles()) {
            addFirstChildLink("Activity", ACTIVITY_NODE, activityTreePanel);
        }
        if (Auth.isAdmin()) {
            addFirstChildLink("Roles", ROLES_NODE);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            addFirstChildLink("Reset Password", RESET_PASSWORD_NODE);
            addFirstChildLink("Preferences", PREFERENCES_NODE);
        }
        addFirstChildLink("Privacy", PRIVACY_NODE);
        if (Auth.isAdmin()) {
            addFirstChildLink("Deactivation", DEACTIVATION_USER_NODE);
        }
        this.rootItem.setState(true);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ADDRESS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
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
        if (REPORTS_TO_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
        }
        if (EMERGENCY_CONTACT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new EmergencyContactOptionsPanel());
        }
        if (COMPANY_CONTACT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new CompanyContactOptionsPanel());
        }
        if (PRIVACY_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPrivacySettngsPanel(getEntityId()));
            TabPanel.instance().myOfficePanel.entityPanel.add(new PrivacyOptionsPanel());
        }
        if (SKILL_SET_NODE.equals(entityNodeKey)) {
            //TODO mode this to comp
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            skillSetTreePanel.loadEntity();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(getEntityId()));
        }
        if (ACTIVITY_NODE.equals(entityNodeKey)) {
            //TODO
        }
        if (DEACTIVATION_USER_NODE.equals(entityNodeKey)) {
            if (Window.confirm("Are you sure! Do you want to deactivate this Employee?")) {
                HttpService.HttpServiceAsync.instance().doPut(getDeactivateuserURL(), null, OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                            @Override
                            public void onResponse(String arg0) {
                                new ResponseStatusWidget().show("Successfully deactivated User");
                            }
                        });
            }

        }
        if (PREFERENCES_NODE.equals(entityNodeKey)) {
            HttpService.HttpServiceAsync.instance().doGet(getPreferencesURI(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            JSONObject preferences = JSONParser.parseLenient(arg0).isObject();
                            if (arg0 != null && preferences != null) {
                                TabPanel.instance().myOfficePanel.entityPanel.clear();
                                TabPanel.instance().myOfficePanel.entityPanel.add(new UpdatePreferencesPanel(preferences));
                            }
                        }
                    });

        }
        if (ROLES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectRoleWidget("Roles", getEntityId()));
        }
        if (RESET_PASSWORD_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ResetPasswordPanel(CreateComposite.CreateCompositeType.CREATE));

        } //TODO review
        if (skillSetTreePanel != null) {
            skillSetTreePanel.treeNodeSelected(entityNodeKey);
        }
        if (activityTreePanel != null) {
            activityTreePanel.treeNodeSelected(entityNodeKey);
        }

    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(entityId));
    }

    protected String getPreferencesURI() {
        return OfficeWelcome.constants.root_url() + "employee/preferences/" + getEntityId();
    }

    protected String getDeactivateuserURL() {
        return OfficeWelcome.constants.root_url() + "admin/deactivateuser/" + getEntityId();
    }
}

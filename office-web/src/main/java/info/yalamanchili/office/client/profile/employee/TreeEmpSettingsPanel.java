/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.password.DeactivatationPanel;
import info.yalamanchili.office.client.profile.password.ResetPasswordPanel;
import info.yalamanchili.office.client.profile.preferences.PreferencesPanel;
import info.yalamanchili.office.client.profile.privacy.ReadAllPrivacySettngsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Kiranmai.Ramisetti
 */
public class TreeEmpSettingsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpSettingsPanel.class.getName());
    protected static final String RESET_PASSWORD_NODE = "resetpassword";
    protected static final String DEACTIVATION_USER_NODE = "deactivation";
    protected static final String PREFERENCES_NODE = "preferences";
    protected static final String PRIVACY_NODE = "privacy";
    protected JSONObject employee;
    protected String employeeId;

    public TreeEmpSettingsPanel(JSONObject emp) {
        this.employee = emp;
        this.employeeId = JSONUtils.toString(emp, "id");
        logger.info("employee id is ... " + employeeId);
        init("Settings", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP) && Auth.isEmployee(employee)) {
            addFirstChildLink("Reset Password", RESET_PASSWORD_NODE);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            addFirstChildLink("Preferences", PREFERENCES_NODE);
        }
        if (Auth.isCorporateEmployee()) {
            addFirstChildLink("Privacy", PRIVACY_NODE);
        }
        if ((Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_SYSTEM_AND_NETWORK_ADMIN, Auth.ROLE.ROLE_CONSULTANT_TIME_ADMIN))) {
            addFirstChildLink("Deactivation", DEACTIVATION_USER_NODE);
        }
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (PRIVACY_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPrivacySettngsPanel(employeeId));
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

        if (RESET_PASSWORD_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ResetPasswordPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }

    @Override
    public void loadEntity() {
    }

    protected String getPreferencesURI() {
        return OfficeWelcome.constants.root_url() + "employee/preferences/" + employeeId;
    }

    protected String getDeactivateuserURL() {
        return OfficeWelcome.constants.root_url() + "admin/deactivateuser/" + employeeId;
    }

    @Override
    public void showEntity() {
    }
}

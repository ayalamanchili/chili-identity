/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client;

import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.internalization.OfficeConstants;
import info.yalamanchili.office.client.internalization.OfficeMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import info.yalamanchili.office.client.config.OfficeClientConfig;
import info.yalamanchili.office.client.login.LoginPage;
import info.yalamanchili.office.client.resources.OfficeImages;

public class OfficeWelcome implements EntryPoint {

    public static Logger logger = Logger.getLogger(OfficeWelcome.class.getName());
    public JSONObject employee;
    public String employeeId;
    public List<String> roles = new ArrayList<String>();
    public static OfficeConstants constants = (OfficeConstants) GWT.create(OfficeConstants.class);
    public static OfficeMessages messages = (OfficeMessages) GWT.create(OfficeMessages.class);
    public OfficeClientConfig officeClientConfig;

    @Override
    public void onModuleLoad() {
        OfficeImages.INSTANCE.officeCss().ensureInjected();
        instance = this;
        RootLayoutPanel.get().add(new LoginPage());
        //This is a hack to load the tab panel js fragment on back ground while the users enters his username and password
        GWT.runAsync(new com.google.gwt.core.client.RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
            }

            @Override
            public void onSuccess() {
                RootLayout rootLayout = new RootLayout();
                rootLayout.setVisible(false);
            }
        });
    }

    public void onMainModuleLoad(JSONObject employee) {
        this.employee = employee;
        this.employeeId = employee.get("id").isString().stringValue();
        initUserRoles(employee);
        GWT.runAsync(new info.chili.gwt.callback.RunAsyncCallback() {
            @Override
            public void onResponse() {
                logger.info(roles.toString());
                RootLayoutPanel.get().clear();
                RootLayout rootLayout = new RootLayout();
                RootLayoutPanel.get().add(rootLayout);
            }
        });
        SessionTimeoutMonitor.get().initialize();
    }

    public String getCurrentUserName() {
        return JSONUtils.toString(employee, "firstName") + " " + JSONUtils.toString(employee, "lastName");
    }

    public String getCurrentUserEmpId() {
        return employeeId;
    }

    protected void initUserRoles(JSONObject employee) {
        JSONObject user = employee.get("user").isObject();
        logger.info(user.toString());
        JSONArray roles = JSONUtils.toJSONArray(user.get("roles"));
        for (int i = 0; i < roles.size(); i++) {
            JSONObject role = (JSONObject) roles.get(i);
            this.roles.add(role.get("rolename").isString().stringValue());
        }
    }
    private static OfficeWelcome instance;

    public static OfficeWelcome instance() {
        if (instance == null) {
            return new OfficeWelcome();
        }
        return instance;
    }

    public OfficeClientConfig getOfficeClientConfig() {
        if (officeClientConfig == null) {
            this.officeClientConfig = GWT.create(OfficeClientConfig.class);
        }
        return this.officeClientConfig;
    }
    //TODO move to server

    public Map<String, String> getHeaders() {
        Map<String, String> headersMap = new HashMap<String, String>();

        return headersMap;
    }
}

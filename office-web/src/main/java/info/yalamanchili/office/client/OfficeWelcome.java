package info.yalamanchili.office.client;

import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.internalization.OfficeConstants;
import info.yalamanchili.office.client.internalization.OfficeMessages;
import info.yalamanchili.office.client.login.LoginPanel;

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

public class OfficeWelcome implements EntryPoint {

    public static Logger logger = Logger.getLogger(OfficeWelcome.class.getName());
    public JSONObject user;
    public JSONObject employee;
    public String employeeId;
    public String username;
    //TODO This is not good find a better way
    public String password;
    public List<String> roles = new ArrayList<String>();
    public static OfficeConstants constants = (OfficeConstants) GWT.create(OfficeConstants.class);
    public static OfficeMessages messages = (OfficeMessages) GWT.create(OfficeMessages.class);

    @Override
    public void onModuleLoad() {
        instance = this;
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.showLoginWindow();

    }

    public void onMainModuleLoad(JSONObject user) {
        this.user = user;
        this.employee = user.get("employee").isObject();
        this.employeeId = employee.get("id").isString().stringValue();
        initUserRoles(user);
        logger.info(roles.toString());
        RootLayout rootLayout = new RootLayout();
        RootLayoutPanel.get().add(rootLayout);
    }

    protected void initUserRoles(JSONObject userObj) {
        logger.info(userObj.toString());
        JSONArray roles = JSONUtils.toJSONArray(userObj.get("roles"));
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

    public Map<String, String> getHeaders() {
        Map<String, String> headersMap = new HashMap<String, String>();
        headersMap.put("Content-Type", "application/json");
        if (username != null) {
            headersMap.put("username", username);
        }
        if (password != null) {
            headersMap.put("password", password);
        }
        return headersMap;
    }
}

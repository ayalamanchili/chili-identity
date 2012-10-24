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
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import info.yalamanchili.office.client.config.OfficeClientConfig;
import info.yalamanchili.office.client.login.LoginPage;
import info.yalamanchili.office.client.resources.OfficeImages;

public class OfficeWelcome implements EntryPoint {

    public static Logger logger = Logger.getLogger(OfficeWelcome.class.getName());
    public JSONObject user;
    public JSONObject employee;
    public String employeeId;
    public List<String> roles = new ArrayList<String>();
    public static OfficeConstants constants = (OfficeConstants) GWT.create(OfficeConstants.class);
    public static OfficeMessages messages = (OfficeMessages) GWT.create(OfficeMessages.class);
    public static OfficeClientConfig config = GWT.create(OfficeClientConfig.class);

    @Override
    public void onModuleLoad() {
        OfficeImages.INSTANCE.officeCss().ensureInjected();
        instance = this;
        RootLayoutPanel.get().add(new LoginPage());

    }

    public void onMainModuleLoad(JSONObject user) {
        this.user = user;
        this.employee = user.get("employee").isObject();
        this.employeeId = employee.get("id").isString().stringValue();
        initUserRoles(user);
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("Code download failed");
            }

            @Override
            public void onSuccess() {
                logger.info(roles.toString());
                RootLayoutPanel.get().clear();
                RootLayout rootLayout = new RootLayout();
                RootLayoutPanel.get().add(rootLayout);
            }
        });

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
    //TODO move to server

    public Map<String, String> getHeaders() {
        Map<String, String> headersMap = new HashMap<String, String>();

        return headersMap;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.LocalStorage;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.config.OfficeClientConfig;
import info.yalamanchili.office.client.login.LoginPage;
import info.yalamanchili.office.client.resources.OfficeImages;

public class OfficeWelcome implements EntryPoint {

    public static Logger logger = Logger.getLogger(OfficeWelcome.class.getName());
    public JSONObject employee;
    public String employeeId;
    public List<String> roles = new ArrayList<>();
    public static OfficeConstants constants = (OfficeConstants) GWT.create(OfficeConstants.class);
    public static OfficeMessages messages = (OfficeMessages) GWT.create(OfficeMessages.class);
    public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);
    public OfficeClientConfig officeClientConfig;

    @Override
    public void onModuleLoad() {
        URLParamProcessor.process();
        OfficeImages.INSTANCE.officeCss().ensureInjected();
        instance = this;
//try to login with existing session
        HttpService.HttpServiceAsync.instance().login(null, null, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String userString) {
                JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
                onMainModuleLoad(user);
            }

            @Override
            public void onFailure(Throwable err) {
                RootLayoutPanel.get().add(new LoginPage());
            }
        });
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

    protected static final String FEEDBACK_KEY = "FEEDBACK-JAN-2015";

    protected void showFeedbackPage() {
        if (LocalStorage.getValue(FEEDBACK_KEY) == null) {
//            Frame feedbackForm = new Frame("https://docs.google.com/forms/d/1m33EzGvGN2aSBg1b0BT0USiNIhF_UpXRt0J3xq7Y-eE/viewform?usp=send_form");
//            feedbackForm.setHeight("70em");
//            feedbackForm.setWidth("55em");
//            new NewWindowPanel(feedbackForm, Window.getClientWidth() / 5, 0).show();
            LocalStorage.putValue(FEEDBACK_KEY, "true");
        }
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
        return JSONUtils.toString(employee, "employeeId");
    }

    protected void initUserRoles(JSONObject employee) {
        JSONArray roles = JSONUtils.toJSONArray(employee.get("roles"));
        for (int i = 0; i < roles.size(); i++) {
            this.roles.add(roles.get(i).isString().stringValue());
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

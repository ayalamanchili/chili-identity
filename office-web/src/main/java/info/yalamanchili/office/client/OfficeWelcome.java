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
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.config.OfficeClientConfig;
import info.yalamanchili.office.client.internalization.OfficeConstants2;
import info.yalamanchili.office.client.login.LoginPage;
import info.yalamanchili.office.client.resources.OfficeImages;
import info.yalamanchili.office.client.user.ReadAllUserMessages;

public class OfficeWelcome implements EntryPoint {

    public static Logger logger = Logger.getLogger(OfficeWelcome.class.getName());
    public JSONObject employee;
    public String employeeId;
    public List<String> roles = new ArrayList<>();
    public static OfficeConstants constants = (OfficeConstants) GWT.create(OfficeConstants.class);
    public static OfficeConstants2 constants2 = (OfficeConstants2) GWT.create(OfficeConstants2.class);
    public static OfficeMessages messages = (OfficeMessages) GWT.create(OfficeMessages.class);
    public static EventBus EVENT_BUS = GWT.create(SimpleEventBus.class);
    public OfficeClientConfig officeClientConfig;

    @Override
    public void onModuleLoad() {
        OfficeImages.INSTANCE.officeCss().ensureInjected();
        if (URLParamProcessor.process()) {
            return;
        }
        instance = this;
//try to login with existing session
        HttpService.HttpServiceAsync.instance().login(null, null, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String userString) {
                JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
                onMainModuleLoad(user);
            }
//is session is not valid or present show login page

            @Override
            public void onFailure(Throwable err) {
                loadingWidget.hide();
                RootLayoutPanel.get().add(new LoginPage());
                downloadJSinBackground();
            }
        });
    }

    protected void downloadJSinBackground() {
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

    public RootLayout rootLayout;

    public void onMainModuleLoad(JSONObject employee) {
        this.employee = employee;
        this.employeeId = employee.get("id").isString().stringValue();
        initUserRoles(employee);
        GWT.runAsync(new info.chili.gwt.callback.RunAsyncCallback() {
            @Override
            public void onResponse() {
                logger.info(roles.toString());
                RootLayoutPanel.get().clear();
                rootLayout = new RootLayout();
                RootLayoutPanel.get().add(rootLayout);
                History.addValueChangeHandler(new OfficeUrlRoutingHandler());
                setLogo(employee);
                Timer timer = new Timer() {
                    @Override
                    public void run() {
                        showMessages();
                    }
                };
                timer.schedule(2000);
                if (History.getToken() != null) {
                    History.fireCurrentHistoryState();
                }
            }
        });

    }

    protected void showMessages() {
        HttpService.HttpServiceAsync.instance().doGet(getMessagesUrl(), OfficeWelcome.instance().getHeaders(),
                false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String result) {
                logger.info(result);
                if (!result.trim().equals("null")) {
                    final DialogBox dialog = new DialogBox();
                    dialog.setText("Messages");
                    new GenericPopup(new ReadAllUserMessages(JSONUtils.toJSONArray(JSONParser.parseLenient(result).isObject().get("userMessage"))), 0, 0) {
                        @Override
                        protected void configure() {
                            setAutoHideEnabled(true);
                            this.getElement().getStyle().setProperty("width", "100%");
                            this.getElement().getStyle().setProperty("height", "100%");
                            this.addStyleName("genericPopup");
                            rootLayout.setVisible(false);
                        }
                    }.show();
                }
            }
        });
    }

    protected String getMessagesUrl() {
        return OfficeWelcome.instance().constants.root_url() + "notifications/user/messages/0/10";
    }

    protected void setLogo(JSONObject employee) {
        if (employee.isObject() != null) {
            return;
        }
        if (employee.get("company") != null) {
            if (employee.get("company").isObject().get("name").isString().stringValue().equalsIgnoreCase(Company.CGS_INC)) {
                StatusPanel.instance().setLogo(OfficeImages.INSTANCE.cgsLogo());
            } else if (employee.get("company").isObject().get("name").isString().stringValue().equalsIgnoreCase(Company.TECHPILLARS)) {
                StatusPanel.instance().setLogo(OfficeImages.INSTANCE.techPillarsLogo());
            }
        }
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

    public OfficeClientConfig
            getOfficeClientConfig() {
        if (officeClientConfig == null) {
            this.officeClientConfig = GWT.create(OfficeClientConfig.class
            );
        }
        return this.officeClientConfig;
    }
    //TODO move to server

    public Map<String, String> getHeaders() {
        Map<String, String> headersMap = new HashMap<String, String>();

        return headersMap;
    }
}

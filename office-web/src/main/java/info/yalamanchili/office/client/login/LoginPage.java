/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.storage.client.StorageMap;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Feedback.AccountResetPanel;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
public class LoginPage extends Composite {

    private static Logger logger = Logger.getLogger(LoginPage.class.getName());
    private static LoginPage.LoginPageUiBinder uiBinder = GWT.create(LoginPage.LoginPageUiBinder.class);
    private static LoginPage instance;

    public static LoginPage instance() {
        return instance;
    }
    @UiField
    Image loginLogo;
    @UiField
    Image loginCenter;
    @UiField
    Label usernameL;
    @UiField
    TextBox usernameTb;
    @UiField
    Label passwordL;
    @UiField
    PasswordTextBox passwordTb;
    @UiField
    Button loginB;
    @UiField
    Image forgotPasswordIcon;
    @UiField
    public Anchor accountResetL;

    @UiHandler("loginB")
    void handleLogin(ClickEvent e) {
        loginClicked();
    }

    @UiHandler("usernameTb")
    public void onKeyPressUserNameTb(KeyPressEvent event) {
        int keyCode = event.getUnicodeCharCode();
        if (keyCode == 0) {
            // Probably Firefox
            keyCode = event.getNativeEvent().getKeyCode();
        }
        if (keyCode == KeyCodes.KEY_ENTER) {
            // Do something when Enter is pressed.
            loginClicked();
        }
    }

    @UiHandler("passwordTb")
    public void onKeyPressPasswordTb(KeyPressEvent event) {
        int keyCode = event.getUnicodeCharCode();
        if (keyCode == 0) {
            // Probably Firefox
            keyCode = event.getNativeEvent().getKeyCode();
        }
        if (keyCode == KeyCodes.KEY_ENTER) {
            // Do something when Enter is pressed.
            loginClicked();
        }
    }

    @UiHandler("forgotPasswordIcon")
    void forgotPasswordLinkClicked(ClickEvent event) {
        forgotPassword();
    }

    @UiHandler("accountResetL")
    void accountResetLinkClicked(ClickEvent e) {
        new GenericPopup(new AccountResetPanel(CreateComposite.CreateCompositeType.CREATE)).show();
    }

    interface LoginPageUiBinder extends UiBinder<Widget, LoginPage> {
    }

    public LoginPage() {
        initWidget(uiBinder.createAndBindUi(this));
        loginB.addStyleName("loginB");
        loginCenter.addStyleName("loginCenterPanel");
        populateUsername();
    }
//TODO move to chili gwt as abstract common methods

    protected void populateUsername() {
        Storage officeLclStorage = null;
        officeLclStorage = Storage.getLocalStorageIfSupported();
        if (officeLclStorage != null) {
            StorageMap officeMap = new StorageMap(officeLclStorage);
            if (officeMap.containsKey("office-username")) {
                String username = officeMap.get("office-username");
                usernameTb.setText(username);
            }
        }
    }

    protected void storeUsername() {
        Storage officeLclStorage = null;
        officeLclStorage = Storage.getLocalStorageIfSupported();
        if (officeLclStorage != null) {
            StorageMap officeMap = new StorageMap(officeLclStorage);
            if (!officeMap.containsKey("office-username")) {
                officeMap.put("office-username", usernameTb.getText());
            } else {
                if (!officeMap.get("office-username").equals(usernameTb.getText())) {
                    //the entered username and stored username are not equal
                    officeMap.remove("office-username");
                    officeMap.put("office-username", usernameTb.getText());
                }
            }
        }
    }

    protected void loginClicked() {
        storeUsername();
        HttpService.HttpServiceAsync.instance().login(usernameTb.getText(), passwordTb.getText(), new ALAsyncCallback<String>() {
            String failureMessage = "Login failed, Please check your username and password";

            @Override
            public void onResponse(String userString) {
                if (userString != null && userString.trim().length() > 0) {
                    JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
                    OfficeWelcome.instance().onMainModuleLoad(user);
                } else {
                    new ResponseStatusWidget().show(getFailureMessage());
                }
            }

            @Override
            public void onFailure(Throwable err) {
                if (err.getMessage().contains("not.authorized.")) {
//                    new GenericPopup(new RequestRemoteAccessPanel()).show();
                    new ResponseStatusWidget().show("Access to ESS Portal is limited to corporate firewall. Please contact system administrator");
                } else {
                    super.onFailure(err);
                }
            }

            @Override
            public String getFailureMessage() {
                return failureMessage;
            }
        });
    }

    protected void forgotPassword() {
        new GenericPopup(new ForgotPasswordPopup()).show();
    }

    protected void setAutoLogout() {
        // TODO
    }

    protected String getLoginURL() {
        return OfficeWelcome.constants.root_url() + "admin/login";
    }
}

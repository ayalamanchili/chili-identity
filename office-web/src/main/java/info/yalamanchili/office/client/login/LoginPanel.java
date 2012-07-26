package info.yalamanchili.office.client.login;

import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;


    public class LoginPanel extends PopupPanel {
	private static Logger logger = Logger.getLogger(LoginPanel.class.getName());
	private static LoginPanelUiBinder uiBinder = GWT.create(LoginPanelUiBinder.class);

	private static LoginPanel instance;

	public static LoginPanel instance() {
		return instance;
	}

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

	@UiHandler("loginB")
	void handleLogin(ClickEvent e) {
		loginClicked();
	}

//        @UiHandler("usernameTb")
//         void usertextboxkeypress(KeyPressEvent event){
//            if(event.getCharCode()==KeyCodes.KEY_ENTER)
//            {
//                loginClicked();
//                        
//            }
//        }       
//        
//          @UiHandler("passwordTb")
//         void passwordtextboxkeypress(KeyPressEvent event){
//            if(event.getCharCode()==KeyCodes.KEY_ENTER)
//            {
//                loginClicked();
//                        
//            }
//        }   
                
	interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
	}

	public LoginPanel() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	protected void loginClicked() {
		JSONObject user = new JSONObject();
		user.put("username", new JSONString(usernameTb.getText()));
		user.put("passwordHash", new JSONString(passwordTb.getText()));
		Map<String, String> headers = OfficeWelcome.instance().getHeaders();
		headers.put("username", usernameTb.getText());
		headers.put("password", passwordTb.getText());
		HttpServiceAsync.instance().doPut(getLoginURL(), user.toString(), headers, true, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable arg0) {
				new ResponseStatusWidget().show("login failed");
			}

			@Override
			public void onSuccess(String userString) {
				if (userString != null && userString.trim().length() > 0) {
					OfficeWelcome.instance().username = usernameTb.getText();
					OfficeWelcome.instance().password = passwordTb.getText();
					JSONObject user = (JSONObject) JSONParser.parseLenient(userString);
					LoginPanel.this.hide();
					OfficeWelcome.instance().onMainModuleLoad(user);
				} else {
					new ResponseStatusWidget().show("login failed");
				}
			}

		});
	}

	public void showLoginWindow() {
		int left = Window.getClientWidth() / 3;
		int top = Window.getClientHeight() / 3;
		this.setPopupPosition(left, top);
		this.show();
	}

	protected void setAutoLogout() {
		// TODO
	}

	protected String getLoginURL() {
		return OfficeWelcome.constants.root_url() + "admin/login";
	}

}

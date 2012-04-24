package info.yalamanchili.office.client.login;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginPanel extends PopupPanel {

	private static LoginPanelUiBinder uiBinder = GWT
			.create(LoginPanelUiBinder.class);

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
	TextBox passwordTb;

	@UiField
	Button loginB;

	@UiHandler("loginB")
	void handleLogin(ClickEvent e) {
		loginClicked();
	}

	interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
	}

	public LoginPanel() {
		setWidget(uiBinder.createAndBindUi(this));
	}

	protected void loginClicked() {
		// AdminServiceAsync.instance().login(usernameTb.getText(),
		// passwordTb.getText(), new ALAsyncCallback<YUser>() {
		//
		// @Override
		// public void onResponse(YUser user) {
		// // TODO use seam observer instead???
		// if (user != null) {
		// LoginPanel.this.hide();
		// OfficeWelcome.instance().onMainModuleLoad(user);
		// loginToCommunicator();
		// }
		//
		// }
		//
		// });
	}

	protected void showLoginWindow() {
		int left = Window.getClientWidth() / 3;
		int top = Window.getClientHeight() / 3;
		this.setPopupPosition(left, top);
		this.show();
	}

	protected void setAutoLogout() {
		// TODO
	}

}

package info.yalamanchili.office.client;

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
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class OfficeWelcome implements EntryPoint {
	private static Logger logger = Logger.getLogger(OfficeWelcome.class
			.getName());

	public String username;
	// This is not good find a better way
	public String password;

	public List<String> roles = new ArrayList<String>();

	public static OfficeConstants constants = (OfficeConstants) GWT
			.create(OfficeConstants.class);

	public static OfficeMessages messages = (OfficeMessages) GWT
			.create(OfficeMessages.class);

	@Override
	public void onModuleLoad() {
		instance = this;
		LoginPanel loginPanel = new LoginPanel();
		loginPanel.showLoginWindow();

	}

	public void onMainModuleLoad(JSONObject user) {
		initUserRoles(user);
		RootLayout rootLayout = new RootLayout();
		RootLayoutPanel.get().add(rootLayout);
	}

	protected void initUserRoles(JSONObject user) {

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

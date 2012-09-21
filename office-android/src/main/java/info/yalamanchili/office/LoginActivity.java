package info.yalamanchili.office;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import info.chili.android.crud.AbstractCreateActivity;
import info.chili.android.views.Field;
import info.chili.android.views.StringField;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import info.yalamanchili.office.R;
import info.chili.android.commons.Base64;

public class LoginActivity extends AbstractCreateActivity {

	@Override
	protected int contentViewId() {
		return R.layout.login;
	}

	@Override
	protected int createButtonId() {
		return R.id.login_loginB;
	}

	@Override
	protected void assignFields() {
		addAndAssignField(R.id.login_usernameSF, "username", "Username",
				Field.STRING_FIELD);
		addAndAssignField(R.id.login_passwordSF, "passwordHash", "Password",
				Field.STRING_FIELD);

	}

	@Override
	protected int appTitleBarId() {
		return R.layout.office_title_bar;
	}

	@Override
	protected int appTitleBArTextViewId() {
		return R.id.office_title_text;
	}

	@Override
	protected String titleText() {
		return "Login in to Portal";
	}

	@Override
	protected void preCreate() {
		entity = new JSONObject();

	}

	@Override
	protected String createURL() {
		return OfficeWelcome.baseURL + "admin/login";
	}

	@Override
	protected Map<String, String> headers() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/json");
		StringField usernameSF = (StringField) fields.get("username");
		StringField passwordSF = (StringField) fields.get("passwordHash");
		String userpass = usernameSF.getValue() + ":" + passwordSF.getValue();
		headers.put("Authorization",
				"Basic " + Base64.encodeBytes(userpass.getBytes()));
		return headers;
	}

}

package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.fields.DateField;
import info.yalamanchili.gwt.fields.EnumField;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;

public class ReadEmployeePanel extends ALComposite {

	protected JSONObject entity;

	/*
	 * Root panel for Read Employee
	 */

	protected FlowPanel panel = new FlowPanel();
	/*
	 * Fields
	 */
	StringField firstNameF = new StringField("First Name", "firstName",
			"Employee", true, true);
	StringField middleNameF = new StringField("MiddleInitial", "middleInitial",
			"Employee", true, false);
	StringField lastNameF = new StringField("Last Name", "lastName",
			"Employee", true, true);
	DateField dateOfBirthF = new DateField("Date of Birth", "dateOfBirth",
			"Employee", true, false);
	String[] strs = { "MALE", "FEMALE" };
	EnumField sexF = new EnumField("Sex", "sex", "Employee", true, false, strs);
	DateField startDateF = new DateField("Start Date", "startDate", "Employee",
			true, false);

	public ReadEmployeePanel(String id) {
		instance = this;
		init(panel);
		loadEntity(id);
	}

	@Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		panel.add(firstNameF);
		panel.add(middleNameF);
		panel.add(lastNameF);
		panel.add(dateOfBirthF);
		panel.add(sexF);
		panel.add(startDateF);
	}

	protected void loadEntity(String id) {
		HttpServiceAsync.instance().doGet(getReadEmployeeURL(id),
				OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String response) {
						entity = (JSONObject) JSONParser.parseLenient(response);
						populateData(entity);
					}

				});
	}

	protected void populateData(JSONObject entity) {
		firstNameF.setText(JSONUtils.toString(entity, "firstName"));
		middleNameF.setText(JSONUtils.toString(entity, "middleName"));
		lastNameF.setText(JSONUtils.toString(entity, "lastName"));
		// dateOfBirthF.setDate(JSONUtils.toString(entity, "dateOfBirth"));
		sexF.setValue(JSONUtils.toString(entity, "sex"));
		// startDateF.setText(JSONUtils.toString(entity, "startDate"));
	}

	protected String getReadEmployeeURL(String id) {
		return OfficeWelcome.constants.root_url() + "employee/" + id;
	}

	private static ReadEmployeePanel instance;

	public static ReadEmployeePanel instance() {
		return instance;
	}
}

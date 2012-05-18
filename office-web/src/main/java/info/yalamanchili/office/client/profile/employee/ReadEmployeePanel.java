package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

public class ReadEmployeePanel extends ReadComposite {

	private static ReadEmployeePanel instance;

	public static ReadEmployeePanel instance() {
		return instance;
	}

	public ReadEmployeePanel(JSONObject entity) {
		instance = this;
		initReadComposite(entity, "Employee", OfficeWelcome.constants);
	}

	public ReadEmployeePanel(String id) {
		initReadComposite(id, "Employee", OfficeWelcome.constants);
	}

	@Override
	public void loadEntity(String entityId) {
		HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String response) {
						entity = (JSONObject) JSONParser.parseLenient(response);
						populateFieldsFromEntity(entity);
					}

				});

	}

	@Override
	public void populateFieldsFromEntity(JSONObject entity) {
		assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
		assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
		assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
		assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
		assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
		assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);

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
		addField("firstName", true, true, DataType.STRING_FIELD);
		addField("middleInitial", true, true, DataType.STRING_FIELD);
		addField("lastName", true, true, DataType.STRING_FIELD);
		addField("dateOfBirth", true, true, DataType.DATE_FIELD);
		String[] strs = { "MALE", "FEMALE" };
		addEnumField("sex", true, true, strs);
		addField("startDate", true, true, DataType.DATE_FIELD);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee/" + entityId;
	}

}

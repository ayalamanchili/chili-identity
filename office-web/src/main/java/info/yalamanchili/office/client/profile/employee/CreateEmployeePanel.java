package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.FileUploadPanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateEmployeePanel extends CreateComposite {

	private static Logger logger = Logger.getLogger(CreateEmployeePanel.class.getName());

	FileUploadPanel empImageUploadPanel = new FileUploadPanel("Employee Uplodate", "Test Image Name");

	public CreateEmployeePanel(CreateCompositeType type) {
		super(type);
		initCreateComposite("Employee", OfficeWelcome.constants);
	}

	@Override
	public JSONObject populateEntityFromFields() {
		JSONObject user = new JSONObject();
		assignEntityValueFromField("username", user);
		assignEntityValueFromField("passwordHash", user);

		JSONObject employee = new JSONObject();
		assignEntityValueFromField("firstName", employee);
		assignEntityValueFromField("middleInitial", employee);
		assignEntityValueFromField("lastName", employee);
		assignEntityValueFromField("dateOfBirth", employee);
		assignEntityValueFromField("sex", employee);
		assignEntityValueFromField("startDate", employee);
		user.put("employee", employee);
		return user;
	}

	// protected void assignImageName() {
	// StringField firstNameF = (StringField) fields.get("firstName");
	// StringField lastNameF = (StringField) fields.get("lastName");
	// empImageUploadPanel.setFileName("employee/" + firstNameF.getText() + "_"
	// + lastNameF.getText());
	// }

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
		addField("username", false, true, DataType.STRING_FIELD);
		addField("passwordHash", false, true, DataType.STRING_FIELD);
		addField("firstName", false, true, DataType.STRING_FIELD);
		addField("middleInitial", false, true, DataType.STRING_FIELD);
		addField("lastName", false, true, DataType.STRING_FIELD);
		addField("dateOfBirth", false, true, DataType.DATE_FIELD);
		String[] strs = { "MALE", "FEMALE" };
		addEnumField("sex", false, true, strs);
		addField("startDate", false, true, DataType.DATE_FIELD);
		entityDisplayWidget.add(empImageUploadPanel);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createButtonClicked() {
		empImageUploadPanel.upload();
		HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
						logger.info(arg0.getMessage());
						handleErrorResponse(arg0);
					}

					@Override
					public void onSuccess(String arg0) {
						new ResponseStatusWidget().show("successfully created employee");
//						TabPanel.instance().myOfficePanel.clear();
//						TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());

					}

				});

	}

	@Override
	protected void addButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "admin/createuser";
	}

}

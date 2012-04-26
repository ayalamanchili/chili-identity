package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.date.DateUtils;
import info.yalamanchili.gwt.fields.DateField;
import info.yalamanchili.gwt.fields.EnumField;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreateEmployeePanel extends Composite implements ClickHandler {
	private static Logger logger = Logger.getLogger(CreateEmployeePanel.class
			.getName());

	/*
	 * Root panel for Create Employee
	 */

	protected FlowPanel panel = new FlowPanel();
	/*
	 * Fields
	 */
	StringField firstNameF = new StringField("First Name", "firstName",
			"Employee", false, true);
	StringField middleNameF = new StringField("MiddleInitial", "middleInitial",
			"Employee", false, false);
	StringField lastNameF = new StringField("Last Name", "lastName",
			"Employee", false, true);
	DateField dateOfBirthF = new DateField("Date of Birth", "dateOfBirth",
			"Employee", false, false);
	String[] strs = { "MALE", "FEMALE" };
	EnumField sexF = new EnumField("Sex", "sex", "Employee", false, false, strs);
	DateField startDateF = new DateField("Start Date", "startDate", "Employee",
			false, false);
	StringField ssnF = new StringField("SSN", "ssn", "Employee", false, false);
	Button createB = new Button("Create Employee");

	public CreateEmployeePanel() {
		initWidget(panel);
		addWidgets();
		addListeners();
	}

	protected void addWidgets() {
		panel.add(firstNameF);
		panel.add(middleNameF);
		panel.add(lastNameF);
		panel.add(dateOfBirthF);
		panel.add(sexF);
		panel.add(startDateF);
		panel.add(ssnF);
		panel.add(createB);

	}

	protected void addListeners() {
		createB.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent clickEvent) {
		if (clickEvent.getSource().equals(createB)) {
			createEmployee(getCreateEmployeeURI(), getEmployeeData());
		}
	}

	protected String getEmployeeData() {
		JSONObject jsonValue = new JSONObject();
		jsonValue.put("firstName", new JSONString(firstNameF.getText()));
		jsonValue.put("middleName", new JSONString(middleNameF.getText()));
		jsonValue.put("lastName", new JSONString(lastNameF.getText()));
		if (dateOfBirthF.getDate() != null) {
			jsonValue.put(
					"dateOfBirth",
					new JSONString(DateUtils.toDateString(dateOfBirthF
							.getDate())));
		}
		jsonValue.put("sex", new JSONString(sexF.getValue()));
		if (startDateF.getDate() != null) {
			jsonValue
					.put("startDate",
							new JSONString(DateUtils.toDateString(startDateF
									.getDate())));
		}
		jsonValue.put("ssn", new JSONString(ssnF.getText()));
		logger.info(jsonValue.toString());
		return jsonValue.toString();
	}

	protected String getCreateEmployeeURI() {
		return OfficeWelcome.constants.root_url() + "employee";
	}

	public void createEmployee(String url, String data) {
		HttpServiceAsync.instance().doPut(url, data,
				OfficeWelcome.instance().getHeaders(),false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String arg0) {
						new ResponseStatusWidget()
								.show("successfully created employee");
						TabPanel.instance().adminPanel.clear();
						TabPanel.instance().adminPanel
								.add(new ReadAllEmployees());
					}

				});
	}
}

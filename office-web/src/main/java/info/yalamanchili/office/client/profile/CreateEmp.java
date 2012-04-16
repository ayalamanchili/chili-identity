package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.fields.DateField;
import info.yalamanchili.gwt.fields.EnumField;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreateEmp extends Composite implements ClickHandler {
	private static Logger logger = Logger.getLogger(CreateEmp.class.getName());

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
	DateField dobF = new DateField("Date of Birth", "dateOfBirth", "Employee",
			false, false);
	String[] strs = { "MALE", "FEMALE" };
	EnumField sexF = new EnumField("Sex", "sex", "Employee", false, false, strs);
	DateField startDateF = new DateField("Start Date", "startDate", "Employee",
			false, false);
	StringField ssnF = new StringField("SSN", "ssn", "Employee", false, false);
	Button createB = new Button("Create Employee");

	public CreateEmp() {
		initWidget(panel);
		addWidgets();
		addListeners();
	}

	protected void addWidgets() {
		panel.add(firstNameF);
		panel.add(middleNameF);
		panel.add(lastNameF);
		panel.add(dobF);
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
			doPost(getCreateEmployeeURI(), getEmployee());
		}
	}

	protected String getEmployee() {
		JSONObject jsonValue = new JSONObject();
		jsonValue.put("firstName", new JSONString(firstNameF.getText()));
		logger.info(jsonValue.toString());
		return jsonValue.toString();
	}

	protected String getCreateEmployeeURI() {
		return OfficeWelcome.constants.root_url() + "employee";
	}

	public void doPost(String url, String postData) {
		HttpServiceAsync.instance().doPut(url, postData,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
						Window.alert("call failed" + arg0.getLocalizedMessage());

					}

					@Override
					public void onSuccess(String arg0) {
						Window.alert("success");

					}

				});
	}
}

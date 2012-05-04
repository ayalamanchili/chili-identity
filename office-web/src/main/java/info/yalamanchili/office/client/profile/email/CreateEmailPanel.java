package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddresses;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreateEmailPanel extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(CreateEmailPanel.class
			.getName());

	protected FlowPanel panel = new FlowPanel();

	StringField emailF = new StringField("Email", "email", "Email", false, true);
	Button createB = new Button("Create");

	public CreateEmailPanel() {
		init(panel);
	}

	@Override
	protected void addListeners() {
		createB.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		panel.add(emailF);
		panel.add(createB);
	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(createB)) {
			AddEmployeeEmail();
		}

	}

	protected void AddEmployeeEmail() {
		logger.info(getAddEmployeeEmailURL(TreeEmployeePanel.instance()
				.getEntityId()));
		HttpServiceAsync.instance().doPut(
				getAddEmployeeEmailURL(TreeEmployeePanel.instance()
						.getEntityId()), getEmailData(),
				OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String arg0) {
						new ResponseStatusWidget()
								.show("successfully added employee address");
						TabPanel.instance().adminPanel.clear();
						TabPanel.instance().adminPanel.entityPanel
								.add(new ReadAllAddresses(TreeEmployeePanel
										.instance().getEntityId()));
						TabPanel.instance().adminPanel.entityPanel
								.add(new AddressOptionsPanel());
					}

				});
	}

	protected String getEmailData() {
		JSONObject jsonValue = new JSONObject();
		jsonValue.put("email", new JSONString(emailF.getText()));
		return jsonValue.toString();
	}

	protected String getAddEmployeeEmailURL(String empId) {
		return OfficeWelcome.constants.root_url() + "employee/email/" + empId;
	}
}

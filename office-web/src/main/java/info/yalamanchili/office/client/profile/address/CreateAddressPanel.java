package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.fields.StringField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreateAddressPanel extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(CreateAddressPanel.class
			.getName());

	protected FlowPanel panel = new FlowPanel();

	StringField street1F = new StringField("Street 1", "street1", "Address",
			false, true);
	StringField street2F = new StringField("Street 2", "street2", "Address",
			false, true);
	StringField cityF = new StringField("City", "city", "Address", false, true);
	StringField stateF = new StringField("State", "state", "Address", false,
			true);
	StringField countryF = new StringField("Country", "country", "Address",
			false, true);
	StringField zipF = new StringField("Zip Code", "zip", "Address", false,
			true);
	Button createB = new Button("Create");

	public CreateAddressPanel() {
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
		panel.add(street1F);
		panel.add(street2F);
		panel.add(cityF);
		panel.add(stateF);
		panel.add(countryF);
		panel.add(zipF);
		panel.add(createB);
	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(createB)) {
			AddEmployeeAddress();
		}

	}

	protected void AddEmployeeAddress() {
		logger.info(getAddEmployeeAddressURL(TreeEmployeePanel.instance()
				.getEntityId()));
		HttpServiceAsync.instance().doPut(
				getAddEmployeeAddressURL(TreeEmployeePanel.instance()
						.getEntityId()), getAddressData(),
				OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String arg0) {
						new ResponseStatusWidget()
								.show("successfully added employee address");
						TabPanel.instance().myOfficePanel.entityPanel.clear();
						TabPanel.instance().myOfficePanel.entityPanel
								.add(new ReadAllAddresses(TreeEmployeePanel
										.instance().getEntityId()));
						TabPanel.instance().myOfficePanel.entityPanel
								.add(new AddressOptionsPanel());
					}

				});
	}

	protected String getAddressData() {
		JSONObject jsonValue = new JSONObject();
		jsonValue.put("street1", new JSONString(street1F.getText()));
		jsonValue.put("street2", new JSONString(street2F.getText()));
		jsonValue.put("city", new JSONString(cityF.getText()));
		jsonValue.put("state", new JSONString(stateF.getText()));
		jsonValue.put("country", new JSONString(countryF.getText()));
		jsonValue.put("zip", new JSONString(zipF.getText()));
		return jsonValue.toString();
	}

	protected String getAddEmployeeAddressURL(String empId) {
		return OfficeWelcome.constants.root_url() + "employee/address/" + empId;
	}
}

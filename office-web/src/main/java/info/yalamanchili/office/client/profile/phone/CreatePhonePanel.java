package info.yalamanchili.office.client.profile.phone;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.gwt.fields.LongField;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phonetype.SelectPhoneTypeWidget;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;

public class CreatePhonePanel extends ALComposite implements ClickHandler {

	private static Logger logger = Logger.getLogger(CreatePhonePanel.class.getName());

	protected FlowPanel panel = new FlowPanel();

	LongField phoneNumberF = new LongField("PhoneNumber", "phoneNumber", "PhoneNumber", false, true);
	SelectPhoneTypeWidget phoneTypeF = new SelectPhoneTypeWidget();
	Button createB = new Button("Create");

	public CreatePhonePanel() {
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
		panel.add(phoneNumberF);
		panel.add(phoneTypeF);
		panel.add(createB);
	}

	@Override
	public void onClick(ClickEvent arg0) {
		if (arg0.getSource().equals(createB)) {
			AddEmployeePhone();
		}

	}

	protected void AddEmployeePhone() {
		logger.info(getAddEmployeePhoneURL(TreeEmployeePanel.instance().getEntityId()));
		HttpServiceAsync.instance().doPut(getAddEmployeePhoneURL(TreeEmployeePanel.instance().getEntityId()),
				getPhoneData(), OfficeWelcome.instance().getHeaders(), false, new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String arg0) {
						new ResponseStatusWidget().show("successfully added employee Phone");
						TabPanel.instance().myOfficePanel.entityPanel.clear();
						TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhones(TreeEmployeePanel.instance()
								.getEntityId()));
						TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());
					}

				});
	}

	protected String getPhoneData() {
		JSONObject jsonValue = new JSONObject();
		jsonValue.put("phoneNumber", new JSONString(String.valueOf(phoneNumberF.getLong())));
		// TODO null checek
		jsonValue.put("phoneType", phoneTypeF.getSelectedObject());
		return jsonValue.toString();
	}

	protected String getAddEmployeePhoneURL(String empId) {
		return OfficeWelcome.constants.root_url() + "employee/phone/" + empId;
	}
}

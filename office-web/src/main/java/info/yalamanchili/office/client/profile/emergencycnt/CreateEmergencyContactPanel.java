package info.yalamanchili.office.client.profile.emergencycnt;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateEmergencyContactPanel extends CreateComposite {
	private static Logger logger = Logger.getLogger(CreateEmergencyContactPanel.class.getName());

	public CreateEmergencyContactPanel(CreateCompositeType type) {
		super(type);
		initCreateComposite("EmergencyContact", OfficeWelcome.constants);
	}

	@Override
	protected JSONObject populateEntityFromFields() {
		JSONObject contact = new JSONObject();
		assignEntityValueFromField("firstName", contact);
		assignEntityValueFromField("middleInitial", contact);
		assignEntityValueFromField("lastName", contact);
		assignEntityValueFromField("sex", contact);

		JSONObject emergencyContact = new JSONObject();
		assignEntityValueFromField("ecPrimary", emergencyContact);
		emergencyContact.put("contact", contact);
		return emergencyContact;
	}

	@Override
	protected void createButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addButtonClicked() {
		HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), false,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
						logger.info(arg0.getMessage());
						handleErrorResponse(arg0);
					}

					@Override
					public void onSuccess(String arg0) {
						new ResponseStatusWidget().show("successfully added Emergency Contact");
						TabPanel.instance().myOfficePanel.clear();
						TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(
								TreeEmployeePanel.instance().getEntityId()));

					}

				});

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
		addField("firstName", false, true, DataType.STRING_FIELD);
		addField("middleInitial", false, true, DataType.STRING_FIELD);
		addField("lastName", false, true, DataType.STRING_FIELD);
		String[] strs = { "MALE", "FEMALE" };
		addEnumField("sex", false, true, strs);
		addField("ecPrimary", false, true, DataType.BOOLEAN_FIELD);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee/emergencycontact/"
				+ TreeEmployeePanel.instance().getEntityId();
	}
}

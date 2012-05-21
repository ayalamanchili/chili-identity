package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateAddressPanel extends CreateComposite {

	public CreateAddressPanel(CreateCompositeType type) {
		super(type);
		initCreateComposite("Address", OfficeWelcome.constants);
	}

	private static Logger logger = Logger.getLogger(CreateAddressPanel.class.getName());

	SelectAddressTypeWidget addressTypeWidget = new SelectAddressTypeWidget();

	@Override
	protected JSONObject populateEntityFromFields() {
		JSONObject entity = new JSONObject();
		assignEntityValueFromField("street1", entity);
		assignEntityValueFromField("street2", entity);
		assignEntityValueFromField("city", entity);
		assignEntityValueFromField("state", entity);
		assignEntityValueFromField("country", entity);
		assignEntityValueFromField("zip", entity);
		entity.put("addressType", addressTypeWidget.getSelectedObject());
		return entity;
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
						handleErrorResponse(arg0);
					}

					@Override
					public void onSuccess(String arg0) {
						new ResponseStatusWidget().show("successfully added employee address");
						TabPanel.instance().myOfficePanel.entityPanel.clear();
						TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(TreeEmployeePanel
								.instance().getEntityId()));
						TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());

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
		addField("street1", false, true, DataType.STRING_FIELD);
		addField("street2", false, true, DataType.STRING_FIELD);
		addField("city", false, true, DataType.STRING_FIELD);
		addField("state", false, true, DataType.STRING_FIELD);
		addField("country", false, true, DataType.STRING_FIELD);
		addField("zip", false, true, DataType.LONG_FIELD);
		entityDisplayWidget.add(addressTypeWidget);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee/address/" + TreeEmployeePanel.instance().getEntityId();
	}

}

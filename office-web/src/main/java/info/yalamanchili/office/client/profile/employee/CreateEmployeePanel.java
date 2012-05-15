package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateEmployeePanel extends CreateComposite {
	private static Logger logger = Logger.getLogger(CreateEmployeePanel.class.getName());

	public CreateEmployeePanel(CreateCompositeType type) {
		super(type);
		initCreateComposite("Employee", OfficeWelcome.constants);
	}

	@Override
	protected JSONObject populateEntityFromFields() {
		JSONObject entity = new JSONObject();
		assignField("firstName", entity);
		assignField("middleInitial", entity);
		assignField("lastName", entity);
		assignField("dateOfBirth", entity);
		assignField("sex", entity);
		assignField("startDate", entity);
		return entity;
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
		addField("dateOfBirth", false, true, DataType.DATE_FIELD);
		String[] strs = { "MALE", "FEMALE" };
		addEnumField("sex", false, true, strs);
		addField("startDate", false, true, DataType.DATE_FIELD);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createButtonClicked() {
		HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), false,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
						logger.info(arg0.getMessage());

					}

					@Override
					public void onSuccess(String arg0) {
						new ResponseStatusWidget().show("successfully created employee");
						TabPanel.instance().adminPanel.clear();
						TabPanel.instance().adminPanel.entityPanel.add(new ReadAllEmployees());

					}

				});

	}

	@Override
	protected void addButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee";
	}

}

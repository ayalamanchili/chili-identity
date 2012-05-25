package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.emailtype.SelectEmailTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class CreateEmailPanel extends CreateComposite {

	private static Logger logger = Logger.getLogger(CreateEmailPanel.class.getName());

	SelectEmailTypeWidget emailTypeF = new SelectEmailTypeWidget();

	public CreateEmailPanel(CreateCompositeType type) {
		super(type);
		initCreateComposite("Email", OfficeWelcome.constants);
	}

	@Override
	protected JSONObject populateEntityFromFields() {
		JSONObject entity = new JSONObject();
		assignEntityValueFromField("email", entity);
		assignEntityValueFromField("primaryEmail", entity);
		entity.put("emailType", emailTypeF.getSelectedObject());
		return entity;
	}

	@Override
	protected void createButtonClicked() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addButtonClicked() {
		HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
				new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable arg0) {
						handleErrorResponse(arg0);
					}

					@Override
					public void onSuccess(String arg0) {
						new ResponseStatusWidget().show("successfully added employee Email");
						TabPanel.instance().myOfficePanel.entityPanel.clear();
						TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(TreeEmployeePanel
								.instance().getEntityId()));
						TabPanel.instance().myOfficePanel.entityPanel.add(new EmailOptionsPanel());
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
		addField("email", false, true, DataType.STRING_FIELD);
		addField("primaryEmail", false, true, DataType.BOOLEAN_FIELD);
		entityDisplayWidget.add(emailTypeF);
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee/email/" + TreeEmployeePanel.instance().getEntityId();
	}

}

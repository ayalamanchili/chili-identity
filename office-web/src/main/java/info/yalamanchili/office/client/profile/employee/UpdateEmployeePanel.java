package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.UpdateComposite;

import com.google.gwt.json.client.JSONObject;

public class UpdateEmployeePanel extends UpdateComposite {

	public UpdateEmployeePanel(JSONObject entity) {
		initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
	}

	@Override
	protected JSONObject populateEntityFromFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateButtonClicked() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void populateFieldsFromEntity(JSONObject entity) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected String getURI() {
		// TODO Auto-generated method stub
		return null;
	}
}

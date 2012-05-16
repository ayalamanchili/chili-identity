package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.FlowPanel;

public class ProfileHome extends ALComposite {

	protected FlowPanel panel = new FlowPanel();

	public ProfileHome() {
		init(panel);
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
		JSONObject user = OfficeWelcome.instance().user;
		panel.add(new ReadEmployeePanel(user.get("employee").isObject()));
	}
}

package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhones;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.DisclosurePanel;
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
		// TODO check for null pointer
		JSONObject employee = OfficeWelcome.instance().user.get("employee").isObject();
		panel.add(new ReadEmployeePanel(employee));
		panel.add(getPhonesPanel(employee.get("id").isString().stringValue()));
		// TODO add disclosure planel for phones, emails, reports to and
		// emergency contact.
	}

	protected DisclosurePanel getPhonesPanel(String empId) {
		DisclosurePanel phonesPanel = new DisclosurePanel("Phones");
		phonesPanel.setContent(new ReadAllPhones(empId));
		return phonesPanel;
	}
}

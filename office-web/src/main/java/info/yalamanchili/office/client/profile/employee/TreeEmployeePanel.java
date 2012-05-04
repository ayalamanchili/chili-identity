package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddresses;
import info.yalamanchili.office.client.profile.email.ReadAllEmails;

import com.google.gwt.json.client.JSONObject;

public class TreeEmployeePanel extends TreePanelComposite {

	protected static final String ADDRESS_NODE = "address";
	protected static final String EMAIL_NODE = "email";

	public TreeEmployeePanel(String entityId) {
		super(entityId);
		init("Employee", OfficeWelcome.constants);
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
		addFirstChildLink("Addresses", ADDRESS_NODE);
		addFirstChildLink("Emails", EMAIL_NODE);
	}

	@Override
	public void treeNodeSelected(String entityNodeKey) {
		if (ADDRESS_NODE.equals(entityNodeKey)) {
			TabPanel.instance().adminPanel.clear();
			TabPanel.instance().adminPanel.entityPanel
					.add(new ReadAllAddresses(entityId));
			TabPanel.instance().adminPanel.entityPanel
					.add(new AddressOptionsPanel());
		}
		if (EMAIL_NODE.equals(entityNodeKey)) {
			TabPanel.instance().adminPanel.clear();
			TabPanel.instance().adminPanel.entityPanel
					.add(new ReadAllEmails(entityId));
			TabPanel.instance().adminPanel.entityPanel
					.add(new AddressOptionsPanel());
		}
	}

	@Override
	public JSONObject loadEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void showEntity() {
		// TODO Auto-generated method stub

	}

}

package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddresses;
import info.yalamanchili.office.client.profile.email.EmailOptionsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmails;
import info.yalamanchili.office.client.profile.phone.PhoneOptionsPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhones;

import com.google.gwt.json.client.JSONObject;

public class TreeEmployeePanel extends TreePanelComposite {

	protected static final String ADDRESS_NODE = "address";
	protected static final String EMAIL_NODE = "email";
	protected static final String PHONE_NODE = "phone";

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
		addFirstChildLink("Phones", PHONE_NODE);
	}

	@Override
	public void treeNodeSelected(String entityNodeKey) {
		if (ADDRESS_NODE.equals(entityNodeKey)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddresses(entityId));
			TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
		}
		if (EMAIL_NODE.equals(entityNodeKey)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmails(entityId));
			TabPanel.instance().myOfficePanel.entityPanel.add(new EmailOptionsPanel());
		}
		if (PHONE_NODE.equals(entityNodeKey)) {
			TabPanel.instance().myOfficePanel.entityPanel.clear();
			TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhones(entityId));
			TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());
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

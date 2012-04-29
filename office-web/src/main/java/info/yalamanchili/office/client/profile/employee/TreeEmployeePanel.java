package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.ReadAllAddresses;

import com.google.gwt.json.client.JSONObject;

public class TreeEmployeePanel extends TreePanelComposite {

	protected static final String ADDRESS_NODE = "address";

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

	}

	@Override
	public void treeNodeSelected(String entityNodeKey) {
		if (ADDRESS_NODE.equals(entityNodeKey)) {
			TabPanel.instance().adminPanel.clear();
			TabPanel.instance().adminPanel.add(new ReadAllAddresses(entityId));
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

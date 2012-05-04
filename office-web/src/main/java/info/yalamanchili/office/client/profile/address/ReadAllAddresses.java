package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class ReadAllAddresses extends ReadAllComposite {
	private static Logger logger = Logger.getLogger(ReadAllAddresses.class
			.getName());

	public static ReadAllAddresses instance;

	public ReadAllAddresses(String parentId) {
		instance = this;
		this.parentId = parentId;
		initTable("Address", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		HttpServiceAsync.instance().doGet(
				getEmployeeAddressesURL(parentId, 0, 10),
				OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
						postFetchTable(result);
					}

				});

	}

	public String getEmployeeAddressesURL(String employeeId, Integer start,
			Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/addresses/"
				+ employeeId + "/" + start.toString() + "/" + limit.toString();
	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getKeyValue("Type"));
		table.setText(0, 2, getKeyValue("Street 1"));
		table.setText(0, 3, getKeyValue("Street 2"));
		table.setText(0, 4, getKeyValue("City"));
		table.setText(0, 5, getKeyValue("State"));
		table.setText(0, 6, getKeyValue("Country"));
		table.setText(0, 7, getKeyValue("Zip"));

	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createViewIcon(i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity, "TODO"));
			table.setText(i, 2, JSONUtils.toString(entity, "street1"));
			table.setText(i, 3, JSONUtils.toString(entity, "street2"));
			table.setText(i, 4, JSONUtils.toString(entity, "city"));
			table.setText(i, 5, JSONUtils.toString(entity, "state"));
			table.setText(i, 6, JSONUtils.toString(entity, "country"));
			table.setText(i, 7, JSONUtils.toString(entity, "zip"));
		}
	}

	@Override
	public void viewClicked(int row, int col) {
		TabPanel.instance().adminPanel.clear();
		// TabPanel.instance().adminPanel.add(new ReadEmployeePanel(
		// getEntityId(row)));
		// TabPanel.instance().adminPanel.sidePanelCenter.clear();
		// RootLayout.instance().sidePanelTop.add(new TreeEmployeePanel());
	}
}

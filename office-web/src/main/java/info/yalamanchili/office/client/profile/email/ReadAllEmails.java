package info.yalamanchili.office.client.profile.email;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class ReadAllEmails extends ReadAllComposite {

	private static Logger logger = Logger.getLogger(ReadAllEmails.class
			.getName());

	public static ReadAllEmails instance;

	public ReadAllEmails(String parentId) {
		instance = this;
		this.parentId = parentId;
		initTable("Email", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		HttpServiceAsync.instance().doGet(
				getEmployeeEmailsURL(parentId, 0, 10),
				OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
						postFetchTable(result);
					}

				});

	}

	public String getEmployeeEmailsURL(String employeeId, Integer start,
			Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/emails/table/"
				+ employeeId + "/" + start.toString() + "/" + limit.toString();
	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getKeyValue("Type"));
	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createViewIcon(i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity, "TODO"));
			table.setText(i, 2, JSONUtils.toString(entity, "email"));
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.RootLayout;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

/**
 * 
 * @author ayalamanchili
 */
public class ReadAllEmployees extends ReadAllComposite {

	private static Logger logger = Logger.getLogger(ReadAllEmployees.class
			.getName());

	public static ReadAllEmployees instance;

	public ReadAllEmployees() {
		instance = this;
		initTable("Employee", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		// TODO externalize the limit size for read all
		HttpServiceAsync.instance().doGet(getReadAllEmployeesURL(0, 10), null,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
						postFetchTable(result);
					}

				});

	}

	public String getReadAllEmployeesURL(Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/table/"
				+ start.toString() + "/" + limit.toString();
	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getKeyValue("First Name"));
		table.setText(0, 2, getKeyValue("Middle Name"));
		table.setText(0, 3, getKeyValue("Last Name"));
		table.setText(0, 4, getKeyValue("Date of Birth"));
		table.setText(0, 5, getKeyValue("Sex"));
		table.setText(0, 6, getKeyValue("Start Date"));
		table.setText(0, 7, getKeyValue("Social Security Number"));

	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createViewIcon(i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
			table.setText(i, 2, JSONUtils.toString(entity, "middleName"));
			table.setText(i, 3, JSONUtils.toString(entity, "lastName"));
			table.setText(i, 4, JSONUtils.toString(entity, "dateOfBirth"));
			table.setText(i, 5, JSONUtils.toString(entity, "sex"));
			table.setText(i, 6, JSONUtils.toString(entity, "startDate"));
			table.setText(i, 7, JSONUtils.toString(entity, "ssn"));
		}
	}

	@Override
	public void viewClicked(int row, int col) {
		TabPanel.instance().adminPanel.clear();
		TabPanel.instance().adminPanel.add(new ReadEmployeePanel(
				getEntityId(row)));
		RootLayout.instance().sidePanelTop.clear();
		RootLayout.instance().sidePanelTop.add(new TreeEmployeePanel());
	}
}

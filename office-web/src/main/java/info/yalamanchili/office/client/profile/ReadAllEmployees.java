/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;

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
		// TODO externalize the readall table
		HttpServiceAsync.instance().doGet(getReadAllEmployeesURL(0, 10), null,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String arg0) {
						logger.info(arg0);
					}

				});

	}

	public String getReadAllEmployeesURL(Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/"
				+ start.toString() + "/" + limit.toString();
	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getClassValue("firstName"));
		table.setText(0, 2, getClassValue("middleName"));
		table.setText(0, 3, getClassValue("lastName"));
		table.setText(0, 4, getClassValue("dateOfBirth"));
		table.setText(0, 5, getClassValue("sex"));
		table.setText(0, 6, getClassValue("startDate"));
		table.setText(0, 6, getClassValue("ssn"));

	}

	@Override
	public void fillData(JSONArray entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewClicked(int row, int col) {
		// TODO Auto-generated method stub

	}
}

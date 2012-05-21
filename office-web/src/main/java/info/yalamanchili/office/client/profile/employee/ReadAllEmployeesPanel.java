/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

/**
 * 
 * @author ayalamanchili
 */
public class ReadAllEmployeesPanel extends ReadAllComposite {

	private static Logger logger = Logger.getLogger(ReadAllEmployeesPanel.class.getName());

	public static ReadAllEmployeesPanel instance;

	public ReadAllEmployeesPanel() {
		instance = this;
		initTable("Employee", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		// TODO externalize the limit size for read all
		HttpServiceAsync.instance().doGet(getReadAllEmployeesURL(0, 10), OfficeWelcome.instance().getHeaders(), false,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
						postFetchTable(result);
					}

				});

	}

	public String getReadAllEmployeesURL(Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/" + start.toString() + "/" + limit.toString();
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

	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createOptionsWidget(OptionsType.READ, i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity, "firstName"));
			table.setText(i, 2, JSONUtils.toString(entity, "middleInitial"));
			table.setText(i, 3, JSONUtils.toString(entity, "lastName"));
			table.setText(i, 4, JSONUtils.toString(entity, "dateOfBirth"));
			table.setText(i, 5, JSONUtils.toString(entity, "sex"));
			table.setText(i, 6, JSONUtils.toString(entity, "startDate"));
		}
	}

	@Override
	public void viewClicked(String entityId) {
		TabPanel.instance().myOfficePanel.clear();
		TabPanel.instance().myOfficePanel.entityPanel.add(new ReadEmployeePanel(entityId));
		TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entityId));
	}

	@Override
	public void deleteClicked(String entityId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateClicked(String entityId) {
		// TODO Auto-generated method stub

	}
}

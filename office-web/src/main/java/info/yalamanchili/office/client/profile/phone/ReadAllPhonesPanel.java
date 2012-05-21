package info.yalamanchili.office.client.profile.phone;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class ReadAllPhonesPanel extends ReadAllComposite {

	private static Logger logger = Logger.getLogger(ReadAllPhonesPanel.class.getName());

	public static ReadAllPhonesPanel instance;

	public ReadAllPhonesPanel(String parentId) {
		instance = this;
		this.parentId = parentId;
		initTable("Phone", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		HttpServiceAsync.instance().doGet(getEmployeePhonesURL(parentId, 0, 10), OfficeWelcome.instance().getHeaders(),
				false, new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						postFetchTable(result);
					}

				});

	}

	public String getEmployeePhonesURL(String employeeId, Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/phones/" + employeeId + "/" + start.toString() + "/"
				+ limit.toString();
	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getKeyValue("Type"));
		table.setText(0, 2, getKeyValue("PhoneNumber"));
	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createOptionsWidget(OptionsType.READ_DELETE, i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity.get("phoneType"), "phoneType"));
			table.setText(i, 2, JSONUtils.toString(entity, "phoneNumber"));
		}
	}

	@Override
	public void viewClicked(String entityId) {
		// TODO Auto-generated method stub
		
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

package info.yalamanchili.office.client.profile.reportsto;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.ReadAllComposite;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;

public class ReadAllReportsToPanel extends ReadAllComposite {

	private static ReadAllReportsToPanel instance;

	public static ReadAllReportsToPanel instance() {
		return instance;
	}

	public ReadAllReportsToPanel(String parentId) {
		instance = this;
		this.parentId = parentId;
		initTable("ReportsTo", OfficeWelcome.constants);
	}

	@Override
	public void preFetchTable(int start) {
		HttpServiceAsync.instance().doGet(getReadAllURL(0, 10), OfficeWelcome.instance().getHeaders(), true,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						postFetchTable(result);
					}

				});

	}

	@Override
	public void createTableHeader() {
		table.setText(0, 0, getKeyValue("Table_Action"));
		table.setText(0, 1, getKeyValue("Primary"));
		table.setText(0, 2, getKeyValue("Role"));
		table.setText(0, 3, getKeyValue("First Name"));
		table.setText(0, 4, getKeyValue("Last Name"));

	}

	@Override
	public void fillData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			createOptionsWidget(OptionsType.READ_DELETE, i, JSONUtils.toString(entity, "id"));
			table.setText(i, 1, JSONUtils.toString(entity, "rtPrimary"));
			table.setText(i, 2, JSONUtils.toString(entity, "reportsToRole"));
			table.setText(i, 3, JSONUtils.toString(entity.get("contact"), "firstName"));
			table.setText(i, 4, JSONUtils.toString(entity.get("contact"), "lastName"));
		}
	}

	// TODO move to composite
	public String getReadAllURL(Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/reportstos/" + parentId + "/" + start.toString() + "/"
				+ limit.toString();
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

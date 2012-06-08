package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.GenericSearchPanel;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;

public class EmployeeSearchPanel extends GenericSearchPanel {
	private static Logger logger = Logger.getLogger(EmployeeSearchPanel.class.getName());

	@Override
	protected void onSearchClicked(ClickEvent clickEvent) {
		HttpServiceAsync.instance().doGet(getEmployeesearchURL(searchTextBox.getText(), 0, 10),
				OfficeWelcome.instance().getHeaders(), true, new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
						if (result == null) {
							new ResponseStatusWidget().show("no results");
						} else {
							TabPanel.instance().myOfficePanel.entityPanel.clear();
							JSONArray results = JSONUtils.toJSONArray(JSONParser.parseLenient(result).isObject()
									.get("employee"));
							TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllEmployeesPanel(results));
						}
					}
				});
	}

	public String getEmployeesearchURL(String searchText, Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/search/" + searchText + "/" + start.toString() + "/"
				+ limit.toString();
	}

}

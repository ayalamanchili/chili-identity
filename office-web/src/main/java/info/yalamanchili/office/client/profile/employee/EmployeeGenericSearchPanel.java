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

public class EmployeeGenericSearchPanel extends GenericSearchPanel {
	private static Logger logger = Logger.getLogger(EmployeeGenericSearchPanel.class.getName());

	@Override
	protected void onSearchClicked(ClickEvent clickEvent) {
		
	}

	public String getEmployeesearchURL(String searchText, Integer start, Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/search/" + searchText + "/" + start.toString() + "/"
				+ limit.toString();
	}

}

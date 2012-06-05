package info.yalamanchili.office.client.search;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class SearchPanel extends Composite implements ClickHandler {

	private static Logger logger = Logger
			.getLogger(SearchPanel.class.getName());

	protected FlowPanel mainPanel = new FlowPanel();

	private Label searchLbl = new Label("EnterSearchText");

	protected TextBox searchTB = new TextBox();

	private Button searchButton = new Button("Search");

	public SearchPanel() {
		initWidget(mainPanel);
		mainPanel.add(searchLbl);
		mainPanel.add(searchTB);
		mainPanel.add(searchButton);
		searchButton.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent arg0) {

		logger.info("in am on onclick");
		HttpServiceAsync.instance().doGet(
				getEmployeesearchURL(searchTB.getText(), 0, 10),
				OfficeWelcome.instance().getHeaders(), true,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String result) {
						logger.info(result);
					}
				});
	}

	public String getEmployeesearchURL(String searchText, Integer start,
			Integer limit) {
		return OfficeWelcome.constants.root_url() + "employee/search/"
				+ searchText + "/" + start.toString() + "/" + limit.toString();
	}

}

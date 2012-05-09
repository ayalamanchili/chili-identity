package info.yalamanchili.office.client.profile.emailtype;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;

public class SelectEmailTypeWidget extends ALComposite implements ClickHandler, ChangeHandler {
	private static Logger logger = Logger.getLogger(SelectEmailTypeWidget.class.getName());
	HorizontalPanel panel = new HorizontalPanel();

	protected Label label = new Label();

	protected ListBox listBox = new ListBox();

	protected Map<Integer, String> values = new HashMap<Integer, String>();

	public SelectEmailTypeWidget() {
		init(panel);
		fetchDropDownData();
	}

	protected void fetchDropDownData() {
		HttpServiceAsync.instance().doGet(getDropDownURL(0, 10, null, null, null),
				OfficeWelcome.instance().getHeaders(), false, new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String entityString) {
						logger.info(entityString);
						JSONObject table = (JSONObject) JSONParser.parseLenient(entityString);
						if (table.get("emailType") != null) {
							values = processDropDownData(JSONUtils.toJSONArray(table.get("emailType")));
							populateDropDown(values);
						}
					}

				});
	}

	protected Map<Integer, String> processDropDownData(JSONArray entities) {
		for (int i = 1; i <= entities.size(); i++) {
			JSONObject entity = (JSONObject) entities.get(i - 1);
			logger.info(entity.toString());
			logger.info(entity.get("id").toString());
			logger.info(entity.get("emailType").toString());
			Integer id = Integer.valueOf(JSONUtils.toString(entity, "id"));
			String value = JSONUtils.toString(entity, "emailType");
			values.put(id, value);
		}
		return values;
	}

	protected void populateDropDown(Map<Integer, String> values) {
		int i = 1;
		for (Integer key : values.keySet()) {
			listBox.insertItem(values.get(key), key.toString(), i);
			i++;
		}
	}

	@Override
	protected void addListeners() {
		listBox.addClickHandler(this);
	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void addWidgets() {
		panel.add(label);
		panel.add(listBox);
	}

	@Override
	public void onChange(ChangeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(ClickEvent arg0) {
		// TODO Auto-generated method stub

	}

	protected String getDropDownURL(Integer start, Integer limit, String param1, String param2, String param3) {
		return OfficeWelcome.constants.root_url() + "emailtype/dropdown/" + start.toString() + "/" + limit.toString();
	}

}

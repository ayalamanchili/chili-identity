/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService.HttpServiceAsync;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
/**
 *
 * @author raghu
 */
public class ReadSkillSetPanel extends  ReadComposite{
    public ReadSkillSetPanel(String id) {
		initReadComposite(id, "Employee", OfficeWelcome.constants);
	}
    
    @Override
	public void loadEntity(String entityId) {
		HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String response) {
						entity = (JSONObject) JSONParser.parseLenient(response);
						populateFieldsFromEntity(entity);
					}

				});

	}
    @Override
	protected void addWidgets() {
		addField("lastUpdated", true, true, DataType.DATE_FIELD);
		addField("resumeUrl", true, true, DataType.STRING_FIELD);
		
	}
    @Override
	protected void addListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
	}
    @Override
	protected void addWidgetsBeforeCaptionPanel() {
		// TODO Auto-generated method stub

	}
    @Override
	protected String getURI() {
		return OfficeWelcome.constants.root_url() + "employee/skillset/" + entityId;
	}
    @Override
	public void populateFieldsFromEntity(JSONObject entity) {
		assignFieldValueFromEntity("lastUpdated", entity, DataType.DATE_FIELD);
		assignFieldValueFromEntity("resumeUrl", entity, DataType.STRING_FIELD);
		
	}
}

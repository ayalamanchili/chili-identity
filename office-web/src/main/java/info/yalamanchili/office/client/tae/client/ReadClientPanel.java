/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class ReadClientPanel extends ReadComposite {

    private static ReadClientPanel instance;

	public static ReadClientPanel instance() {
		return instance;
	}

	public ReadClientPanel(JSONObject entity) {
		instance = this;
		initReadComposite(entity, "Client", OfficeWelcome.constants);
	}

	public ReadClientPanel(String id) {
		initReadComposite(id, "Client", OfficeWelcome.constants);
	}
    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
				new ALAsyncCallback<String>() {

					@Override
					public void onResponse(String response) {
						entity = (JSONObject) JSONParser.parseLenient(response);
						populateFieldsFromEntity(entity);
					}

				});
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
		assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
        addField("name", true, false, DataType.STRING_FIELD);
		addField("description", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/" + entityId;
    }
    
}

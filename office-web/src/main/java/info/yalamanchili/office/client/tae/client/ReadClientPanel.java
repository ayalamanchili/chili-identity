/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.client;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void addListeners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void configure() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void addWidgets() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadExternalRefPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadExternalRefPanel.class.getName());

    public ReadExternalRefPanel(JSONObject entity) {
        initReadComposite(entity, "ExternalRef", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("source", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("externalId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityId", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("source", true, false, DataType.STRING_FIELD);
        addField("externalId", true, false, DataType.STRING_FIELD);
        addField("targetEntityName", true, false, DataType.STRING_FIELD);
        addField("targetEntityId", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "external-ref";
    }

    @Override
    protected boolean enableClone() {
        return true;
    }

    @Override
    protected void cloneClicked() {
        HttpServiceAsync.instance().doGet(getURI() + "/clone/" + getEntityId(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        logger.info(arg0);
                        TabPanel.instance().adminPanel.entityPanel.clear();
                        TabPanel.instance().adminPanel.entityPanel.add(new UpdateExternalReferencesPanel(JSONParser.parseLenient(arg0).isObject()));
                    }
                });
    }
}

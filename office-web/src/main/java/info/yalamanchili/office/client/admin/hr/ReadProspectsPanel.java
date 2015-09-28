/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.hr;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author radhika.mukkala
 */
public class ReadProspectsPanel extends ReadComposite{
    
    private static ReadProspectsPanel instance;
    
    public static ReadProspectsPanel instance() {
        return instance;
    }
     public ReadProspectsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Prospect", OfficeWelcome.constants);
    }

    public ReadProspectsPanel(String id) {
        initReadComposite(id, "Prospect", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("screenedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("contactDetails", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("referredBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("processDocSentDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("screenedBy", true, false, DataType.STRING_FIELD);
        addField("name", true, false, DataType.STRING_FIELD);
        addField("contactDetails", true, false, DataType.TEXT_AREA_FIELD);
        addField("referredBy", true, false, DataType.STRING_FIELD);
        addField("processDocSentDate", true, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
       return OfficeWelcome.constants.root_url() + "prospect/" + entityId;
    }
    
}

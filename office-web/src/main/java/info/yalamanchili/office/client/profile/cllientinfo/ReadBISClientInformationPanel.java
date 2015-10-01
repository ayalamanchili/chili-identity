/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadBISClientInformationPanel extends ReadComposite {

    private static ReadBISClientInformationPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());

    public ReadBISClientInformationPanel(String id) {
        instance = this;
        initReadComposite(id, "Client Information", OfficeWelcome.constants);
    }

    public ReadBISClientInformationPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Client Information", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("BillingRate", entity, null);
        assignFieldValueFromEntity("BillingRateDuration", entity, null);
        assignFieldValueFromEntity("CPDCreatedBy", entity, null);
        assignFieldValueFromEntity("CPDCreatedDate", entity, null);
        assignFieldValueFromEntity("CPDCreatedUserId", entity, null);
        assignFieldValueFromEntity("CPDLastModifiedBy", entity, null);
        assignFieldValueFromEntity("CPDLastModifiedDate", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("BillingRate", true, false, DataType.INTEGER_FIELD);
        addField("BillingRateDuration", true, false, DataType.STRING_FIELD);
        addField("CPDCreatedBy", true, false, DataType.STRING_FIELD);
        addField("CPDCreatedDate", true, false, DataType.DATE_FIELD);
        addField("CPDCreatedUserId", true, false, DataType.INTEGER_FIELD);
        addField("CPDLastModifiedBy", true, false, DataType.STRING_FIELD);
        addField("CPDLastModifiedDate", true, false, DataType.DATE_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

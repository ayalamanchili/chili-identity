/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Rohith.Vallabhaneni
 */
public class ReadInviteCodePanel extends ReadComposite {
    
    private static ReadInviteCodePanel instance;
    private static Logger logger = Logger.getLogger(ReadInviteCodePanel.class.getName());
    
    public static ReadInviteCodePanel instance() {
        return instance;
    }
    
    public ReadInviteCodePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "InviteCodeService", OfficeWelcome.constants2);
    }
    
    public ReadInviteCodePanel(String id) {
        instance = this;
        initReadComposite(id, "InviteCodeService", OfficeWelcome.constants2);
    }
    
    @Override
    public void loadEntity(String entityId) {
        logger.info("load entity");
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
        assignFieldValueFromEntity("invitationCode", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("expiryDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("validFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invitationType", entity, DataType.ENUM_FIELD);
    }
    
    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        addField("invitationCode", true, false, DataType.STRING_FIELD);
        addField("expiryDate", true, false, DataType.DATE_FIELD);
        addField("validFromDate", true, false, DataType.DATE_FIELD);
        addField("email", true, false, DataType.STRING_FIELD);
        addEnumField("invitationType", true, false, InvitationType.names());
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invitecode/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllInviteCodePanel.instance;
     }
}

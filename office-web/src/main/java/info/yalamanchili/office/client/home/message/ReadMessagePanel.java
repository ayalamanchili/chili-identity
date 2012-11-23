/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home.message;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.RichTextArea;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.ReadComposite;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class ReadMessagePanel extends ReadComposite{

private static ReadMessagePanel instance;
final RichTextArea textArea = new RichTextArea();

 public static ReadMessagePanel instance() {
        return instance;
    }

    public ReadMessagePanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Message", OfficeWelcome.constants);
    }

    public ReadMessagePanel(String id) {
        initReadComposite(id, "Message", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("tos", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("subject", entity, DataType.STRING_FIELD);
//        assignFieldValueFromEntity("message", entity, DataType.STRING_FIELD);
         textArea.setHTML(JSONUtils.toString(entity, "postContent"));
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
        addField("tos", true, false, DataType.STRING_FIELD);
        addField("subject", true, false, DataType.STRING_FIELD);
        addField("message", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "message/" + entityId;
    }
    
}

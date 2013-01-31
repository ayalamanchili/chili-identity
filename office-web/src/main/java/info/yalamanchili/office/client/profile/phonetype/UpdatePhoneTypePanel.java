/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.phonetype;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;

import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author Bapuji
 */
public class UpdatePhoneTypePanel extends UpdateComposite {
    
    public UpdatePhoneTypePanel(JSONObject entity) {
        initUpdateComposite(entity, "PhoneType", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("phoneType", entity);
       
        
        return entity;
    }
     @Override
    protected void updateButtonClicked() {
        // OfficeWelcome.logger.info("dddd"+entity);
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postUpdateSuccess(arg0);
            }
        });

    }
     @Override
    public void populateFieldsFromEntity(JSONObject entity) {
       assignFieldValueFromEntity("phoneType", entity, DataType.STRING_FIELD);
        
       
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Phone Type Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhoneTypePanel());
    }
    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
       addField("phoneType", false, true, DataType.STRING_FIELD);
        
        
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "phonetype";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.client;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.rpc.HttpService;

/**
 *
 * @author raghu
 */
public class UpdateClientPanel extends UpdateComposite {

     public UpdateClientPanel(JSONObject entity) {
        initUpdateComposite(entity, "Client", OfficeWelcome.constants);
    }
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated client");
        TabPanel.instance().TimeandExpensePanel.sidePanelTop.clear();
        TabPanel.instance().TimeandExpensePanel.sidePanelTop.add(new ClientSidePanel());
        TabPanel.instance().TimeandExpensePanel.entityPanel.clear(); 
        TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllClientsPanel());
    }

    @Override
    protected void addListeners() {
        
    }

    @Override
    protected void configure() {
       
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
       
    }

    @Override
    protected String getURI() {
         return OfficeWelcome.constants.root_url() + "client";
    }
    
}

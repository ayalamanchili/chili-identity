/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.preferences;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
public class UpdatePreferencesPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdatePreferencesPanel.class.getName());
    
    public UpdatePreferencesPanel(JSONObject entity) {
        initUpdateComposite(entity, "Preferences", OfficeWelcome.constants);
        
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("enableEmailNotifications", entity);
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Preferences");
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("enableEmailNotifications", entity, DataType.BOOLEAN_FIELD);
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
    protected void addWidgets() {
        addField("enableEmailNotifications", false, false, DataType.BOOLEAN_FIELD);
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "preferences";
    }
    
    @Override
    protected boolean showDocumentationLink() {
        return true;
    }
    
    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "profile/preferences.html";
    }
}

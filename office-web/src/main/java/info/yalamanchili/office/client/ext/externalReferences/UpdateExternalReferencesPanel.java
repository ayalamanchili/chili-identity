/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author benerji.v
 */
public class UpdateExternalReferencesPanel extends UpdateComposite{
    public UpdateExternalReferencesPanel(JSONObject entity) {
        initUpdateComposite(entity, "ExternalReferences", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("source", entity);
        assignEntityValueFromField("externalId", entity);
        assignEntityValueFromField("targetEntityName", entity);
        assignEntityValueFromField("targetEntityId", entity);
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
        assignFieldValueFromEntity("source", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("externalId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityId", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client");
        TabPanel.instance().getAdminPanel().entityPanel.clear();
        TabPanel.instance().getAdminPanel().sidePanelTop.clear();
        TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllExternalRefPanel());
        
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("source", false, true, DataType.STRING_FIELD);
        addField("externalId", false, true, DataType.STRING_FIELD);
        addField("targetEntityName", false, true, DataType.STRING_FIELD);
        addField("targetEntityId", false, true, DataType.STRING_FIELD);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
                return OfficeWelcome.constants.root_url() + "external-ref";

    }
    
}

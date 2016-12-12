/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.company;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWidget;

/**
 *
 * @author chaitanya.k
 */
public class ReadCompanyPanel extends ReadComposite {

    private static ReadCompanyPanel instance;

    public static ReadCompanyPanel instance() {
        return instance;
    }

    public ReadCompanyPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Company", OfficeWelcome.constants);
    }

    public ReadCompanyPanel(String id) {
        initReadComposite(id, "Company", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("establishedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("abbreviation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("logoURL", entity, DataType.IMAGE_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", true, false, DataType.STRING_FIELD);
        addField("establishedDate", true, false, DataType.DATE_FIELD);
        addField("abbreviation", true, false, DataType.STRING_FIELD);
        addField("logoURL", true, false, DataType.IMAGE_FIELD);

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "company/" + entityId;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllCompanyPanel.instance;
    }    
}

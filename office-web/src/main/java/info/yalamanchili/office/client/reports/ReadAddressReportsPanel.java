/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reports;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author hemalatha.duggirala
 */
public class ReadAddressReportsPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadEmployeePanel.class.getName());
    private static ReadAddressReportsPanel instance;

    public static ReadAddressReportsPanel instance() {
        return instance;
    }

    public ReadAddressReportsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Employee", OfficeWelcome.constants);
    }
    public ReadAddressReportsPanel(String id) {
        initReadComposite(id, "Employee", OfficeWelcome.constants);
    }

     @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("this is the response from the server" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
       // logger.info("ddd" + entity);
       // assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
       // assignFieldValueFromEntity("lastname", entity, DataType.STRING_FIELD);
       // assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
       // assignFieldValueFromEntity("state", entity, DataType.STRING_FIELD);
       // assignFieldValueFromEntity("", entity, DataType.STRING_FIELD);
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
        
        addField("firstName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
    }
 @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/" + entityId;
    }
       @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP, Auth.ROLE.ROLE_CORPORATE_TIME_REPORTS);
    }
    
    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Employee" + "/" + getEntityId();
    }



}

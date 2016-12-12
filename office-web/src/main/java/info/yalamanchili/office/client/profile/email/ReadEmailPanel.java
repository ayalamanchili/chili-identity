/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.email;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.yalamanchili.office.client.profile.emailtype.SelectEmailTypeWidget;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadEmailPanel extends ReadComposite {

    private static ReadEmailPanel instance;
    private static Logger logger = Logger.getLogger(ReadEmailPanel.class.getName());

    public static ReadEmailPanel instance() {
        return instance;
    }

    public ReadEmailPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Email", OfficeWelcome.constants);
    }

    public ReadEmailPanel(String id) {
        initReadComposite(id, "Email", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info("read ec6 response" + response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("primaryEmail", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("emailType", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("email", true, false, DataType.STRING_FIELD);
        addField("primaryEmail", true, false, DataType.BOOLEAN_FIELD);
        addDropDown("emailType", new SelectEmailTypeWidget(true, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.Email" + "/" + getEntityId();
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmailsPanel.instance;
    }    
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "email";
    }
}

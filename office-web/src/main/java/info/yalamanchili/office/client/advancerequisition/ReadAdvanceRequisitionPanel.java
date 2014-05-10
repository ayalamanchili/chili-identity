/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.advancerequisition;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.advancetranscation.AdvanceRequisitionStatus;
import info.yalamanchili.office.client.expense.check.ReadCheckWidget;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadAdvanceRequisitionPanel extends ReadComposite {
    
    private static ReadAdvanceRequisitionPanel instance;
    private static Logger logger = Logger.getLogger(ReadAdvanceRequisitionPanel.class.getName());
    
    public static ReadAdvanceRequisitionPanel instance() {
        return instance;
    }
    
    public ReadAdvanceRequisitionPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "AdvanceRequisition", OfficeWelcome.constants);
    }
    
    public ReadAdvanceRequisitionPanel(String id) {
        instance = this;
        initReadComposite(id, "AdvanceRequisition", OfficeWelcome.constants);
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
        assignFieldValueFromEntity("purpose", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("amount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("neededBy", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        if (entity.containsKey("check")) {
            logger.info(entity.get("check").isObject().toString());
            entityFieldsPanel.add(new ReadCheckWidget(entity.get("check").isObject()));
        }
    }
    
    @Override
    protected void addListeners() {
    }
    
    @Override
    protected void configure() {
    }
    
    @Override
    protected void addWidgets() {
        addField("purpose", true, false, DataType.STRING_FIELD);
        addField("amount", true, false, DataType.CURRENCY_FIELD);
        addField("neededBy", true, false, DataType.DATE_FIELD);
        addEnumField("status", true, false, AdvanceRequisitionStatus.names());
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "advancerequisition/" + getEntityId();
    }
    
    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(ROLE.ROLE_EXPENSE);
    }
    
    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.expense.AdvanceRequisition" + "/" + getEntityId();
    }
}

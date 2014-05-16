/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense.check;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.UpdateAddressWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class UpdateCheckWidget extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdateCheckWidget.class.getName());
    UpdateAddressWidget updateAddressWidget;
    
    public UpdateCheckWidget(JSONObject entity) {
        initUpdateComposite(entity, "Check", OfficeWelcome.constants);
        update.setVisible(false);
    }
    
    @Override
    public JSONObject populateEntityFromFields() {
        assignEntityValueFromField("payableTo", entity);
        assignEntityValueFromField("checkAmount", entity);
        assignEntityValueFromField("notes", entity);
        if (updateAddressWidget != null) {
            entity.put("checkMalingAddress", updateAddressWidget.populateEntityFromFields());
        }
        return entity;
    }
    
    @Override
    protected void updateButtonClicked() {
    }
    
    @Override
    protected void postUpdateSuccess(String result) {
        
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("payableTo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("checkAmount", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        if (entity.containsKey("checkMalingAddress")) {
            updateAddressWidget = new UpdateAddressWidget(entity.get("checkMalingAddress").isObject());
            entityFieldsPanel.add(updateAddressWidget);
        }
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
        addField("payableTo", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("checkAmount", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }
    
    @Override
    protected String getURI() {
        return "";
    }
}

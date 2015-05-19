/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.expense;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;

/**
 *
 * @author Sadipan.B
 */
public class CreateImmigrationCheckItemPanel extends CreateComposite {    
    
    public CreateImmigrationCheckItemPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("CheckRequisitionItem", OfficeWelcome.constants);
    }
    
    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();        
        assignEntityValueFromField("itemName", entity);
        assignEntityValueFromField("amount", entity);        
        return entity;
    }
    
        
    @Override
    protected void addWidgets() {
        addField("itemName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("amount", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void createButtonClicked() {     
    }

    @Override
    protected void addButtonClicked() {
    }

    @Override
    protected void postCreateSuccess(String result) {
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        create.setVisible(false);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return null;
    }
        

}

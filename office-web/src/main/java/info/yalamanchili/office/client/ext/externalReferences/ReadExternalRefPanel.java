/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.ext.externalReferences;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class ReadExternalRefPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadExternalRefPanel.class.getName());

    public ReadExternalRefPanel(JSONObject entity) {
        initReadComposite(entity, "ExternalRef", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("source", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("externalId", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("targetEntityId", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("source", true, false, DataType.STRING_FIELD);
        addField("externalId", true, false, DataType.STRING_FIELD);
        addField("targetEntityName", true, false, DataType.STRING_FIELD);
        addField("targetEntityId", true, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "external-ref";
    }

    @Override
    protected boolean enableClone() {
        return false;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
     protected ReadAllComposite getReadAllPanel() {
        return ReadAllExternalRefPanel.instance;
    }
}

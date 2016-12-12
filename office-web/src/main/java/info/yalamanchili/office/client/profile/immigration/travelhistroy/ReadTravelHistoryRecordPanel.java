/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.travelhistroy;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadTravelHistoryRecordPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadTravelHistoryRecordPanel.class.getName());

    public ReadTravelHistoryRecordPanel(JSONObject entity) {
        initReadComposite(entity, "TravelHistoryRecord", OfficeWelcome.constants2);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("typeOfVisa", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("arrivalDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("departureDate", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("typeOfVisa", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("arrivalDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("departureDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return null;
    }
    
    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllTravelHistoryRecordPanel.instance;
    }

    @Override
    public void loadEntity(String entityId) {

    }
}

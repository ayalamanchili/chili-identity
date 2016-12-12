/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.educationrecord;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Sudha
 */
public class ReadEducationRecordPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadEducationRecordPanel.class.getName());

    public ReadEducationRecordPanel(JSONObject entity) {
        initReadComposite(entity, "EducationRecord", OfficeWelcome.constants2);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("degreeOfStudy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("fieldOfStudy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("nameOfSchool", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("address", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateDegreeAwarded", entity, DataType.DATE_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("degreeOfStudy", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("fieldOfStudy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nameOfSchool", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("address", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateDegreeAwarded", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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
        return ReadAllEducationRecordPanel.instance;
    }
    
    @Override
    public void loadEntity(String entityId) {
    }
}

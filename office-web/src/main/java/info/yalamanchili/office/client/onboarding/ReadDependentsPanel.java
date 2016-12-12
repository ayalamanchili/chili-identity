/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadDependentsPanel extends ReadComposite {

    private static ReadDependentsPanel instance;
    private static Logger logger = Logger.getLogger(ReadDependentsPanel.class.getName());
    protected boolean enableBackB = true;

    public static ReadDependentsPanel instance() {
        return instance;
    }

    public ReadDependentsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Dependent", OfficeWelcome.constants);
    }

    public ReadDependentsPanel(JSONObject entity, boolean enableBackB) {
        instance = this;
        this.enableBackB = enableBackB;
        initReadComposite(entity, "Dependent", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("dfirstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dlastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ddateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("relationship", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        addField("dfirstName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dlastName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ddateOfBirth", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("relationship", true, true, Relationship.names(), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return "";
    }

    @Override
    protected boolean enableBack() {
        if (enableBackB == true) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllEmployeeOnBoardingPanel.instance;
    }
}

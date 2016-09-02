/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadInsuranceEnrollmentWidget extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadInsuranceEnrollmentWidget.class.getName());
    EnumField yearsF;

    public ReadInsuranceEnrollmentWidget(JSONObject entity) {
        initReadComposite(entity, "InsuranceEnrollment", OfficeWelcome.constants2);
    }

    public ReadInsuranceEnrollmentWidget(String id) {
        initReadComposite(id, "InsuranceEnrollment", OfficeWelcome.constants2);
    }

    @Override
    public void loadEntity(String entityId) {

    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("year", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("insuranceType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("comments", entity, DataType.TEXT_AREA_FIELD);

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("year", true, false, HealthInsuranceYear.getyears().toArray(new String[0]), Alignment.HORIZONTAL);
        yearsF = (EnumField) fields.get("year");
        addEnumField("insuranceType", true, false, InsuranceType.names(), Alignment.HORIZONTAL);
        addField("comments", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getURI1(String entityId) {
        return "";
    }

    @Override
    protected String getURI() {
        return "";
    }
    
    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllHealthInsuranceEnrollment.instance;
    }
}

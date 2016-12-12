/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.insurance;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class InsuranceEnrollmentPanel extends CreateComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(InsuranceEnrollmentPanel.class.getName());

    EnumField yearsF;

    public InsuranceEnrollmentPanel() {
        super(CreateComposite.CreateCompositeType.CREATE);
        initCreateComposite("InsuranceEnrollment", OfficeWelcome.constants2);
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("year", entity);
        assignEntityValueFromField("insuranceType", entity);
        assignEntityValueFromField("comments", entity);
        entity.put("targetEntityName", new JSONString("targetEntityName"));
        entity.put("targetEntityId", new JSONString("0"));
        logger.info(entity.toString());
        return entity;

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
    protected void addWidgets() {
        addEnumField("year", false, true, HealthInsuranceYear.getyears().toArray(new String[0]), Alignment.HORIZONTAL);
        yearsF = (EnumField) fields.get("year");
        addEnumField("insuranceType", false, true, InsuranceType.names(), Alignment.HORIZONTAL);
        addField("comments", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return "";
    }

}

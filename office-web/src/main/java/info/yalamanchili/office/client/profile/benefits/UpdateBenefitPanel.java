/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.benefits;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.insurance.HealthInsuranceWaiverPanel;
import java.util.logging.Logger;

/**
 *
 * @author Hemanth
 */
public class UpdateBenefitPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateBenefitPanel.class.getName());
    BooleanField enrolledFlagField = new BooleanField(OfficeWelcome.constants2, "enrolled", "Benefit", false, false, Alignment.HORIZONTAL);
    DateField requestedDate = new DateField(OfficeWelcome.constants2, "affectiveDate", "Benefit", false, false, Alignment.HORIZONTAL);
    EnumField benefitType = new EnumField(OfficeWelcome.constants, "benefitType", "Benefit", false, false, BenefitType.names(), Alignment.HORIZONTAL);
    protected String empId;

    HealthInsuranceWaiverPanel insuranceWaiver = new HealthInsuranceWaiverPanel();

    public UpdateBenefitPanel(JSONObject entity) {
        initUpdateComposite(entity, "Benefit", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        entity.put("benefitType", new JSONString(benefitType.getValue()));
        if (insuranceWaiver != null) {
            JSONObject waiver = insuranceWaiver.populateEntityFromFields();
            entity.put("healthInsuranceWaiver", insuranceWaiver.populateEntityFromFields());
        }
        entity.put("enrolled", new JSONString(enrolledFlagField.getValue().toString()));
        assignEntityValueFromField("year", entity);
        if (requestedDate.getDate() != null) {
            entity.put("affectiveDate", new JSONString(DateUtils.toDateString(requestedDate.getDate())));
        }

        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postUpdateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Benefit Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllBenefitsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("benefitType", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("year", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("enrolled", entity, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addEnumField("benefitType", false, false, BenefitType.names(), Alignment.HORIZONTAL);
        addEnumField("year", false, false, YearType.names(), Alignment.HORIZONTAL);
        addField("enrolled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "benefit/save/" + TreeEmployeePanel.instance().getEntityId();
    }
}

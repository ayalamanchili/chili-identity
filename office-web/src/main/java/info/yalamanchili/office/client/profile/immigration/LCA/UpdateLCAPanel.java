/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressWidget;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.SOCCodesAndOccupations;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdateLCAPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateLCAPanel.class.getName());
    protected BooleanField addAddress = new BooleanField(OfficeWelcome.constants, "Add LCA Secondary Address", "LCA", false, false, Alignment.HORIZONTAL);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML addInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    HTML empInfo = new HTML("<h4 style=\"color:#427fed\">" + "Select Consultants</h4>");
    UpdateLCAAddressWidget updateAddressWidget1;
    UpdateLCAAddressWidget updateAddressWidget2;
    CreateAddressWidget createAddressWidget2 = new CreateAddressWidget(CreateAddressPanel.CreateAddressPanelType.MIN);
    boolean isLCASecAddAvail = false;

    public UpdateLCAPanel(JSONObject entity) {
        initUpdateComposite(entity, "LCA", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("candidateNames", entity);
        assignEntityValueFromField("lcaNumber", entity);
        assignEntityValueFromField("lcaFiledDate", entity);
        assignEntityValueFromField("lcaValidFromDate", entity);
        assignEntityValueFromField("lcaValidToDate", entity);
        assignEntityValueFromField("jobTitle", entity);
        assignEntityValueFromField("totalWorkingPositions", entity);
        assignEntityValueFromField("visaClassification", entity);
        assignEntityValueFromField("socCodesAndOccupations", entity);
        assignEntityValueFromField("status", entity);
        // Address Information 1
        if (entity.containsKey("lcaAddress1")) {
            entity.put("lcaAddress1", updateAddressWidget1.populateEntityFromFields());
        }
        // Address Information 2
        if (entity.containsKey("lcaAddress2")) {
            entity.put("lcaAddress2", updateAddressWidget2.populateEntityFromFields());
        }
        if (isLCASecAddAvail) {
            entity.put("lcaAddress2", createAddressWidget2.populateEntityFromFields());
        }
        // Other Information
        assignEntityValueFromField("lcaCurrWageLvl", entity);
        assignEntityValueFromField("lcaCurrMinWage", entity);
        assignEntityValueFromField("lcaCurrMaxWage", entity);
        assignEntityValueFromField("clientName", entity);
        assignEntityValueFromField("vendorName", entity);
        assignEntityValueFromField("nonDisplacement", entity);
        assignEntityValueFromField("lcaPostingSentToVendor", entity);
        assignEntityValueFromField("responseOnLcaPosting", entity);
        assignEntityValueFromField("reminderEmail", entity);
        assignEntityValueFromField("certifiedLcaSentConsultant", entity);
        assignEntityValueFromField("lcaPostingSSTLocation", entity);
        assignEntityValueFromField("lcaFiledInPIF", entity);
        assignEntityValueFromField("workedByEmployees", entity);
        assignEntityValueFromField("withdrawnLCANumber", entity);
        if (fields.containsKey("company") && selectCompanyWidget.getSelectedObject() != null) {
            JSONObject company = selectCompanyWidget.getSelectedObject();
            entity.put("company", company);
        }
        JSONArray employees = new JSONArray();
        int i = 0;
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("candidateNames", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidToDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaCurrWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaCurrMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaCurrMaxWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("totalWorkingPositions", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("visaClassification", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("status", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("socCodesAndOccupations", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("clientName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("nonDisplacement", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaPostingSentToVendor", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("responseOnLcaPosting", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("reminderEmail", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("certifiedLcaSentConsultant", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaPostingSSTLocation", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaFiledInPIF", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("workedByEmployees", entity, null);
        assignFieldValueFromEntity("withdrawnLCANumber", entity, DataType.STRING_FIELD);
        if (fields.containsKey("company")) {
            assignFieldValueFromEntity("company", entity, null);
        }
        if (entity.containsKey("lcaAddress1")) {
            entityFieldsPanel.add(lcaAddress1);
            updateAddressWidget1 = new UpdateLCAAddressWidget(entity.get("lcaAddress1").isObject(), UpdateAddressPanel.UpdateAddressPanelType.MIN);
            entityFieldsPanel.add(updateAddressWidget1);
        }
        if (entity.containsKey("lcaAddress2")) {
            entityFieldsPanel.add(lcaAddress2);
            updateAddressWidget2 = new UpdateLCAAddressWidget(entity.get("lcaAddress2").isObject(), UpdateAddressPanel.UpdateAddressPanelType.MIN);
            entityFieldsPanel.add(updateAddressWidget2);
            entityActionsPanel.remove(addAddress);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated LCA");
        TabPanel.instance().immigrationPanel.entityPanel.clear();
        TabPanel.instance().immigrationPanel.entityPanel.add(new LcaMenu());
        TabPanel.instance().immigrationPanel.entityPanel.add(new ReadAllLCAPanel());
    }

    @Override
    protected void addListeners() {
        addAddress.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        addField("candidateNames", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("totalWorkingPositions", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", false, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("socCodesAndOccupations", false, true, SOCCodesAndOccupations.names(), Alignment.HORIZONTAL);
        addField("lcaValidFromDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", false, true, LCAStatus.names(), Alignment.HORIZONTAL);
        addDropDown("workedByEmployees", selectRecruiterW);
        entityFieldsPanel.add(empInfo);
        entityFieldsPanel.add(wagesInfo);
        addEnumField("lcaCurrWageLvl", false, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(addInfo);
        addField("clientName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("nonDisplacement", false, true, Polar.names(), Alignment.HORIZONTAL);
        addField("lcaPostingSentToVendor", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("responseOnLcaPosting", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reminderEmail", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("certifiedLcaSentConsultant", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaPostingSSTLocation", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledInPIF", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("withdrawnLCANumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityActionsPanel.add(addAddress);
        addAddress.setValue(false);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "lca/update";
    }

    @Override
    public void onClick(ClickEvent event) {
        if (addAddress.getValue()) {
            entityFieldsPanel.add(lcaAddress2);
            entityFieldsPanel.add(createAddressWidget2);
            isLCASecAddAvail = true;
        } else {
            entityFieldsPanel.remove(lcaAddress2);
            entityFieldsPanel.remove(createAddressWidget2);
            isLCASecAddAvail = false;
        }
        if (event.getSource().equals(update)) {
            super.onClick(event);
        }
    }

}

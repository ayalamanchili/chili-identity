/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.LCA;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.immigration.Polar;
import info.yalamanchili.office.client.profile.immigration.SOCCodesAndOccupations;
import info.yalamanchili.office.client.profile.immigration.VisaClassificationType;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadLCAPanel extends TReadComposite {

    private static ReadLCAPanel instance;
    private static Logger logger = Logger.getLogger(ReadLCAPanel.class.getName());
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, false, Alignment.HORIZONTAL);
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML addInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML empInfo = new HTML("<h4 style=\"color:#427fed\">" + "Select Consultants</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    ReadLCAAddressWidget readAddressWidget1;
    ReadLCAAddressWidget readAddressWidget2;
    String lcaAdd1 = "LCA Primary Address";
    String lcaAdd2 = "LCA Secondary Address";

    public ReadLCAPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "LCA", OfficeWelcome.constants2);
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
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("WorkedBy", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    @Override
    protected void addWidgets() {
        addField("candidateNames", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("lcaNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addEnumField("visaClassification", true, true, VisaClassificationType.names(), Alignment.HORIZONTAL, 2, 1);
        entityFieldsPanel.getFlexCellFormatter().setColSpan(2, 2, 2);
        addDropDown("workedByEmployees", selectRecruiterW, 3, 1);
        addDropDown("company", selectCompanyWidget, 3, 2);
        addField("jobTitle", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 4, 1);
        addEnumField("socCodesAndOccupations", true, false, SOCCodesAndOccupations.names(), Alignment.HORIZONTAL, 4, 2);
        addField("lcaValidFromDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 5, 1);
        addField("lcaValidToDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 5, 2);
        addEnumField("lcaCurrWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL, 6, 1);
        addField("lcaCurrMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 1);
        addField("lcaCurrMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 2);
        if (entity.containsKey("lcaAddress1")) {
            readAddressWidget1 = new ReadLCAAddressWidget(entity.get("lcaAddress1").isObject(), lcaAdd1);
            entityFieldsPanel.setWidget(9, 1, readAddressWidget1);
        }
        if (entity.containsKey("lcaAddress2")) {
            readAddressWidget2 = new ReadLCAAddressWidget(entity.get("lcaAddress2").isObject(), lcaAdd2);
            entityFieldsPanel.setWidget(9, 2, readAddressWidget2);
        }
        addField("clientName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 1);
        addField("vendorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 2);
        addField("lcaPostingSentToVendor", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 11, 1);
        addField("responseOnLcaPosting", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 11, 2);
        addEnumField("nonDisplacement", true, false, Polar.names(), Alignment.HORIZONTAL, 12, 1);
        addField("reminderEmail", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 12, 2);
        addField("certifiedLcaSentConsultant", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 13, 1);
        addField("lcaPostingSSTLocation", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 13, 2);
        addField("lcaFiledDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 14, 1);
        addField("lcaFiledInPIF", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 14, 2);
        addField("totalWorkingPositions", true, false, DataType.LONG_FIELD, Alignment.HORIZONTAL, 15, 1);
        addEnumField("status", true, false, LCAStatus.names(), Alignment.HORIZONTAL, 15, 2);
        addField("withdrawnLCANumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 16, 1);
        populateComments();
        alignFields();
    }

    protected final void populateComments() {
        entityFieldsPanel.getFlexCellFormatter().setColSpan(18, 1, 2);
        entityFieldsPanel.setWidget(18, 1, new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.immigration.LCA"));
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.immigration.LCA" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {

    }

    @Override
    protected String getURI() {
        return null;
    }

}

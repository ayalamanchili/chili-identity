/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ReadLCAPanel extends ReadComposite {

    private static Logger logger = Logger.getLogger(ReadPassportPanel.class.getName());
    protected SelectCompanyWidget selectCompanyWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    protected MultiSelectConsultantWidget employeeSelectWidget;
    HTML wagesInfo = new HTML("<h4 style=\"color:#427fed\">" + "Wages Information</h4>");
    HTML addInfo = new HTML("<h4 style=\"color:#427fed\">" + "Additional Information</h4>");
    HTML empInfo = new HTML("<h4 style=\"color:#427fed\">" + "Select Consultants</h4>");
    HTML lcaAddress1 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Primary Address </h4>");
    HTML lcaAddress2 = new HTML("<h4 style=\"color:#427fed\">" + "LCA Secondary Address</h4>");
    ReadLCAAddressWidget readAddressWidget1;
    ReadLCAAddressWidget readAddressWidget2;

    public ReadLCAPanel(JSONObject entity) {
        initReadComposite(entity, "LCA", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("lcaNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaFiledDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("lcaValidToDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lcaCurrWageLvl", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("lcaCurrMinWage", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("lcaCurrMaxWage", entity, DataType.CURRENCY_FIELD);
//        assignFieldValueFromEntity("lcaPrevWageLvl", entity, DataType.ENUM_FIELD);
//        assignFieldValueFromEntity("lcaPrevMinWage", entity, DataType.CURRENCY_FIELD);
//        assignFieldValueFromEntity("lcaPrevMaxWage", entity, DataType.CURRENCY_FIELD);
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
        if (fields.containsKey("company")) {
            assignFieldValueFromEntity("company", entity, null);
        }
        if (entity.containsKey("lcaAddress1")) {
            entityFieldsPanel.add(lcaAddress1);
            readAddressWidget1 = new ReadLCAAddressWidget(entity.get("lcaAddress1").isObject());
            entityFieldsPanel.add(readAddressWidget1);
        }
        if (entity.containsKey("lcaAddress2")) {
            entityFieldsPanel.add(lcaAddress2);
            readAddressWidget2 = new ReadLCAAddressWidget(entity.get("lcaAddress2").isObject());
            entityFieldsPanel.add(readAddressWidget2);
        }
    }

    @Override
    protected void addListeners() {

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
        logger.info("entity read : " + entity);
        addField("lcaNumber", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("totalWorkingPositions", true, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addEnumField("visaClassification", true, true, VisaClassificationType.names(), Alignment.HORIZONTAL);
        addDropDown("company", selectCompanyWidget);
        addField("jobTitle", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("socCodesAndOccupations", true, true, SOCCodesAndOccupations.names(), Alignment.HORIZONTAL);
        addField("lcaValidFromDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaValidToDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("status", true, true, LCAStatus.names(), Alignment.HORIZONTAL);
        addDropDown("workedByEmployees", selectRecruiterW);
        entityFieldsPanel.add(empInfo);
        // Populate selected Consultants
        employeeSelectWidget = new MultiSelectConsultantWidget("Employees", getEntityId(), true, true);
        entityFieldsPanel.add(employeeSelectWidget);
        entityFieldsPanel.add(wagesInfo);
        addEnumField("lcaCurrWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
        addField("lcaCurrMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("lcaCurrMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
//        addEnumField("lcaPrevWageLvl", true, true, LCAWageLevels.names(), Alignment.HORIZONTAL);
//        addField("lcaPrevMinWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
//        addField("lcaPrevMaxWage", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(addInfo);
        addField("clientName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorName", true, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledDate", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("nonDisplacement", true, true, Polar.names(), Alignment.HORIZONTAL);
        addField("lcaPostingSentToVendor", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("responseOnLcaPosting", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("reminderEmail", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("certifiedLcaSentConsultant", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaPostingSSTLocation", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("lcaFiledInPIF", true, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
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
    public void loadEntity(String entityId) {

    }

}

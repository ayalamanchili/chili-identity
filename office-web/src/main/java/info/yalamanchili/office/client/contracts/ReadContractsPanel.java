/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadContractsPanel extends ReadComposite {

    private static ReadContractsPanel instance;
    private static Logger logger = Logger.getLogger(ReadContractsPanel.class.getName());

    public ReadContractsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Contract", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("recruiter", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("joiningReport", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        if (isSubContractor(entity)) {
            assignFieldValueFromEntity("subContractorName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subContractorContactName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
        }
        if (is1099(entity)) {
            assignFieldValueFromEntity("payRate1099", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("paymentTerms1099", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("payTimeDuration1099", entity, DataType.ENUM_FIELD);
        }
    }
    //pleado same for 1099 

    protected boolean isSubContractor(JSONObject contractDto) {
        if ((JSONUtils.toString(contractDto, "employeeType")).equals("SUB_CONTRACTOR")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean is1099(JSONObject contractDto) {
        if ((JSONUtils.toString(contractDto, "employeeType")).equals("1099")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD);
        addField("client", true, false, DataType.STRING_FIELD);
        addField("clientLocation", true, false, DataType.STRING_FIELD);
        addField("clientContact", true, false, DataType.RICH_TEXT_AREA);
        addField("vendor", true, false, DataType.STRING_FIELD);
        addField("vendorContact", true, false, DataType.RICH_TEXT_AREA);
        addField("vendorLocation", true, false, DataType.STRING_FIELD);
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
        addField("itemNumber", true, false, DataType.STRING_FIELD);
        addField("payRate", true, false, DataType.CURRENCY_FIELD);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD);
        String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
        addEnumField("invoiceFrequency", true, false, invoiceFrequencies);
        String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
        addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods);
        String[] billingDuration = {"HOUR", "DAY", "MONTH"};
        addEnumField("billingRateDuration", true, false, billingDuration);
        addEnumField("overTimeRateDuration", true, false, billingDuration);
        addField("recruiter", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", true, false, DataType.STRING_FIELD);
        addField("joiningReport", true, false, DataType.STRING_FIELD);
        addField("terminationNotice", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
        addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD);
        addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD);
        addField("i9Filled", true, false, DataType.BOOLEAN_FIELD);
        addField("w4Filled", true, false, DataType.BOOLEAN_FIELD);
        addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD);
        addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD);
        if (isSubContractor(entity)) {
            entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
            addField("subContractorName", true, false, DataType.STRING_FIELD);
            addField("subContractorContactName", true, false, DataType.STRING_FIELD);
            String[] invoiceFrequencie = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
            addEnumField("subcontractorinvoiceFrequency", true, false, invoiceFrequencie);
            addField("subcontractorpaymentTerms", true, false, DataType.STRING_FIELD);
            addField("subcontractorw4Filled", true, false, DataType.BOOLEAN_FIELD);
            addField("subcontractCOI", true, false, DataType.BOOLEAN_FIELD);
        }
        if (is1099(entity)) {
            entityFieldsPanel.add(getLineSeperatorTag("1099 Employee Information"));
            addField("payRate1099", true, false, DataType.CURRENCY_FIELD);
            addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD);
            addField("paymentTerms1099", true, false, DataType.STRING_FIELD);
            addEnumField("payTimeDuration1099", true, false, billingDuration);
        }
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contract/" + entityId;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import info.yalamanchili.office.client.time.consultant.ReadAllConsultantTimeSheetsPanel;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadContractsPanel extends ReadComposite {

    private static ReadContractsPanel instance;
    private static Logger logger = Logger.getLogger(ReadContractsPanel.class.getName());

    protected static HTML clientVendorText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">Client & Vendor Information</strong></p>\n"
            + "\n");
    protected static HTML billingText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">Billing Information</strong></p>\n"
            + "\n");
    protected static HTML otherText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">Other Information</strong></p>\n"
            + "\n");
    protected static HTML hrText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">HR and Account Department Docs</strong></p>\n"
            + "\n");
    protected static HTML subText = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">Subcontractor Information</strong></p>\n"
            + "\n");
    protected static HTML sub1099Text = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 5px; background: rgb(238, 238, 238)\">"
            + "<strong style=\"color:#555555\">1099 Contractor Information</strong></p>\n"
            + "\n");

    public ReadContractsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Contract", OfficeWelcome.constants);
        populateComments();
    }

    protected final void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.ClientInformation"));
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("employeeCompany", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorAPContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorRecruiter", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("middleVendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientProject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("recruiter", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("joiningReport", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.RICH_TEXT_AREA);
        if (isSubContractor(entity)) {
            assignFieldValueFromEntity("subContractorName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subContractorContactName", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("subcontractorAddress", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("subContractorWorkOrderNo", entity, DataType.STRING_FIELD);
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
        if ((JSONUtils.toString(contractDto, "employeeType")).equals("Subcontractor")) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean is1099(JSONObject contractDto) {
        if ((JSONUtils.toString(contractDto, "employeeType")).equals("1099 Contractor")) {
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
        clientVendorText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        billingText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        otherText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        hrText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        subText.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        sub1099Text.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 30);
            }
        }
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeCompany", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        new ReadAllConsultantTimeSheetsPanel().renderLeaveHistory(getEmployeeId(), entityFieldsPanel);
        entityFieldsPanel.add(clientVendorText);
        addField("client", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("clientLocation", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("clientContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("vendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorLocation", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("vendorContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("vendorAPContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("vendorPaymentTerms", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("vendorRecruiter", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("middleVendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("recruiter", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("clientProject", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(billingText);
        addField("itemNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("payRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        new ReadAllUpdateBillingRatePanel().renderBillingRateHistory(getEntityId(), entityFieldsPanel);
        String[] billingDuration = {"HOUR", "DAY", "MONTH"};
        addEnumField("billingRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
        addField("overTimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addEnumField("overTimeRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
        addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
        String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
        addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods, Alignment.HORIZONTAL);
        entityFieldsPanel.add(otherText);
        addField("visaStatus", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("joiningReport", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        addField("terminationNotice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(hrText);
        addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("i9Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("w4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("specialInvoiceInstructions", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        if (isSubContractor(entity)) {
            entityFieldsPanel.add(subText);
            addField("subContractorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("subContractorContactName", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
            addField("subcontractorAddress", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            //         String[] invoiceFrequencie = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
            addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            addField("subcontractorpaymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("subcontractorw4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("subcontractCOI", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("subContractorWorkOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        if (is1099(entity)) {
            entityFieldsPanel.add(sub1099Text);
            addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("paymentTerms1099", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addEnumField("payTimeDuration1099", true, false, billingDuration, Alignment.HORIZONTAL);
        }
        addField("notes", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contract/" + entityId;
    }

    public String getEmployeeId() {
        return JSONUtils.toString(entity, "employeeID");
    }
}

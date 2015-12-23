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
import info.chili.gwt.crud.TReadComposite;
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
public class ReadContractsPanel extends TReadComposite {

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
        assignFieldValueFromEntity("company", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("clientLocation", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("clientContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("clientAPContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendor", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("vendorContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorAPContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.RICH_TEXT_AREA);
        //      assignFieldValueFromEntity("vendorLocation", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("vendorRecruiter", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("middleVendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientProject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        //       assignFieldValueFromEntity("purchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        //      assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        //       assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
        //       assignFieldValueFromEntity("recruiter", entity, DataType.STRING_FIELD);
        //       assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        //       assignFieldValueFromEntity("joiningReport", entity, DataType.RICH_TEXT_AREA);
        //      assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
        //      assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
        //       assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
        //      assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
        //      assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
        //      assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
        //      assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.RICH_TEXT_AREA);
        if (isSubContractor(entity)) {
            assignFieldValueFromEntity("subContractorName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subContractorContactName", entity, DataType.RICH_TEXT_AREA);
            //         assignFieldValueFromEntity("subcontractorAddress", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
            //           assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
            //           assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
            //          assignFieldValueFromEntity("subContractorWorkOrderNo", entity, DataType.STRING_FIELD);
        }
        if (is1099(entity)) {
            assignFieldValueFromEntity("payRate1099", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("paymentTerms1099", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("invoiceFrequency1099", entity, DataType.ENUM_FIELD);
        }
        assignFieldValueFromEntity("practice", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sectorsAndBUs", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("employeeDetails", entity, DataType.RICH_TEXT_AREA);
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
        addField("employee", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addField("clientProject", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("company", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 2);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 3, 1);
        String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
        addEnumField("billingRateDuration", true, false, billingDuration, Alignment.HORIZONTAL, 4, 1);
        addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 3, 2);
        addEnumField("overTimeRateDuration", true, false, billingDuration, Alignment.HORIZONTAL, 4, 2);
        addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 5, 1);
        addField("itemNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 5, 2);
        addField("specialInvoiceInstructions", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 6, 1);
        addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 6, 2);
        entityFieldsPanel.setWidget(9, 1, ReadAllUpdateBillingRatePanel.renderBillingRateHistory(getEntityId()));
        entityFieldsPanel.getFlexCellFormatter().setColSpan(9, 1, 2);
        if (isSubContractor(entity)) {
            addField("subContractorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 11, 2);
            addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 1);
            addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 2);
            addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 8, 1);
            addField("subContractorContactName", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 12, 2);
            addField("subcontractorpaymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 2);
        }
        if (is1099(entity)) {
            addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 1);
            addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 2);
            addEnumField("invoiceFrequency1099", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 8, 1);
            addField("paymentTerms1099", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 2);
        }
        addField("vendorPaymentTerms", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 10, 1);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 15, 1);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 15, 2);

        addField("client", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 2);
        addField("vendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 11, 1);
        addField("middleVendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 1);
        addField("clientAPContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 14, 2);
        addField("vendorAPContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 12, 1);
        addField("notes", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 14, 1);
        addField("practice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 16, 1);
        addField("sectorsAndBUs", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 16, 2);
        addField("employeeDetails", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 17, 1);
        entityFieldsPanel.setWidget(18, 1, ReadAllConsultantTimeSheetsPanel.renderLeaveHistory(getEmployeeId()));
        entityFieldsPanel.getFlexCellFormatter().setColSpan(18, 1, 2);
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

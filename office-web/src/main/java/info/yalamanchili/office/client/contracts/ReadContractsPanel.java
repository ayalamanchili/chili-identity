/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.hr.ProspectStatus;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.cllientinfo.InvoiceFrequency;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllCiDocumentPanel;
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
    protected boolean isSubOr1099 = false;

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
        populateCIDocuments();
        populateComments();
    }

    public ReadContractsPanel(String entityId) {
        instance = this;
        initReadComposite(entityId, "Contract", OfficeWelcome.constants);
        populateCIDocuments();
        populateComments();
    }

    protected final void populateComments() {
        entityActionsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.ClientInformation"));
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        if (entity.containsKey("vendorFees")) {
                            addField("finalBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 3, 1);
                            addField("vendorFees", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL, 3, 2);
                            assignFieldValueFromEntity("finalBillingRate", entity, DataType.CURRENCY_FIELD);
                            assignFieldValueFromEntity("vendorFees", entity, DataType.FLOAT_FIELD);
                            alignFields();
                        }
                        if (entity.containsKey("subContractorName")) {
                            addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 6, 1);
                            addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 6, 2);
                            addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 8, 1);
                            addField("subcontractorpaymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 2);
                            addField("subContractorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 11, 2);
                            addField("subContractorContactName", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 12, 2);
                            assignFieldValueFromEntity("subContractorContactName", entity, DataType.RICH_TEXT_AREA);
                            assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                            assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
                            assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
                            assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
                            alignFields();
                        }
                        if (entity.containsKey("payRate1099")) {
                            addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 1);
                            addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 7, 2);
                            addEnumField("invoiceFrequency1099", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 8, 1);
                            addField("paymentTerms1099", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 10, 2);
                            assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
                            assignFieldValueFromEntity("paymentTerms1099", entity, DataType.STRING_FIELD);
                            assignFieldValueFromEntity("invoiceFrequency1099", entity, DataType.ENUM_FIELD);
                            alignFields();
                        }
                        populateFieldsFromEntity(entity);
                    }
                });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("clientAPContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendor", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("vendorContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorAPContact", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("clientPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        //      assignFieldValueFromEntity("vendorLocation", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("vendorRecruiter", entity, DataType.RICH_TEXT_AREA);
        assignFieldValueFromEntity("middleVendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientProject", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("purchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        //      assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        //      assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
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
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.TEXT_AREA_FIELD);
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
        addField("itemNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 2);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 2, 1);
        addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL, 2, 2);
        String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
        addEnumField("billingRateDuration", true, false, billingDuration, Alignment.HORIZONTAL, 4, 1);
        addEnumField("overTimeRateDuration", true, false, billingDuration, Alignment.HORIZONTAL, 4, 2);
        addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL, 5, 1);
        String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX", "UPLOAD"};
        addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods, Alignment.HORIZONTAL, 5, 2);
        addField("specialInvoiceInstructions", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL, 6, 1);
        addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 6, 2);
        if ((isSubContractor(entity)) || (is1099(entity))) {
            isSubOr1099 = true;
        }
        entityFieldsPanel.setWidget(9, 1, ReadAllUpdateBillingRatePanel.renderBillingRateHistory(getEntity(), isSubOr1099));
        entityFieldsPanel.getFlexCellFormatter().setColSpan(9, 1, 2);
        addField("vendorPaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL, 10, 1);
        addField("vendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 11, 1);
        addField("vendorAPContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 12, 1);
        addField("client", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 1);
        addField("clientLocation", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 13, 2);
        addField("clientAPContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 14, 1);
        addField("clientContact", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 14, 2);
        addField("clientPaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL, 15, 1);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL, 15, 2);
        addField("middleVendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 16, 1);
        addField("company", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 16, 2);
        addField("clientProject", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 17, 1);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 17, 2);
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 18, 1);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 18, 2);
        addField("practice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 19, 1);
        addField("sectorsAndBUs", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 19, 2);
        addField("employeeDetails", true, false, DataType.RICH_TEXT_AREA, Alignment.HORIZONTAL, 20, 1);
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 20, 2);
        entityFieldsPanel.setWidget(21, 1, ReadAllConsultantTimeSheetsPanel.renderLeaveHistory(getEmployeeId()));
        entityFieldsPanel.getFlexCellFormatter().setColSpan(21, 1, 2);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contract/read/" + entityId;
    }

    protected void populateCIDocuments() {
        HttpService.HttpServiceAsync.instance().doGet(getDocumentUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.trim().toString().equals("null")) {
                            JSONArray docs = JSONUtils.toJSONArray(JSONParser.parseLenient(response).isObject().get("ciDocument"));
                            entityFieldsPanel.setWidget(22, 1, new ReadAllCiDocumentPanel(getEntityId(), docs));
                            entityFieldsPanel.getFlexCellFormatter().setColSpan(22, 1, 2);
                        }
                    }
                });
    }

    protected String getDocumentUrl() {
        return OfficeWelcome.constants.root_url() + "cidocument/cidocs/" + getEntityId();
    }

    public String getEmployeeId() {
        return JSONUtils.toString(entity, "employeeID");
    }
}

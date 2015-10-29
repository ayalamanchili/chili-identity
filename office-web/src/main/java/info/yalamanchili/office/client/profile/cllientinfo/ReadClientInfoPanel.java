/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.project.SelectProjectWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL);

    public ReadClientInfoPanel(String id) {
        instance = this;
        initReadComposite(id, "ClientInfo", OfficeWelcome.constants);
    }

    public ReadClientInfoPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ClientInfo", OfficeWelcome.constants);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, null);
        assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("vendorContact", entity, null);
        assignFieldValueFromEntity("vendorAPContact", entity, null);
        assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("vendorRecruiter", entity, null);
        assignFieldValueFromEntity("middleVendor", entity, null);
        assignFieldValueFromEntity("clientProject", entity, null);
        if (entity.get("clientProject") != null) {
            JSONObject project = entity.get("clientProject").isObject();
            assignFieldValueFromEntity("purchaseOrderNo", project, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        if (checkPermission()) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("recruiter", entity, null);
            assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("joiningReport", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
            if (Auth.isSubContractor(getEmployee())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
                assignFieldValueFromEntity("subcontractorAddress", entity, null);
                assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
                assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
                assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
                assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
                if (entity.get("clientProject") != null) {
                    JSONObject project = entity.get("clientProject").isObject();
                    assignFieldValueFromEntity("subContractorWorkOrderNo", project, DataType.STRING_FIELD);
                }
            }
            if (Auth.is1099(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor Information"));
                assignFieldValueFromEntity("payRate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("paymentTerms1099", entity, DataType.STRING_FIELD);
                assignFieldValueFromEntity("payTimeDuration1099", entity, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("isCPDFilled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("vacationDetails", entity, DataType.STRING_FIELD);
    }

    protected void renderBillingRatesPanel() {

    }

    protected boolean checkPermission() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    protected JSONObject getEmployee() {
        return TreeEmployeePanel.instance().getEntity();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("company", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientContact", new SelectClientContactWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientLocation", new SelectClientLocationWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("vendor", new SelectVendorWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("vendorContact", new SelectVendorContactWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("vendorAPContact", new SelectVendorAcctPayContact(true, false, Alignment.HORIZONTAL));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("vendorRecruiter", new SelectVendorRecruiterContactWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("middleVendor", new SelectMiddleVendorWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientProject", new SelectProjectWidget(true, false));
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (checkPermission()) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
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
            addDropDown("recruiter", selectRecruiterWidget);
            if (Auth.isSubContractor(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(true, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(true, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(true, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                String[] invoiceFrequencie = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
                addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subContractorWorkOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.is1099(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor"));
                addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addEnumField("payTimeDuration1099", true, false, billingDuration, Alignment.HORIZONTAL);
            }
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("joiningReport", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("terminationNotice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
            addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("i9Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("w4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("specialInvoiceInstructions", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addField("isCPDFilled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("vacationDetails", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
        if (TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
            StringField jobTitleF = (StringField) fields.get("employeeType");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("description").isString().stringValue());
        }
        if (TreeEmployeePanel.instance().getEntity().get("company") != null) {
            StringField jobTitleF = (StringField) fields.get("company");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("company").isObject().get("name").isString().stringValue());
        }
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/" + entityId;
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

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.ClientInformation" + "/" + getEntityId();
    }
}

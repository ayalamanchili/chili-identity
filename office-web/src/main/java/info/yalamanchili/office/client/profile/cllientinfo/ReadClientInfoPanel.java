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
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import java.util.Map.Entry;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(true, false, Alignment.HORIZONTAL);
    protected boolean isSubOr1099 = false;

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
        logger.info(entity.toString());
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("client", entity, null);
        //assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("clientAPContacts", entity, null);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("vendor", entity, null);
        // assignFieldValueFromEntity("vendorContact", entity, null);
        assignFieldValueFromEntity("vendorAPContacts", entity, null);
        //  assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("vendorRecruiters", entity, null);
        assignFieldValueFromEntity("middleVendor", entity, null);
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        if (entity.get("clientProject") != null) {
            JSONObject project = entity.get("clientProject").isObject();
            assignFieldValueFromEntity("name", project, DataType.STRING_FIELD);
            assignFieldValueFromEntity("purchaseOrderNo", project, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("isEndDateConfirmed", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("recruiters", entity, null);
        if (checkPermission()) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            //      assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            //      assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("joiningReport", entity, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
            if (Auth.isSubContractor(getEmployee())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
                //assignFieldValueFromEntity("subcontractorAddress", entity, null);
                assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
                assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.TEXT_AREA_FIELD);
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
                assignFieldValueFromEntity("paymentTerms1099", entity, DataType.TEXT_AREA_FIELD);
                //assignFieldValueFromEntity("payTimeDuration1099", entity, DataType.ENUM_FIELD);
                assignFieldValueFromEntity("invoiceFrequency1099", entity, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("isCPDFilled", entity, DataType.BOOLEAN_FIELD);
        }
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("sectorsAndBUs", entity, DataType.STRING_FIELD);
    }

    protected void renderBillingRatesPanel() {

    }

    protected boolean checkPermission() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_BILLING_AND_INVOICING);
    }

    protected JSONObject getEmployee() {
        return TreeEmployeePanel.instance().getEntity();
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        for (Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 30);
            }
        }
    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, true, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };

    SelectVendorAcctPayContact selectVendorAPContactsW = null;
    SelectVendorRecruiterContactWidget selectVendorRecruiterContactsWidget = null;
    SelectClientAcctPayContact selectClientAcctPayContact = null;

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("company", true, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientLocation", new SelectClientLocationWidget(true, false, Alignment.HORIZONTAL));
        //addDropDown("clientContact", new SelectClientContactWidget(true, false, Alignment.HORIZONTAL));
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
        addDropDown("vendor", new SelectVendorWidget(true, false, Alignment.HORIZONTAL));
        //addDropDown("vendorContact", new SelectVendorContactWidget(true, false, Alignment.HORIZONTAL));
        selectVendorAPContactsW = new SelectVendorAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorAPContacts", selectVendorAPContactsW);
        //addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, false, Alignment.HORIZONTAL));
        selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
        addField("vendorPaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addDropDown("middleVendor", new SelectMiddleVendorWidget(true, false, Alignment.HORIZONTAL));
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("isEndDateConfirmed", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("recruiters", selectRecruiterW);
        addField("name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (checkPermission()) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("itemNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            //       addField("payRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            if ((Auth.isSubContractor(getEmployee())) || (Auth.is1099(getEmployee()))) {
                isSubOr1099 = true;
            }
            addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            entityFieldsPanel.add(ReadAllUpdateBillingRatePanel.renderBillingRateHistory(getEntityId(), isSubOr1099));
            String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
            addEnumField("billingRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
            //       addField("overTimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addEnumField("overTimeRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
            addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX", "UPLOAD"};
            addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods, Alignment.HORIZONTAL);
            if (Auth.isSubContractor(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(true, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(true, false, Alignment.HORIZONTAL));
                //addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(true, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subContractorWorkOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.is1099(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor"));
                addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                //addEnumField("payTimeDuration1099", true, false, billingDuration, Alignment.HORIZONTAL);
                addEnumField("invoiceFrequency1099", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            }
            entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
            addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("i9Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("w4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("specialInvoiceInstructions", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            addField("joiningReport", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            addField("isCPDFilled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
            StringField jobTitleF = (StringField) fields.get("employeeType");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
        }
        addDropDown("practice", selectPractiseWidgetF);
        addField("sectorsAndBUs", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
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
                        populateComments();
                    }
                });
    }

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.ClientInformation"));
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.ClientInformation" + "/" + getEntityId();
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }
}

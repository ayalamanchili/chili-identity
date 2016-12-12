/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.updateBillingRate.CreateUpdateBillingRatePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import java.util.Map;

public class UpdateClientInfoPanel extends UpdateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(UpdateClientInfoPanel.class.getName());
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(false, true, Alignment.HORIZONTAL);
    SelectVendorWidget selectVendorWidgetF = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);
    SelectClientWidget selectClientWidgetF = new SelectClientWidget(false, true, Alignment.HORIZONTAL);
    EnumField servicesF;
    EnumField sectorsF;
    protected BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit For Approval", "ClientInfo", false, false, Alignment.HORIZONTAL);
    protected boolean isSubOr1099 = false;
    protected String cistatus;
    protected boolean isSub = false;
    protected boolean is1099 = false;
    protected boolean active = false;
    JSONArray cidocument = new JSONArray();

    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants2, "ClientInformation", "cidocument", "CIDocument/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };

    protected static UpdateClientInfoPanel instance;

    public static UpdateClientInfoPanel instance() {
        return instance;
    }

    public UpdateClientInfoPanel(JSONObject entity) {
        instance = this;
        initUpdateComposite(entity, "ClientInfo", OfficeWelcome.constants2);
    }

    public UpdateClientInfoPanel(JSONObject entity, boolean active) {
        instance = this;
        this.active = active;
        initUpdateComposite(entity, "ClientInfo", OfficeWelcome.constants2);
    }

    protected void populateCIDocuments() {
        HttpService.HttpServiceAsync.instance().doGet(getDocumentUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.trim().toString().equals("null")) {
                    JSONArray docs = JSONUtils.toJSONArray(JSONParser.parseLenient(response).isObject().get("ciDocument"));
                    entityFieldsPanel.add(new ReadAllCiDocumentPanel(getEntityId(), docs));
                }
            }
        });
    }

    protected String getDocumentUrl() {
        return OfficeWelcome.constants.root_url() + "cidocument/cidocs/" + getEntityId();
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("consultantJobTitle", entity);
        assignEntityValueFromField("company", entity);
        assignEntityValueFromField("client", entity);
        assignEntityValueFromField("clientLocation", entity);
        assignEntityValueFromField("clientContact", entity);
        assignEntityValueFromField("clientAPContacts", entity);
        assignEntityValueFromField("clientPaymentTerms", entity);
//        assignEntityValueFromField("clientFeeApplicable", entity);
//        assignEntityValueFromField("directClient", entity);
        assignEntityValueFromField("vendor", entity);
        assignEntityValueFromField("vendorAPContacts", entity);
        assignEntityValueFromField("vendorRecruiters", entity);
        assignEntityValueFromField("vendorLocation", entity);
        assignEntityValueFromField("middleVendor", entity);
        assignEntityValueFromField("vendorPaymentTerms", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        assignEntityValueFromField("isEndDateConfirmed", entity);
        assignEntityValueFromField("recruiters", entity);
        assignEntityValueFromField("itemNumber", entity);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
            assignEntityValueFromField("payRatePercentage", entity);
            assignEntityValueFromField("overTimePayRatePercentage", entity);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            assignEntityValueFromField("billingRate", entity);
            assignEntityValueFromField("overTimeBillingRate", entity);
            assignEntityValueFromField("invoiceFrequency", entity);
            assignEntityValueFromField("invoiceDeliveryMethod", entity);
            assignEntityValueFromField("billingRateDuration", entity);
            assignEntityValueFromField("overTimeRateDuration", entity);
            assignEntityValueFromField("joiningReport", entity);
            assignEntityValueFromField("accountVerificationDocs", entity);
            assignEntityValueFromField("signedCopyOfWorkOrder", entity);
            assignEntityValueFromField("i9Filled", entity);
            assignEntityValueFromField("w4Filled", entity);
            assignEntityValueFromField("logisticsPreparation", entity);
            assignEntityValueFromField("hrOrientation", entity);
            assignEntityValueFromField("timeSheetRequirement", entity);
            assignEntityValueFromField("specialInvoiceInstructions", entity);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
                assignEntityValueFromField("subcontractor", entity);
                assignEntityValueFromField("subcontractorContact", entity);
                assignEntityValueFromField("subcontractorPayRate", entity);
                assignEntityValueFromField("subcontractorOvertimePayRate", entity);
                assignEntityValueFromField("subcontractorinvoiceFrequency", entity);
                assignEntityValueFromField("subcontractorpaymentTerms", entity);
                assignEntityValueFromField("subcontractorw4Filled", entity);
                assignEntityValueFromField("subcontractCOI", entity);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity())) {
                assignEntityValueFromField("payRate1099", entity);
                assignEntityValueFromField("overTimePayrate1099", entity);
                assignEntityValueFromField("paymentTerms1099", entity);
                assignEntityValueFromField("invoiceFrequency1099", entity);
            }
        }

        assignEntityValueFromField("terminationNotice", entity);
        assignEntityValueFromField("visaStatus", entity);
        assignEntityValueFromField("Comments", entity);
        assignEntityValueFromField("practice", entity);
        assignEntityValueFromField("sectorsAndBUs", entity);
        assignEntityValueFromField("active", entity);
        int j = cidocument.size();
        for (JSONString fileName : fileUploadPanel.getFileNames()) {
            if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                JSONObject docs = new JSONObject();
                docs.put("fileURL", fileName);
                docs.put("name", new JSONString("File Name"));
                cidocument.set(j, docs);
                j++;
            }
        }
        if (cidocument.size() > 0) {
            entity.put("cidocument", cidocument);
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
                uploadDocuments(arg0);
            }
        });

    }

    protected void uploadDocuments(String postString) {
        JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
        fileUploadPanel.upload(JSONUtils.toJSONArray(post.get("cidocument")), "fileURL");
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId(), active));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("client", entity, null);
//        assignFieldValueFromEntity("directClient", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("clientAPContacts", entity, null);
//        assignFieldValueFromEntity("clientFeeApplicable", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("clientPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("vendorAPContacts", entity, null);
        assignFieldValueFromEntity("vendorLocation", entity, null);
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
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
            assignFieldValueFromEntity("payRatePercentage", entity, DataType.FLOAT_FIELD);
            assignFieldValueFromEntity("overTimePayRatePercentage", entity, DataType.FLOAT_FIELD);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("joiningReport", entity, DataType.TEXT_AREA_FIELD);
            assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
                assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
                assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
                assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity())) {
                assignFieldValueFromEntity("payRate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("paymentTerms1099", entity, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("invoiceFrequency1099", entity, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.TEXT_AREA_FIELD);
        }
        assignFieldValueFromEntity("Comments", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("sectorsAndBUs", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("active", entity, DataType.BOOLEAN_FIELD);
        populateCIDocuments();
    }

    @Override
    protected void addListeners() {
        updateBillingRateIcn.addClickHandler(this);
        selectPractiseWidgetF.getListBox().addChangeHandler(this);
        selectVendorWidgetF.getListBox().addChangeHandler(this);
        selectClientWidgetF.getListBox().addChangeHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 30);
            }
        }
        if (cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
            submitForApprovalF.setValue(true);
            setButtonText("Submit");
        } else {
            submitForApprovalF.setVisible(false);
            submitForApprovalF.setValue(false);
        }

    }

    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
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
        cistatus = JSONUtils.toString(entity, "status");
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("company", false, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client Information"));
        addDropDown("client", selectClientWidgetF);
//        addField("directClient", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
//        addField("clientFeeApplicable", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("clientPaymentTerms", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (!Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN) && cistatus.equals("COMPLETED")) {
            selectVendorWidgetF.setReadOnly(true);
            entityFieldsPanel.add(getLineSeperatorTag("Middle Vendor Information"));
            addDropDown("middleVendor", new SelectMiddleVendorWidget(true, false, Alignment.HORIZONTAL));
            entityFieldsPanel.add(getLineSeperatorTag("Vendor Information"));
            addDropDown("vendor", selectVendorWidgetF);
            addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, true, Alignment.HORIZONTAL));
            selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(true, true, Alignment.HORIZONTAL) {
                @Override
                public boolean enableMultiSelect() {
                    return true;
                }
            };
            addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
            selectVendorAPContactsW = new SelectVendorAcctPayContact(true, true, Alignment.HORIZONTAL) {
                @Override
                public boolean enableMultiSelect() {
                    return true;
                }
            };
            addDropDown("vendorAPContacts", selectVendorAPContactsW);
            addField("vendorPaymentTerms", true, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        } else {
            selectVendorWidgetF.setReadOnly(false);
            entityFieldsPanel.add(getLineSeperatorTag("Middle Vendor Information"));
            addDropDown("middleVendor", new SelectMiddleVendorWidget(false, false, Alignment.HORIZONTAL));
            entityFieldsPanel.add(getLineSeperatorTag("Vendor Information"));
            addDropDown("vendor", selectVendorWidgetF);
            addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, true, Alignment.HORIZONTAL));
            selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, true, Alignment.HORIZONTAL) {
                @Override
                public boolean enableMultiSelect() {
                    return true;
                }
            };
            addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
            selectVendorAPContactsW = new SelectVendorAcctPayContact(false, true, Alignment.HORIZONTAL) {
                @Override
                public boolean enableMultiSelect() {
                    return true;
                }
            };
            addDropDown("vendorAPContacts", selectVendorAPContactsW);
            addField("vendorPaymentTerms", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(getLineSeperatorTag("Project Details"));
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("isEndDateConfirmed", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("recruiters", selectRecruiterW);
        addField("name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
        addField("itemNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_ADMIN)) {
            if (cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
                addField("billingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            } else {
                addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            }
            if ((Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity()))
                    || (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity()))) {
                isSubOr1099 = true;
            }
            entityFieldsPanel.add(ReadAllUpdateBillingRatePanel.renderBillingRateHistory(getEntity(), isSubOr1099));
            if (!cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
                renderUpdateBillingRateFieldLink();
            }
            String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
            addEnumField("billingRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
                addField("payRatePercentage", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
            }
            if (cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
                addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            } else {
                addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            }
            addEnumField("overTimeRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS, Auth.ROLE.ROLE_ADMIN)) {
                addField("overTimePayRatePercentage", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
            }
            if ((cistatus.equals("COMPLETED")) && Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN)) {
                addEnumField("invoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addEnumField("invoiceDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
            } else {
                addEnumField("invoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addEnumField("invoiceDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
            }
            entityFieldsPanel.add(getLineSeperatorTag("HR Department Docs"));
            addField("i9Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("w4Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("hrOrientation", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("joiningReport", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            addField("logisticsPreparation", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            entityFieldsPanel.add(getLineSeperatorTag("Account Department Docs"));
            addField("accountVerificationDocs", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("signedCopyOfWorkOrder", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("timeSheetRequirement", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("specialInvoiceInstructions", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);

            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, true, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, true, Alignment.HORIZONTAL));
                if (cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
                    addField("subcontractorPayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("subcontractorOvertimePayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addEnumField("subcontractorinvoiceFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                } else {
                    addField("subcontractorPayRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("subcontractorOvertimePayRate", true, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addEnumField("subcontractorinvoiceFrequency", true, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                }
                addField("subcontractorpaymentTerms", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                isSub = true;
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor Information"));
                if (cistatus.equals("PENDING_CONTRACTS_SUBMIT")) {
                    addField("payRate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("overTimePayrate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addEnumField("invoiceFrequency1099", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                } else {
                    addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addEnumField("invoiceFrequency1099", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                }
                addField("paymentTerms1099", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                is1099 = true;
            }
        }
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);

        if (TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
            StringField employeeTypeF = (StringField) fields.get("employeeType");
            employeeTypeF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
        }
        JSONObject prj = (JSONObject) entity.get("practice");
        addDropDown("practice", selectPractiseWidgetF);
        String service = JSONUtils.toString(prj, "name");
        switch (service) {
            case "4100-CONSULTING SERVICES":
                addEnumField("sectorsAndBUs", false, true, ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4200-PROJECT MANAGEMENT SERVICES":
                addEnumField("sectorsAndBUs", false, true, ProjectManagementServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4300-SOFTWARE DEVELOPMENT SERVICES":
                addEnumField("sectorsAndBUs", false, true, SoftwareDevelopmentServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4400-INFRASTRUCTURE SERVICES":
                addEnumField("sectorsAndBUs", false, true, InfrastructureServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4500-MOBILITY SERVICES":
                addEnumField("sectorsAndBUs", false, true, MobilityServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4600-TECHNOLOGY,DEVELOPMENT,INTEGRATION SERVICES":
                addEnumField("sectorsAndBUs", false, true, TechnologyIntegrationServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            case "4700-QUALIY ASURANCE SERVICES":
                addEnumField("sectorsAndBUs", false, true, QualityAsuranceServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
            default:
                addEnumField("sectorsAndBUs", false, true, QualityAsuranceServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
                break;
        }
        addField("sectorsAndBUs", false, true, DataType.ENUM_FIELD);
        addField("Comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("active", false, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        sectorsF = (EnumField) fields.get("sectorsAndBUs");
        entityFieldsPanel.add(fileUploadPanel);
        entityFieldsPanel.add(submitForApprovalF);
        alignFields();
    }

    ClickableImage updateBillingRateIcn = new ClickableImage("update", ChiliImages.INSTANCE.updateIcon_16_16());

    protected void renderUpdateBillingRateFieldLink() {
        BaseField billRateField = fields.get("billingRate");
        billRateField.addWidgetToFieldPanel(updateBillingRateIcn);
    }

    @Override
    public void onClick(ClickEvent event) {
        super.onClick(event);
        if (event.getSource().equals(updateBillingRateIcn)) {
            new GenericPopup(new CreateUpdateBillingRatePanel(getEntity(), getEntity())).show();
        }
        if (submitForApprovalF.getValue()) {
            setButtonText("Submit");
        } else {
            setButtonText("Update");
        }
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(selectPractiseWidgetF.getListBox())) {
            String service = selectPractiseWidgetF.getSelectedObject().get("value").isString().stringValue().trim();
            switch (service) {
                case "4100-CONSULTING SERVICES":
                    sectorsF.setValues(ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4200-PROJECT MANAGEMENT SERVICES":
                    sectorsF.setValues(ProjectManagementServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4300-SOFTWARE DEVELOPMENT SERVICES":
                    sectorsF.setValues(SoftwareDevelopmentServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4400-INFRASTRUCTURE SERVICES":
                    sectorsF.setValues(InfrastructureServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4500-MOBILITY SERVICES":
                    sectorsF.setValues(MobilityServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4600-TECHNOLOGY,DEVELOPMENT,INTEGRATION SERVICES":
                    sectorsF.setValues(TechnologyIntegrationServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                case "4700-QUALIY ASURANCE SERVICES":
                    sectorsF.setValues(QualityAsuranceServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
                default:
                    sectorsF.setValues(QualityAsuranceServices.getSectorsAndBusinessUnits().toArray(new String[0]));
                    break;
            }
        }
        if (event.getSource().equals(selectVendorWidgetF.getListBox())) {
            String id = selectVendorWidgetF.getSelectedObject().get("id").isString().stringValue().trim();
            loadVendor(id);
        }

        if (event.getSource().equals(selectClientWidgetF.getListBox())) {
            String id = selectClientWidgetF.getSelectedObject().get("id").isString().stringValue().trim();
            loadClient(id);
        }
    }

    public void loadVendor(String vendorEntityId) {
        HttpService.HttpServiceAsync.instance().doGet(getVendor(vendorEntityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject vendor = (JSONObject) JSONParser.parseLenient(response);
                TextAreaField payTermF = (TextAreaField) fields.get("vendorPaymentTerms");
                payTermF.setValue(JSONUtils.toString(vendor, "paymentTerms"));
                EnumField invDelv = (EnumField) fields.get("invoiceDeliveryMethod");
                if (vendor.get("vendorinvDeliveryMethod") != null) {
                    invDelv.selectValue(JSONUtils.toString(vendor, "vendorinvDeliveryMethod"));
                } else {
                    invDelv.setSelectedIndex(0);
                }
            }
        });
    }

    protected String getVendor(String vendorEntityId) {
        return OfficeWelcome.constants.root_url() + "vendor/" + vendorEntityId;
    }

    public void loadClient(String clientEntityId) {
        HttpService.HttpServiceAsync.instance().doGet(getClient(clientEntityId), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject client = (JSONObject) JSONParser.parseLenient(response);
                TextAreaField payTermF = (TextAreaField) fields.get("clientPaymentTerms");
                payTermF.setValue(JSONUtils.toString(client, "paymentTerms"));
//                        BooleanField directClientB = (BooleanField) fields.get("directClient");
//                        directClientB.setValue(JSONUtils.toBoolean(client, "directClient"));
            }
        });
    }

    protected String getClient(String clientEntityId) {
        return OfficeWelcome.constants.root_url() + "client/" + clientEntityId;
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/save" + "?submitForApproval=" + submitForApprovalF.getValue();
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        if (submitForApprovalF.getValue()) {
            if (isSub) {
                CurrencyField subPay = (CurrencyField) fields.get("subcontractorPayRate");
                if (subPay.getCurrency() == null) {
                    subPay.setMessage("PayRate may not be null");
                    valid = false;
                }
            } else if (is1099) {
                CurrencyField pay1099 = (CurrencyField) fields.get("payRate1099");
                if (pay1099.getCurrency() == null) {
                    pay1099.setMessage("PayRate may not be null");
                    valid = false;
                }
            }
        }

        StringField visaStatusF = (StringField) fields.get("visaStatus");
        if (visaStatusF.getValue() == null || "".equals(visaStatusF.getValue())) {
            visaStatusF.setMessage("Visa status cannot be empty");
            valid = false;
        }
        return valid;
    }
}

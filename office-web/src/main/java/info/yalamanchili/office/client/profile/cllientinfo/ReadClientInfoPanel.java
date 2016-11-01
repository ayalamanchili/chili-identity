/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.home.tasks.ReadAllTasks;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import info.yalamanchili.office.client.profile.updateBillingRate.CreateUpdateBillingRatePanel;
import java.util.Map.Entry;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite implements ClickHandler {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(true, false, Alignment.HORIZONTAL);
    protected boolean isSubOr1099 = false;
    protected boolean active = false;
    protected boolean isProspectCPD = false;

    public ReadClientInfoPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "ClientInfo", OfficeWelcome.constants2);
    }

    public ReadClientInfoPanel(JSONObject entity, boolean active) {
        instance = this;
        this.active = active;
        initReadComposite(entity, "ClientInfo", OfficeWelcome.constants2);
    }

    public ReadClientInfoPanel(JSONObject entity, boolean active, boolean isProspectCPD) {
        instance = this;
        this.active = active;
        this.isProspectCPD = isProspectCPD;
        initReadComposite(entity, "ClientInfo", OfficeWelcome.constants2);
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("client", entity, null);
        assignFieldValueFromEntity("clientAPContacts", entity, null);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("vendorAPContacts", entity, null);
        assignFieldValueFromEntity("vendorRecruiters", entity, null);
        assignFieldValueFromEntity("middleVendor", entity, null);
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("clientPaymentTerms", entity, DataType.TEXT_AREA_FIELD);
        if (entity.get("clientProject") != null) {
            JSONObject project = entity.get("clientProject").isObject();
            assignFieldValueFromEntity("name", project, DataType.STRING_FIELD);
            assignFieldValueFromEntity("purchaseOrderNo", project, DataType.STRING_FIELD);
        }
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("isEndDateConfirmed", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("recruiters", entity, null);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
            assignFieldValueFromEntity("payRatePercentage", entity, DataType.FLOAT_FIELD);
            assignFieldValueFromEntity("overTimePayRatePercentage", entity, DataType.FLOAT_FIELD);
        }
        if (checkPermission()) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
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
            logger.info("is prospect cpd .... "+isProspectCPD);
            if (isProspectCPD == false && Auth.isSubContractor(getEmployee())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
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
            if (isProspectCPD == false && Auth.is1099(getEmployee())) {
                assignFieldValueFromEntity("payRate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("overTimePayrate1099", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("paymentTerms1099", entity, DataType.TEXT_AREA_FIELD);
                assignFieldValueFromEntity("invoiceFrequency1099", entity, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("terminationNotice", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("timeSheetRequirement", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("specialInvoiceInstructions", entity, DataType.TEXT_AREA_FIELD);
        }
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.TEXT_AREA_FIELD);
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("sectorsAndBUs", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("active", entity, DataType.BOOLEAN_FIELD);
        populateComments();
    }

    protected void renderBillingRatesPanel() {

    }

    protected boolean checkPermission() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_BILLING_ADMIN);
    }

    protected JSONObject getEmployee() {
        if (isProspectCPD == false) {
            return TreeEmployeePanel.instance().getEntity();
        } else {
            return null;
        }
    }

    @Override
    protected void addListeners() {
        updateBillingRateIcn.addClickHandler(this);
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
        entityFieldsPanel.add(getLineSeperatorTag("Client Information"));
        addDropDown("client", new SelectClientWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientLocation", new SelectClientLocationWidget(true, false, Alignment.HORIZONTAL));
        addDropDown("clientContact", new SelectClientContactWidget(true, false, Alignment.HORIZONTAL));
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
        addField("clientPaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Middle Vendor Information"));
        addDropDown("middleVendor", new SelectMiddleVendorWidget(true, false, Alignment.HORIZONTAL));
        entityFieldsPanel.add(getLineSeperatorTag("Vendor Information"));
        addDropDown("vendor", new SelectVendorWidget(true, true, Alignment.HORIZONTAL));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, true, Alignment.HORIZONTAL));
        selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, false, Alignment.HORIZONTAL) {
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
        addField("vendorPaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Details"));
        addField("startDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("isEndDateConfirmed", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("recruiters", selectRecruiterW);
        addField("name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("purchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (checkPermission()) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("itemNumber", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            if (isProspectCPD == false && ((Auth.isSubContractor(getEmployee())) || (Auth.is1099(getEmployee())))) {
                isSubOr1099 = true;
            }
            addField("billingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            if (isProspectCPD == false) {
                entityFieldsPanel.add(ReadAllUpdateBillingRatePanel.renderBillingRateHistory(getEntity(), isSubOr1099));
            }
            if (Auth.hasAnyOfRoles(ROLE.ROLE_BILLING_ADMIN, ROLE.ROLE_CONTRACTS_ADMIN)) {
                renderUpdateBillingRateFieldLink();
            }
            String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
            addEnumField("billingRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
            if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
                addField("payRatePercentage", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
            }
            addField("overTimeBillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addEnumField("overTimeRateDuration", true, false, billingDuration, Alignment.HORIZONTAL);
            if (Auth.hasAnyOfRoles(ROLE.ROLE_PAYROLL_AND_BENIFITS, ROLE.ROLE_ADMIN)) {
                addField("overTimePayRatePercentage", true, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
            }
            addEnumField("invoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            addEnumField("invoiceDeliveryMethod", true, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
            if (isProspectCPD == false && Auth.isSubContractor(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(true, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(true, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addEnumField("subcontractorinvoiceFrequency", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subContractorWorkOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            if (isProspectCPD == false && Auth.is1099(getEmployee())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor"));
                addField("payRate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                addEnumField("invoiceFrequency1099", true, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            }
            entityFieldsPanel.add(getLineSeperatorTag("HR Department Docs"));
            addField("i9Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("w4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("timeSheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("specialInvoiceInstructions", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
            addField("joiningReport", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);

            entityFieldsPanel.add(getLineSeperatorTag("Account Department Docs"));
            addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("practice", selectPractiseWidgetF);
        addField("sectorsAndBUs", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("notes", true, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        if (isProspectCPD == false && TreeEmployeePanel.instance() != null && TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
            StringField jobTitleF = (StringField) fields.get("employeeType");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
        }
        addField("active", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        populateCIDocuments();
        alignFields();
    }

    ClickableImage updateBillingRateIcn = new ClickableImage("update", ChiliImages.INSTANCE.updateIcon_16_16());

    protected void renderUpdateBillingRateFieldLink() {
        BaseField billRateField = fields.get("billingRate");
        billRateField.addWidgetToFieldPanel(updateBillingRateIcn);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation/read/" + entityId;
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

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.ClientInformation"));
    }

    @Override
    protected boolean enableAudit() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS, Auth.ROLE.ROLE_RECRUITER);
    }

    @Override
    protected String getAuditUrl() {
        return OfficeWelcome.instance().constants.root_url() + "audit/changes/" + "info.yalamanchili.office.entity.profile.ClientInformation" + "/" + getEntityId();
    }

    @Override
    protected boolean enableBack() {
        return true;
    }

    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllClientInfoPanel.instance;
    }

    @Override
    protected boolean enableViewTasks() {
        return Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN);
    }

    @Override
    protected void displayTasks() {
        String tasksUrl = OfficeWelcome.constants.root_url() + "bpm/tasks/process/";
        tasksDP.setContent(new ReadAllTasks(tasksUrl + JSONUtils.toString(getEntity(), "bpmProcessId") + "/", true));
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updateBillingRateIcn)) {
            new GenericPopup(new CreateUpdateBillingRatePanel(getEntity(), getEntity())).show();
        }
    }

    @Override
    public void loadEntity(String entityId) {

    }
}

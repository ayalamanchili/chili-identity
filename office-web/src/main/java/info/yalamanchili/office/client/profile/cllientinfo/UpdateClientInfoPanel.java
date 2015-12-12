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
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.updateBillingRate.CreateUpdateBillingRatePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;

public class UpdateClientInfoPanel extends UpdateComposite implements ChangeHandler {
    
    private static Logger logger = Logger.getLogger(UpdateClientInfoPanel.class.getName());
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(false, true, Alignment.HORIZONTAL);
    SelectProjectWidget selectProjectWidgetF = new SelectProjectWidget(true, false);
    EnumField servicesF;
    EnumField sectorsF;
    
    public UpdateClientInfoPanel(JSONObject entity) {
        initUpdateComposite(entity, "ClientInfo", OfficeWelcome.constants);
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("consultantJobTitle", entity);
        assignEntityValueFromField("company", entity);
        assignEntityValueFromField("client", entity);
        assignEntityValueFromField("clientContact", entity);
        assignEntityValueFromField("clientLocation", entity);
        assignEntityValueFromField("vendor", entity);
        assignEntityValueFromField("vendorContact", entity);
        assignEntityValueFromField("vendorAPContact", entity);
        assignEntityValueFromField("vendorLocation", entity);
        assignEntityValueFromField("vendorRecruiter", entity);
        assignEntityValueFromField("middleVendor", entity);
        assignEntityValueFromField("clientProject", entity);
        assignEntityValueFromField("vendorPaymentTerms", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignEntityValueFromField("itemNumber", entity);
            assignEntityValueFromField("payRate", entity);
            assignEntityValueFromField("billingRate", entity);
            assignEntityValueFromField("overTimePayRate", entity);
            assignEntityValueFromField("overTimeBillingRate", entity);
            assignEntityValueFromField("invoiceFrequency", entity);
            assignEntityValueFromField("invoiceDeliveryMethod", entity);
            assignEntityValueFromField("recruiters", entity);
            assignEntityValueFromField("billingRateDuration", entity);
            assignEntityValueFromField("overTimeRateDuration", entity);
            assignEntityValueFromField("visaStatus", entity);
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
                assignEntityValueFromField("subcontractorAddress", entity);
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
                assignEntityValueFromField("payTimeDuration1099", entity);
                assignEntityValueFromField("paymentTerms1099", entity);
            }
            assignEntityValueFromField("terminationNotice", entity);
            assignEntityValueFromField("notes", entity);
        }
        assignEntityValueFromField("isCPDFilled", entity);
        assignEntityValueFromField("practice", entity);
        assignEntityValueFromField("sectorsAndBUs", entity);
        logger.info(entity.toString());
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
                        postUpdateSuccess(arg0);
                    }
                });
        
    }
    
    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }
    
    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("company", entity, DataType.ENUM_FIELD);
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
        assignFieldValueFromEntity("vendorPaymentTerms", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeBillingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("recruiters", entity, null);
            assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("overTimeRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("joiningReport", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
            assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
                assignFieldValueFromEntity("subcontractorAddress", entity, null);
                assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorinvoiceFrequency", entity, DataType.ENUM_FIELD);
                assignFieldValueFromEntity("subcontractorpaymentTerms", entity, DataType.STRING_FIELD);
                assignFieldValueFromEntity("subcontractorw4Filled", entity, DataType.BOOLEAN_FIELD);
                assignFieldValueFromEntity("subcontractCOI", entity, DataType.BOOLEAN_FIELD);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity())) {
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
        assignFieldValueFromEntity("practice", entity, null);
        assignFieldValueFromEntity("sectorsAndBUs", entity, DataType.ENUM_FIELD);
    }
    
    @Override
    protected void addListeners() {
        updateBillingRateIcn.addClickHandler(this);
        selectPractiseWidgetF.getListBox().addChangeHandler(this);
        selectProjectWidgetF.setReadOnly(true);
    }
    
    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }
    
    SelectEmployeeWithRoleWidget selectRecruiterW = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL) {
        @Override
        public boolean enableMultiSelect() {
            return true;
        }
    };
    
    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("company", false, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(false, true, Alignment.HORIZONTAL));
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendor", new SelectVendorWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorContact", new SelectVendorContactWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorAPContact", new SelectVendorAcctPayContact(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorRecruiter", new SelectVendorRecruiterContactWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("middleVendor", new SelectMiddleVendorWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("clientProject", selectProjectWidgetF);
        addField("vendorPaymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("itemNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("payRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("billingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            new ReadAllUpdateBillingRatePanel().renderBillingRateHistory(getEntityId(), entityFieldsPanel);
            renderUpdateBillingRateFieldLink();
            String[] billingDuration = {"HOUR", "DAY", "MONTH"};
            addEnumField("billingRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addField("overTimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addEnumField("overTimeRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addEnumField("invoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
            addEnumField("invoiceDeliveryMethod", false, false, invoiceDeliveryMethods, Alignment.HORIZONTAL);
            addDropDown("recruiters", selectRecruiterW);
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("joiningReport", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
            addField("accountVerificationDocs", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("signedCopyOfWorkOrder", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("i9Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("w4Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("logisticsPreparation", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("hrOrientation", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("timeSheetRequirement", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("specialInvoiceInstructions", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                //               String[] invoiceFrequencie = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
                addEnumField("subcontractorinvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor Information"));
                addField("payRate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addEnumField("payTimeDuration1099", false, false, billingDuration, Alignment.HORIZONTAL);
            }
            addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("notes", false, false, DataType.RICH_TEXT_AREA);
        }
        addField("isCPDFilled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        if (TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
            StringField jobTitleF = (StringField) fields.get("employeeType");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
        }
        if (TreeEmployeePanel.instance().getEntity().get("company") != null) {
            StringField jobTitleF = (StringField) fields.get("company");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("company").isObject().get("name").isString().stringValue());
        }
        addField("sectorsAndBUs", false, true, DataType.ENUM_FIELD);
        JSONObject prj = (JSONObject) entity.get("practice");
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
        sectorsF = (EnumField) fields.get("sectorsAndBUs");
        addDropDown("practice", selectPractiseWidgetF);
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
            new GenericPopup(new CreateUpdateBillingRatePanel(getEntityId(), getEntity())).show();
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
    }
    
    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }
    
    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation";
    }
}

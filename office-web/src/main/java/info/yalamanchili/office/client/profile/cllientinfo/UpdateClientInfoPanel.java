/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.gwt.resources.ChiliImages;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ClickableImage;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.updateBillingRate.CreateUpdateBillingRatePanel;
import info.yalamanchili.office.client.profile.updateBillingRate.ReadAllUpdateBillingRatePanel;
import java.util.logging.Logger;

public class UpdateClientInfoPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateClientInfoPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL);

    public UpdateClientInfoPanel(JSONObject entity) {
        initUpdateComposite(entity, "ClientInfo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("consultantJobTitle", entity);
        assignEntityValueFromField("client", entity);
        assignEntityValueFromField("clientContact", entity);
        assignEntityValueFromField("clientLocation", entity);
        assignEntityValueFromField("vendor", entity);
        assignEntityValueFromField("vendorContact", entity);
        assignEntityValueFromField("vendorAPContact", entity);
        assignEntityValueFromField("vendorLocation", entity);
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
            assignEntityValueFromField("recruiter", entity);
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
        assignFieldValueFromEntity("client", entity, null);
        assignFieldValueFromEntity("clientContact", entity, null);
        assignFieldValueFromEntity("clientLocation", entity, null);
        assignFieldValueFromEntity("vendor", entity, null);
        assignFieldValueFromEntity("vendorContact", entity, null);
        assignFieldValueFromEntity("vendorAPContact", entity, null);
        assignFieldValueFromEntity("vendorLocation", entity, null);
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
            assignFieldValueFromEntity("recruiter", entity, null);
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
        }
    }

    @Override
    protected void addListeners() {
        updateBillingRateIcn.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(false, true, Alignment.HORIZONTAL));
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendor", new SelectVendorWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorContact", new SelectVendorContactWidget(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorAPContact", new SelectVendorAcctPayContact(false, false, Alignment.HORIZONTAL));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, false, Alignment.HORIZONTAL));
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
            addDropDown("recruiter", selectRecruiterWidget);
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
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                String[] invoiceFrequencie = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
                addEnumField("subcontractorinvoiceFrequency", false, false, invoiceFrequencie, Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorw4Filled", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
                addField("subcontractCOI", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Employee Information"));
                addField("payRate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addEnumField("payTimeDuration1099", false, false, billingDuration, Alignment.HORIZONTAL);
            }
            addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("notes", false, false, DataType.RICH_TEXT_AREA);
        }
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
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation";
    }
}

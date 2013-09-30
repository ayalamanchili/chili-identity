/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import java.util.logging.Logger;

public class UpdateClientInfoPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateClientInfoPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER.name(), false, false);

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
        assignEntityValueFromField("vendorLocation", entity);
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("endDate", entity);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignEntityValueFromField("itemNumber", entity);
            assignEntityValueFromField("payRate", entity);
            assignEntityValueFromField("billingRate", entity);
            assignEntityValueFromField("overTimePayRate", entity);
            assignEntityValueFromField("invoiceFrequency", entity);
            assignEntityValueFromField("invoiceDeliveryMethod", entity);
            assignEntityValueFromField("recruiter", entity);
            assignEntityValueFromField("billingRateDuration", entity);
            assignEntityValueFromField("overTimeDuration", entity);
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
            }
            assignEntityValueFromField("notes", entity);
        }
        logger.info("ddddddddddddd" + entity.toString());
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
        assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("recruiter", entity, null);
            assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("overTimeDuration", entity, DataType.ENUM_FIELD);
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
            }
            assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        }
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(false, true));
        addDropDown("clientContact", new SelectClientContactWidget(false, false));
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false));
        addDropDown("vendor", new SelectVendorWidget(false, false));
        addDropDown("vendorContact", new SelectVendorContactWidget(false, false));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, false));
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("itemNumber", false, false, DataType.STRING_FIELD);
            addField("payRate", false, false, DataType.CURRENCY_FIELD);
            addField("billingRate", false, false, DataType.CURRENCY_FIELD);
            String[] billingDuration = {"HOUR", "DAY", "MONTH"};
            addEnumField("billingRateDuration", false, false, billingDuration);
            addField("overTimePayRate", false, false, DataType.CURRENCY_FIELD);
            addEnumField("overTimeDuration", false, false, billingDuration);
            String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
            addEnumField("invoiceFrequency", false, false, invoiceFrequencies);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
            addEnumField("invoiceDeliveryMethod", false, false, invoiceDeliveryMethods);
            addDropDown("recruiter", selectRecruiterWidget);
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", false, false, DataType.STRING_FIELD);
            addField("joiningReport", false, true, DataType.STRING_FIELD);
            entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
            addField("accountVerificationDocs", false, false, DataType.BOOLEAN_FIELD);
            addField("signedCopyOfWorkOrder", false, false, DataType.BOOLEAN_FIELD);
            addField("i9Filled", false, false, DataType.BOOLEAN_FIELD);
            addField("w4Filled", false, false, DataType.BOOLEAN_FIELD);
            addField("logisticsPreparation", false, false, DataType.BOOLEAN_FIELD);
            addField("hrOrientation", false, false, DataType.BOOLEAN_FIELD);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD);
            }
            addField("notes", false, false, DataType.RICH_TEXT_AREA);
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
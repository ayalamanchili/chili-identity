/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.chili.gwt.rpc.HttpService;
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
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class ReadClientInfoPanel extends ReadComposite {

    private static ReadClientInfoPanel instance;
    private static Logger logger = Logger.getLogger(ReadClientInfoPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER.name(), false, false);

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
        assignFieldValueFromEntity("vendorLocation", entity, null);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("overTimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("overTimeDuration", entity, DataType.ENUM_FIELD);
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
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                assignFieldValueFromEntity("subcontractor", entity, null);
                assignFieldValueFromEntity("subcontractorContact", entity, null);
                assignFieldValueFromEntity("subcontractorAddress", entity, null);
                assignFieldValueFromEntity("subcontractorPayRate", entity, DataType.CURRENCY_FIELD);
                assignFieldValueFromEntity("subcontractorOvertimePayRate", entity, DataType.CURRENCY_FIELD);
            }
            assignFieldValueFromEntity("terminationNotice", entity, DataType.RICH_TEXT_AREA);
            assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(true, false));
        addDropDown("clientContact", new SelectClientContactWidget(true, false));
        addDropDown("clientLocation", new SelectClientLocationWidget(true, false));
        addDropDown("vendor", new SelectVendorWidget(true, false));
        addDropDown("vendorContact", new SelectVendorContactWidget(true, false));
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(true, false));
        addField("startDate", true, false, DataType.DATE_FIELD);
        addField("endDate", true, false, DataType.DATE_FIELD);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_TIME, Auth.ROLE.ROLE_RECRUITER, Auth.ROLE.ROLE_RELATIONSHIP)) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("itemNumber", true, false, DataType.STRING_FIELD);
            addField("payRate", true, false, DataType.CURRENCY_FIELD);
            addField("billingRate", true, false, DataType.CURRENCY_FIELD);
            String[] billingDuration = {"HOUR", "DAY", "MONTH"};
            addEnumField("billingRateDuration", true, false, billingDuration);
            addField("overTimePayRate", true, false, DataType.CURRENCY_FIELD);
            addEnumField("overTimeDuration", true, false, billingDuration);
            String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
            addEnumField("invoiceFrequency", true, false, invoiceFrequencies);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
            addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods);
            addDropDown("recruiter", selectRecruiterWidget);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD);
            }
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", true, false, DataType.STRING_FIELD);
            addField("joiningReport", true, false, DataType.STRING_FIELD);
            entityFieldsPanel.add(getLineSeperatorTag("HR and Account Department Docs"));
            addField("accountVerificationDocs", true, false, DataType.BOOLEAN_FIELD);
            addField("signedCopyOfWorkOrder", true, false, DataType.BOOLEAN_FIELD);
            addField("i9Filled", true, false, DataType.BOOLEAN_FIELD);
            addField("w4Filled", true, false, DataType.BOOLEAN_FIELD);
            addField("logisticsPreparation", true, false, DataType.BOOLEAN_FIELD);
            addField("hrOrientation", true, false, DataType.BOOLEAN_FIELD);
            addField("terminationNotice", true, false, DataType.STRING_FIELD);
            addField("notes", true, false, DataType.RICH_TEXT_AREA);
        }
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
}

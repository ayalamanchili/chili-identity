/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.contracts;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadContractsPanel extends ReadComposite {

    private static ReadContractsPanel instance;
    private static Logger logger = Logger.getLogger(ReadContractsPanel.class.getName());

    public ReadContractsPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Contract", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String entityId) {
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("employee", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("client", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("clientContact", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorContact", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("vendorLocation", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("endDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("itemNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("payRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("billingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("invoiceFrequency", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("invoiceDeliveryMethod", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("billingRateDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("overTimeDuration", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("recruiter", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("visaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("joiningReport", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("accountVerificationDocs", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("signedCopyOfWorkOrder", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("i9Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("w4Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("logisticsPreparation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("hrOrientation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("notes", entity, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("employee", true, false, DataType.STRING_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addField("consultantJobTitle", true, false, DataType.STRING_FIELD);
        addField("client", true, false, DataType.STRING_FIELD);
        addField("clientLocation", true, false, DataType.STRING_FIELD);
        addField("clientContact", true, false, DataType.STRING_FIELD);
        addField("vendor", true, false, DataType.STRING_FIELD);
        addField("vendorContact", true, false, DataType.STRING_FIELD);
        addField("vendorLocation", true, false, DataType.STRING_FIELD);
        addField("startDate", false, true, DataType.DATE_FIELD);
        addField("endDate", false, false, DataType.DATE_FIELD);
        entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
        addField("itemNumber", true, false, DataType.STRING_FIELD);
        addField("payRate", false, false, DataType.CURRENCY_FIELD);
        addField("billingRate", true, false, DataType.CURRENCY_FIELD);
        String[] invoiceFrequencies = {"WEEKLY", "BI_WEEKLY", "MONTHLY", "SEMI_MONTHLY", "NOT_REQUIRED"};
        addEnumField("invoiceFrequency", true, false, invoiceFrequencies);
        String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
        addEnumField("invoiceDeliveryMethod", true, false, invoiceDeliveryMethods);
        String[] billingDuration = {"HOUR", "DAY", "MONTH"};
        addEnumField("billingRateDuration", true, false, billingDuration);
        addEnumField("overTimeDuration", true, false, billingDuration);
        addField("recruiter", true, false, DataType.STRING_FIELD);
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
//        if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity())) {
//            entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
//            addDropDown("subcontractor", new SelectSubcontractorWidget(false, false));
//            addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false));
//            addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false));
//            addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD);
//            addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD);
//        }
        addField("notes", true, false, DataType.RICH_TEXT_AREA);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "contract/" + entityId;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.ReadAllComposite;
import info.chili.gwt.crud.ReadComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class ReadBISClientInformationPanel extends ReadComposite {

    private static ReadBISClientInformationPanel instance;
    private static Logger logger = Logger.getLogger(ReadBISClientInformationPanel.class.getName());
    SelectEmployeeWithRoleWidget selectRecruiterWidget = new SelectEmployeeWithRoleWidget("Recruiter", Auth.ROLE.ROLE_RECRUITER, false, false, Alignment.HORIZONTAL);

    public ReadBISClientInformationPanel(String id) {
        instance = this;
        initReadComposite(id, "Client Information", OfficeWelcome.constants);
    }

    public ReadBISClientInformationPanel(JSONObject entity) {
        instance = this;
        initReadComposite(entity, "Client Information", OfficeWelcome.constants);
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("BillingRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("BillingRateDuration", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("CPDCreatedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("CPDCreatedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("CPDCreatedUserId", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("CPDLastModifiedBy", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("CPDLastModifiedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("CPDLastModifiedUserDepartmentId", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("CPDLastModifiedUserId", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("CPDProject_EndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("CPDProject_StartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("ClientLocationId", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("ClientLocationTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ClientLocation_Address", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ClientLocation_City_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ClientLocation_State_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ClientLocation_ZipCode", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Client_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Client_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Client_Sector", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Comments_Accounting", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Comments_Contract", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Comments_Hr", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Company", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Company_Id", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("ConsultantFullName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ConsultantProjectDetailsTable_Id", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("ConsultantType", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Consultant_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("CpdDetailsTable_Ide", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("CurrentPayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("CurrentPayRateEffectiveFrom", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("DateofRelieving", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("ExtraNotes", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Frequency_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("HrOrientation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("I9Filled", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("Invoice_DeliveryMethod", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Invoice_Frequency_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("IsActive", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("ItemNo", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("JobTitle_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Job_Title_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("JoiningReportDetails", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("LogisticsPreparation", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("MiddleVendorID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("MiddleVendorName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("OvertimeBillingRateDuration", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("OvertimePayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("PayRate", entity, DataType.CURRENCY_FIELD);
        assignFieldValueFromEntity("PaymentTerms_SubContractor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("PaymentTerms_Vendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("PersonalCellNo", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("PersonalEmail", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Photo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("PreviousProjectEndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("PreviousProjectStartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("PreviousVendorID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("PreviousVendorName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("ProjectEndingForSure", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Project_EndDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("Project_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Project_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Project_StartDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("PurchaseOrderNo", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("RecruiterIDS", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Recruiters", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("SCInvoiceFrequency", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Sectors_BusinessUnits", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Services_Practices", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("SignedCopyofWorkOrder", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("SpecialInvoiceInstructions", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("SpecialNotes", entity, DataType.STRING_FIELD);
        if (Auth.isSubContractor(getEmployee())) {
            assignFieldValueFromEntity("SubContractorAgentEmail", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractorAgentName", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractorAgentPhoneNo", entity, DataType.INTEGER_FIELD);
            assignFieldValueFromEntity("SubContractorCertificateofInsurance", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractorComments", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractorContactPerson", entity, DataType.INTEGER_FIELD);
            assignFieldValueFromEntity("SubContractorW9Form", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractorWorkOrderNo", entity, DataType.INTEGER_FIELD);
            assignFieldValueFromEntity("SubContractor_ID", entity, DataType.INTEGER_FIELD);
            assignFieldValueFromEntity("SubContractor_Invoice_Frequency_ID", entity, DataType.INTEGER_FIELD);
            assignFieldValueFromEntity("SubContractor_Name", entity, DataType.STRING_FIELD);
            assignFieldValueFromEntity("SubContractor_OvertimePayRate", entity, DataType.CURRENCY_FIELD);
            assignFieldValueFromEntity("SubContractor_PayRate", entity, DataType.CURRENCY_FIELD);
        }
        assignFieldValueFromEntity("TerminationNoticeProvided", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("TimesheetRequirement", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Updated_By", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("Updated_Date", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("VacationDetails", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("VendorAPContactPersonIDs", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("VendorRecruiterEmails", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("VendorRecruiterIDs", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("VendorRecruiterNames", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("VendorRecruiterPhoneNos", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Vendor_ID", entity, DataType.INTEGER_FIELD);
        assignFieldValueFromEntity("Vendor_Name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("VisaStatus", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("W4Filled", entity, DataType.BOOLEAN_FIELD);
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
        addField("BillingRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("BillingRateDuration", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("CPDCreatedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("CPDCreatedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("CPDCreatedUserId", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("CPDLastModifiedBy", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("CPDLastModifiedDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("CPDLastModifiedUserDepartmentId", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("CPDLastModifiedUserId", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("CPDProject_EndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("CPDProject_StartDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocationId", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocationTitle", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocation_Address", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocation_City_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocation_State_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ClientLocation_ZipCode", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Client_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Client_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Client_Sector", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Comments_Accounting", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Comments_Contract", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Comments_Hr", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Company", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Company_Id", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("ConsultantFullName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ConsultantProjectDetailsTable_Id", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("ConsultantType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Consultant_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("CpdDetailsTable_Ide", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("CurrentPayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("CurrentPayRateEffectiveFrom", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("DateofRelieving", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("ExtraNotes", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Frequency_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("HrOrientation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("I9Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("Invoice_DeliveryMethod", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Invoice_Frequency_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("IsActive", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("ItemNo", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("JobTitle_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Job_Title_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("JoiningReportDetails", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("LogisticsPreparation", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("MiddleVendorID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("MiddleVendorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("OvertimeBillingRateDuration", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("OvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("PayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        addField("PaymentTerms_SubContractor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("PaymentTerms_Vendor", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("PersonalCellNo", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("PersonalEmail", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Photo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("PreviousProjectEndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("PreviousProjectStartDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("PreviousVendorID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("PreviousVendorName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("ProjectEndingForSure", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Project_EndDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("Project_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Project_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Project_StartDate", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("PurchaseOrderNo", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("RecruiterIDS", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Recruiters", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("SCInvoiceFrequency", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Sectors_BusinessUnits", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Services_Practices", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("SignedCopyofWorkOrder", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("SpecialInvoiceInstructions", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("SpecialNotes", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (Auth.isSubContractor(getEmployee())) {
            entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
            addField("SubContractorAgentEmail", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorAgentName", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorAgentPhoneNo", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorCertificateofInsurance", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorComments", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorContactPerson", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorW9Form", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractorWorkOrderNo", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addField("SubContractor_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addField("SubContractor_Invoice_Frequency_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addField("SubContractor_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("SubContractor_OvertimePayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("SubContractor_PayRate", true, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
        }
        addField("TerminationNoticeProvided", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("TimesheetRequirement", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Updated_By", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("Updated_Date", true, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("VacationDetails", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("VendorAPContactPersonIDs", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("VendorRecruiterEmails", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("VendorRecruiterIDs", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("VendorRecruiterNames", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("VendorRecruiterPhoneNos", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Vendor_ID", true, false, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        addField("Vendor_Name", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("VisaStatus", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("W4Filled", true, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   protected boolean enableBack() {
       return true;
   }
    
    @Override
    protected ReadAllComposite getReadAllPanel() {
        return ReadAllBISClientInformationPanel.instance;
    }
}

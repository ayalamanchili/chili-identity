/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;
import info.yalamanchili.office.client.admin.client.SelectClientWidget;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.client.CreateClientPanel;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcntrlocation.SelectSubcontractorLocationWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.CreateVendorPanel;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import com.google.gwt.event.dom.client.ChangeHandler;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;

public class CreateClientInfoPanel extends CreateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(CreateClientInfoPanel.class.getName());
    protected Anchor addClientL = new Anchor("Client not present? submit request");
    protected Anchor addVendorL = new Anchor("Vendor not present? submit request");
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(false, true, Alignment.HORIZONTAL);
    protected BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit For Approval", "ClientInfo", false, false, Alignment.HORIZONTAL);

    public CreateClientInfoPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientInfo", OfficeWelcome.constants);
    }

    BooleanField endPreviousProjectFlagField;
    DateField previousProjectEndDate;
    EnumField servicesF;
    EnumField sectorsF;

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clientInfo = new JSONObject();
        assignEntityValueFromField("consultantJobTitle", clientInfo);
        assignEntityValueFromField("company", clientInfo);
        assignEntityValueFromField("client", clientInfo);
        assignEntityValueFromField("clientContact", clientInfo);
        assignEntityValueFromField("clientAPContacts", clientInfo);
        assignEntityValueFromField("clientLocation", clientInfo);
        assignEntityValueFromField("vendor", clientInfo);
        assignEntityValueFromField("vendorContact", clientInfo);
        assignEntityValueFromField("vendorAPContacts", clientInfo);
        assignEntityValueFromField("vendorLocation", clientInfo);
        assignEntityValueFromField("vendorRecruiters", clientInfo);
        assignEntityValueFromField("middleVendor", clientInfo);
        assignEntityValueFromField("vendorPaymentTerms", clientInfo);
        assignEntityValueFromField("startDate", clientInfo);
        assignEntityValueFromField("endDate", clientInfo);
        if (ReadAllClientInfoPanel.instance().numberOfRecords > 0) {
            assignEntityValueFromField("endPreviousProject", clientInfo);
            assignEntityValueFromField("previousProjectEndDate", clientInfo);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            assignEntityValueFromField("payRate", clientInfo);
            assignEntityValueFromField("billingRate", clientInfo);
            assignEntityValueFromField("billingRateDuration", clientInfo);
            assignEntityValueFromField("overTimePayRate", clientInfo);
            assignEntityValueFromField("overTimeBillingRate", clientInfo);
            assignEntityValueFromField("overTimeRateDuration", clientInfo);
            assignEntityValueFromField("invoiceFrequency", clientInfo);
            assignEntityValueFromField("invoiceDeliveryMethod", clientInfo);
            clientInfo.put("recruiters", selectRecruiterW.getSelectedObjects());
            assignEntityValueFromField("visaStatus", clientInfo);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                assignEntityValueFromField("subcontractor", clientInfo);
                assignEntityValueFromField("subcontractorContact", clientInfo);
                assignEntityValueFromField("subcontractorAddress", clientInfo);
                assignEntityValueFromField("subcontractorPayRate", clientInfo);
                assignEntityValueFromField("subcontractorOvertimePayRate", clientInfo);
                assignEntityValueFromField("subcontractorinvoiceFrequency", clientInfo);
                assignEntityValueFromField("subcontractorpaymentTerms", clientInfo);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                assignEntityValueFromField("payRate1099", clientInfo);
                assignEntityValueFromField("overTimePayrate1099", clientInfo);
                assignEntityValueFromField("payTimeDuration1099", clientInfo);
                assignEntityValueFromField("paymentTerms1099", clientInfo);
            }
            assignEntityValueFromField("terminationNotice", clientInfo);
            assignEntityValueFromField("notes", clientInfo);
        }
        assignEntityValueFromField("practice", clientInfo);
        assignEntityValueFromField("sectorsAndBUs", clientInfo);
        logger.info(clientInfo.toString());
        return clientInfo;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        logger.info(arg0.getMessage());
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });

    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    protected void addListeners() {
        addClientL.addClickHandler(this);
        addVendorL.addClickHandler(this);
        if (endPreviousProjectFlagField != null) {
            endPreviousProjectFlagField.getBox().addClickHandler(this);
        }
        selectPractiseWidgetF.getListBox().addChangeHandler(this);
    }

    @Override
    protected void configure() {
        endPreviousProjectFlagField = (BooleanField) fields.get("endPreviousProject");
        previousProjectEndDate = (DateField) fields.get("previousProjectEndDate");
        if (previousProjectEndDate != null) {
            previousProjectEndDate.setVisible(false);
        }
        add.setText("Save");
        submitForApprovalF.setValue(true);
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
        //Basic
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("company", false, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        //client
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", new SelectClientWidget(false, true, Alignment.HORIZONTAL));
        entityFieldsPanel.add(addClientL);
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
        addDropDown("clientLocation", new SelectClientLocationWidget(false, false, Alignment.HORIZONTAL));
        //Vendor
        addDropDown("vendor", new SelectVendorWidget(false, false, Alignment.HORIZONTAL));
        entityFieldsPanel.add(addVendorL);
        addDropDown("vendorContact", new SelectVendorContactWidget(false, false, Alignment.HORIZONTAL));
        selectVendorAPContactsW = new SelectVendorAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorAPContacts", selectVendorAPContactsW);
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, false, Alignment.HORIZONTAL));
        selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
        addDropDown("middleVendor", new SelectMiddleVendorWidget(false, false, Alignment.HORIZONTAL));
        addField("vendorPaymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        //Contract basic
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        if (ReadAllClientInfoPanel.instance().numberOfRecords > 0) {
            addField("endPreviousProject", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("previousProjectEndDate", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            addDropDown("recruiter", selectRecruiterW);
            //Billing Information
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("payRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("billingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            String[] billingDuration = {"HOUR", "DAY", "MONTH"};
            addEnumField("billingRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addField("overTimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addEnumField("overTimeRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addEnumField("invoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            String[] invoiceDeliveryMethods = {"MANUAL", "EMAIL", "FAX"};
            addEnumField("invoiceDeliveryMethod", false, false, invoiceDeliveryMethods, Alignment.HORIZONTAL);
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorAddress", new SelectSubcontractorLocationWidget(false, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addEnumField("subcontractorinvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            }
            if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor Information"));
                addField("payRate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("overTimePayrate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("paymentTerms1099", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
                addEnumField("payTimeDuration1099", false, false, billingDuration, Alignment.HORIZONTAL);
            }
            entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
            addField("visaStatus", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
            addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        }

        if (TreeEmployeePanel.instance()
                .getEntity().get("jobTitle") != null) {
            StringField jobTitleF = (StringField) fields.get("consultantJobTitle");
            jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("jobTitle").isString().stringValue());
        }

        if (TreeEmployeePanel.instance()
                .getEntity().get("employeeType") != null) {
            StringField employeeTypeF = (StringField) fields.get("employeeType");
            employeeTypeF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
        }

        addDropDown("practice", selectPractiseWidgetF);
        addEnumField("sectorsAndBUs", false, true, ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
        sectorsF = (EnumField) fields.get("sectorsAndBUs");
        entityFieldsPanel.add(submitForApprovalF);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addClientL)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateClientPanel(CreateCompositeType.CREATE)).show();
            } else {
                new GenericPopup(new GenericBPMStartFormPanel("AddNewClientRequest", "add_new_client_request_1")).show();
            }
        }
        if (event.getSource().equals(addVendorL)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateVendorPanel(CreateCompositeType.CREATE)).show();
            } else {
                new GenericPopup(new GenericBPMStartFormPanel("AddNewVendorRequest", "add_new_vendor_request_1")).show();
            }
        }

        if ((ReadAllClientInfoPanel.instance().numberOfRecords > 0) && (event.getSource().equals(endPreviousProjectFlagField.getBox()))) {
            previousProjectEndDate.setVisible(endPreviousProjectFlagField.getValue());
        }

        super.onClick(event);
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
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + TreeEmployeePanel.instance().getEntityId() + "?submitForApproval=" + submitForApprovalF.getValue();
    }
}

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
import info.yalamanchili.office.client.admin.clientlocation.SelectClientLocationWidget;
import info.yalamanchili.office.client.admin.vendor.SelectVendorWidget;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.admin.client.CreateClientPanel;
import info.yalamanchili.office.client.admin.subcntrcontact.SelectSubcontractorContactWidget;
import info.yalamanchili.office.client.admin.subcontractor.SelectSubcontractorWidget;
import info.yalamanchili.office.client.admin.vendor.CreateVendorPanel;
import info.yalamanchili.office.client.admin.vendor.SelectMiddleVendorWidget;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorAcctPayContact;
import info.yalamanchili.office.client.admin.vendorcontact.SelectVendorRecruiterContactWidget;
import info.yalamanchili.office.client.home.tasks.GenericBPMStartFormPanel;
import info.yalamanchili.office.client.profile.employee.SelectEmployeeWithRoleWidget;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.SelectComposite;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.FloatField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.admin.clientcontact.CreateClientAcctPayCntPanel;
import info.yalamanchili.office.client.admin.clientcontact.CreateClientContactPanel;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.clientlocation.CreateClientLocationPanel;
import info.yalamanchili.office.client.admin.hr.ProspectMenu;
import info.yalamanchili.office.client.admin.hr.ReadAllProspectsPanel;
import info.yalamanchili.office.client.admin.vendorcontact.CreateVendorAcctPayCntPanel;
import info.yalamanchili.office.client.admin.vendorcontact.CreateVendorContactPanel;
import info.yalamanchili.office.client.admin.vendorlocation.CreateVendorLocationsPanel;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;

public class CreateClientInfoPanel extends CreateComposite implements ChangeHandler, ValueChangeHandler {

    private static Logger logger = Logger.getLogger(CreateClientInfoPanel.class.getName());
    protected Anchor addClientL = new Anchor("Client not present? submit request");
    protected Anchor addClientLocation = new Anchor("Add new Worksite Location");
    protected Anchor addClientRecruiter = new Anchor("Add new Client Recruiter Contact");
    protected Anchor addClientAcctPayContact = new Anchor("Add new Client Account Payable Contact");
    protected Anchor addVendorL = new Anchor("Vendor not present? submit request");
    protected Anchor addVendorLocation = new Anchor("Add new Vendor Location");
    protected Anchor addVendorRecruiter = new Anchor("Add new Vendor Recruiter Contact");
    protected Anchor addVendorAcctPayContact = new Anchor("Add new Vendor Account Payable Contact");
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(false, true, Alignment.HORIZONTAL);
    SelectVendorWidget selectVendorWidgetF = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);
    SelectClientWidget selectClientWidgetF = new SelectClientWidget(false, true, Alignment.HORIZONTAL);
    protected BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit For Approval", "ClientInfo", false, false, Alignment.HORIZONTAL);
    protected boolean isSub = false;
    protected boolean is1099 = false;
    protected boolean active = false;
    protected String sourceId = null;
    protected String sourceName = null;
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants2, "ClientInformation", "cidocument", "CIDocument/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(res);
        }
    };

    public CreateClientInfoPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientInfo", OfficeWelcome.constants2);
    }

    public CreateClientInfoPanel(CreateCompositeType type, String sourceId, String sourceName) {
        super(type);
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        initCreateComposite("ClientInfo", OfficeWelcome.constants2);
    }

    public CreateClientInfoPanel(CreateCompositeType type, boolean active) {
        super(type);
        this.active = active;
        initCreateComposite("ClientInfo", OfficeWelcome.constants2);
    }

    EnumField servicesF;
    EnumField sectorsF;
    DateField endDateF;
    FloatField clientFee;
    FloatField vendorFee;
    BooleanField isEndDateConfirmedF;
    BooleanField isClientFeeApplicable;
    BooleanField isVendorFeeApplicable;

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clientInfo = new JSONObject();
        assignEntityValueFromField("consultantJobTitle", clientInfo);
        assignEntityValueFromField("company", clientInfo);
        assignEntityValueFromField("client", clientInfo);
//        assignEntityValueFromField("clientFeeApplicable", clientInfo);
        assignEntityValueFromField("clientFee", clientInfo);
//        assignEntityValueFromField("directClient", clientInfo);        
        assignEntityValueFromField("clientContact", clientInfo);
        assignEntityValueFromField("clientAPContacts", clientInfo);
        assignEntityValueFromField("clientLocation", clientInfo);
        assignEntityValueFromField("clientPaymentTerms", clientInfo);
        assignEntityValueFromField("vendor", clientInfo);
        assignEntityValueFromField("vendorAPContacts", clientInfo);
//        assignEntityValueFromField("vendorFeeApplicable", clientInfo);
        assignEntityValueFromField("vendorFee", clientInfo);
        assignEntityValueFromField("vendorLocation", clientInfo);
        assignEntityValueFromField("vendorRecruiters", clientInfo);
        assignEntityValueFromField("middleVendor", clientInfo);
        assignEntityValueFromField("vendorPaymentTerms", clientInfo);
        assignEntityValueFromField("startDate", clientInfo);
        assignEntityValueFromField("endDate", clientInfo);
        if (isEndDateConfirmedF.isVisible() == true) {
            isEndDateConfirmedF.getValue();
            clientInfo.put("isEndDateConfirmed", new JSONString(isEndDateConfirmedF.getValue().toString()));
        }
        clientInfo.put("recruiters", selectRecruiterW.getSelectedObjects());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            assignEntityValueFromField("billingRate", clientInfo);
            assignEntityValueFromField("billingRateDuration", clientInfo);
            assignEntityValueFromField("overTimeBillingRate", clientInfo);
            assignEntityValueFromField("overTimeRateDuration", clientInfo);
            assignEntityValueFromField("invoiceFrequency", clientInfo);
            assignEntityValueFromField("invoiceDeliveryMethod", clientInfo);
            if (sourceId == null) {
                if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                    assignEntityValueFromField("subcontractor", clientInfo);
                    assignEntityValueFromField("subcontractorContact", clientInfo);
                    assignEntityValueFromField("subcontractorPayRate", clientInfo);
                    assignEntityValueFromField("subcontractorOvertimePayRate", clientInfo);
                    assignEntityValueFromField("subcontractorinvoiceFrequency", clientInfo);
                    assignEntityValueFromField("subcontractorpaymentTerms", clientInfo);
                }
                if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                    assignEntityValueFromField("payRate1099", clientInfo);
                    assignEntityValueFromField("overTimePayrate1099", clientInfo);
                    assignEntityValueFromField("paymentTerms1099", clientInfo);
                    assignEntityValueFromField("invoiceFrequency1099", clientInfo);
                }
            }
        }
        assignEntityValueFromField("terminationNotice", clientInfo);
        assignEntityValueFromField("notes", clientInfo);
        assignEntityValueFromField("visaStatus", clientInfo);
        assignEntityValueFromField("practice", clientInfo);
        assignEntityValueFromField("sectorsAndBUs", clientInfo);
        JSONArray cidocument = new JSONArray();
        if (!fileUploadPanel.isEmpty()) {
            int i = 0;
            for (JSONString fileName : fileUploadPanel.getFileNames()) {
                if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                    JSONObject clientInformation = new JSONObject();
                    clientInformation.put("fileURL", fileName);
                    clientInformation.put("name", new JSONString("File Name"));
                    cidocument.set(i, clientInformation);
                    i++;
                }
            }
        }
        if (cidocument.size() > 0) {
            clientInfo.put("cidocument", cidocument);
        }
        return clientInfo;
    }

    protected void uploadDocuments(String postString) {
        entity = JSONParser.parseLenient(postString).isObject();
        if (!fileUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
            JSONArray cidocument = JSONUtils.toJSONArray(post.get("cidocument"));
            fileUploadPanel.upload(cidocument, "fileURL");
        } else {
            postCreateSuccess(null);
        }
    }

    @Override
    protected void createButtonClicked() {
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
                        uploadDocuments(arg0);
                    }
                });
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Client Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        if (sourceId == null) {
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId(), active));
        } else {
            GenericPopup.hideIfOpen();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ProspectMenu());
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllProspectsPanel());
        }
    }

    @Override
    protected void addListeners() {
        addClientL.addClickHandler(this);
        addClientLocation.addClickHandler(this);
        addClientRecruiter.addClickHandler(this);
        addClientAcctPayContact.addClickHandler(this);
        addVendorL.addClickHandler(this);
        addVendorLocation.addClickHandler(this);
        addVendorRecruiter.addClickHandler(this);
        addVendorAcctPayContact.addClickHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
        selectVendorWidgetF.getListBox().addChangeHandler(this);
        selectClientWidgetF.getListBox().addChangeHandler(this);
        selectPractiseWidgetF.getListBox().addChangeHandler(this);
        endDateF = (DateField) fields.get("endDate");
        if (endDateF != null) {
            endDateF.getDatePicker().addValueChangeHandler(this);
        }
//        isClientFeeApplicable.getBox().addClickHandler(this);
//        isVendorFeeApplicable.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {
        setButtonText("Submit");
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
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        if (sourceId == null) {
            addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        } else {
            addField("employeeType", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addEnumField("company", false, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client Information"));
        addDropDown("client", selectClientWidgetF);
        entityFieldsPanel.add(addClientL);

//        addField("directClient", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("clientLocation", new SelectClientLocationWidget(false, true, Alignment.HORIZONTAL));
        entityFieldsPanel.add(addClientLocation);
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        entityFieldsPanel.add(addClientRecruiter);
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
        entityFieldsPanel.add(addClientAcctPayContact);
//        addField("clientFeeApplicable", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
//        isClientFeeApplicable = (BooleanField) fields.get("clientFeeApplicable");
//        addField("clientFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL); 
//        clientFee = (FloatField) fields.get("clientFee");
//        clientFee.setVisible(false);
        addField("clientPaymentTerms", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Middle Vendor Information"));
        addDropDown("middleVendor", new SelectMiddleVendorWidget(false, false, Alignment.HORIZONTAL));
        entityFieldsPanel.add(getLineSeperatorTag("Vendor Information"));
        addDropDown("vendor", selectVendorWidgetF);
        entityFieldsPanel.add(addVendorL);
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, true, Alignment.HORIZONTAL));
        entityFieldsPanel.add(addVendorLocation);
        selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, true, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
        entityFieldsPanel.add(addVendorRecruiter);
        selectVendorAPContactsW = new SelectVendorAcctPayContact(false, true, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorAPContacts", selectVendorAPContactsW);
        entityFieldsPanel.add(addVendorAcctPayContact);
//        addField("vendorFeeApplicable", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
//        isVendorFeeApplicable = (BooleanField) fields.get("vendorFeeApplicable");
//        addField("vendorFee", false, false, DataType.FLOAT_FIELD, Alignment.HORIZONTAL);
//        vendorFee = (FloatField) fields.get("vendorFee");
//        vendorFee.setVisible(false);
        addField("vendorPaymentTerms", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Project Details"));
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("isEndDateConfirmed", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addDropDown("recruiter", selectRecruiterW);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            entityFieldsPanel.add(getLineSeperatorTag("Billing Information"));
            addField("billingRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            String[] billingDuration = {"HOUR", "DAY", "MONTH", "WEEK"};
            addEnumField("billingRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addField("overTimeBillingRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
            addEnumField("overTimeRateDuration", false, false, billingDuration, Alignment.HORIZONTAL);
            addEnumField("invoiceFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
            addEnumField("invoiceDeliveryMethod", false, false, InvoiceDeliveryMethod.names(), Alignment.HORIZONTAL);
            if (sourceId == null) {
                if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                    entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                    addDropDown("subcontractor", new SelectSubcontractorWidget(false, true, Alignment.HORIZONTAL));
                    addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, true, Alignment.HORIZONTAL));
                    addField("subcontractorPayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("subcontractorOvertimePayRate", false, true, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addEnumField("subcontractorinvoiceFrequency", false, true, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                    addField("subcontractorpaymentTerms", false, true, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                    isSub = true;
                }
                if (Auth.is1099(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                    entityFieldsPanel.add(getLineSeperatorTag("1099 Contractor Information"));
                    addField("payRate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("overTimePayrate1099", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                    addField("paymentTerms1099", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
                    addEnumField("invoiceFrequency1099", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                    is1099 = true;
                }
            }
        }
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addDropDown("practice", selectPractiseWidgetF);
        if (sourceId == null) {
            if (TreeEmployeePanel.instance().getEntity().get("workStatus") != null) {
                StringField employeeVisaStatusF = (StringField) fields.get("visaStatus");
                employeeVisaStatusF.setValue(TreeEmployeePanel.instance().getEntity().get("workStatus").isString().stringValue());
            }
            if (TreeEmployeePanel.instance().getEntity().get("jobTitle") != null) {
                StringField jobTitleF = (StringField) fields.get("consultantJobTitle");
                jobTitleF.setValue(TreeEmployeePanel.instance().getEntity().get("jobTitle").isString().stringValue());
            }
            if (TreeEmployeePanel.instance().getEntity().get("employeeType") != null) {
                StringField employeeTypeF = (StringField) fields.get("employeeType");
                employeeTypeF.setValue(TreeEmployeePanel.instance().getEntity().get("employeeType").isObject().get("name").isString().stringValue());
            }
        }
        addEnumField("sectorsAndBUs", false, true, ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        sectorsF = (EnumField) fields.get("sectorsAndBUs");
        endDateF = (DateField) fields.get("endDate");
        isEndDateConfirmedF = (BooleanField) fields.get("isEndDateConfirmed");
        isEndDateConfirmedF.setVisible(false);
        entityFieldsPanel.add(getLineSeperatorTag("CPD Document"));
        entityFieldsPanel.add(fileUploadPanel);
        entityActionsPanel.add(submitForApprovalF);
        submitForApprovalF.setValue(true);
        alignFields();

    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addClientL)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateClientPanel(CreateCompositeType.CREATE), 350, 10).show();
            } else {
                new GenericPopup(new GenericBPMStartFormPanel("AddNewClientRequest", "add_new_client_request_1"), 350, 10).show();
            }
        }
        if (event.getSource().equals(addClientLocation)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateClientLocationPanel(selectClientWidgetF.getSelectedObjectId(), CreateCompositeType.CREATE), 400, 100).show();
            }
        }
        if (event.getSource().equals(addClientRecruiter)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateClientContactPanel(selectClientWidgetF.getSelectedObjectId(), CreateCompositeType.ADD), 400, 100).show();
            }
        }
        if (event.getSource().equals(addClientAcctPayContact)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateClientAcctPayCntPanel(selectClientWidgetF.getSelectedObjectId(), CreateCompositeType.ADD), 400, 100).show();
            }
        }
//        if (event.getSource().equals(isClientFeeApplicable.getBox()) && isClientFeeApplicable.getValue()) {
//            clientFee.setVisible(true);
//        } else {
//            clientFee.setVisible(false);
//        }
//        if (event.getSource().equals(isVendorFeeApplicable.getBox()) && isVendorFeeApplicable.getValue()) {
//            vendorFee.setVisible(true);
//        } else {
//            vendorFee.setVisible(false);
//        }
        if (event.getSource().equals(addVendorL)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateVendorPanel(CreateCompositeType.CREATE), 350, 10).show();
            } else {
                new GenericPopup(new GenericBPMStartFormPanel("AddNewVendorRequest", "add_new_vendor_request_1"), 350, 10).show();
            }
        }
        if (event.getSource().equals(addVendorLocation)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateVendorLocationsPanel(selectVendorWidgetF.getSelectedObjectId(), CreateCompositeType.CREATE), 400, 100).show();
            }
        }
        if (event.getSource().equals(addVendorRecruiter)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateVendorContactPanel(selectVendorWidgetF.getSelectedObjectId(), CreateCompositeType.ADD), 400, 100).show();
            }
        }
        if (event.getSource().equals(addVendorAcctPayContact)) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                new GenericPopup(new CreateVendorAcctPayCntPanel(selectVendorWidgetF.getSelectedObjectId(), CreateCompositeType.ADD), 400, 100).show();
            }
        }

        if (submitForApprovalF.getValue()) {
            setButtonText("Submit");
        } else {
            setButtonText("Save");
        }

        super.onClick(event);
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
                        EnumField invFrequencyv = (EnumField) fields.get("invoiceFrequency");
                        if (vendor.get("vendorinvFrequency") != null) {
                            invFrequencyv.selectValue(JSONUtils.toString(vendor, "vendorinvFrequency"));
                        } else {
                            invFrequencyv.setSelectedIndex(0);
                        }
//                        FloatField vendorFee=(FloatField) fields.get("vendorFee");
//                        vendorFee.setValue(JSONUtils.toString(vendor, "vendorFees"));
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
//                        BooleanField directClientB=(BooleanField) fields.get("directClient");
//                        directClientB.setValue(JSONUtils.toBoolean(client, "directClient"));
//                        FloatField clientFee=(FloatField) fields.get("clientFee");
//                        clientFee.setValue(JSONUtils.toString(client, "clientFee"));

                    }
                });
    }

    protected String getClient(String clientEntityId) {
        return OfficeWelcome.constants.root_url() + "client/" + clientEntityId;
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

    @Override
    protected String getURI() {
        if (sourceId == null) {
            return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + TreeEmployeePanel.instance().getEntityId() + "?submitForApproval=" + submitForApprovalF.getValue();
        } else {
            return OfficeWelcome.constants.root_url() + "clientinformation/add-cpd/" + sourceId + "/" + sourceName;
        }
    }

    @Override
    public void onValueChange(ValueChangeEvent event) {
        if (endDateF.getDate() != null) {
            isEndDateConfirmedF.setVisible(true);
        } else {
            isEndDateConfirmedF.setVisible(false);
        }
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

        if (sourceId != null) {
            SelectComposite clientLocation = (SelectComposite) fields.get("clientLocation");
            if (clientLocation.getSelectedObject() == null) {
                clientLocation.setMessage("may not be null");
                valid = false;
            }
            SelectComposite vendorLocation = (SelectComposite) fields.get("vendorLocation");
            if (vendorLocation.getSelectedObject() == null) {
                vendorLocation.setMessage("may not be null");
                valid = false;
            }
            DateField endDate = (DateField) fields.get("endDate");
            if (endDate.getDate() == null) {
                endDate.setMessage("may not be null");
                valid = false;
            }
            CurrencyField billRate = (CurrencyField) fields.get("billingRate");
            if (billRate.getValue() == null || billRate.getValue().isEmpty()) {
                billRate.setMessage("may not be null");
            }
            EnumField invoiceFrequency = (EnumField) fields.get("invoiceFrequency");
            if (invoiceFrequency.getValue() == null || invoiceFrequency.getValue().isEmpty()) {
                invoiceFrequency.setMessage("may not be null");
                valid = false;
            }
            TextAreaField vendorPayTerms = (TextAreaField) fields.get("vendorPaymentTerms");
            if (vendorPayTerms.getValue() == null || vendorPayTerms.getValue().isEmpty()) {
                vendorPayTerms.setMessage("may not be null");
                valid = false;
            }
        }
        return valid;
    }
}

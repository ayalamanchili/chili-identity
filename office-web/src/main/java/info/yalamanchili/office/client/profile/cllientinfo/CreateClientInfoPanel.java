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
import com.google.gwt.user.client.ui.FileUpload;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.date.DateUtils;
import info.chili.gwt.fields.CurrencyField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.TextAreaField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientAcctPayContact;
import info.yalamanchili.office.client.admin.clientcontact.SelectClientContactWidget;
import info.yalamanchili.office.client.admin.vendorlocation.SelectVendorLocationsWidget;
import info.yalamanchili.office.client.practice.SelectPracticeWidget;
import java.util.Date;

public class CreateClientInfoPanel extends CreateComposite implements ChangeHandler, ValueChangeHandler {

    private static Logger logger = Logger.getLogger(CreateClientInfoPanel.class.getName());
    protected Anchor addClientL = new Anchor("Client not present? submit request");
    protected Anchor addVendorL = new Anchor("Vendor not present? submit request");
    SelectPracticeWidget selectPractiseWidgetF = new SelectPracticeWidget(false, true, Alignment.HORIZONTAL);
    SelectVendorWidget selectVendorWidgetF = new SelectVendorWidget(false, true, Alignment.HORIZONTAL);
    SelectClientWidget selectClientWidgetF = new SelectClientWidget(false, true, Alignment.HORIZONTAL);
    protected BooleanField submitForApprovalF = new BooleanField(OfficeWelcome.constants, "Submit For Approval", "ClientInfo", false, false, Alignment.HORIZONTAL);
    protected boolean isSub = false;
    protected boolean is1099 = false;
    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "ClientInformation", "cidocument", "CIDocument/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postCreateSuccess(res);
        }
    };

    public CreateClientInfoPanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("ClientInfo", OfficeWelcome.constants2);
    }

    BooleanField endPreviousProjectFlagField = new BooleanField(OfficeWelcome.constants2, "endPreviousProject", "ClientInfo", false, false, Alignment.HORIZONTAL);
    DateField previousProjectEndDate = new DateField(OfficeWelcome.constants2, "previousProjectEndDate", "ClientInfo", false, false, Alignment.HORIZONTAL);
    TextAreaField reason = new TextAreaField(OfficeWelcome.constants2, "reason", "ClientInfo", false, false, Alignment.HORIZONTAL);
    EnumField servicesF;
    EnumField sectorsF;
    DateField endDateF;
    BooleanField isEndDateConfirmedF;

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject clientInfo = new JSONObject();
        assignEntityValueFromField("consultantJobTitle", clientInfo);
        assignEntityValueFromField("company", clientInfo);
        assignEntityValueFromField("client", clientInfo);
        assignEntityValueFromField("clientContact", clientInfo);
        assignEntityValueFromField("clientAPContacts", clientInfo);
        assignEntityValueFromField("clientLocation", clientInfo);
        assignEntityValueFromField("clientPaymentTerms", clientInfo);
        assignEntityValueFromField("vendor", clientInfo);
        assignEntityValueFromField("vendorAPContacts", clientInfo);
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
        if (ReadAllClientInfoPanel.instance().numberOfRecords > 0) {
            clientInfo.put("endPreviousProject", new JSONString(endPreviousProjectFlagField.getValue().toString()));
            clientInfo.put("previousProjectEndDate", new JSONString(DateUtils.toDateString(previousProjectEndDate.getDate())));
            clientInfo.put("reason", new JSONString(reason.getValue()));
        }
        clientInfo.put("recruiters", selectRecruiterW.getSelectedObjects());
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            assignEntityValueFromField("billingRate", clientInfo);
            assignEntityValueFromField("billingRateDuration", clientInfo);
            assignEntityValueFromField("overTimeBillingRate", clientInfo);
            assignEntityValueFromField("overTimeRateDuration", clientInfo);
            assignEntityValueFromField("invoiceFrequency", clientInfo);
            assignEntityValueFromField("invoiceDeliveryMethod", clientInfo);
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
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    protected void addListeners() {
        addClientL.addClickHandler(this);
        addVendorL.addClickHandler(this);
        submitForApprovalF.getBox().addClickHandler(this);
        selectVendorWidgetF.getListBox().addChangeHandler(this);
        selectClientWidgetF.getListBox().addChangeHandler(this);
        if (endPreviousProjectFlagField != null) {
            endPreviousProjectFlagField.getBox().addClickHandler(this);
        }
        selectPractiseWidgetF.getListBox().addChangeHandler(this);
        endDateF = (DateField) fields.get("endDate");
        if (endDateF != null) {
            endDateF.getDatePicker().addValueChangeHandler(this);
        }
    }

    @Override
    protected void configure() {
        if (ReadAllClientInfoPanel.instance().numberOfRecords > 0) {
            endPreviousProjectFlagField.setValue(Boolean.TRUE);
            entityFieldsPanel.insert(previousProjectEndDate, 21);
            entityFieldsPanel.insert(reason, 22);
            previousProjectEndDate.setVisible(Boolean.TRUE);
            reason.setVisible(Boolean.TRUE);
            populateEndDate();
        }
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
        addField("employeeType", true, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("company", false, true, ClientInformationCompany.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Client & Vendor Information"));
        addDropDown("client", selectClientWidgetF);
        entityFieldsPanel.add(addClientL);
        addDropDown("clientLocation", new SelectClientLocationWidget(false, true, Alignment.HORIZONTAL));
        selectClientAcctPayContact = new SelectClientAcctPayContact(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("clientAPContacts", selectClientAcctPayContact);
        addDropDown("clientContact", new SelectClientContactWidget(false, false, Alignment.HORIZONTAL));
        addField("clientPaymentTerms", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addDropDown("vendor", selectVendorWidgetF);
        entityFieldsPanel.add(addVendorL);
        addDropDown("vendorLocation", new SelectVendorLocationsWidget(false, true, Alignment.HORIZONTAL));
        selectVendorAPContactsW = new SelectVendorAcctPayContact(false, true, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorAPContacts", selectVendorAPContactsW);
        selectVendorRecruiterContactsWidget = new SelectVendorRecruiterContactWidget(false, false, Alignment.HORIZONTAL) {
            @Override
            public boolean enableMultiSelect() {
                return true;
            }
        };
        addDropDown("vendorRecruiters", selectVendorRecruiterContactsWidget);
        addField("vendorPaymentTerms", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addDropDown("middleVendor", new SelectMiddleVendorWidget(false, false, Alignment.HORIZONTAL));
        addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("endDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("isEndDateConfirmed", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        if (ReadAllClientInfoPanel.instance().numberOfRecords > 0) {
            entityFieldsPanel.add(endPreviousProjectFlagField);
            entityFieldsPanel.add(previousProjectEndDate);
            entityFieldsPanel.add(reason);
        }
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
            if (Auth.isSubContractor(TreeEmployeePanel.instance().getEntity() == null ? OfficeWelcome.instance().employee : TreeEmployeePanel.instance().getEntity())) {
                entityFieldsPanel.add(getLineSeperatorTag("Subcontractor Information"));
                addDropDown("subcontractor", new SelectSubcontractorWidget(false, false, Alignment.HORIZONTAL));
                addDropDown("subcontractorContact", new SelectSubcontractorContactWidget(false, false, Alignment.HORIZONTAL));
                addField("subcontractorPayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addField("subcontractorOvertimePayRate", false, false, DataType.CURRENCY_FIELD, Alignment.HORIZONTAL);
                addEnumField("subcontractorinvoiceFrequency", false, false, InvoiceFrequency.names(), Alignment.HORIZONTAL);
                addField("subcontractorpaymentTerms", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
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
        entityFieldsPanel.add(getLineSeperatorTag("Other Information"));
        addField("visaStatus", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("terminationNotice", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("notes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
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

        addDropDown("practice", selectPractiseWidgetF);
        addEnumField("sectorsAndBUs", false, true, ConsultingServices.getSectorsAndBusinessUnits().toArray(new String[0]), Alignment.HORIZONTAL);
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
            reason.setVisible(endPreviousProjectFlagField.getValue());
            populateEndDate();
        }
        if (submitForApprovalF.getValue()) {
            setButtonText("Submit");
        } else {
            setButtonText("Save");
        }

        super.onClick(event);
    }

    public void populateEndDate() {
        HttpService.HttpServiceAsync.instance().doGet(getProjectEndDate(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                if (arg0 != null) {
                    Date date2 = new Date(arg0);
                    previousProjectEndDate.setDate(date2);
                }
            }
        }
        );
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
            }
        });
    }

    protected String getClient(String clientEntityId) {
        return OfficeWelcome.constants.root_url() + "client/" + clientEntityId;
    }

    private String getProjectEndDate() {
        return OfficeWelcome.constants.root_url() + "clientinformation/endDate/" + TreeEmployeePanel.instance().getEntityId() + "/" + endPreviousProjectFlagField.getValue();
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
        return OfficeWelcome.constants.root_url() + "employee/clientinformation/" + TreeEmployeePanel.instance().getEntityId() + "?submitForApproval=" + submitForApprovalF.getValue();
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
        if ((ReadAllClientInfoPanel.instance().numberOfRecords > 0) && endPreviousProjectFlagField.isVisible() == true && endPreviousProjectFlagField.getValue() == true) {
            if (reason.getValue() == null || "".equals(reason.getValue())) {
                reason.setMessage("Reason Required");
                valid = false;
            }
        }
        return valid;
    }

}

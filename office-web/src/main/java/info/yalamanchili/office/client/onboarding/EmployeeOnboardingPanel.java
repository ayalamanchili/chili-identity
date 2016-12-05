/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.crud.CRUDComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.fields.IntegerField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.expense.bnkacct.AccountType;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class EmployeeOnboardingPanel extends UpdateComposite implements ClickHandler, ChangeHandler, BlurHandler {

    private static Logger logger = Logger.getLogger(EmployeeOnboardingPanel.class.getName());
    protected ClickableLink addDependentsL = new ClickableLink("Add Dependents");
    protected ClickableLink addEmerContact = new ClickableLink("Add Emergency Contacts");
    protected List<CreateDependentsPanel> dependentsPanels = new ArrayList<>();
    protected List<CreateEmergencyContactWidget> emergencyContactsPanels = new ArrayList<>();
    HTML emptyLine = new HTML("<br/>");
    HTML fileUploadNotes1 = new HTML("<p><strong style=\"color:#F31212\">Note: please use the above button to upload I9, W4 and I9 supporting doc in pdf format. (To select multiple files use cntrl+click)</strong></p> \n");
    HTML fileUploadNotes2 = new HTML("<b> Note: </b> Original copy of I-9 Form should be sent to Tampa office by Mail.");
    HTML emerContactNotes = new HTML("<b> Note: </b> Primary Emergency Contact should be local and Secondary Emergency Contact can be non local.");
    HTML dependentNotes = new HTML("<b> Note: </b> If you have no dependents, please select this checkbox.");
    protected CheckBox noDependentsCB = new CheckBox("I have No Dependents", false);

    protected static HTML formsInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Please upload W4 Form, I9 Form and I9 supporting document</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML bankInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Bank Account Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML additionalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Additional Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML depsInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Dependents Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML emerInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Emergency Contact Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    IntegerField countryCodeF = new IntegerField(OfficeWelcome.constants, "countryCode", "Phone", false, false, Alignment.HORIZONTAL);
    StringField phoneNumberF = new StringField(OfficeWelcome.constants, "phoneNumber", "Phone", false, true, Alignment.HORIZONTAL);

    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "EmployeeDocument", "", "EmployeeDocument/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }

        @Override
        protected List<String> getValidFileExtensions() {
            String[] exts = "pdf".split(",");
            return new ArrayList<>(Arrays.asList(exts));
        }
    };

    EnumField statesF;
    EnumField countriesF;
    protected String invitationCode;

    protected static EmployeeOnboardingPanel instance;

    public static EmployeeOnboardingPanel instance() {
        return instance;
    }

    public EmployeeOnboardingPanel(String inviteCode) {
        this.invitationCode = inviteCode;
        instance = this;
        initUpdateComposite(invitationCode, "Employee", OfficeWelcome.constants2);
        fileUploadPanel.appendUploadUrl("?public=true&token=" + inviteCode);
    }

    @Override
    public void loadEntity(String invitationCode) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(invitationCode), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String response) {
                logger.info(response);
                if (!response.trim().equals("null")) {
                    entity = (JSONObject) JSONParser.parseLenient(response);
                    populateFieldsFromEntity(entity);
                }
            }
        });
    }

    protected String getReadURI(String invitationCode) {
        return OfficeWelcome.constants.public_url() + "onboarding/getdetails/" + invitationCode;
    }

    @Override
    public JSONObject populateEntityFromFields() {
        JSONObject employee = new JSONObject();
        JSONObject address = new JSONObject();
        JSONObject bankAccount = new JSONObject();
        JSONObject employeeAdditionalDetails = new JSONObject();
        assignEntityValueFromField("firstName", employee);
        assignEntityValueFromField("middleInitial", employee);
        assignEntityValueFromField("lastName", employee);
        assignEntityValueFromField("dateOfBirth", employee);
        assignEntityValueFromField("sex", employee);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignEntityValueFromField("workStatus", employee);
        }
        assignEntityValueFromField("ssn", employee);
        if (countryCodeF.getValue() != null && !countryCodeF.getValue().trim().isEmpty()) {
            employee.put("countryCode", new JSONString(countryCodeF.getValue()));
        }
        if (phoneNumberF.getValue() != null && !phoneNumberF.getValue().trim().isEmpty()) {
            employee.put("phoneNumber", new JSONString(phoneNumberF.getValue()));
        }
        // Address Information
        assignEntityValueFromField("street1", address);
        assignEntityValueFromField("street2", address);
        assignEntityValueFromField("city", address);
        assignEntityValueFromField("state", address);
        assignEntityValueFromField("country", address);
        assignEntityValueFromField("zip", address);
        employee.put("address", address);
        // Bank Account Information
        assignEntityValueFromField("accountFirstName", bankAccount);
        assignEntityValueFromField("accountLastName", bankAccount);
        assignEntityValueFromField("bankName", bankAccount);
        assignEntityValueFromField("bankRoutingNumber", bankAccount);
        assignEntityValueFromField("bankAccountNumber", bankAccount);
        assignEntityValueFromField("bankAddress1", bankAccount);
        assignEntityValueFromField("bankAddress2", bankAccount);
        assignEntityValueFromField("accountType", bankAccount);
        //assignEntityValueFromField("achBlocked", bankAccount);
        bankAccount.put("targetEntityName", new JSONString("targetEntityName"));
        bankAccount.put("targetEntityId", new JSONString("0"));
        employee.put("bankAccount", bankAccount);
        // Dependent Information
        if (dependentsPanels.size() > 0) {
            JSONArray dependent = new JSONArray();
            int i = 0;
            for (CreateDependentsPanel panel : dependentsPanels) {
                dependent.set(i, panel.populateEntityFromFields());
                i++;
            }
            employee.put("dependent", dependent);
        }
        // Emergency Contact Information
        if (emergencyContactsPanels.size() > 0) {
            JSONArray emergencyContact = new JSONArray();
            int i = 0;
            for (CreateEmergencyContactWidget panel : emergencyContactsPanels) {
                emergencyContact.set(i, panel.populateEntityFromFields());
                i++;
            }
            employee.put("emergencyContact", emergencyContact);
        }
        // Additional Information
        assignEntityValueFromField("referredBy", employeeAdditionalDetails);
        assignEntityValueFromField("maritalStatus", employeeAdditionalDetails);
        assignEntityValueFromField("ethnicity", employeeAdditionalDetails);
        assignEntityValueFromField("veteranStatus", employeeAdditionalDetails);
        assignEntityValueFromField("disability", employeeAdditionalDetails);        
        employeeAdditionalDetails.put("targetEntityName", new JSONString("targetEntityName"));
        employeeAdditionalDetails.put("targetEntityId", new JSONString("0"));
        employee.put("employeeAdditionalDetails", employeeAdditionalDetails);
        employee.put("inviteCode", new JSONString(invitationCode));

        JSONArray onBoardingDocs = new JSONArray();
        if (!fileUploadPanel.isEmpty()) {
            int i = 0;
            for (JSONString fileName : fileUploadPanel.getFileNames()) {
                if (fileName != null && !fileName.stringValue().trim().isEmpty()) {
                    JSONObject docs = new JSONObject();
                    docs.put("fileUrl", fileName);
                    docs.put("name", new JSONString("File Name"));
                    onBoardingDocs.set(i, docs);
                    i++;
                }
            }
        }
        employee.put("documents", onBoardingDocs);
        return employee;
    }

    @Override
    protected void addListeners() {
        countriesF.listBox.addChangeHandler(this);
        addDependentsL.addClickHandler(this);
        addEmerContact.addClickHandler(this);
        firstNameF.getTextbox().addBlurHandler(this);
        lastNameF.getTextbox().addBlurHandler(this);
        noDependentsCB.addClickHandler(this);
    }

    @Override
    protected void configure() {
        phoneNumberF.getTextbox().setMaxLength(10);
        bankInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        additionalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        formsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        depsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        emerInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        update.setText("Sign & Submit");
    }

    StringField firstNameF;
    StringField lastNameF;
    StringField baFirstNameF;
    StringField baLastNameF;

    @Override
    protected void addWidgets() {
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, true, Sex.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addEnumField("workStatus", false, true, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        addField("ssn", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(countryCodeF);
        entityFieldsPanel.add(phoneNumberF);
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(bankInfo);
        addField("accountFirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        //addField("achBlocked", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(additionalInfo);
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", false, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", false, false, Ethnicity.names(), Alignment.HORIZONTAL);
        addEnumField("veteranStatus", false, false, VeteranStatus.names(), Alignment.HORIZONTAL);
        addEnumField("disability", false, false, Disability.names(), Alignment.HORIZONTAL);        
        entityFieldsPanel.add(formsInfo);
        entityFieldsPanel.add(fileUploadPanel);
        entityFieldsPanel.add(fileUploadNotes1);
        entityFieldsPanel.add(fileUploadNotes2);
        entityFieldsPanel.add(depsInfo);
        entityFieldsPanel.add(dependentNotes);
        entityFieldsPanel.add(noDependentsCB);
        entityFieldsPanel.add(addDependentsL);
        entityFieldsPanel.add(emerInfo);
        entityFieldsPanel.add(addEmerContact);
        entityFieldsPanel.add(emerContactNotes);
        CreateEmergencyContactWidget panel = new CreateEmergencyContactWidget(CreateComposite.CreateCompositeType.ADD, this, 0) {
            @Override
            protected void setFocus() {

            }
        };
        emergencyContactsPanels.add(panel);
        entityFieldsPanel.add(panel);
        countriesF = (EnumField) fields.get("country");
        statesF = (EnumField) fields.get("state");
        firstNameF = (StringField) fields.get("firstName");
        lastNameF = (StringField) fields.get("lastName");
        baFirstNameF = (StringField) fields.get("accountFirstName");
        baLastNameF = (StringField) fields.get("accountLastName");
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                uploadDocs(arg0);
            }
        });
    }

    @Override
    protected Map<String, BaseField> getChildWidget(int childIndexWidget) {
        Map<String, BaseField> emergContactFields = new HashMap<>();
        if (dependentsPanels.size() > 0) {
            Map<String, BaseField> dependentFields = ((CRUDComposite) dependentsPanels.get(childIndexWidget)).fields;
            for (String key : dependentFields.keySet()) {
                emergContactFields.put(key, dependentFields.get(key));
            }
        }
        Map<String, BaseField> emergContactFields1 = ((CRUDComposite) emergencyContactsPanels.get(childIndexWidget)).fields;
        for (String key : emergContactFields1.keySet()) {
            emergContactFields.put(key, emergContactFields1.get(key));
        }
        return emergContactFields;
    }

    protected void uploadDocs(String postString) {
        if (!fileUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
            JSONArray employeeforms = JSONUtils.toJSONArray(post.get("documents"));
            fileUploadPanel.upload(employeeforms, "fileUrl");
        } else {
            postUpdateSuccess(null);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        RootPanel.get().clear();
        RootPanel.get().add(new HTML("Thank you. Please check your email on follow up instructions"));
    }

    @Override
    public void onChange(ChangeEvent event) {
        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
            case "CANADA":
                statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }

    @Override
    protected boolean showDocumentationLink() {
        return true;
    }

    @Override
    protected String getDocumentationLink() {
        return OfficeWelcome.instance().getOfficeClientConfig().getPortalDocumentationSiteUrl() + "employee.html";
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.public_url() + "onboarding/on-board-employee";
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        JSONObject account = (JSONObject) entity.get("bankAccount");
        if (account != null) {
            assignFieldValueFromEntity("accountFirstName", account, DataType.STRING_FIELD);
            assignFieldValueFromEntity("accountLastName", account, DataType.STRING_FIELD);
        }
        if (entity.containsKey("countryCode")) {
            countryCodeF.setValue(entity.get("countryCode").isString().stringValue());
        }
        if (entity.containsKey("phoneNumber")) {
            phoneNumberF.setValue(entity.get("phoneNumber").isString().stringValue());
        }
        JSONObject address = (JSONObject) entity.get("address");
        if (address != null) {
            JSONObject contact = (JSONObject) address.get("contact");
            if (contact != null) {
                assignFieldValueFromEntity("sex", contact, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("street1", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("street2", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("city", address, DataType.STRING_FIELD);
            assignFieldValueFromEntity("country", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("state", address, DataType.ENUM_FIELD);
            assignFieldValueFromEntity("zip", address, DataType.STRING_FIELD);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addDependentsL)) {
            CreateDependentsPanel panel = null;
            int i = dependentsPanels.size();
            panel = new CreateDependentsPanel(this, i, false);
            dependentsPanels.add(panel);
            entityFieldsPanel.insert(panel, entityFieldsPanel.getWidgetIndex(emerInfo));
        } else if (event.getSource().equals(addEmerContact)) {
            CreateEmergencyContactWidget panel = null;
            int x = emergencyContactsPanels.size();
            panel = new CreateEmergencyContactWidget(CreateComposite.CreateCompositeType.ADD, this, x);
            emergencyContactsPanels.add(panel);
            entityFieldsPanel.add(panel);
        } else if (event.getSource().equals(noDependentsCB)) {
            if (noDependentsCB.getValue() == true) {
                entityFieldsPanel.remove(addDependentsL);
            } else {
                entityFieldsPanel.insert(addDependentsL, entityFieldsPanel.getWidgetIndex(emerInfo));
            }
        }
        super.onClick(event);
    }

    public void removePanel(int i) {
        if (dependentsPanels.size() > 0) {
            dependentsPanels.get(i).removeFromParent();
            dependentsPanels.remove(i);
        }
    }

    public void removeEmergencyContactPanel(int x) {
        if (emergencyContactsPanels.size() > 0) {
            emergencyContactsPanels.get(x).removeFromParent();
            emergencyContactsPanels.remove(x);
        }
    }

    @Override
    public void onBlur(BlurEvent event) {
        if (event.getSource().equals(firstNameF.getTextbox())) {
            baFirstNameF.setValue(firstNameF.getValue());
        }
        if (event.getSource().equals(lastNameF.getTextbox())) {
            baLastNameF.setValue(lastNameF.getValue());
        }
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField zipF = (StringField) fields.get("zip");
        StringField referredByF = (StringField) fields.get("referredBy");
        if (zipF.getValue() == null || "".equals(zipF.getValue())) {
            fields.get("zip").setMessage("Zip can not be empty");
            valid = false;
        }
        if (referredByF.getValue() == null || "".equals(referredByF.getValue())) {
            fields.get("referredBy").setMessage("ReferredBy can not be empty");
            valid = false;
        }
        if (phoneNumberF.getValue() == null || "".equals(phoneNumberF.getValue())) {
            phoneNumberF.setMessage("Phone Number can not be empty");
            valid = false;
        } else if (phoneNumberF.getValue() != null) {
            String number = phoneNumberF.getValue();
            if (!number.matches("[0-9]*")) {
                phoneNumberF.setMessage("Invalid Phone Number");
                valid = false;
            } else if (number.length() != 10) {
                phoneNumberF.setMessage("PhoneNumber must be in 10 characters long");
            }
        }
        if (dependentsPanels.isEmpty() && noDependentsCB.getValue().equals(Boolean.FALSE)) {
            Window.confirm("Please choose dependents or select I have No Dependents check box");
            valid = false;
        }
        if (fileUploadPanel.getFileNames().size() < 3) {
            Window.confirm("Please make sure you are uploading I9, W4 and Supporting doc before submitting");
            valid = false;
        }
        return valid;
    }
}
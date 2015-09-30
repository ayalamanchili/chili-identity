/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.FileuploadField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.expense.bnkacct.AccountType;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import info.yalamanchili.office.client.profile.employee.CreateEmployeePanel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class EmployeeOnboardingPanel extends UpdateComposite implements ClickHandler, ChangeHandler {

    private static Logger logger = Logger.getLogger(CreateEmployeePanel.class.getName());
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    protected ClickableLink addDependentsL = new ClickableLink("Add Dependents");
    protected ClickableLink addEmerContact = new ClickableLink("Add Emergency Contacts");
    protected List<CreateDependentsPanel> createDependentsPanel = new ArrayList<>();
    protected List<CreateEmergencyContactWidget> createEmergencyContactPanel = new ArrayList<>();
    HTML emptyLine = new HTML("<br/>");

    protected static HTML formsInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Please upload W2_Form and I9_Form</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML bankInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Bank Account Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML additionalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Additional Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML depsInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Dependents Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");
    protected static HTML emerInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(204, 204, 204); padding: 5px 10px; background: rgb(238, 238, 238);\">"
            + "<strong style=\"color:#555555\">Emergency Contact Information</strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    FileuploadField fileUploadPanel = new FileuploadField(OfficeWelcome.constants, "Forms", "", "Forms/fileURL", false, true) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
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
        initUpdateComposite(invitationCode, "Employee", OfficeWelcome.constants);
    }

    @Override
    public void loadEntity(String invitationCode) {
        HttpService.HttpServiceAsync.instance().doGet(getReadURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        logger.info(response);
                        entity = (JSONObject) JSONParser.parseLenient(response);
                        populateFieldsFromEntity(entity);

                    }
                });
    }

    protected String getReadURI() {
        return OfficeWelcome.constants.root_url() + "on-board-employee/" + invitationCode;
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
        if (Auth.isAdmin()) {
            assignEntityValueFromField("ssn", employee);
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
        assignEntityValueFromField("achBlocked", bankAccount);
        bankAccount.put("targetEntityName", new JSONString("targetEntityName"));
        bankAccount.put("targetEntityId", new JSONString("0"));
        employee.put("bankAccount", bankAccount);
        // Dependent Information
        if (createDependentsPanel.size() > 0) {
            JSONArray dependent = new JSONArray();
            int i = 0;
            for (CreateDependentsPanel panel : createDependentsPanel) {
                dependent.set(i, panel.populateEntityFromFields());
                i++;
            }
            employee.put("dependent", dependent);
        }
        // Emergency Contact Information
        if (createEmergencyContactPanel.size() > 0) {
            JSONArray emergencyContact = new JSONArray();
            int i = 0;
            for (CreateEmergencyContactWidget panel : createEmergencyContactPanel) {
                emergencyContact.set(i, panel.populateEntityFromFields());
                i++;
            }
            employee.put("emergencyContact", emergencyContact);
        }
        // Additional Information
        assignEntityValueFromField("referredBy", employeeAdditionalDetails);
        assignEntityValueFromField("maritalStatus", employeeAdditionalDetails);
        assignEntityValueFromField("ethnicity", employeeAdditionalDetails);
        employeeAdditionalDetails.put("targetEntityName", new JSONString("targetEntityName"));
        employeeAdditionalDetails.put("targetEntityId", new JSONString("0"));
        employee.put("employeeAdditionalDetails", employeeAdditionalDetails);
        // 
        employee.put("inviteCode", new JSONString(invitationCode));

        JSONArray Onboardingforms = new JSONArray();

        if (!fileUploadPanel.isEmpty()) {
            int i = 0;
            for (FileUpload upload : fileUploadPanel.getFileUploads()) {
                if (upload.getFilename() != null && !upload.getFilename().trim().isEmpty()) {
                    JSONObject forms = new JSONObject();
                    forms.put("fileURL", fileUploadPanel.getFileName(upload));
                    forms.put("name", new JSONString("File Name"));
                    Onboardingforms.set(i, forms);
                    i++;
                }
            }
        }
        employee.put("forms", Onboardingforms);
        logger.info("employee" + employee.toString());
        return employee;
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
        countriesF.listBox.addChangeHandler(this);
        addDependentsL.addClickHandler(this);
        addEmerContact.addClickHandler(this);
    }

    @Override
    protected void configure() {
        bankInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        additionalInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        formsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        depsInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        emerInfo.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
    }

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
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(bankInfo);
        addField("accountFirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress1", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        addField("achBlocked", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(additionalInfo);
        addField("referredBy", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", false, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", false, false, Ethnicity.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(formsInfo);
        entityFieldsPanel.add(fileUploadPanel);
        entityFieldsPanel.add(depsInfo);
        entityFieldsPanel.add(addDependentsL);
        entityFieldsPanel.add(emerInfo);
        entityFieldsPanel.add(addEmerContact);
        countriesF = (EnumField) fields.get("country");
        statesF = (EnumField) fields.get("state");
        entityFieldsPanel.add(emptyLine);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void updateButtonClicked() {
        logger.info("entity details:" + entity.toString());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        uploadReceipts(arg0);
                    }
                });
    }

    protected void uploadReceipts(String postString) {
        if (!fileUploadPanel.isEmpty()) {
            JSONObject post = (JSONObject) JSONParser.parseLenient(postString);
            JSONArray employeeforms = JSONUtils.toJSONArray(post.get("forms"));
            fileUploadPanel.upload(employeeforms, "fileURL");
        } else {
            postUpdateSuccess(null);
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Created Employee");
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
        return OfficeWelcome.constants.root_url() + "on-board-employee/on-board-employee";
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addDependentsL)) {
            CreateDependentsPanel panel = null;
            int i = createDependentsPanel.size();
            logger.info("im in employeeonboarding post adddepbef " + i);
            panel = new CreateDependentsPanel(this, i);
            createDependentsPanel.add(panel);
            entityFieldsPanel.add(panel);
            logger.info("im in employeeonboarding post adddep " + i);
        } else if (event.getSource().equals(addEmerContact)) {
            CreateEmergencyContactWidget panel = null;
            int x = createEmergencyContactPanel.size();
            logger.info("im in employeeonboarding post addEmerContactbef " + x);
            panel = new CreateEmergencyContactWidget(CreateComposite.CreateCompositeType.ADD, this, x);
            createEmergencyContactPanel.add(panel);
            entityFieldsPanel.add(panel);
            logger.info("im in employeeonboarding post addEmerContact " + x);
        }
        super.onClick(event);
    }

    public void removePanel(int i) {
        logger.info("im in employeeonboarding post removePanel " + i);
        if (createDependentsPanel.size() > 0) {
            createDependentsPanel.get(i).removeFromParent();
            createDependentsPanel.remove(i);
        }
    }

    public void removeEmergencyContactPanel(int x) {
        logger.info("im in employeeonboarding post removeEmergencyContactPanel " + x);
        if (createEmergencyContactPanel.size() > 0) {
            createEmergencyContactPanel.get(x).removeFromParent();
            createEmergencyContactPanel.remove(x);
        }
    }

}

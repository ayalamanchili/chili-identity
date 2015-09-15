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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
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
    protected List<CreateDependentsPanel> createDependentsPanel = new ArrayList<>();
    HTML emptyLine = new HTML("<br/>");

    EnumField statesF;
    EnumField countriesF;
    protected String invitationCode;

    public EmployeeOnboardingPanel(String inviteCode) {
        this.invitationCode = inviteCode;
        initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
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
        // Additional Information
        assignEntityValueFromField("referredBy", employeeAdditionalDetails);
        assignEntityValueFromField("maritalStatus", employeeAdditionalDetails);
        assignEntityValueFromField("ethnicity", employeeAdditionalDetails);
        employeeAdditionalDetails.put("targetEntityName", new JSONString("targetEntityName"));
        employeeAdditionalDetails.put("targetEntityId", new JSONString("0"));
        employee.put("employeeAdditionalDetails", employeeAdditionalDetails);
        // 
        employee.put("inviteCode", new JSONString(invitationCode));
        logger.info("employee" + employee.toString());
        return employee;
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
        countriesF.listBox.addChangeHandler(this);
        addDependentsL.addClickHandler(this);
    }

    @Override
    protected void configure() {
        addDependentsL.setAutoHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
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
        entityFieldsPanel.add(getLineSeperatorTag("Bank Account Information"));
        addField("accountFirstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("accountLastName", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankRoutingNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAccountNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("bankAddress2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("accountType", false, true, AccountType.names(), Alignment.HORIZONTAL);
        addField("achBlocked", false, true, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Additional Information"));
        addField("referredBy", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("maritalStatus", false, true, MaritalStatus.names(), Alignment.HORIZONTAL);
        addEnumField("ethnicity", false, true, Ethnicity.names(), Alignment.HORIZONTAL);
        entityFieldsPanel.add(getLineSeperatorTag("Dependent's Information"));
        entityFieldsPanel.add(addDependentsL);
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
                        postUpdateSuccess(arg0);
                    }
                });
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
        return OfficeWelcome.constants.root_url() + "admin/on-board-employee";
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {

    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addDependentsL)) {
            CreateDependentsPanel panel = null;
            panel = new CreateDependentsPanel();
            createDependentsPanel.add(panel);
            entityFieldsPanel.add(panel);
        }
        super.onClick(event);
    }
}

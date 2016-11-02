/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.UpdateComposite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.fields.FileuploadField;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;
import info.yalamanchili.office.client.profile.contact.Branch;
import info.yalamanchili.office.client.profile.contact.Sex;
import info.yalamanchili.office.client.profile.contact.WorkStatus;
import java.util.logging.Logger;

public class UpdateEmployeePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmployeePanel.class.getName());
    protected SelectEmployeeTypeWidget employeeSelectWidget = new SelectEmployeeTypeWidget(false, false);
    protected SelectCompanyWidget selectCompnayWidget = new SelectCompanyWidget(false, true, Alignment.HORIZONTAL);
    FileuploadField empImageUploadPanel = new FileuploadField(OfficeWelcome.constants, "Employee", "imageUrl", "Employee/imageURL", false) {
        @Override
        public void onUploadComplete(String res) {
            postUpdateSuccess(null);
        }
    };
    JSONObject employee = new JSONObject();
    protected Anchor internalTransfer = new Anchor("Do Internal Company Transfer?");
    protected Anchor departmentTransfer = new Anchor(" Department Transfer");
    protected static HTML generalInfo = new HTML("\n"
            + "<p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\">Image should not exceed more than 2mb </strong></p>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

    public UpdateEmployeePanel(JSONObject entity) {
        this.employee = entity;
        initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("sex", entity);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CONSULTANT_TIME_ADMIN) && Auth.isConsultantEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.isSubContractor(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.is1099(entity))) {
            assignEntityValueFromField("startDate", entity);
        }
        assignEntityValueFromField("jobTitle", entity);
        assignEntityValueFromField("branch", entity);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_HR, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignEntityValueFromField("workStatus", entity);
        }
        if (fields.containsKey("hoursPerWeek") && Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            assignEntityValueFromField("hoursPerWeek", entity);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            assignEntityValueFromField("ssn", entity);
        }
        if (!empImageUploadPanel.isEmpty()) {
            entity.put("imageURL", empImageUploadPanel.getFileName());
        }
        //hack to swap employeetype value attribute with name attribute
        if (fields.containsKey("employeeType")) {
            JSONObject employeeType = employeeSelectWidget.getSelectedObject();
            employeeType.put("name", employeeType.get("value"));
            entity.put("employeeType", employeeType);
        }
        if (fields.containsKey("company") && selectCompnayWidget.getSelectedObject() != null) {
            JSONObject company = selectCompnayWidget.getSelectedObject();
            company.put("name", company.get("value"));
            entity.put("company", company);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN)) {
            assignEntityValueFromField("status", entity);
        }
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
                        uploadImage(JSONUtils.toString(entity, "id"));
                    }
                });

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

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.Employee"));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CONSULTANT_TIME_ADMIN) && Auth.isConsultantEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.isSubContractor(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.is1099(entity))) {
            assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        }
        if (fields.containsKey("employeeType")) {
            assignFieldValueFromEntity("employeeType", entity, null);
        }
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("branch", entity, DataType.ENUM_FIELD);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_HR)) {
            assignFieldValueFromEntity("workStatus", entity, DataType.ENUM_FIELD);
        }
        if (fields.containsKey("hoursPerWeek") && Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignFieldValueFromEntity("hoursPerWeek", entity, DataType.INTEGER_FIELD);
        }
        if (fields.containsKey("company")) {
            assignFieldValueFromEntity("company", entity, null);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            assignFieldValueFromEntity("ssn", entity, DataType.STRING_FIELD);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN) && TabPanel.instance().myOfficePanel.isVisible()) {
            assignFieldValueFromEntity("status", entity, DataType.BOOLEAN_FIELD);
        }
        //TODO add image panel for employee image
        populateComments();
    }

    @Override
    protected void addListeners() {
        internalTransfer.addClickHandler(this);
        departmentTransfer.addClickHandler(this);
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        departmentTransfer.addStyleName("horizontalAlignment");
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        // same here update them
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR_ADMINSTRATION)) {
            addDropDown("employeeType", employeeSelectWidget);
        }
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, true, Sex.names(), Alignment.HORIZONTAL);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_CONSULTANT_TIME_ADMIN) && Auth.isConsultantEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.isSubContractor(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN) && Auth.is1099(entity))) {
            addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", false, true, Branch.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_HR)) {
            addEnumField("workStatus", false, true, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addField("hoursPerWeek", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION, Auth.ROLE.ROLE_ON_BOARDING_MGR)) {
            addDropDown("company", selectCompnayWidget);
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR)) {
                selectCompnayWidget.setReadOnly(true);
            }
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addField("ssn", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            entityFieldsPanel.add(internalTransfer);
            entityFieldsPanel.add(departmentTransfer);
        }
        entityFieldsPanel.add(generalInfo);
        entityFieldsPanel.add(empImageUploadPanel);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN)) {
            addField("status", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        }
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/save";
    }

    protected void uploadImage(String entityId) {
        empImageUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
        TabPanel.instance().myOfficePanel.sidePanelTop.clear();
        TabPanel.instance().myOfficePanel.sidePanelTop.add(new TreeEmployeePanel(entity));
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(internalTransfer)) {
            new GenericPopup(new InternalTransferPopUpPanel(CreateCompositeType.CREATE, entity.get("id").isString().stringValue())).show();
        }
        if (event.getSource().equals(departmentTransfer)) {
            new GenericPopup(new DepartmentTransferPopUpPanel(CreateCompositeType.CREATE, entity.get("id").isString().stringValue())).show();
        }
        super.onClick(event);
    }
}

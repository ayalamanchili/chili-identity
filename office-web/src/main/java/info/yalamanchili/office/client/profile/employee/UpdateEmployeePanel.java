/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.UpdateComposite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.fields.FileuploadField;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.company.SelectCompanyWidget;
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

    public static Object instance() {
        return null;
    }

    public UpdateEmployeePanel(JSONObject entity) {
        initUpdateComposite(entity, "Employee", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("dateOfBirth", entity);
        assignEntityValueFromField("sex", entity);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP) && Auth.isConsultantEmployee(entity))) {
            assignEntityValueFromField("startDate", entity);
        }
        assignEntityValueFromField("jobTitle", entity);
        assignEntityValueFromField("branch", entity);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_HR,Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignEntityValueFromField("workStatus", entity);
        }
        if (fields.containsKey("hoursPerWeek") && Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            assignEntityValueFromField("hoursPerWeek", entity);
        }
        if (Auth.isAdmin()) {
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
        logger.info("aaaaaaaaaa" + entity.toString());
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP) && Auth.isConsultantEmployee(entity))) {
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
        if (fields.containsKey("hoursPerWeek") && Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION,Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            assignFieldValueFromEntity("hoursPerWeek", entity, DataType.INTEGER_FIELD);
        }
        if (fields.containsKey("company")) {
            assignFieldValueFromEntity("company", entity, null);
        }
        if (Auth.isAdmin()) {
            assignFieldValueFromEntity("ssn", entity, DataType.STRING_FIELD);
        }
        //TODO add image panel for employee image
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        // same here update them
        addDropDown("employeeType", employeeSelectWidget);
        addField("firstName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("middleInitial", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("lastName", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("sex", false, true, Sex.names(), Alignment.HORIZONTAL);
        if ((Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION) && Auth.isCorporateEmployee(entity)) || (Auth.hasAnyOfRoles(ROLE.ROLE_RELATIONSHIP) && Auth.isConsultantEmployee(entity))) {
            addField("startDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        }
        addField("jobTitle", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("branch", false, true, Branch.names(), Alignment.HORIZONTAL);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_H1B_IMMIGRATION, ROLE.ROLE_HR)) {
            addEnumField("workStatus", false, true, WorkStatus.names(), Alignment.HORIZONTAL);
        }
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR_ADMINSTRATION)) {
            addField("hoursPerWeek", false, true, DataType.INTEGER_FIELD, Alignment.HORIZONTAL);
            addDropDown("company", selectCompnayWidget);
        }
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        }
        entityFieldsPanel.add(empImageUploadPanel);
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
}

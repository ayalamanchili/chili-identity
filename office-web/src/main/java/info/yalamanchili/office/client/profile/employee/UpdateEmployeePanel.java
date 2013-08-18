/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.chili.gwt.crud.UpdateComposite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.fields.FileuploadField;
import info.yalamanchili.office.client.profile.employeetype.SelectEmployeeTypeWidget;
import info.chili.gwt.rpc.HttpService;

public class UpdateEmployeePanel extends UpdateComposite {

    protected SelectEmployeeTypeWidget employeeSelectWidget = new SelectEmployeeTypeWidget(false, false);
    FileuploadField empImageUploadPanel = new FileuploadField(OfficeWelcome.constants, "Employee", "imageUrl", "Employee/imageURL", false) {
        @Override
        public void onUploadComplete() {
            postUpdateSuccess(null);
        }

        @Override
        public void onFileUploadError() {
            Window.alert("Image Size exceeded please upload a smaler Image Limit:2MB");
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
        assignEntityValueFromField("startDate", entity);
        assignEntityValueFromField("jobTitle", entity);
        if (Auth.isAdmin()) {
            assignEntityValueFromField("ssn", entity);
        }
        if (!empImageUploadPanel.isEmpty()) {
            entity.put("imageURL", empImageUploadPanel.getFileName());
        }
        //hack to swap employeetype value attribute with name attribute
        JSONObject employeeType = employeeSelectWidget.getSelectedObject();
        employeeType.put("name", employeeType.get("value"));
        entity.put("employeeType", employeeType);
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
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("employeeType", entity, null);
        assignFieldValueFromEntity("jobTitle", entity, DataType.STRING_FIELD);
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
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("startDate", false, false, DataType.DATE_FIELD);
        addField("jobTitle", false, true, DataType.STRING_FIELD);
        if (Auth.isAdmin()) {
            addField("ssn", false, false, DataType.STRING_FIELD);
        }
        entityFieldsPanel.add(empImageUploadPanel);

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

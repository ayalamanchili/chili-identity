package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.UpdateComposite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.FileuploadField;
import info.yalamanchili.office.client.rpc.HttpService;

public class UpdateEmployeePanel extends UpdateComposite {

    FileuploadField empImageUploadPanel = new FileuploadField(OfficeWelcome.constants, "Employee", "imageUrl", "Employee/imageURL", false) {
        @Override
        public void onUploadComplete() {
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
        assignEntityValueFromField("startDate", entity);
        if (!empImageUploadPanel.isEmpty()) {
            entity.put("imageURL", empImageUploadPanel.getFileName());
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("dateOfBirth", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("startDate", entity, DataType.DATE_FIELD);
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
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        addField("dateOfBirth", false, true, DataType.DATE_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("startDate", false, false, DataType.DATE_FIELD);
        entityDisplayWidget.add(empImageUploadPanel);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee";
    }

    protected void uploadImage(String entityId) {
        empImageUploadPanel.upload(entityId.trim());
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated Employee information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmployeesPanel());
    }
}

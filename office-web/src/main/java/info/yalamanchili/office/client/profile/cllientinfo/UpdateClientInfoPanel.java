package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class UpdateClientInfoPanel extends UpdateComposite {

    public UpdateClientInfoPanel(JSONObject entity) {
        initUpdateComposite(entity, "ClientInfo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("firstName", entity);
        assignEntityValueFromField("middleInitial", entity);
        assignEntityValueFromField("lastName", entity);
        assignEntityValueFromField("sex", entity);
        assignEntityValueFromField("reportsToRole", entity);
        assignEntityValueFromField("rtPrimary", entity);
        assignEntityValueFromField("consultantJobTitle", entity);
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        assignEntityValueFromField("countryCode", entity);
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
                postUpdateSuccess(arg0);
            }
        });

    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated Reports To information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("consultantJobTitle", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("reportsToRole", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("rtPrimary", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("firstName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("sex", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);

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
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        addField("firstName", false, true, DataType.STRING_FIELD);
        addField("middleInitial", false, false, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("reportsToRole", false, true, DataType.STRING_FIELD);
        addField("rtPrimary", false, false, DataType.BOOLEAN_FIELD);
        addField("consultantJobTitle", false, true, DataType.STRING_FIELD);
        addField("phoneNumber", false, true, DataType.LONG_FIELD);
        addField("email", false, true, DataType.STRING_FIELD);
        addField("extension", false, true, DataType.LONG_FIELD);
        addField("countryCode", false, true, DataType.LONG_FIELD);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "clientinformation";
    }
}
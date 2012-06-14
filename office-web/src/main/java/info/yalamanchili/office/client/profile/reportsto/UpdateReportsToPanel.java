package info.yalamanchili.office.client.profile.reportsto;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.office.client.profile.emergencycnt.EmergencyContactOptionsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPanel;

public class UpdateReportsToPanel extends UpdateComposite {

    public UpdateReportsToPanel(JSONObject entity) {
        initUpdateComposite(entity, "ReportsTo", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject contact = entity.get("contact").isObject();
        assignEntityValueFromField("firstName", contact);
        assignEntityValueFromField("middleInitial", contact);
        assignEntityValueFromField("lastName", contact);
        assignEntityValueFromField("sex", contact);

        assignEntityValueFromField("reportsToRole", entity);
        assignEntityValueFromField("rtPrimary", entity);
        entity.put("contact", contact);
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
                postSuccess(arg0);
            }
        });

    }

    @Override
    protected void postSuccess(String result) {
        new ResponseStatusWidget().show("successfully updated Reports To information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllReportsToPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReportsToOptionsPanel());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("reportsToRole", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("rtPrimary", entity, DataType.BOOLEAN_FIELD);
        // Contact
        JSONObject contact = entity.get("contact").isObject();
        assignFieldValueFromEntity("firstName", contact, DataType.STRING_FIELD);
        assignFieldValueFromEntity("middleInitial", contact, DataType.STRING_FIELD);
        assignFieldValueFromEntity("lastName", contact, DataType.STRING_FIELD);
        assignFieldValueFromEntity("sex", contact, DataType.ENUM_FIELD);

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
        addField("middleInitial", false, true, DataType.STRING_FIELD);
        addField("lastName", false, true, DataType.STRING_FIELD);
        String[] strs = {"MALE", "FEMALE"};
        addEnumField("sex", false, true, strs);
        addField("reportsToRole", false, true, DataType.STRING_FIELD);
        addField("rtPrimary", false, true, DataType.BOOLEAN_FIELD);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "reportsto";
    }
}
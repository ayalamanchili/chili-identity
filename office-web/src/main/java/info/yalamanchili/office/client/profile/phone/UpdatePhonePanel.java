package info.yalamanchili.office.client.profile.phone;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phonetype.SelectPhoneTypeWidget;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.PopupPanel;

public class UpdatePhonePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePhonePanel.class.getName());
    SelectPhoneTypeWidget phoneTypeF = new SelectPhoneTypeWidget();

    public UpdatePhonePanel(JSONObject entity) {
        initUpdateComposite(entity, "Phone", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        assignEntityValueFromField("countryCode", entity);
        entity.put("phoneType", phoneTypeF.getSelectedObject());
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
        new ResponseStatusWidget().show("successfully updated Phone information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        // TODO set phone type
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
        addField("phoneNumber", false, true, DataType.LONG_FIELD);
        addField("extension", false, true, DataType.LONG_FIELD);
        addField("countryCode", false, true, DataType.LONG_FIELD);
        entityDisplayWidget.add(phoneTypeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "phone";
    }
}

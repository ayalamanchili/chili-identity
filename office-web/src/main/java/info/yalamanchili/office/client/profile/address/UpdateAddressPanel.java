package info.yalamanchili.office.client.profile.address;

import info.yalamanchili.gwt.fields.DataType;
import info.yalamanchili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.yalamanchili.office.client.profile.email.EmailOptionsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;

public class UpdateAddressPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateAddressPanel.class.getName());
    SelectAddressTypeWidget AddressTypeF = new SelectAddressTypeWidget();

    public UpdateAddressPanel(JSONObject entity) {
        initUpdateComposite(entity, "Address", OfficeWelcome.constants);

    }

    @Override
    protected JSONObject populateEntityFromFields() {
        // TODO Auto-generated method stub
        assignEntityValueFromField("street1", entity);
        assignEntityValueFromField("street2", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("country", entity);
        assignEntityValueFromField("zip", entity);
        entity.put("AddressType", AddressTypeF.getSelectedObject());
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        // TODO Auto-generated method stub
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
        new ResponseStatusWidget().show("successfully updated employee Address");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        // TODO Auto-generated method stub
        assignFieldValueFromEntity("street1", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("street2", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("city", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("state", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("country", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("zip", entity, DataType.STRING_FIELD);
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
        addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, true, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.STRING_FIELD);
        addField("country", false, true, DataType.STRING_FIELD);
        addField("zip", false, true, DataType.STRING_FIELD);
        entityDisplayWidget.add(AddressTypeF);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        // TODO Auto-generated method stub
        return OfficeWelcome.constants.root_url() + "address";
    }
}

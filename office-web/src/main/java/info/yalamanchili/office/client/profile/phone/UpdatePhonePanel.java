/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.phone;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phonetype.SelectPhoneTypeWidget;
import info.chili.gwt.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.utils.Alignment;

public class UpdatePhonePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePhonePanel.class.getName());
    public SelectPhoneTypeWidget phoneTypeW = new SelectPhoneTypeWidget(false, false, Alignment.HORIZONTAL);


    public UpdatePhonePanel(JSONObject entity) {
        initUpdateComposite(entity, "Phone", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneType", entity);
        logger.info(entity.toString());
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
        new ResponseStatusWidget().show("Successfully Updated Phone Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("phoneNumber", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("extension", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("countryCode", entity, DataType.LONG_FIELD);
        assignFieldValueFromEntity("phoneType", entity, null);
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
        addDropDown("phoneType", phoneTypeW);
        addField("countryCode", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("extension", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        
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

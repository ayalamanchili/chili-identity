/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.phone;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phonetype.SelectPhoneTypeWidget;
import info.chili.gwt.rpc.HttpService.HttpServiceAsync;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.utils.Alignment;

public class CreatePhonePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePhonePanel.class.getName());
    public SelectPhoneTypeWidget phoneTypeF = new SelectPhoneTypeWidget(false, false, Alignment.HORIZONTAL);

    public CreatePhonePanel(CreateCompositeType type) {
        super(type);
        initCreateComposite("Phone", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("countryCode", entity);
        assignEntityValueFromField("phoneNumber", entity);
        assignEntityValueFromField("extension", entity);
        entity.put("phoneType", phoneTypeF.getSelectedObject());
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addButtonClicked() {
        HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);

            }

            @Override
            public void onSuccess(String arg0) {
                postCreateSuccess(arg0);
            }
        });
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Employee Phone");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // StringField countryCodeF = (StringField) fields.get("countryCode");
        // countryCodeF.setText("001");
    }

    @Override
    protected void addWidgets() {
        entityFieldsPanel.add(phoneTypeF);
        addField("countryCode", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("phoneNumber", false, true, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        addField("extension", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "employee/phone/" + TreeEmployeePanel.instance().getEntityId();
    }
}

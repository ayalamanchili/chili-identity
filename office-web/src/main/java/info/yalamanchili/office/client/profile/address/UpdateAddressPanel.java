/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.addresstype.SelectAddressTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.utils.Alignment;
import info.yalamanchili.office.client.ext.comment.ReadAllCommentsPanel;

public class UpdateAddressPanel extends UpdateComposite implements ChangeHandler{

    private static Logger logger = Logger.getLogger(UpdateAddressPanel.class.getName());

    public enum UpdateAddressPanelType {

        ALL, MIN, CHANGE_WITH_TYPE_NOTIFY
    }
    UpdateAddressPanelType type;

    public UpdateAddressPanel(JSONObject entity, UpdateAddressPanelType type) {
        this.type = type;
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
        if (UpdateAddressPanelType.ALL.equals(type)) {
            assignEntityValueFromField("addressType", entity);
        }
        if (UpdateAddressPanel.UpdateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY.equals(type)) {
            assignEntityValueFromField("addressType", entity);
            assignEntityValueFromField("notifyChange", entity);
            assignEntityValueFromField("changeNotes", entity);
        }
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        logger.info(entity.toString());
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

    protected void populateComments() {
        entityFieldsPanel.add(new ReadAllCommentsPanel(getEntityId(), "info.yalamanchili.office.entity.profile.Address"));
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Address");
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
        assignFieldValueFromEntity("state", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("country", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("zip", entity, DataType.LONG_FIELD);
        if (UpdateAddressPanelType.ALL.equals(type)) {
            assignFieldValueFromEntity("addressType", entity, null);
        }
        populateComments();
    }
    EnumField statesF;
    EnumField countriesF;

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        countriesF.listBox.addChangeHandler(this);    }

    @Override
    protected void addWidgets() {
        // TODO Auto-generated method stub
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("zip", false, false, DataType.LONG_FIELD, Alignment.HORIZONTAL);
        if (UpdateAddressPanelType.ALL.equals(type)) {
            addDropDown("addressType", new SelectAddressTypeWidget(false, false));
        }
        if (UpdateAddressPanel.UpdateAddressPanelType.CHANGE_WITH_TYPE_NOTIFY.equals(type)) {
            addDropDown("addressType", new SelectAddressTypeWidget(false, false));
            addField("notifyChange", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
            addField("changeNotes", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        }
        statesF = (EnumField) fields.get("state");
        countriesF = (EnumField) fields.get("country");
        alignFields();
    }

    @Override
    public void onChange(ChangeEvent event) {
        switch (countriesF.getValue()) {
            case "USA":
                statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                break;
            case "INDIA":
                statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "address/employee";
    }
}

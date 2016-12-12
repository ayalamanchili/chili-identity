/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorlocation;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorLocationsPanel extends CreateAddressPanel implements ChangeHandler {

    public CreateVendorLocationsPanel(CreateComposite.CreateCompositeType type) {
        super(CreateAddressPanelType.ALL);
    }

    String vendorId;

    public CreateVendorLocationsPanel(String vendorId, CreateComposite.CreateCompositeType type) {
        super(CreateAddressPanelType.ALL);
        this.vendorId = vendorId;
    }
    
    @Override
    protected JSONObject populateEntityFromFields() {
        //TODO is thid needed
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("street1", entity);
        assignEntityValueFromField("street2", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("country", entity);
        assignEntityValueFromField("zip", entity);
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        if (SelectVendorLocationsWidget.instance() != null) {
            SelectVendorLocationsWidget.instance().fireEvent();
        }
        GenericPopup.hideIfOpen();
        new ResponseStatusWidget().show("Successfully Added Vendor Location");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorLocationPanel(TreeVendorsPanel.instance().getEntityId()));
    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("street2", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("zip", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("city", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("state", false, true, DataType.ENUM_FIELD, Alignment.HORIZONTAL);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        super.countriesF = (EnumField) fields.get("country");
        super.statesF = (EnumField) fields.get("state");
        super.zipField = (StringField) fields.get("zip");
        super.cityField = (StringField) fields.get("city");
    }

    @Override
    protected String getURI() {
        if (vendorId != null) {
            return OfficeWelcome.constants.root_url() + "vendor/vendorlocation/" + vendorId;
        } else {
        return OfficeWelcome.constants.root_url() + "vendor/vendorlocation/" + TreeVendorsPanel.instance().getEntityId();
    
        }
    }    

    @Override
    protected void addListeners() {
        super.addListeners();
    }

    @Override
    public void onChange(ChangeEvent event) {

        super.onChange(event);
    }
    
    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        boolean valid = true;
        StringField street1F = (StringField) fields.get("street1");
        if (street1F.getValue() == null || "".equals(street1F.getValue())) {
            street1F.setMessage("Please enter the street");
            valid = false;
        }
        StringField cityF = (StringField) fields.get("city");
        if (cityF.getValue() == null || "".equals(cityF.getValue())) {
            cityF.setMessage("Please enter the city");
            valid = false;
        }
        StringField zipF = (StringField) fields.get("zip");
        if (zipF.getValue() == null || "".equals(zipF.getValue())) {
            zipF.setMessage("Please enter the zip code");
            valid = false;
        }
        EnumField stateF = (EnumField) fields.get("state");
        if (stateF.getValue() == null || "".equals(stateF.getValue())) {
            stateF.setMessage("Please select the state");
            valid = false;
        }
        EnumField countryF = (EnumField) fields.get("country");
        if (countryF.getValue() == null || "".equals(countryF.getValue())) {
            countryF.setMessage("Please select the country");
            valid = false;
        }
        return valid;
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcntrlocation;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.subcontractor.TreeSubcontractorPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;

/**
 *
 * @author anuyalamanchili
 */
public class CreateSubcontractorLocationPanel extends CreateAddressPanel implements ChangeHandler {

    public CreateSubcontractorLocationPanel(CreateComposite.CreateCompositeType type) {
        super(CreateAddressPanelType.ALL);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("street1", entity);
        assignEntityValueFromField("street2", entity);
        assignEntityValueFromField("zip", entity);
        assignEntityValueFromField("city", entity);
        assignEntityValueFromField("state", entity);
        assignEntityValueFromField("country", entity);
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Subcontractor Location");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorLocationsPanel(TreeSubcontractorPanel.instance().getEntityId()));
    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, false, DataType.STRING_FIELD);
        addField("zip", false, false, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.ENUM_FIELD);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]));
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]));
        super.countriesF = (EnumField) fields.get("country");
        super.statesF = (EnumField) fields.get("state");
        super.zipField = (StringField) fields.get("zip");
        super.cityField = (StringField) fields.get("city");
    }

    @Override
    protected void addListeners() {
        super.addListeners();
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor/location/add/" + TreeSubcontractorPanel.instance().getEntityId();
    }

    @Override
    public void onChange(ChangeEvent event) {
        super.onChange(event);
    }
}

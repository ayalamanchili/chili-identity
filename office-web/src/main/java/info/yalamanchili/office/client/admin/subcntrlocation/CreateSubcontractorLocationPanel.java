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
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.subcontractor.TreeSubcontractorPanel;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class CreateSubcontractorLocationPanel extends CreateAddressPanel implements ChangeHandler {

    private static Logger logger = Logger.getLogger(CreateSubcontractorLocationPanel.class.getName());

    public CreateSubcontractorLocationPanel(CreateComposite.CreateCompositeType type) {
        super(CreateAddressPanelType.ALL);
    }
    EnumField statesF;
    EnumField countriesF;

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
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Subcontractor Locatrion");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorLocationsPanel(TreeSubcontractorPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new SubcontractorLocationOptionsPanel());

    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, false, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.ENUM_FIELD);
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]));
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]));
        addField("zip", false, false, DataType.STRING_FIELD);
        countriesF = (EnumField) fields.get("country");
        statesF = (EnumField) fields.get("state");
    }
    
    @Override
    protected void addListeners() {
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
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
            case "CANADA":
                statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                break;
        }
    }    

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "subcontractor/location/add/" + TreeSubcontractorPanel.instance().getEntityId();
    }
}

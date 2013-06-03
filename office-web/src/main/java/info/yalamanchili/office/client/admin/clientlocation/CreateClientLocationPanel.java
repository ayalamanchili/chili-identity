/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.clientlocation;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.admin.client.TreeClientPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class CreateClientLocationPanel extends CreateAddressPanel {

    private static Logger logger = Logger.getLogger(CreateClientLocationPanel.class.getName());

    public CreateClientLocationPanel(CreateComposite.CreateCompositeType type) {
        super(type);
//         initCreateComposite("ClientLocation", OfficeWelcome.constants);
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
//        assignEntityValueFromField("addressType", entity);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Client Locatrion");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientLocationsPanel(TreeClientPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new ClientLocationOptionsPanel());

    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, false, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.ENUM_FIELD);
        addEnumField("state", false, true, USAStatesFactory.getStates().toArray(new String[0]));
        addEnumField("country", false, true, CountryFactory.getCountries().toArray(new String[0]));
        addField("zip", false, false, DataType.LONG_FIELD);
//        addDropDown("addressType", new SelectAddressTypeWidget(false, false));
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientlocation/" + TreeClientPanel.instance().getEntityId();
    }
}

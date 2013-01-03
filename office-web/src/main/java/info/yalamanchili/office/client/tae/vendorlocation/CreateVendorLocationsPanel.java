/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.vendorlocation;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.tae.vendor.TreeVendorsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorLocationsPanel extends CreateAddressPanel {

    private static Logger logger = Logger.getLogger(CreateVendorLocationsPanel.class.getName());

    public CreateVendorLocationsPanel(CreateComposite.CreateCompositeType type) {
        super(type);
//         initCreateComposite("VendorLocation", OfficeWelcome.constants);
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
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("successfully added Client Locatrion");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllVendorLocationPanel(TreeVendorsPanel.instance().getEntityId()));
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new VendorLocationOptionsPanel());

    }

    @Override
    protected void addWidgets() {
        addField("street1", false, true, DataType.STRING_FIELD);
        addField("street2", false, false, DataType.STRING_FIELD);
        addField("city", false, true, DataType.STRING_FIELD);
        addField("state", false, true, DataType.ENUM_FIELD);
        addEnumField("state", false, true, getStates().toArray(new String[0]));
        addEnumField("country", false, true, getCountries().toArray(new String[0]));
        addField("zip", false, false, DataType.LONG_FIELD);
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "client/clientlocation/" + TreeVendorsPanel.instance().getEntityId();
    }
}

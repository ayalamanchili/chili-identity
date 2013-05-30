/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;
import info.yalamanchili.office.client.profile.contact.UpdateContactPanel;

/**
 *
 * @author Prashanthi
 */
public class UpdateVendorContactPanel extends UpdateContactPanel {

    public UpdateVendorContactPanel(JSONObject entity) {
        super(entity);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Vendor contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorContactPanel(TreeVendorsPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new VendorContactOptionsPanel());
    }
}

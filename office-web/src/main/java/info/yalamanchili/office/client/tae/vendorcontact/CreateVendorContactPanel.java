/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.vendorcontact;

import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;
import info.yalamanchili.office.client.tae.vendor.TreeVendorsPanel;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorContactPanel extends CreateContactPanel {

    public CreateVendorContactPanel(CreateCompositeType type) {
        super(type);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Vendor Contact");
        TabPanel.instance().timeandExpensePanel.entityPanel.clear();
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new ReadAllVendorContactPanel(TreeVendorsPanel.instance().getEntityId()));
        TabPanel.instance().timeandExpensePanel.entityPanel.add(new VendorContactOptionsPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/vendorcontact/" + TreeVendorsPanel.instance().getEntityId();
    }
}

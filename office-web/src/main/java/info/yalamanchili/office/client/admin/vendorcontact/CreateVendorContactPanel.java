/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;

/**
 *
 * @author Prashanthi
 */
public class CreateVendorContactPanel extends CreateContactPanel {

    public CreateVendorContactPanel(CreateCompositeType type) {
        super(type);
    }

    String vendorId;

    public CreateVendorContactPanel(String vendorId, CreateCompositeType type) {
        super(type);
        this.vendorId = vendorId;
    }
    
    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Vendor Contact");
        GenericPopup.hideIfOpen();
        if (SelectVendorRecruiterContactWidget.instance() != null) {
            SelectVendorRecruiterContactWidget.instance().fireEvent();
        } else {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorContactPanel(TreeVendorsPanel.instance().getEntityId()));
        }
    }    

    @Override
    protected String getURI() {
        if (vendorId != null) {
            return OfficeWelcome.constants.root_url() + "vendor/vendorcontact/" + vendorId;
        } else {
        return OfficeWelcome.constants.root_url() + "vendor/vendorcontact/" + TreeVendorsPanel.instance().getEntityId();
        }
    }
}

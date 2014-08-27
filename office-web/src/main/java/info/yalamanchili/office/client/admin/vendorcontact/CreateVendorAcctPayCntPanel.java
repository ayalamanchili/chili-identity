/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendor.TreeVendorsPanel;
import info.yalamanchili.office.client.profile.contact.CreateContactPanel;

/**
 *
 * @author anuyalamanchili
 */
public class CreateVendorAcctPayCntPanel extends CreateContactPanel {

    public CreateVendorAcctPayCntPanel(CreateComposite.CreateCompositeType type) {
        super(type);
    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Added Vendor Account Payable Contact");
        TabPanel.instance().adminPanel.entityPanel.clear();
        TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorAcctPayContacts(TreeVendorsPanel.instance().getEntityId()));
        TabPanel.instance().adminPanel.entityPanel.add(new VendorAcctPayCntOptionsPanel());
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "vendor/acct-pay-contact/" + TreeVendorsPanel.instance().getEntityId();
    }
}

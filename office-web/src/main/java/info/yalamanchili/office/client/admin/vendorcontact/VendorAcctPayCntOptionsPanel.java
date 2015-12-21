/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendorcontact;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author anuyalamanchili
 */
public class VendorAcctPayCntOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addVendorAcctPayContactLink = new ClickableLink("Add Vendor Accounts Payable Contact");

    public VendorAcctPayCntOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addVendorAcctPayContactLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            panel.add(addVendorAcctPayContactLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(addVendorAcctPayContactLink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateVendorAcctPayCntPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class VendorsSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(VendorsSidePanel.class.getName());
    public FlowPanel vendorsidepanel = new FlowPanel();
    ClickableLink createvendorslink = new ClickableLink("Create Vendor");

    public VendorsSidePanel() {
        init(vendorsidepanel);
    }

    @Override
    protected void addListeners() {
        createvendorslink.addClickHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CONTRACTS_ADMIN, Auth.ROLE.ROLE_BILLING_AND_INVOICING, Auth.ROLE.ROLE_CONTRACTS)) {
            vendorsidepanel.add(createvendorslink);
        }
        vendorsidepanel.add(new SearchVendorPanel());
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createvendorslink)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new CreateVendorPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}

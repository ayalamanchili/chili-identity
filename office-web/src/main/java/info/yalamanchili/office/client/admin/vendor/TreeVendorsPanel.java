/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.vendor;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorAcctPayContacts;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorContactPanel;
import info.yalamanchili.office.client.admin.vendorcontact.VendorAcctPayCntOptionsPanel;
import info.yalamanchili.office.client.admin.vendorcontact.VendorContactOptionsPanel;
import info.yalamanchili.office.client.admin.vendorlocation.ReadAllVendorLocationPanel;
import info.yalamanchili.office.client.admin.vendorlocation.VendorLocationOptionsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class TreeVendorsPanel extends TreePanelComposite {

    private static TreeVendorsPanel instance;

    public static TreeVendorsPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeVendorsPanel.class.getName());
    protected static final String VENDOR_LOCATION_NODE = "vendorlocation";
    protected static final String VENDOR_CONTACTS_NODE = "vendorcontacts";
    protected static final String VENDOR_ACCT_PAY_CONTACTS_NODE = "vendoracctpaycontacts";

    public TreeVendorsPanel(String entityId) {
        super(entityId);
        instance = this;
        init("Vendors", OfficeWelcome.constants);
    }

    public TreeVendorsPanel(JSONObject vendor) {
        super(vendor);
        instance = this;
        String name = JSONUtils.toString(vendor, "name");
        init(name, OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    public boolean expandTree() {
        return true;
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Locations", VENDOR_LOCATION_NODE);
        addFirstChildLink("Recruiter Contacts", VENDOR_CONTACTS_NODE);
        addFirstChildLink("Acct Pay Contacts", VENDOR_ACCT_PAY_CONTACTS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (VENDOR_LOCATION_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorLocationPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorLocationOptionsPanel());
        }
        if (VENDOR_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorContactPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorContactOptionsPanel());
        }
        if (VENDOR_ACCT_PAY_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorAcctPayContacts(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorAcctPayCntOptionsPanel());
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

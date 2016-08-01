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
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorInvoiceSchedulePanel;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorAcctPayContacts;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorContactPanel;
import info.yalamanchili.office.client.admin.vendorlocation.ReadAllVendorLocationPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class TreeVendorsPanel extends TreePanelComposite {

    private static TreeVendorsPanel instance;
    protected String vendorId;
    protected JSONObject vendor;

    public static TreeVendorsPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeVendorsPanel.class.getName());
    protected static final String VENDOR_LOCATION_NODE = "vendorlocation";
    protected static final String VENDOR_CONTACTS_NODE = "vendorcontacts";
    protected static final String VENDOR_ACCT_PAY_CONTACTS_NODE = "vendoracctpaycontacts";
    protected static final String VENDOR_INVOICE_SCHEDULE_NODE = "invoiceSchedules";

    public TreeVendorsPanel(String entityId) {
        super(entityId);
        this.vendorId = entityId;
        instance = this;
        init("Vendors", OfficeWelcome.constants);
    }

    public TreeVendorsPanel(JSONObject vendor) {
        super(vendor);
        this.vendorId = JSONUtils.toString(vendor, "id");
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
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_BILLING_AND_INVOICING)) {
            addFirstChildLink("Invoice Schedules", VENDOR_INVOICE_SCHEDULE_NODE);
        }
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (VENDOR_LOCATION_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorLocationPanel(entityId));
        }
        if (VENDOR_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorContactPanel(entityId));
        }
        if (VENDOR_ACCT_PAY_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorAcctPayContacts(entityId));
        }
        if (VENDOR_INVOICE_SCHEDULE_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorInvoiceSchedulePanel(vendorId, "info.yalamanchili.office.entity.client.Vendor"));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

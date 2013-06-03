/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.admin.vendorcontact.ReadAllVendorContactPanel;
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
    protected static final String VENDORLOCATION_NODE = "vendorlocation";
    protected static final String VENDORCONTACTS_NODE = "vendorcontacts";

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
        addFirstChildLink("Locations", VENDORLOCATION_NODE);
        addFirstChildLink("Contacts", VENDORCONTACTS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (VENDORLOCATION_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorLocationPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorLocationOptionsPanel());
        }
        if (VENDORCONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorContactPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorContactOptionsPanel());
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

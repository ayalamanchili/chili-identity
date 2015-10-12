/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.project;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.clientlocation.ClientLocationOptionsPanel;
import info.yalamanchili.office.client.admin.clientlocation.ReadAllClientLocationsPanel;
import info.yalamanchili.office.client.admin.vendor.ReadAllVendorsPanel;
import info.yalamanchili.office.client.admin.vendor.VendorsOptionPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeProjectPanel extends TreePanelComposite {

    private static TreeProjectPanel instance;

    public static TreeProjectPanel instance() {
        return instance;
    }

    private static Logger logger = Logger.getLogger(TreeProjectPanel.class.getName());
    protected static final String VENDOR_NODE = "vendor";
    protected static final String MIDDLEVENDOR_NODE = "middleVendor";

    public TreeProjectPanel(String entityId) {
        super(entityId);
        instance = this;
        init("Client", OfficeWelcome.constants);
    }

    public TreeProjectPanel(JSONObject project) {
        super(project);
        instance = this;
        String name = JSONUtils.toString(project, "name");
        init(name, OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (VENDOR_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllVendorsPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new VendorsOptionPanel());
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }

}

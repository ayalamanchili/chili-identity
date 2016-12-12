/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.i18n;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class Ci18nBundleTreePanel extends TreePanelComposite {

    private static Ci18nBundleTreePanel instance;

    public static Ci18nBundleTreePanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(Ci18nBundleTreePanel.class.getName());

    protected static final String RESOURCES_NODE = "resources";

    public Ci18nBundleTreePanel(String entityId) {
        super(entityId);
        instance = this;
        init("ResourceBundle", OfficeWelcome.constants);
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
        addFirstChildLink("Resources", RESOURCES_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (RESOURCES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().chiliAdminPanel.entityPanel.clear();
            TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllCi8nResourcesPanel(entityId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

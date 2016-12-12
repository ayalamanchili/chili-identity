/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.bulkimport;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeBulkImportPanel extends TreePanelComposite {

    private static TreeBulkImportPanel instance;

    public static TreeBulkImportPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeBulkImportPanel.class.getName());
    protected static final String ENTITIES_NODE = "ENTITIES";
    protected static final String INFO_MESSAGES_NODE = "INFO_Messages";
    protected static final String WARN_MESSAGES_NODE = "WARN_Messages";
    protected static final String ERROR_MESSAGES_NODE = "ERROR_Messages";

    public TreeBulkImportPanel(String entityId) {
        super(entityId);
        instance = this;
        init("BulkImport", OfficeWelcome.constants);
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
        addFirstChildLink("Entities", ENTITIES_NODE);
        addFirstChildLink("INFO Messages", INFO_MESSAGES_NODE);
        addFirstChildLink("WARN Messages", WARN_MESSAGES_NODE);
        addFirstChildLink("ERROR Messages", ERROR_MESSAGES_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ENTITIES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportEntitiesPanel(entityId));
        }
        if (INFO_MESSAGES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportMessagesPanel(entityId, "INFO"));
        }
        if (WARN_MESSAGES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportMessagesPanel(entityId, "WARN"));
        }
        if (ERROR_MESSAGES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportMessagesPanel(entityId, "ERROR"));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

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
    protected static final String MESSAGES_NODE = "messages";

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
        addFirstChildLink("Messages", MESSAGES_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (MESSAGES_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllBulkImportMessagesPanel(entityId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

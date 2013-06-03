/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.gwt;

import info.chili.gwt.utils.Utils;

import java.util.logging.Logger;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.i18n.client.ConstantsWithLookup;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import info.chili.gwt.utils.JSONUtils;
//TODO extend tree item?
public abstract class TreePanelComposite extends Composite implements SelectionHandler<TreeItem> {

    Logger logger = Logger.getLogger(TreePanelComposite.class.getName());
    protected String entityId;
    protected JSONObject entity;
    protected ConstantsWithLookup constants;
    protected FlowPanel panel = new FlowPanel();
    protected Tree tree = new Tree();
    protected TreeItem rootItem = new TreeItem("root");

    public String getEntityId() {
        if (entityId == null && entity != null) {
            return JSONUtils.toString(entity, "id");
        }
        return entityId;

    }

    public JSONObject getEntity() {
        return entity;
    }

    public TreePanelComposite() {
        initWidget(panel);
    }

    public TreePanelComposite(JSONObject entity) {
        initWidget(panel);
        this.entity = entity;
        this.entityId = JSONUtils.toString(entity, "id");
    }

    public TreePanelComposite(String entityId) {
        initWidget(panel);
        this.entityId = entityId;
    }

    public void init(String entityNodeNameKey, ConstantsWithLookup constants) {
        this.constants = constants;
        panel.add(tree);
        panel.addStyleName("y-gwt-TreePanel");
        addRootNode(entityNodeNameKey);
        tree.addSelectionHandler(this);
        addListeners();
        configure();
        addWidgets();
        rootItem.setState(expandTree());
    }

    public boolean expandTree() {
        return false;
    }

    public TreeItem getRoot() {
        return rootItem;
    }

    @Override
    public void onSelection(SelectionEvent<TreeItem> event) {
        loadEntity();
        TreeItem selectedItem = (TreeItem) event.getSelectedItem();
        TreeItem root = tree.getItem(0);
        if (root.equals(selectedItem)) {
            logger.info("root selected");
            showEntity();
        } else {
            logger.info("tree node selected:" + selectedItem.getUserObject().toString());
            treeNodeSelected((String) selectedItem.getUserObject());
        }
    }

    protected void addRootNode(String name) {
        // TODO get the roo node name from constants
        TreeItemLabel label = new TreeItemLabel(name);
        rootItem.setWidget(label);;
        rootItem.addStyleName("y-gwt-treePanelComposite-RootNode");
        tree.addItem(rootItem);
    }

    protected void addFirstChildLink(String childNodeName, String childNodeKey) {
        // TODO get the name from constants
        TreeItemLabel label = new TreeItemLabel(Utils.getKeyValue(childNodeName, constants));
        TreeItem child = new TreeItem(label);
        child.addStyleName("y-gwt-treePanelComposite-Node");

        child.setUserObject(childNodeKey);
        rootItem.addItem(child);
    }

    protected void addFirstChildLink(String childNodeName, String childNodeKey, TreeItem treeItem) {
        TreeItemLabel label = new TreeItemLabel(Utils.getKeyValue(childNodeName, constants));
        treeItem.setWidget(label);
        treeItem.setUserObject(childNodeKey);
        rootItem.addItem(treeItem);
    }

    protected void removeFirstChildLink(String childNodeKey) {
        TreeItem root = tree.getItem(0);
        for (int i = 0; i < root.getChildCount(); i++) {
            TreeItem child = root.getChild(i);
            if (childNodeKey.contains((CharSequence) child.getUserObject())) {
                child.remove();
            }
        }
    }

    protected abstract void addListeners();

    protected abstract void configure();

    protected abstract void addWidgets();

    public abstract void treeNodeSelected(String entityNodeKey);

    public abstract void loadEntity();

    public abstract void showEntity();

    public class TreeItemLabel extends Label {

        public TreeItemLabel(String name) {
            super(name);
            this.addStyleName("treeItemLabel");
        }
    }
}

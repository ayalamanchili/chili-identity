/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreeEntityItem;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
//TODO move generic/common logic to abstracttreepanel
public class DriveTreePanel extends ALComposite implements SelectionHandler<TreeItem> {

    private static Logger logger = Logger.getLogger(TreeEmployeePanel.class.getName());
    private static DriveTreePanel instance;
    protected TreeEntityItem rootNode;

    public static DriveTreePanel instance() {
        return instance;
    }
    protected FlowPanel panel = new FlowPanel();
    protected Tree tree = new Tree();

    public DriveTreePanel() {
        instance = this;
        init(panel);
        initTree();
    }

    protected void initTree() {
        HttpService.HttpServiceAsync.instance().doGet(getDriveTreeUrl(), OfficeWelcome.instance().getHeaders(), false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                JSONObject driveFolder = (JSONObject) JSONParser.parseLenient(arg0);
                rootNode = new TreeEntityItem(OfficeWelcome.constants, "DRIVE", driveFolder);
                tree.addItem(rootNode);
                if (driveFolder.containsKey("children")) {
                    buildDriveTree(rootNode, driveFolder, JSONUtils.toJSONArray(driveFolder.get("children")));
                }
                rootNode.setState(true);
            }
        });
    }

    protected void refresh() {
        tree.clear();
        initTree();
    }

    protected void buildDriveTree(TreeEntityItem parentNode, JSONObject parent, JSONArray children) {
        for (int i = 0; i < children.size(); i++) {
            JSONObject child = (JSONObject) children.get(i);
            addChildNode(parentNode, child);
            TreeEntityItem childNode = (TreeEntityItem) parentNode.getChild(i);
            if (child.containsKey("children")) {
                buildDriveTree(childNode, child, JSONUtils.toJSONArray(child.get("children")));
            }
        }
    }

    @Override
    protected void addListeners() {
        tree.addSelectionHandler(this);
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(tree);
    }

    protected void addChildNode(TreeEntityItem parentNode, JSONObject child) {
        TreeEntityItem childNode = new TreeEntityItem(OfficeWelcome.constants, JSONUtils.toString(child, "name"), child);
        parentNode.addItem(childNode);
    }

    protected TreeEntityItem getSelectedNode() {
        return (TreeEntityItem) tree.getSelectedItem();
    }

    protected String getDriveTreeUrl() {
        return OfficeWelcome.constants.root_url() + "drive/tree";
    }

    @Override
    public void onSelection(SelectionEvent<TreeItem> event) {
        TreeEntityItem selectedNode = (TreeEntityItem) event.getSelectedItem();
        TabPanel.instance().drivePanel.entityPanel.clear();
        TabPanel.instance().drivePanel.entityPanel.add(new ReadAllFiles(selectedNode.getEntityId()));

    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.drive;

import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Tree;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.TreeEntityItem;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

/**
 *
 * @author yphanikumar
 */
public class DriveTreePanel extends ALComposite {

    private static Logger logger = Logger.getLogger(TreeEmployeePanel.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected Tree tree = new Tree();

    public DriveTreePanel() {
        init(panel);
        initTree();
    }

    protected void initTree() {
        HttpService.HttpServiceAsync.instance().doGet(getDriveTreeUrl(), OfficeWelcome.instance().getHeaders(), false, new ALAsyncCallback<String>() {
            @Override
            public void onResponse(String arg0) {
                JSONObject driveFolder = (JSONObject) JSONParser.parseLenient(arg0);
                TreeEntityItem rootNode = new TreeEntityItem(OfficeWelcome.constants, "DRIVE", driveFolder);
                tree.addItem(rootNode);
                if (driveFolder.containsKey("children")) {
                    buildDriveTree(driveFolder, JSONUtils.toJSONArray(driveFolder.get("children")));
                }
            }
        });
    }

    protected void buildDriveTree(JSONObject parent, JSONArray children) {
        for (int i = 0; i < children.size(); i++) {
            JSONObject child = (JSONObject) children.get(i);
            addChildNode(JSONUtils.toString(parent, "name"), JSONUtils.toString(child, "name"), child);
            if (child.containsKey("children")) {
                buildDriveTree(child, JSONUtils.toJSONArray(child.get("children")));
            }
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        panel.add(tree);
    }

    protected void addChildNode(String parentKey, String childKey, JSONObject child) {
        TreeEntityItem parentNode = getNodeForKey(parentKey);
        TreeEntityItem childNode = new TreeEntityItem(OfficeWelcome.constants, childKey, child);
        if (parentNode != null) {
            parentNode.addItem(childNode);
        }
    }

    protected TreeEntityItem getNodeForKey(String key) {
        for (int i = 0; i < tree.getItemCount(); i++) {
            TreeEntityItem node = (TreeEntityItem) tree.getItem(i);
            if (key.equalsIgnoreCase(node.getKey())) {
                return node;
            }
            TreeEntityItem child = getNodeForKey(key, node);
            if (child != null) {
                return child;
            }

        }
        return null;
    }

    protected TreeEntityItem getNodeForKey(String key, TreeEntityItem treeNode) {
        for (int i = 0; i < treeNode.getChildCount(); i++) {
            TreeEntityItem node = (TreeEntityItem) treeNode.getChild(i);
            if (key.equalsIgnoreCase(node.getKey())) {
                return node;
            }
            getNodeForKey(key, node);
        }
        return null;
    }

    protected String getDriveTreeUrl() {
        return OfficeWelcome.constants.root_url() + "drive/tree";
    }
}

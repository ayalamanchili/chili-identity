/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.client;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.admin.clientcontact.ReadAllClientAcctPayContacts;
import info.yalamanchili.office.client.admin.clientcontact.ReadAllClientContactPanel;
import info.yalamanchili.office.client.admin.clientlocation.ReadAllClientLocationsPanel;
import java.util.logging.Logger;

/**
 *
 * @author raghu
 */
public class TreeClientPanel extends TreePanelComposite {

    private static TreeClientPanel instance;

    public static TreeClientPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeClientPanel.class.getName());
//    protected static final String PROJECT_NODE = "project";
    protected static final String CLIENTLOCATION_NODE = "clientlocation";
    protected static final String CONTACTS_NODE = "contacts";
    protected static final String CLIENT_ACCT_PAY_CONTACTS_NODE = "clientacctpaycontacts";

    public TreeClientPanel(String entityId) {
        super(entityId);
        instance = this;
        init("Client", OfficeWelcome.constants);
    }

    public TreeClientPanel(JSONObject client) {
        super(client);
        instance = this;
        String name = JSONUtils.toString(client, "name");
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
        addFirstChildLink("Locations", CLIENTLOCATION_NODE);
        addFirstChildLink("Recruiter Contacts", CONTACTS_NODE);
        addFirstChildLink("Acct Pay Contacts", CLIENT_ACCT_PAY_CONTACTS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (CLIENTLOCATION_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientLocationsPanel(entityId));
        }
        if (CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientContactPanel(entityId));
        }
        if (CLIENT_ACCT_PAY_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllClientAcctPayContacts(entityId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

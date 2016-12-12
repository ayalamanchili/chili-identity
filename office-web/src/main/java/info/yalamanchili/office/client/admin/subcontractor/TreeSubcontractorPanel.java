/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.subcontractor;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.subcntrcontact.ReadAllSubcontractorContactsPanel;
import info.yalamanchili.office.client.admin.subcntrlocation.ReadAllSubcontractorLocationsPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class TreeSubcontractorPanel extends TreePanelComposite {

    private static TreeSubcontractorPanel instance;

    public static TreeSubcontractorPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeSubcontractorPanel.class.getName());
    protected static final String SUBCONTRACTOR_LOCATION_NODE = "subcontractorlocation";
    protected static final String SUBCONTRACTOR_CONTACTS_NODE = "subcontractorcontacts";

    public TreeSubcontractorPanel(String entityId) {
        super(entityId);
        instance = this;
        init("Subcontractor", OfficeWelcome.constants);
    }

    public TreeSubcontractorPanel(JSONObject subcontractor) {
        super(subcontractor);
        instance = this;
        String name = JSONUtils.toString(subcontractor, "name");
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
        addFirstChildLink("Locations", SUBCONTRACTOR_LOCATION_NODE);
        addFirstChildLink("Recruiter Contacts", SUBCONTRACTOR_CONTACTS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (SUBCONTRACTOR_LOCATION_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorLocationsPanel(entityId));
        }
        if (SUBCONTRACTOR_CONTACTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSubcontractorContactsPanel(entityId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

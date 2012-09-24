/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae.sow;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.tae.project.ProjectOptionsPanel;
import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;
import info.yalamanchili.office.client.tae.sow.SOWOptionsPanel;
import info.yalamanchili.office.client.tae.sow.ReadAllSOWPanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi
 */
public class TreeSOWPanel extends TreePanelComposite {

    private static TreeSOWPanel instance;

    public static TreeSOWPanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeSOWPanel.class.getName());
    protected static final String TIMESHEET_NODE = " timesheet";

    public TreeSOWPanel(String entityId) {
        super(entityId);
        instance = this;
        init("StatementOfWork", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink(" timesheet", TIMESHEET_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (TIMESHEET_NODE.equals(entityNodeKey)) {
            TabPanel.instance().TimeandExpensePanel.entityPanel.clear();
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllProjectsPanel(entityId));
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ProjectOptionsPanel());
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new SOWOptionsPanel());
            TabPanel.instance().TimeandExpensePanel.entityPanel.add(new ReadAllSOWPanel());
        }
    }

    @Override
    public JSONObject loadEntity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void showEntity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

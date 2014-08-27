/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.sow;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.admin.project.ProjectOptionsPanel;
import info.yalamanchili.office.client.admin.project.ReadAllProjectsPanel;
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
            TabPanel.instance().adminPanel.entityPanel.clear();
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllProjectsPanel(entityId));
            TabPanel.instance().adminPanel.entityPanel.add(new ProjectOptionsPanel());
            TabPanel.instance().adminPanel.entityPanel.add(new SOWOptionsPanel());
            TabPanel.instance().adminPanel.entityPanel.add(new ReadAllSOWPanel());
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

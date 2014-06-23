/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.statusreport.ReadAllStatusReportPanel;
import java.util.logging.Logger;

/**
 *
 * @author anuyalamanchili
 */
public class TreeClientInfoPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeClientInfoPanel.class.getName());
    protected static final String PROJECTS_REPORTS_NODE = "project-reports";
    protected String employeeId;

    public TreeClientInfoPanel(String empId) {
        this.employeeId = empId;
        init("ClientInformation", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_HR, ROLE.ROLE_RELATIONSHIP)) {
            addFirstChildLink("Project Reports", PROJECTS_REPORTS_NODE);
        }
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (PROJECTS_REPORTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllStatusReportPanel(employeeId));
        }
    }

    @Override
    public void loadEntity() {

    }

    @Override
    public void showEntity() {
    }
}

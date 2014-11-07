/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.employee.prefeval.ReadAllPerformanceEvaluationPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.statusreport.ReadAllStatusReportPanel;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeEmpReportsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpReportsPanel.class.getName());
    protected static final String PROJECTS_REPORTS_NODE = "project-reports";
    protected static final String PERFORMANCE_REPORTS_NODE = "preformance-reports";
    protected String employeeId;

    public TreeEmpReportsPanel(String empId) {
        this.employeeId = empId;
        init("Reports", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_HR, Auth.ROLE.ROLE_RELATIONSHIP)) {
            addFirstChildLink("Status Reports", PROJECTS_REPORTS_NODE);
        }
        addFirstChildLink("Performance Reports", PERFORMANCE_REPORTS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (PROJECTS_REPORTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllStatusReportPanel(employeeId));
        }
        if (PERFORMANCE_REPORTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPerformanceEvaluationPanel(employeeId));
        }
    }

    @Override
    public void loadEntity() {

    }

    @Override
    public void showEntity() {
    }
}

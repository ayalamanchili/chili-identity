/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.immigration.ReadAllPassportPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeEmployeeImmigrationPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmployeeImmigrationPanel.class.getName());
    protected static final String PASSPORT_NODE = "passport-immigration";
    protected static final String LCA_NODE = "lca-immigration";
    protected static final String PETITION_NODE = "petition-immigration";
    protected String employeeId;

    public TreeEmployeeImmigrationPanel(String empId) {
        this.employeeId = empId;
        init("Immigration", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Passport", PASSPORT_NODE);
//        addFirstChildLink("LCA", LCA_NODE);
//        addFirstChildLink("Petition", PETITION_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (PASSPORT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPassportPanel(employeeId));
        }
//        if (LCA_NODE.equals(entityNodeKey)) {
//            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
//            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllStatusReportPanel(employeeId));
//        }
//        if (PETITION_NODE.equals(entityNodeKey)) {
//            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
//            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllPerformanceEvaluationPanel(employeeId));
//        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
    
}

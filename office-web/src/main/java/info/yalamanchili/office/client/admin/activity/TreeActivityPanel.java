/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeActivityPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeActivityPanel.class.getName());
    protected static final String COMMUNICATIONS_NODE = "communications";
    protected String employeeId;

    public TreeActivityPanel(String empId) {
        this.employeeId = empId;
        init("Activity", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Communications", COMMUNICATIONS_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (COMMUNICATIONS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCommunicationActivityPanel(employeeId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new CommunicationActivityOptionsWidget());
        }
    }

    protected String getcommunicationActivityUrl() {
        return OfficeWelcome.constants.root_url() + "communication_activity/" + employeeId + "/0/10";
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

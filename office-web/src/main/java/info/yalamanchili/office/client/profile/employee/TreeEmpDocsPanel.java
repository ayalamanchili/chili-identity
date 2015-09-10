/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.json.client.JSONObject;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeEmpDocsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpDocsPanel.class.getName());
    protected static final String READALL_ACH_PANEL = "ReadAll_ACH_Panel";
    protected static final String READALL_JOINING_FORM_PANEL = "ReadAll_Joining_Form_Panel";
    protected String employeeId;

    public TreeEmpDocsPanel(JSONObject emp) {
        this.employeeId = JSONUtils.toString(emp, "employeeId");
        init("Forms", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("ACH Form", READALL_ACH_PANEL);
        addFirstChildLink("Joining Form", READALL_JOINING_FORM_PANEL);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (READALL_ACH_PANEL.equals(entityNodeKey)) {
            logger.info("employeeid: " + employeeId);
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadBankAcctWidget(employeeId));
        }
        if (READALL_JOINING_FORM_PANEL.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
//            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllJoiningFormPanel(employeeId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }

}

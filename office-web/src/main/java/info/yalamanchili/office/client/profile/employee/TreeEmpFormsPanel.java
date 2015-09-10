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
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.onboarding.ReadACHPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeEmpFormsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpFormsPanel.class.getName());
    protected static final String ACH_FORM = "ach";
    protected static final String JOINING_FORM = "joining-form";
    protected String employeeId;

    public TreeEmpFormsPanel(JSONObject emp) {
        this.employeeId = JSONUtils.toString(emp, "id");
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
        addFirstChildLink("ACH Form", ACH_FORM);
        addFirstChildLink("Joining Form", JOINING_FORM);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ACH_FORM.equals(entityNodeKey)) {
            logger.info("employeeid: " + employeeId);
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadACHPanel(employeeId));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(this);
        }
        if (JOINING_FORM.equals(entityNodeKey)) {
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

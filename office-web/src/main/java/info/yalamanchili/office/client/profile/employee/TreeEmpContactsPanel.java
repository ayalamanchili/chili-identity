/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
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
import info.yalamanchili.office.client.companycontact.ReadAllCompanyContactPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllDependentsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPanel;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class TreeEmpContactsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpContactsPanel.class.getName());
    protected static final String EMERGENCY_CONTACT_NODE = "emergencyContact";
    protected static final String DEPENDENT_NODE = "dependents";
    protected static final String COMPANY_CONTACT_NODE = "companyContact";
    protected String employeeId;

    public TreeEmpContactsPanel(JSONObject emp) {
        this.employeeId = JSONUtils.toString(emp, "id");
        init("Contacts", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Emergency Contacts", EMERGENCY_CONTACT_NODE);
        addFirstChildLink("Dependents", DEPENDENT_NODE);
        addFirstChildLink("Company Contacts", COMPANY_CONTACT_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (EMERGENCY_CONTACT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(employeeId));
        }
        if (DEPENDENT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllDependentsPanel(employeeId));
        }
        if (COMPANY_CONTACT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllCompanyContactPanel(employeeId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}
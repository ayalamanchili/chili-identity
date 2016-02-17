/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.expense.bnkacct.ReadBankAcctWidget;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.onboarding.ReadJoiningFormPanel;
import info.yalamanchili.office.client.profile.empdoc.EmpDocOptionsPanel;
import info.yalamanchili.office.client.profile.empdoc.ReadAllEmpDocsPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class TreeEmpFormsPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeEmpFormsPanel.class.getName());
    protected static final String ACH_FORM = "ach";
    protected static final String JOINING_FORM = "joining-form";
    protected static final String DOCUMENTS_NODE = "documents";
    protected String employeeId;
    protected Anchor printACHL = new Anchor("Print");
    protected Anchor printJoiningFormL = new Anchor("Print");

    public TreeEmpFormsPanel(JSONObject emp) {
        this.employeeId = JSONUtils.toString(emp, "id");
        init("Forms & Docs", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
        printACHL.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/ach-report/" + TreeEmployeePanel.instance().getEntityId() + "&passthrough=true", "_blank", "");
            }
        });

        printJoiningFormL.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/joining-form-report/" + TreeEmployeePanel.instance().getEntityId() + "&passthrough=true", "_blank", "");
            }
        });
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR)) {
            addFirstChildLink("ACH Form", ACH_FORM);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR, Auth.ROLE.ROLE_HR_ADMINSTRATION)) {
            addFirstChildLink("Joining Form", JOINING_FORM);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR)) {
            addFirstChildLink("Documents", DOCUMENTS_NODE);
        }
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ACH_FORM.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllBankAcctWidget(employeeId));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printACHL);
        }
        if (JOINING_FORM.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadJoiningFormPanel(employeeId));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printJoiningFormL);
        }
        if (DOCUMENTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmpDocsPanel(employeeId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new EmpDocOptionsPanel());
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

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
import com.google.gwt.user.client.ui.HTML;
import info.chili.gwt.config.ChiliClientConfig;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.onboarding.ReadEmployeeRolesAndResponsibilitesPanel;
import info.yalamanchili.office.client.onboarding.ReadJoiningFormPanel;
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
    protected static final String ROLESRESPONSIBILITES = "roles-respo";
    protected static final String DOCUMENTS_NODE = "documents";
    protected String employeeId;
    protected Anchor printACHL = new Anchor("Print Ach Form");
    protected Anchor printJoiningFormL = new Anchor("Print Joining Form");
    protected Anchor printselfIdFormL = new Anchor("Print Self Identification Form");
    protected Anchor printRolesResIdFormL = new Anchor("Print Roles And Responsibilities");
    protected static HTML generalInfo = new HTML("\n"
            + "<center><p style=\"border: 1px solid rgb(191, 191, 191); padding: 0px 10px; background: rgb(222, 222, 222);\">"
            + "<strong style=\"color:#555555\"> Self Identification Form </strong></p></center>\n"
            + "\n"
            + "<ul>\n"
            + "</ul>");

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
        printselfIdFormL.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                Window.open(ChiliClientConfig.instance().getFileDownloadUrl() + "employee-forms/self-Identification-report/" + TreeEmployeePanel.instance().getEntityId() + "&passthrough=true", "_blank", "");
            }
        });
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            addFirstChildLink("ACH Form", ACH_FORM);
        }
        addFirstChildLink("Joining Form", JOINING_FORM);
        addFirstChildLink("Roles & Responsibilities", ROLESRESPONSIBILITES);
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ON_BOARDING_MGR, Auth.ROLE.ROLE_BACKGROUND_SCREENING_MGR, Auth.ROLE.ROLE_E_VERIFY_MGR, Auth.ROLE.ROLE_PAYROLL_AND_BENIFITS)) {
            addFirstChildLink("Documents", DOCUMENTS_NODE);

        }
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ACH_FORM.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllBankAcctWidget(employeeId));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printACHL);
            TabPanel.instance().getMyOfficePanel().entityPanel.add(generalInfo);
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printselfIdFormL);
        }
        if (JOINING_FORM.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadJoiningFormPanel(employeeId));
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printJoiningFormL);
            TabPanel.instance().getMyOfficePanel().entityPanel.add(generalInfo);
            TabPanel.instance().getMyOfficePanel().entityPanel.add(printselfIdFormL);

        }
        if (ROLESRESPONSIBILITES.equals(entityNodeKey)) {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadEmployeeRolesAndResponsibilitesPanel(employeeId));
        }
        if (DOCUMENTS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmpDocsPanel(employeeId));
        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

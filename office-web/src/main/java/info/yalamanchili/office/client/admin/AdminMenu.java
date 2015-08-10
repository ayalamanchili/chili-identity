/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.bulkimport.BulkImportSidePanel;
import info.yalamanchili.office.client.admin.bulkimport.ReadAllBulkImportsPanel;
import info.yalamanchili.office.client.admin.notificationgroup.NotificationGroupSidePanel;
import info.yalamanchili.office.client.admin.notificationgroup.ReadAllNotificationGroupsPanel;
import info.yalamanchili.office.client.admin.client.ClientSidePanel;
import info.yalamanchili.office.client.admin.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.admin.project.ProjectSidePanel;
import info.yalamanchili.office.client.admin.project.ReadAllProjectsPanel;
import info.yalamanchili.office.client.admin.sow.ReadAllSOWPanel;
import info.yalamanchili.office.client.admin.sow.SOWSidePanel;
import info.yalamanchili.office.client.admin.subcontractor.ReadAllSubcontractorsPanel;
import info.yalamanchili.office.client.admin.subcontractor.SubcontractorSidePanel;
import info.yalamanchili.office.client.admin.vendor.ReadAllVendorsPanel;
import info.yalamanchili.office.client.admin.vendor.VendorsSidePanel;
import info.yalamanchili.office.client.analytics.event.EventsSidePanel;
import info.yalamanchili.office.client.analytics.event.ReadAllEventsPanel;
import info.yalamanchili.office.client.company.CompanySidePanel;
import info.yalamanchili.office.client.company.ReadAllCompanyPanel;
import info.yalamanchili.office.client.ext.externalReferences.ReadAllExternalRefPanel;
import info.yalamanchili.office.client.ext.question.QuestionSidePanel;
import info.yalamanchili.office.client.ext.question.ReadAllQuestionPanel;

/**
 *
 * @author anuyalamanchili
 */
public class AdminMenu extends Composite {

    MenuBar adminMenuBar = new MenuBar(false);

    public AdminMenu() {
        initWidget(adminMenuBar);
        configureAdminMenu();
    }

    protected void configureAdminMenu() {
        adminMenuBar.addItem("Clients", clientsMaintainenceCmd);
        adminMenuBar.addItem("Projects", projectsMaintainenceCmd);
        adminMenuBar.addItem("Vendors", vendorsMaintainenceCmd);
        adminMenuBar.addItem("Subcontractors", subcontractorsMaintainenceCmd);
        adminMenuBar.addItem("SOW's", sowMaintainenceCmd);
        adminMenuBar.addItem("Notification Groups", notificationGroupMaintainenceCmd);
        adminMenuBar.addItem("Question", questionMaintainenceCmd);
        if (Auth.hasAnyOfRoles(ROLE.ROLE_BULK_IMPORT, ROLE.ROLE_ADMIN)) {
            adminMenuBar.addItem("External Refs", externalReferencesMaintainenceCmd);
            adminMenuBar.addItem("Bulk Import", bulkImportMaintainenceCmd);
        }
        if (Auth.isAdmin()) {
            adminMenuBar.addItem("Activity", activityMaintainenceCmd);
        }
        if (Auth.isAdmin()) {
            adminMenuBar.addItem("Company", companyMaintainenceCmd);
        }
        adminMenuBar.addStyleName("entityMenuBar");
    }
    Command notificationGroupMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllNotificationGroupsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new NotificationGroupSidePanel());
        }
    };
    Command clientsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllClientsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new ClientSidePanel());
        }
    };
    Command externalReferencesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllExternalRefPanel());

        }
    };
    Command projectsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllProjectsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new ProjectSidePanel());
        }
    };
    Command sowMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllSOWPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new SOWSidePanel());
        }
    };
    Command vendorsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllVendorsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new VendorsSidePanel());
        }
    };
    Command subcontractorsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllSubcontractorsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new SubcontractorSidePanel());
        }
    };
    Command bulkImportMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllBulkImportsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new BulkImportSidePanel());
        }
    };
    Command questionMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllQuestionPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new QuestionSidePanel());
        }
    };
    Command activityMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new EventsSidePanel());
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllEventsPanel());

        }
    };
    Command companyMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new CompanySidePanel());
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllCompanyPanel());

        }
    };
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin;

import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.admin.bulkimport.ReadAllBulkImportsPanel;
import info.yalamanchili.office.client.admin.notificationgroup.ReadAllNotificationGroupsPanel;
import info.yalamanchili.office.client.admin.client.ClientSidePanel;
import info.yalamanchili.office.client.admin.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.admin.project.ReadAllProjectsPanel;
import info.yalamanchili.office.client.admin.project.SearchProjectsPanel;
import info.yalamanchili.office.client.admin.sow.ReadAllSOWPanel;
import info.yalamanchili.office.client.admin.subcontractor.ReadAllSubcontractorsPanel;
import info.yalamanchili.office.client.admin.subcontractor.SubcontractorSidePanel;
import info.yalamanchili.office.client.admin.vendor.ReadAllVendorsPanel;
import info.yalamanchili.office.client.admin.vendor.VendorsSidePanel;
import info.yalamanchili.office.client.analytics.event.EventsSidePanel;
import info.yalamanchili.office.client.analytics.event.ReadAllEventsPanel;
import info.yalamanchili.office.client.company.ReadAllCompanyPanel;
import info.yalamanchili.office.client.ext.externalReferences.ExternalSidePanel;
import info.yalamanchili.office.client.ext.externalReferences.ReadAllExternalRefPanel;
import info.yalamanchili.office.client.ext.question.ReadAllQuestionPanel;

/**
 *
 * @author anuyalamanchili
 */
public class AdminMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ACCOUNTS_PAYABLE, ROLE.ROLE_ACCOUNTS_RECEIVABLE, ROLE.ROLE_ADMIN)) {
            addMenuItem("Clients", "Clients", clientsMaintainenceCmd);
            addMenuItem("Vendors", "Vendors", vendorsMaintainenceCmd);
            addMenuItem("Subcontractors", "Subcontractors", subcontractorsMaintainenceCmd);
        } else {
            addMenuItem("Clients", "Clients", clientsMaintainenceCmd);
            addMenuItem("Projects", "Projects", projectsMaintainenceCmd);
            addMenuItem("Vendors", "Vendors", vendorsMaintainenceCmd);
            addMenuItem("Subcontractors", "Subcontractors", subcontractorsMaintainenceCmd);
            addMenuItem("SOW's", "SOW's", sowMaintainenceCmd);
            addMenuItem("Notification Groups", "Notification Groups", notificationGroupMaintainenceCmd);
            addMenuItem("Question", "Question", questionMaintainenceCmd);
            if (Auth.hasAnyOfRoles(ROLE.ROLE_BULK_IMPORT, ROLE.ROLE_ADMIN)) {
                addMenuItem("External Refs", "External Refs", externalReferencesMaintainenceCmd);
                addMenuItem("Bulk Import", "Bulk Import", bulkImportMaintainenceCmd);
            }
            if (Auth.isAdmin()) {
                addMenuItem("Activity", "Activity", activityMaintainenceCmd);
            }
            if (Auth.isAdmin()) {
                addMenuItem("Company", "Company", companyMaintainenceCmd);
            }
        }
    }
    static Command notificationGroupMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllNotificationGroupsPanel());
        }
    };
    static Command clientsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.setHeight("100%");
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllClientsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new ClientSidePanel());
        }
    };
    static Command externalReferencesMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllExternalRefPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new ExternalSidePanel());
        }
    };
    static Command projectsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllProjectsPanel());
            if (Auth.hasAnyOfRoles(ROLE.ROLE_CONTRACTS_ADMIN)) {
                TabPanel.instance().getAdminPanel().sidePanelTop.add(new SearchProjectsPanel());
            }
        }
    };
    static Command sowMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllSOWPanel());
        }
    };
    static Command vendorsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.setHeight("100%");
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllVendorsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new VendorsSidePanel());
        }
    };
    static Command subcontractorsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.setHeight("100%");
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllSubcontractorsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new SubcontractorSidePanel());
        }
    };
    static Command bulkImportMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllBulkImportsPanel());
        }
    };
    static Command questionMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllQuestionPanel());
        }
    };
    static Command activityMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.setHeight("100%");
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new EventsSidePanel());
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllEventsPanel());

        }
    };
    static Command companyMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllCompanyPanel());
        }
    };
}

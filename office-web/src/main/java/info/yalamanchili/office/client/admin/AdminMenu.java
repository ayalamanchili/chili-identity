/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
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
import info.yalamanchili.office.client.admin.vendor.ReadAllVendorsPanel;
import info.yalamanchili.office.client.admin.vendor.VendorsSidePanel;

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
//        MenuBar menu = new MenuBar(true);

        if (Auth.isAdmin() || Auth.isHR()) {
            adminMenuBar.addItem("Clients", clientsMaintainenceCmd);
            adminMenuBar.addItem("Projects", projectsMaintainenceCmd);
            adminMenuBar.addItem("Vendors", vendorsMaintainenceCmd);
            adminMenuBar.addItem("SOW's", sowMaintainenceCmd);
            adminMenuBar.addItem("Notification Groups", notificationGroupMaintainenceCmd);
            if (Auth.isAdmin() || Auth.isAccountant() || Auth.isPayroll()) {
                adminMenuBar.addItem("Bulk Import", bulkImportMaintainenceCmd);
            }
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
    Command bulkImportMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getAdminPanel().entityPanel.clear();
            TabPanel.instance().getAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllBulkImportsPanel());
            TabPanel.instance().getAdminPanel().sidePanelTop.add(new BulkImportSidePanel());
        }
    };
}

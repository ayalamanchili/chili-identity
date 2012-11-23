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
import info.yalamanchili.office.client.profile.notificationgroup.NotificationGroupSidePanel;
import info.yalamanchili.office.client.profile.notificationgroup.ReadAllNotificationGroupsPanel;

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
        MenuBar menu = new MenuBar(true);

        if (Auth.isAdmin() || Auth.isHR()) {
            adminMenuBar.addItem("Notification Groups", notificationGroupMaintainenceCmd);

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
}

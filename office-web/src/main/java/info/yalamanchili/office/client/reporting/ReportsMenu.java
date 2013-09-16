/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.reporting;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author prasanthi.p
 */
public class ReportsMenu extends Composite {

    MenuBar reportsMenuBar = new MenuBar(false);

    public ReportsMenu() {
        initWidget(reportsMenuBar);
        configureReportsMenu();
    }

    protected void configureReportsMenu() {
        reportsMenuBar.addItem("Contracts", ContractingMaintainenceCmd);

        reportsMenuBar.addStyleName("entityMenuBar");
    }
    
    Command ContractingMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getReportingPanel().entityPanel.clear();
            TabPanel.instance().getReportingPanel().sidePanelTop.clear();
////            TabPanel.instance().getAdminPanel().entityPanel.add(new ReadAllNotificationGroupsPanel());
////            TabPanel.instance().getAdminPanel().sidePanelTop.add(new NotificationGroupSidePanel());
        }
    };
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.tae;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.tae.client.ClientSidePanel;
import info.yalamanchili.office.client.tae.client.ReadAllClientsPanel;
import info.yalamanchili.office.client.tae.project.ProjectSidePanel;
import info.yalamanchili.office.client.tae.project.ReadAllProjectsPanel;
import info.yalamanchili.office.client.tae.sow.SOWSidePanel;
import info.yalamanchili.office.client.tae.sow.ReadAllSOWPanel;
/**
 *
 * @author ayalamanchili
 */
public class TAEMenu extends Composite{
     MenuBar tAEMenuBar = new MenuBar(false);
     public TAEMenu() {
        initWidget(tAEMenuBar);
        configureTAEMenu();
    }
       protected void configureTAEMenu() {
        MenuBar menu = new MenuBar(true);
        tAEMenuBar.addItem("Menu", menu);
        tAEMenuBar.addStyleName("entityMenuBar");
        

        if (Auth.isAdmin() || Auth.isHR()) {
            menu.addItem("Clients", clientsMaintainenceCmd);
            menu.addItem("Projects",projectsMaintainenceCmd);
            menu.addItem("SOW",sowMaintainenceCmd);
      
        }
    }
        Command clientsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getTimeandExpensePanel().entityPanel.clear();
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getTimeandExpensePanel().entityPanel.add(new ReadAllClientsPanel());
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.add(new ClientSidePanel());
        }
    };
        Command projectsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getTimeandExpensePanel().entityPanel.clear();
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getTimeandExpensePanel().entityPanel.add(new ReadAllProjectsPanel());
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.add(new ProjectSidePanel());
        }
    };
         Command sowMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getTimeandExpensePanel().entityPanel.clear();
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.clear();
            TabPanel.instance().getTimeandExpensePanel().entityPanel.add(new ReadAllSOWPanel());
            TabPanel.instance().getTimeandExpensePanel().sidePanelTop.add(new SOWSidePanel());
        }
    };
}


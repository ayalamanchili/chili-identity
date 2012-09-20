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

/**
 *
 * @author ayalamanchili
 */
public class TAEMenu extends Composite{
     MenuBar tAEMenuBar = new MenuBar(false);
     public TAEMenu() {
        initWidget(tAEMenuBar);
        configureAdminMenu();
    }
       protected void configureAdminMenu() {
        MenuBar menu = new MenuBar(true);
        tAEMenuBar.addItem("TAEMenu", menu);
        tAEMenuBar.addStyleName("entityMenuBar");
        

        if (Auth.isAdmin() || Auth.isHR()) {
            menu.addItem("Clients", clientsMaintainenceCmd);
            
      
        }
    }
        Command clientsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getMyOfficePanel().entityPanel.clear();
            TabPanel.instance().getMyOfficePanel().sidePanelTop.clear();
            TabPanel.instance().getMyOfficePanel().entityPanel.add(new ReadAllClientsPanel());
            TabPanel.instance().getMyOfficePanel().sidePanelTop.add(new ClientSidePanel());
        }
    };
}

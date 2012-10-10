/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.home.todo.ReadAllTodosPanel;
import info.yalamanchili.office.client.home.todo.TodoSidePanel;

/**
 *
 * @author Prashanthi
 */
public class HomeMenu extends Composite {

    MenuBar homeMenuBar = new MenuBar(false);

    public HomeMenu() {

        initWidget(homeMenuBar);
        configureTOTDOMenu();
    }

    protected void configureTOTDOMenu() {

        MenuBar menu = new MenuBar(true);
        homeMenuBar.addItem("Menu", menu);
        homeMenuBar.addStyleName("entityMenuBar");

        menu.addItem("TODO's", todoMaintainenceCmd);
    }
    Command todoMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            
            TabPanel.instance().getHomePanel().entityPanel.clear();
            TabPanel.instance().getHomePanel().sidePanelTop.clear();
            TabPanel.instance().getHomePanel().entityPanel.add(new ReadAllTodosPanel());
            TabPanel.instance().getHomePanel().sidePanelTop.add(new TodoSidePanel());
        }
    };
}
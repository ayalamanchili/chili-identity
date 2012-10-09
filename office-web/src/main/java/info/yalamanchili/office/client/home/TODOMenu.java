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
public class TODOMenu extends Composite {

    MenuBar tODOMenuBar = new MenuBar(false);

    public TODOMenu() {

        initWidget(tODOMenuBar);
        configureTOTDOMenu();
    }

    protected void configureTOTDOMenu() {

        MenuBar menu = new MenuBar(true);
        tODOMenuBar.addItem("Menu", menu);
        tODOMenuBar.addStyleName("entityMenuBar");

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
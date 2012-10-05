/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.home;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;

/**
 *
 * @author Prashanthi
 */
public class TODOMenu extends Composite {

    MenuBar tODOMenuBar = new MenuBar(false);

    public TODOMenu() {

        initWidget(tODOMenuBar);
    }

    protected void configureTOTDOMenu() {

        MenuBar menu = new MenuBar(true);
        tODOMenuBar.addItem("MENU", menu);
        tODOMenuBar.addStyleName("entityMenuBar");

        menu.addItem("TODO", todoMaintainenceCmd);
    }
    Command todoMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            
        }
    };
}

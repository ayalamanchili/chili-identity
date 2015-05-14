/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.chiliadmin;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.i18n.ReadAllci18nResourceBundlesPanel;

/**
 *
 * @author ayalamanchili
 */
public class ChiliAdminMenu extends Composite {

    MenuBar chiliAdminMenuBar = new MenuBar(false);

    public ChiliAdminMenu() {
        initWidget(chiliAdminMenuBar);
        configureAdminMenu();
    }

    protected void configureAdminMenu() {
        chiliAdminMenuBar.addItem("Resource Bundles", chiliAdminMenuResourceBundles);
        chiliAdminMenuBar.addStyleName("entityMenuBar");
    }
    Command chiliAdminMenuResourceBundles = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanelTop.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllci18nResourceBundlesPanel());
        }
    };
}

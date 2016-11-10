/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import info.yalamanchili.office.client.profile.immigration.Petitions.ReadAllPetitionsPanel;
import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.immigration.LCA.LcaMenu;
import info.yalamanchili.office.client.profile.immigration.LCA.LcaSidePanel;
import info.yalamanchili.office.client.profile.immigration.LCA.ReadAllLCAPanel;
import info.yalamanchili.office.client.profile.immigration.LCA.SearchLcaPanel;

/**
 *
 * @author Madhu.Badiginchala
 */
public class ImmigrationMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addMenuItem("LCA", "LCA", immigrationlcaCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
            addMenuItem("Petition", "Petition", immigrationpetitionCmd);
        }
    }

    static Command immigrationlcaCmd = new Command() {
        public void execute() {
            TabPanel.instance().getImmigrationPanel().entityPanel.clear();
            TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
            TabPanel.instance().getImmigrationPanel().entityPanel.add(new LcaMenu());
            if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION)) {
                TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllLCAPanel());
                TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new LcaSidePanel());
            } else if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_H1B_IMMIGRATION, Auth.ROLE.ROLE_GC_IMMIGRATION, Auth.ROLE.ROLE_RECRUITER)) {
                TabPanel.instance().getImmigrationPanel().sidePanelTop.add(new SearchLcaPanel());
            }
        }
    };
    static Command immigrationpetitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getImmigrationPanel().entityPanel.clear();
            TabPanel.instance().getImmigrationPanel().sidePanelTop.clear();
            TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllPetitionsPanel());
        }
    };

}

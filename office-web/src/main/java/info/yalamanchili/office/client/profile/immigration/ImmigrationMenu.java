/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

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
            TabPanel.instance().getImmigrationPanel().sidePanel.clear();
            TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllLCAPanel());
        }
    };
    static Command immigrationpetitionCmd = new Command() {
        public void execute() {
            TabPanel.instance().getImmigrationPanel().entityPanel.clear();
            TabPanel.instance().getImmigrationPanel().sidePanel.clear();
            TabPanel.instance().getImmigrationPanel().entityPanel.add(new ReadAllPetitionsPanel());
        }
    };
    
}


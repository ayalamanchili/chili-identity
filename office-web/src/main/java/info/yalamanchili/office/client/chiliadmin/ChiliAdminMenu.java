/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.chiliadmin;

import info.yalamanchili.office.client.bpm.taskrule.ReadAllBPMTaskDelegateRulePanel;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.MenuBar;
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.analytics.emailevent.EmailEventSidePanel;
import info.yalamanchili.office.client.email.ReadAllEmailPreferenceRulePanel;
import info.yalamanchili.office.client.analytics.emailevent.ReadAllEmailEventsPanel;
import info.yalamanchili.office.client.i18n.ReadAllci18nResourceBundlesPanel;
import info.yalamanchili.office.client.invite.InviteCodeSidePanel;
import info.yalamanchili.office.client.invite.ReadAllInviteCodePanel;
import info.yalamanchili.office.client.releasenotes.ReadAllReleaseNotesPanel;
import info.yalamanchili.office.client.releasenotes.ReleaseNotesSidePanel;

/**
 *
 * @author ayalamanchili
 */
public class ChiliAdminMenu extends CMenuBar {
    
    MenuBar chiliAdminMenuBar = new MenuBar(false);
    
    public ChiliAdminMenu() {
        initWidget(chiliAdminMenuBar);
        configureAdminMenu();
    }
    
    protected void configureAdminMenu() {
        chiliAdminMenuBar.addItem("Resource Bundles", chiliAdminMenuResourceBundles);
        chiliAdminMenuBar.addItem("Task Rules", chiliAdminMenubpmTaskDelegate);
        chiliAdminMenuBar.addItem("Email Rules", chiliAdminMenuEmailPreferenceRule);
        chiliAdminMenuBar.addItem("Email Events", chiliAdminMenuEvent);
        chiliAdminMenuBar.addItem("Invite Code", chiliAdminMenuCode);        
        chiliAdminMenuBar.addItem("Release Notes", chiliAdminMenuRelease);
        chiliAdminMenuBar.addStyleName("entityMenuBar");
    }
    Command chiliAdminMenuResourceBundles = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllci18nResourceBundlesPanel());
        }
    };
    Command chiliAdminMenubpmTaskDelegate = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllBPMTaskDelegateRulePanel());
        }
    };
    Command chiliAdminMenuEmailPreferenceRule = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllEmailPreferenceRulePanel());
        }
    };
    Command chiliAdminMenuEvent = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new EmailEventSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllEmailEventsPanel());
        }
    };
    Command chiliAdminMenuCode = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new InviteCodeSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllInviteCodePanel());
        }
    };
    Command chiliAdminMenuRelease = new Command() {
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new ReleaseNotesSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllReleaseNotesPanel());
        }
    };

    @Override
    protected void configureMenu() {
    }
}    


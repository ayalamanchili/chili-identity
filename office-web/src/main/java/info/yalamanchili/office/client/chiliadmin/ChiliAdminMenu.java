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
import info.chili.gwt.widgets.CMenuBar;
import info.yalamanchili.office.client.Auth;
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

    @Override
    protected void configureMenu() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Resource Bundles", "Resource Bundles", chiliAdminMenuResourceBundles);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Task Rules", "Task Rules", chiliAdminMenubpmTaskDelegate);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Email Rules", "Email Rules", chiliAdminMenuEmailPreferenceRule);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Email Events", "Email Events", chiliAdminMenuEvent);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Invite Code", "Invite Code", chiliAdminMenuCode);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_CHILI_ADMIN)) {
            addMenuItem("Release Notes", "Release Notes", chiliAdminMenuRelease);
        }
    }
    
    public static Command chiliAdminMenuResourceBundles = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllci18nResourceBundlesPanel());
        }
    };
    public static Command chiliAdminMenubpmTaskDelegate = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllBPMTaskDelegateRulePanel());
        }
    };
    public static Command chiliAdminMenuEmailPreferenceRule = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllEmailPreferenceRulePanel());
        }
    };
    public static Command chiliAdminMenuEvent = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new EmailEventSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllEmailEventsPanel());
        }
    };
    public static Command chiliAdminMenuCode = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new InviteCodeSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllInviteCodePanel());
        }
    };
    public static Command chiliAdminMenuRelease = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getChiliAdminPanel().entityPanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.clear();
            TabPanel.instance().getChiliAdminPanel().sidePanel.add(new ReleaseNotesSidePanel());
            TabPanel.instance().getChiliAdminPanel().entityPanel.add(new ReadAllReleaseNotesPanel());
        }
    };

}

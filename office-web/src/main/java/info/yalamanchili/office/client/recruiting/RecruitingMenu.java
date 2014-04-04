/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

/**
 *
 * @author prasanthi.p
 */
public class RecruitingMenu extends Composite {

    MenuBar recruitingMenuBar = new MenuBar(false);

    public RecruitingMenu() {
        initWidget(recruitingMenuBar);
        configureRecruitingMenu();
    }

    protected void configureRecruitingMenu() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            recruitingMenuBar.addItem("SkillSet Tags", skillSetTagsMaintainenceCmd);
        }
        recruitingMenuBar.addStyleName("entityMenuBar");
    }
    Command skillSetTagsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new SkillSetTagSidePanel());
        }
    };
}

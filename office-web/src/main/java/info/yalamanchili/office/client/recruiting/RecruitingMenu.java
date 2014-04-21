/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting;

import info.yalamanchili.office.client.recruiting.reports.SkillSetSearchPanel;
import info.yalamanchili.office.client.recruiting.skillsettag.SkillSetTagSidePanel;
import info.yalamanchili.office.client.recruiting.skillsettag.ReadAllSkillSetTagPanel;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.MenuBar;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.practice.PracticeSidePanel;
import info.yalamanchili.office.client.practice.ReadAllPracticePanel;
import info.yalamanchili.office.client.profile.certification.CertificationSidePanel;
import info.yalamanchili.office.client.profile.certification.ReadAllCertificationsPanel;
import info.yalamanchili.office.client.profile.skill.ReadAllSkillsPanel;
import info.yalamanchili.office.client.profile.skill.SkillSidePanel;
import info.yalamanchili.office.client.profile.technologyGroup.ReadAllTechnologyGroupPanel;
import info.yalamanchili.office.client.profile.technologyGroup.TechnologyGroupSidePanel;
import info.yalamanchili.office.client.recruiting.reports.ResumeSearchWidget;

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
            recruitingMenuBar.addItem("Skills", skillsMaintainenceCmd);
            recruitingMenuBar.addItem("Certifications", certificationsMaintainenceCmd);
            recruitingMenuBar.addItem("Practice", practiceMaintainenceCmd);
            recruitingMenuBar.addItem("TechnologyGroup", technologyGroupMaintainenceCmd);
            recruitingMenuBar.addItem("SkillSet Tags", skillSetTagsMaintainenceCmd);
            recruitingMenuBar.addItem("Find Candidates", reportsCmd);
        }
        recruitingMenuBar.addStyleName("entityMenuBar");
    }
    Command skillSetTagsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityTitlePanel.add(new RecruitingMenu());
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllSkillSetTagPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new SkillSetTagSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    Command practiceMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllPracticePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new PracticeSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    Command technologyGroupMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllTechnologyGroupPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new TechnologyGroupSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    Command reportsCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new SkillSetSearchPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.add(new ResumeSearchWidget());
        }
    };
    Command skillsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getRecruitingPanel().clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllSkillsPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new SkillSidePanel());
        }
    };
    Command certificationsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllCertificationsPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new CertificationSidePanel());
        }
    };
}

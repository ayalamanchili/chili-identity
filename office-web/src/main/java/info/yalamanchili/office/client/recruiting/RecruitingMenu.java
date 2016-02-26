/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting;

import info.yalamanchili.office.client.recruiting.reports.SkillSetSearchPanel;
import info.yalamanchili.office.client.recruiting.skillsettag.ReadAllSkillSetTagPanel;
import com.google.gwt.user.client.Command;
import info.chili.gwt.widgets.CMenuBar;
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
import info.yalamanchili.office.client.recruiting.reports.SkillSetReportSidePanel;

/**
 *
 * @author prasanthi.p
 */
public class RecruitingMenu extends CMenuBar {

    @Override
    protected void configureMenu() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            addMenuItem("Skills", "Skills", skillsMaintainenceCmd);
            addMenuItem("Certifications", "Certifications", certificationsMaintainenceCmd);
            addMenuItem("Practice", "Practice", practiceMaintainenceCmd);
            addMenuItem("TechnologyGroup", "TechnologyGroup", technologyGroupMaintainenceCmd);
            addMenuItem("SkillSet Tags", "SkillSet Tags", skillSetTagsMaintainenceCmd);
        }
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_CEO, Auth.ROLE.ROLE_RECRUITER)) {
            addMenuItem("Find Candidates", "Find Candidates", reportsCmd);
        }
    }
    static Command skillSetTagsMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().entityTitlePanel.add(new RecruitingMenu());
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllSkillSetTagPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    static Command practiceMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllPracticePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new PracticeSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    static Command technologyGroupMaintainenceCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllTechnologyGroupPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new TechnologyGroupSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
        }
    };
    static Command reportsCmd = new Command() {
        @Override
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanel.add(new SkillSetReportSidePanel());
            TabPanel.instance().getRecruitingPanel().sidePanel.add(new SkillSetSearchPanel());
            TabPanel.instance().getRecruitingPanel().sidePanel.add(new ResumeSearchWidget());

        }
    };
    static Command skillsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getRecruitingPanel().clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllSkillsPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new SkillSidePanel());
        }
    };
    static Command certificationsMaintainenceCmd = new Command() {
        public void execute() {
            TabPanel.instance().getRecruitingPanel().entityPanel.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelTop.clear();
            TabPanel.instance().getRecruitingPanel().sidePanelBottom.clear();
            TabPanel.instance().getRecruitingPanel().entityPanel.add(new ReadAllCertificationsPanel());
            TabPanel.instance().getRecruitingPanel().sidePanelTop.add(new CertificationSidePanel());
        }
    };
}

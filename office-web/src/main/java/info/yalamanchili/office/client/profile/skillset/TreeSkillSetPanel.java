/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skillset;

import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.certification.MuitiSelectCertificationWidget;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import java.util.logging.Logger;

/**
 *
 * @author ayalamanchili
 */
public class TreeSkillSetPanel extends TreePanelComposite {

    private static Logger logger = Logger.getLogger(TreeSkillSetPanel.class.getName());
    protected static final String SKILLS_NODE = "skills";
    protected static final String CERTIFICATIONS_NODE = "certifications";
    protected static final String PRACTICE_NODE = "Practice";
    protected static final String TECHNOLOGYGROUP_NODE = "Technology Group";

    public TreeSkillSetPanel(String empId) {
        init("SkillSet", OfficeWelcome.constants);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addFirstChildLink("Skills", SKILLS_NODE);
        addFirstChildLink("Certifications", CERTIFICATIONS_NODE);
        addFirstChildLink("Practice", PRACTICE_NODE);
        addFirstChildLink("Technology Group", TECHNOLOGYGROUP_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (SKILLS_NODE.equals(entityNodeKey) && ReadSkillSetPanel.instance().getEntityId() != null) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectSkillWidget("Skills", ReadSkillSetPanel.instance().getEntityId(), true, false));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectSkillWidget("Skills", ReadSkillSetPanel.instance().getEntityId(), false, false));
            }

        }
        if (CERTIFICATIONS_NODE.equals(entityNodeKey) && ReadSkillSetPanel.instance().getEntityId() != null) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MuitiSelectCertificationWidget("Certifications", ReadSkillSetPanel.instance().getEntityId(), true, false));
            } else {
                TabPanel.instance().myOfficePanel.entityPanel.add(new MuitiSelectCertificationWidget("Certifications", ReadSkillSetPanel.instance().getEntityId(), false, false));
            }
        }
        if (PRACTICE_NODE.equals(entityNodeKey) && ReadSkillSetPanel.instance().getEntityId() != null) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
//                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectPracticeWidget("Practice", ReadSkillSetPanel.instance().getEntityId(), true, false));
            } else {
//                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectPracticeWidget("Practice", ReadSkillSetPanel.instance().getEntityId(), false, false));
            }

        }
        if (TECHNOLOGYGROUP_NODE.equals(entityNodeKey) && ReadSkillSetPanel.instance().getEntityId() != null) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            if (Auth.hasOnlyUserRole()) {
//                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectTechnologyGroupWidget("Technology Group", ReadSkillSetPanel.instance().getEntityId(), true, false));
            } else {
//                TabPanel.instance().myOfficePanel.entityPanel.add(new MultiSelectTechnologyGroupWidget("Technology Group", ReadSkillSetPanel.instance().getEntityId(), false, false));
            }

        }
    }

    @Override
    public void loadEntity() {
    }

    @Override
    public void showEntity() {
    }
}

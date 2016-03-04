/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.skill;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite;
import java.util.logging.Logger;

/**
 *
 * @author prani
 */
public class SkillSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SkillSidePanel.class.getName());
    public FlowPanel skillSidePanel = new FlowPanel();
    //ClickableLink createSkillLink = new ClickableLink("Create Skill");

    public SkillSidePanel() {
        init(skillSidePanel);
    }

    @Override
    protected void addListeners() {
        //createSkillLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        /*if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_RECRUITER)) {
            skillSidePanel.add(createSkillLink);
        }*/
        skillSidePanel.add(new SearchSkillpanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        /*if (clickEvent.getSource().equals(createSkillLink)) {
            TabPanel.instance().recruitingPanel.entityPanel.clear();
            TabPanel.instance().recruitingPanel.entityPanel.add(new CreateSkillPanel(CreateComposite.CreateCompositeType.CREATE));
        }*/
    }
}

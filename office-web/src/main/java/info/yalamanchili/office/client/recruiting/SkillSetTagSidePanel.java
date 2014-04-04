/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author prasanthi.p
 */
public class SkillSetTagSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SkillSetTagSidePanel.class.getName());
    public FlowPanel skillSetTagSidePanel = new FlowPanel();
    ClickableLink createSkillSetTagLink = new ClickableLink("Create SkillSetTag");

    public SkillSetTagSidePanel() {
        init(skillSetTagSidePanel);
    }

    @Override
    protected void addListeners() {
        createSkillSetTagLink.addClickHandler(this);

    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_RECRUITER)) {
            skillSetTagSidePanel.add(createSkillSetTagLink);
        }
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(createSkillSetTagLink)) {
            TabPanel.instance().recruitingPanel.entityPanel.clear();
            TabPanel.instance().recruitingPanel.entityPanel.add(new CreateSkillSetTagPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}

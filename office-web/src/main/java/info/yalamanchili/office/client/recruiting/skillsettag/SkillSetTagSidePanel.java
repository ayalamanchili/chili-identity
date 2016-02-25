/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.recruiting.skillsettag;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import info.chili.gwt.composite.ALComposite;
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
    private IsWidget createSkillSetTagLink;

    public SkillSetTagSidePanel() {
        init(skillSetTagSidePanel);
    }

    @Override
    protected void addListeners() {

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
        if (event.getSource().equals(createSkillSetTagLink))
        {
            TabPanel.instance().recruitingPanel.entityPanel.clear();
            TabPanel.instance().recruitingPanel.entityPanel.add(new CreateSkillSetTagPanel());
        }
    }
}

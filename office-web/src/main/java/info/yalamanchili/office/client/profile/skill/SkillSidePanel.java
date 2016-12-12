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
import java.util.logging.Logger;

/**
 *
 * @author prani
 */
public class SkillSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(SkillSidePanel.class.getName());
    public FlowPanel skillSidePanel = new FlowPanel();

    public SkillSidePanel() {
        init(skillSidePanel);
    }

    @Override
    protected void addListeners() {

    }

    @Override
    protected void configure() {

    }

    @Override
    protected void addWidgets() {
        skillSidePanel.add(new SearchSkillpanel());
    }

    @Override
    public void onClick(ClickEvent clickEvent) {

    }
}

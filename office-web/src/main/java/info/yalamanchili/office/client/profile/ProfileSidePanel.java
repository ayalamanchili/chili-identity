/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import info.chili.gwt.composite.ALComposite;

import java.util.logging.Logger;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;

public class ProfileSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(ProfileSidePanel.class.getName());

    public FlowPanel adminSidePanel = new FlowPanel();

    public ProfileSidePanel() {
        init(adminSidePanel);
    }

    @Override
    public void onClick(ClickEvent clickEvent) {

    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void addWidgets() {

    }
}

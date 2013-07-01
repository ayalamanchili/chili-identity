/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.admin.activity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;

/**
 *
 * @author ayalamanchili
 */
public class CommunicationActivityOptionsWidget extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addActivityLink = new ClickableLink("Add Activity");

    public CommunicationActivityOptionsWidget() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addActivityLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    protected void addWidgets() {
        if (Auth.hasNonUserRoles()) {
            panel.add(addActivityLink);
        }

    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addActivityLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateCommunicationActivityPanel(CreateComposite.CreateCompositeType.CREATE));
        }
    }
}

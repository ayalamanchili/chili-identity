/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.yalamanchili.office.client.Auth.ROLE;

public class ClientInfoOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addClientInfoLink = new ClickableLink("Add Client Information");

    public ClientInfoOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addClientInfoLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_RELATIONSHIP, ROLE.ROLE_TIME, ROLE.ROLE_RECRUITER, ROLE.ROLE_HR)) {
            panel.add(addClientInfoLink);
        }

    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addClientInfoLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateClientInfoPanel(CreateCompositeType.ADD));
        }
    }
}

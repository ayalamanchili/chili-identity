/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.VerticalPanel;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.project.offboarding.CreateProjectOffBoardingPanel;

public class ClientInfoOptionsPanel extends ALComposite implements ClickHandler {

    protected VerticalPanel panel = new VerticalPanel();
    protected ClickableLink addClientInfoLink = new ClickableLink("Add Client Information");
    protected ClickableLink submitProjectEndDetails = new ClickableLink("Submit Project End Details");

    public ClientInfoOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addClientInfoLink.addClickHandler(this);
        submitProjectEndDetails.addClickHandler(this);
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
        panel.add(submitProjectEndDetails);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addClientInfoLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateClientInfoPanel(CreateCompositeType.ADD));
        }
        if (arg0.getSource().equals(submitProjectEndDetails)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateProjectOffBoardingPanel(CreateCompositeType.ADD));
        }
    }
}

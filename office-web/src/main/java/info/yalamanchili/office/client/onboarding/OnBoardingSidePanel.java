/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.onboarding;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class OnBoardingSidePanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(OnBoardingSidePanel.class.getName());
    public FlowPanel OnBoardingSidePanel = new FlowPanel();
    ClickableLink createEmployeeOnboardingLink = new ClickableLink("Employee Onboarding");

    public OnBoardingSidePanel() {
        init(OnBoardingSidePanel);
    }

    @Override
    protected void addListeners() {
        createEmployeeOnboardingLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        
    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(Auth.ROLE.ROLE_ADMIN, Auth.ROLE.ROLE_HR,Auth.ROLE.ROLE_ON_BOARDING_MGR)) {
            OnBoardingSidePanel.add(createEmployeeOnboardingLink);
        }
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
        if (clickEvent.getSource().equals(createEmployeeOnboardingLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new InitiateOnBoardingPanel());
        }
    }

}

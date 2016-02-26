/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.cllientinfo;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.CreateComposite.CreateCompositeType;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.project.offboarding.CreateProjectOffBoardingPanel;

public class ClientInfoOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink submitProjectEndDetails = new ClickableLink("Submit Project End Details");

    public ClientInfoOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        submitProjectEndDetails.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        panel.add(submitProjectEndDetails);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(submitProjectEndDetails)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateProjectOffBoardingPanel(CreateCompositeType.ADD));
        }
    }

    protected String getBISInfoUrl() {
        return OfficeWelcome.constants.root_url() + "clientinformation/bis-info/" + TreeEmployeePanel.instance().getEntityId();
    }   
}

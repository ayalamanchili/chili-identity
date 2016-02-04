/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.onboarding.CreateDependentsPanel;

/**
 *
 * @author radhika.mukkala
 */
public class DependentOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();

    protected ClickableLink addDependentsLink = new ClickableLink("Add Dependent");

    public DependentOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addDependentsLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);
    }

    @Override
    protected void addWidgets() {
        if (Auth.isAdmin() || Auth.isHR()) {
            panel.add(addDependentsLink);
        }
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addDependentsLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateDependentsPanel(CreateComposite.CreateCompositeType.ADD));
        }
    }
}


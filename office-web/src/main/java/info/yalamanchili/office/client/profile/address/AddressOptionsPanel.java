/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel.CreateAddressPanelType;

public class AddressOptionsPanel extends ALComposite implements ClickHandler {

    protected HorizontalPanel panel = new HorizontalPanel();
    protected ClickableLink addAddressLink = new ClickableLink("Add Address");

    public AddressOptionsPanel() {
        init(panel);
    }

    @Override
    protected void addListeners() {
        addAddressLink.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO move this to common css
        panel.setSpacing(5);

    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_TIME)) {
            panel.add(addAddressLink);
        }

    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addAddressLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressPanel(CreateAddressPanelType.ALL_WITH_NOTIFY));
        }
    }
}

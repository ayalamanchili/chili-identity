/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel.CreateAddressPanelType;
import java.util.logging.Logger;

public class AddressOptionsPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AddressOptionsPanel.class.getName());

    protected HorizontalPanel panel = new HorizontalPanel();
    protected Anchor addAddressLink = new Anchor("Add Address");
    protected Anchor manageHomeAddressL = new Anchor("Manage Home Address");
    protected String employeeId;
    protected String manageHomeAddressType;

    public AddressOptionsPanel() {
        init(panel);
    }

    public AddressOptionsPanel(String employeeId) {
        this.employeeId = employeeId;
        init(panel);
    }

    @Override
    protected void addListeners() {
        addAddressLink.addClickHandler(this);
        manageHomeAddressL.addClickHandler(this);
    }

    @Override
    protected void configure() {

        panel.setSpacing(5);
        HttpService.HttpServiceAsync.instance().doGet(manageAddressOptionsUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        logger.info("a" + arg0);
                        manageHomeAddressType = arg0.trim();
                    }
                });

    }

    protected String manageAddressOptionsUrl() {
        return OfficeWelcome.constants.root_url() + "address/options?employeeId=" + employeeId;

    }

    @Override
    protected void addWidgets() {
        if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR, ROLE.ROLE_TIME)) {
            panel.add(manageHomeAddressL);
            panel.add(addAddressLink);
        }
//TODO how is this visible to actual users with consultant role
    }

    @Override
    public void onClick(ClickEvent arg0) {
        if (arg0.getSource().equals(addAddressLink)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressPanel(CreateAddressPanelType.MIN));
        }
        if (arg0.getSource().equals(manageHomeAddressL)) {
            switch (manageHomeAddressType) {
                case "create":
                    if (TabPanel.instance().myOfficePanel.isVisible()) {
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
                        TabPanel.instance().myOfficePanel.entityPanel.add(new CreateHomeAddressPanel());
                    } else if (TabPanel.instance().profilePanel.isVisible()) {
                        TabPanel.instance().profilePanel.entityPanel.clear();
                        TabPanel.instance().profilePanel.entityPanel.add(new CreateHomeAddressPanel());
                    }
                    break;
                case "update":
                    if (TabPanel.instance().myOfficePanel.isVisible()) {
                        TabPanel.instance().myOfficePanel.entityPanel.clear();
//                        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateHomeAddressPanel());
                    } else if (TabPanel.instance().profilePanel.isVisible()) {
                        TabPanel.instance().profilePanel.entityPanel.clear();
//                        TabPanel.instance().profilePanel.entityPanel.add(new UpdateHomeAddressPanel());
                    }
                    break;
            }
        }
    }
}

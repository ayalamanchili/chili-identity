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
    protected String employeeId;

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
    }

    @Override
    protected void configure() {

        panel.setSpacing(5);
        HttpService.HttpServiceAsync.instance().doGet(manageAddressOptionsUrl(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {

                    @Override
                    public void onResponse(String arg0) {
                        renderAddressOptions(arg0);
                    }
                });

    }

    protected String manageAddressOptionsUrl() {
        return OfficeWelcome.constants.root_url() + "address/options?employeeId=" + employeeId;

    }

    protected void renderAddressOptions(String options) {
        switch (options.trim()) {
            case "create":
                Anchor createAnchor = new Anchor("Create Home Address");
                panel.add(createAnchor);
                logger.info("adding create home address link");
                createAnchor.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        if (TabPanel.instance().myOfficePanel.isVisible()) {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateHomeAddressPanel());
                        } else if (TabPanel.instance().profilePanel.isVisible()) {
                            TabPanel.instance().profilePanel.entityPanel.clear();
                            TabPanel.instance().profilePanel.entityPanel.add(new CreateHomeAddressPanel());
                        }
                    }
                }
                );
                break;
            case "update":
                Anchor updateAnchor = new Anchor("Update Home Address");
                panel.add(updateAnchor);
                updateAnchor.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        if (TabPanel.instance().myOfficePanel.isVisible()) {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
//                        TabPanel.instance().myOfficePanel.entityPanel.add(new UpdateHomeAddressPanel());
                        } else if (TabPanel.instance().profilePanel.isVisible()) {
                            TabPanel.instance().profilePanel.entityPanel.clear();
//                        TabPanel.instance().profilePanel.entityPanel.add(new UpdateHomeAddressPanel());
                        }
                    }
                }
                );
                break;
        }
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
            TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressPanel(CreateAddressPanelType.MIN));
        }
    }
}

/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile.address;

import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.Auth;
import info.yalamanchili.office.client.TabPanel;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.chili.gwt.widgets.GenericPopup;
import info.yalamanchili.office.client.Auth.ROLE;
import info.yalamanchili.office.client.OfficeWelcome;
import java.util.logging.Logger;

public class AddressOptionsPanel extends ALComposite implements ClickHandler {

    private static Logger logger = Logger.getLogger(AddressOptionsPanel.class.getName());

    protected HorizontalPanel panel = new HorizontalPanel();
    //protected ClickableLink addAddressLink = new ClickableLink("Add Address");
    protected ClickableLink manageHomeAddressL = new ClickableLink("");
    protected static HTML addressUpdateInstructions = new HTML("<ul>\n"
            + "<li><span style=\"font-size:14px;\">Please make sure your current Home/Primary Address is reflected in Portal<b>&nbsp;</b>as this will be used by all departments and systems.</span></li>\n"
            + "<li><span style=\"font-size:14px;\">When changing your Home/Primary Address in Portal please select the<strong> Notify Change</strong> check box to notify the appropriate departments.</span></li>\n"
            + "</ul>");

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
        //addAddressLink.addClickHandler(this);
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
                        switch (manageHomeAddressType) {
                            case "create":
                                manageHomeAddressL.setText("Create Home Address");
                                break;
                            case "update":
                                manageHomeAddressL.setText("Update Home Address");
                                break;
                        }
                    }
                });

    }

    protected String manageAddressOptionsUrl() {
        if (employeeId != null) {
            return OfficeWelcome.constants.root_url() + "address/options?id=" + employeeId;
        } else {
            return OfficeWelcome.constants.root_url() + "address/options";
        }

    }

    @Override
    protected void addWidgets() {
        if (TabPanel.instance().myOfficePanel.isVisible()) {
            if (Auth.hasAnyOfRoles(ROLE.ROLE_ADMIN, ROLE.ROLE_HR)) {
                panel.add(manageHomeAddressL);
                //panel.add(addAddressLink);
            }
        } else if (TabPanel.instance().profilePanel.isVisible()) {
            panel.add(manageHomeAddressL);
            //panel.add(addAddressLink);
        }
        panel.add(addressUpdateInstructions);
    }

    @Override
    public void onClick(ClickEvent arg0) {
        /*if (arg0.getSource().equals(addAddressLink)) {
         if (TabPanel.instance().myOfficePanel.isVisible()) {
         TabPanel.instance().myOfficePanel.entityPanel.clear();
         TabPanel.instance().myOfficePanel.entityPanel.add(new CreateAddressPanel(CreateAddressPanelType.ALL));
         } else if (TabPanel.instance().profilePanel.isVisible()) {
         new GenericPopup(new CreateAddressPanel(CreateAddressPanelType.ALL)).show();
         }
         }*/
        if (arg0.getSource().equals(manageHomeAddressL)) {
            if (TabPanel.instance().myOfficePanel.isVisible()) {
                TabPanel.instance().myOfficePanel.entityPanel.clear();
                TabPanel.instance().myOfficePanel.entityPanel.add(new CreateHomeAddressPanel());
            } else if (TabPanel.instance().profilePanel.isVisible()) {
                new GenericPopup(new CreateHomeAddressPanel()).show();
            }
        }
    }
}

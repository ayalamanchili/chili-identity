package info.yalamanchili.office.client.profile;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPopupPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPopupPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;
import info.yalamanchili.office.client.profile.reportsto.ReadAllReportsToPopupPanel;
import java.util.logging.Logger;

public class ProfileHome extends ALComposite {

    private static ProfileHome instance;

    public static ProfileHome instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(ProfileHome.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected DisclosurePanel phonesPanel;
    protected DisclosurePanel emailsPanel;
    protected DisclosurePanel addressesPanel;
    protected DisclosurePanel reportsTosPanel;
    protected DisclosurePanel emergencyContactsPanel;

    public ProfileHome() {
        instance = this;
        init(panel);
    }

    @Override
    protected void addListeners() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        panel.add(new ReadEmployeePanel(OfficeWelcome.instance().employee));
        addAddressesPanel();
        addPhonesPanel();
        addEmailsPanel();
        addReportsToPanel();
        addEmergencyContactsPanel();
        // TODO add disclosure planel for reports to and
        // emergency contact.
    }

    /*
     * Addresses
     */
    protected void addAddressesPanel() {
        if (panel.getWidgetIndex(phonesPanel) < 0) {
            addressesPanel = new DisclosurePanel("Addresses");
            panel.add(addressesPanel);

            addressesPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

                @Override
                public void onOpen(OpenEvent<DisclosurePanel> event) {
                    addressesPanel.setContent(
                            new ReadAllAddressesPopupPanel(OfficeWelcome.instance().employeeId));

                }
            });
        }
    }

    public void refreshAddresses() {
        addressesPanel.setOpen(false);
        addressesPanel.setOpen(true);
    }

    /**
     * Phones
     */
    protected void addPhonesPanel() {
        if (panel.getWidgetIndex(phonesPanel) < 0) {
            phonesPanel = new DisclosurePanel("Phones");
            panel.add(phonesPanel);

            phonesPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

                @Override
                public void onOpen(OpenEvent<DisclosurePanel> event) {
                    phonesPanel.setContent(
                            new ReadAllPhonesPopupPanel(OfficeWelcome.instance().employeeId));

                }
            });
        }
    }

    public void refreshPhones() {
        phonesPanel.setOpen(false);
        phonesPanel.setOpen(true);
    }
    /*
     * Emails
     */

    protected void addEmailsPanel() {
    	 if (panel.getWidgetIndex(emailsPanel) < 0){
    	/*emailsPanel = null;*/
        emailsPanel = new DisclosurePanel("Emails");
        panel.add(emailsPanel);
        emailsPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                emailsPanel.setContent(
                        new ReadAllEmailsPopupPanel(OfficeWelcome.instance().employeeId));

            }
        });
    	 }
    }
    public void refreshEmails() {
        emailsPanel.setOpen(false);
        emailsPanel.setOpen(true);
    }
    /*
     * ReportsTo
     */
    protected void addReportsToPanel() {
        reportsTosPanel = null;
        reportsTosPanel = new DisclosurePanel("ReportsTo");
        panel.add(reportsTosPanel);
        reportsTosPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                reportsTosPanel.setContent(
                        new ReadAllReportsToPopupPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public void refreshReportsTo() {
        reportsTosPanel.setOpen(false);
        reportsTosPanel.setOpen(true);
    }
    /*
     * emergency contact
     */

    protected void addEmergencyContactsPanel() {
        emergencyContactsPanel = null;
        emergencyContactsPanel = new DisclosurePanel("EmergencyContacts");
        panel.add(emergencyContactsPanel);
        emergencyContactsPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                emergencyContactsPanel.setContent(
                        new ReadAllEmergencyContactsPopupPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public void refreshEmergencyContactsPanel() {
        emergencyContactsPanel.setOpen(false);
        emergencyContactsPanel.setOpen(true);
    }
}

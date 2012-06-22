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
    protected DisclosurePanel employeeePanel;
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
        addEmployeePanel();
        addAddressesPanel();
        addPhonesPanel();
        addEmailsPanel();
        addReportsToPanel();
        addEmergencyContactsPanel();
    }
    /*
     * Read Employee Panel
     */
    
    protected void addEmployeePanel() {
        if (panel.getWidgetIndex(employeeePanel) < 0) {
            employeeePanel = new DisclosurePanel("Profile");
            panel.add(employeeePanel);
            employeeePanel.addStyleName("profileHome");
            employeeePanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
                @Override
                public void onOpen(OpenEvent<DisclosurePanel> event) {
                    employeeePanel.setContent(new ReadEmployeePanel(OfficeWelcome.instance().employee));
                    
                }
            });
            employeeePanel.setOpen(true);
        }
    }
    /*
     * Addresses
     */
    
    protected void addAddressesPanel() {
        if (panel.getWidgetIndex(phonesPanel) < 0) {
            addressesPanel = new DisclosurePanel("Addresses");
            panel.add(addressesPanel);
            addressesPanel.addStyleName("profileHome");
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
            phonesPanel.addStyleName("profileHome");
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
        if (panel.getWidgetIndex(emailsPanel) < 0) {
            /*emailsPanel = null;*/
            emailsPanel = new DisclosurePanel("Emails");
            panel.add(emailsPanel);
            emailsPanel.addStyleName("profileHome");
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
        reportsTosPanel = new DisclosurePanel("ReportsTo");
        panel.add(reportsTosPanel);
        reportsTosPanel.addStyleName("profileHome");
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
        emergencyContactsPanel = new DisclosurePanel("EmergencyContacts");
        panel.add(emergencyContactsPanel);
        emergencyContactsPanel.addStyleName("profileHome");
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

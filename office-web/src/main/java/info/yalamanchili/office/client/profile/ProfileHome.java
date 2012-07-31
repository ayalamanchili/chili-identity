package info.yalamanchili.office.client.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPopupPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPopupPanel;
import info.yalamanchili.office.client.profile.employee.UpdateEmployeePopupPanel;
import info.yalamanchili.office.client.profile.employee.ChangePasswordPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPopupPanel;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPopupPanel;
import java.util.logging.Logger;

public class ProfileHome extends ALComposite implements ClickHandler {

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
    protected DisclosurePanel clientInfoPanel;
    protected DisclosurePanel emergencyContactsPanel;
    protected DisclosurePanel skillSetPanel;
    protected ClickableLink updateProfile = new ClickableLink("Update Profile");
    protected ClickableLink changePassword = new ClickableLink("Change Password");

    public ProfileHome() {
        instance = this;
        init(panel);
    }

    @Override
    protected void addListeners() {
        updateProfile.addClickHandler(this);
        changePassword.addClickHandler(this);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addWidgets() {
        addEmployeePanel();
        panel.add(updateProfile);
        panel.add(changePassword);
        addAddressesPanel();
        addPhonesPanel();
        addEmailsPanel();
        addClientInfoPanel();
        addEmergencyContactsPanel();
        addSkillSetPanel();
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

    public void refreshEmployeePanel() {
        employeeePanel.setOpen(false);
        employeeePanel.setOpen(true);
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
     * Client Information
     */

    protected void addClientInfoPanel() {
        clientInfoPanel = new DisclosurePanel("Client Information");
        panel.add(clientInfoPanel);
        clientInfoPanel.addStyleName("profileHome");
        clientInfoPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                clientInfoPanel.setContent(
                        new ReadAllClientInfoPopupPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public void refreshClientInformation() {
        clientInfoPanel.setOpen(false);
        clientInfoPanel.setOpen(true);
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
    /* SkillSet Panel */

    protected void addSkillSetPanel() {
        skillSetPanel = new DisclosurePanel("SkillSet");
        panel.add(skillSetPanel);
        skillSetPanel.addStyleName("profileHome");
        skillSetPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                skillSetPanel.setContent(
                        new ReadSkillSetPopupPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public void refreshSkillSetPanel() {
        skillSetPanel.setOpen(false);
        skillSetPanel.setOpen(true);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updateProfile)) {
            UpdateEmployeePopupPanel UpdatePanel = new UpdateEmployeePopupPanel(OfficeWelcome.instance().employee);
            new GenericPopup(UpdatePanel).show();
        }
        else if(event.getSource().equals(changePassword))
        {
            ChangePasswordPanel cngPasswordPanel = new  ChangePasswordPanel(CreateComposite.CreateCompositeType.CREATE);
            new GenericPopup(cngPasswordPanel).show();
        }
    }
}

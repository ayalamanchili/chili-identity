/**
 * System Soft Technolgies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPopupPanel;
import info.yalamanchili.office.client.profile.certification.MuitiSelectCertificationWidget;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPopupPanel;
import info.yalamanchili.office.client.profile.employee.UpdateEmployeePopupPanel;
import info.yalamanchili.office.client.profile.employee.ChangePasswordPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPopupPanel;
import info.yalamanchili.office.client.profile.preferences.UpdatePreferencesPanel;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import info.yalamanchili.office.client.profile.skillset.CreateSkillSetPanel;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPopupPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.companycontact.ReadAllCompanyContactPanel;
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
    protected DisclosurePanel companyContactsPanel;
    protected DisclosurePanel skillSetDP;
    protected DisclosurePanel preferencesPanel;
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
        addCompanyContactsPanel();
        addSkillSetPanel();
        addPreferencesPanel();
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
    /*
     *company contact
     */

    protected void addCompanyContactsPanel() {
        companyContactsPanel = new DisclosurePanel("CompanyContacts");
        panel.add(companyContactsPanel);
        companyContactsPanel.addStyleName("profileHome");
        companyContactsPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                companyContactsPanel.setContent(
                        new ReadAllCompanyContactPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }
    /* SkillSet Panel */
//TODO clean up

    protected void addSkillSetPanel() {
        skillSetDP = new DisclosurePanel("SkillSet");
        final FlowPanel skillSetPanel = new FlowPanel();
        panel.add(skillSetDP);
        skillSetDP.addStyleName("profileHome");
        skillSetDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                skillSetDP.setContent(skillSetPanel);
                skillSetPanel.clear();
                HttpService.HttpServiceAsync.instance().doGet(getSkillSetUrl(OfficeWelcome.instance().employeeId), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null && !response.isEmpty()) {
                            JSONObject skillSet = (JSONObject) JSONParser.parseLenient(response);
                            skillSetPanel.add(new ReadSkillSetPopupPanel(OfficeWelcome.instance().employeeId));
                            skillSetPanel.add(new MultiSelectSkillWidget("Skills", JSONUtils.toString(skillSet, "id"), false, false));
                            skillSetPanel.add(new MuitiSelectCertificationWidget("Certifications", JSONUtils.toString(skillSet, "id"), false, false));
                        } else {
                            TabPanel.instance().myOfficePanel.entityPanel.clear();
                            skillSetPanel.add(new CreateSkillSetPanel(OfficeWelcome.instance().employeeId));
                        }
                    }
                });


            }
        });
    }
//TODO remove and access from ReadAllSkillSetPanel

    public String getSkillSetUrl(String empId) {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + empId;
    }

    public void refreshSkillSetPanel() {
        skillSetDP.setOpen(false);
        skillSetDP.setOpen(true);
    }

    protected void addPreferencesPanel() {
        preferencesPanel = new DisclosurePanel("Preferences");
        panel.add(preferencesPanel);
        preferencesPanel.addStyleName("profileHome");
        preferencesPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                HttpService.HttpServiceAsync.instance().doGet(getPreferencesURI(), OfficeWelcome.instance().getHeaders(), true,
                        new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        JSONObject preferences = JSONParser.parseLenient(arg0).isObject();
                        if (arg0 != null && preferences != null) {
                            preferencesPanel.clear();
                            preferencesPanel.setContent(
                                    new UpdatePreferencesPanel(preferences));
                        }
                    }
                });


            }
        });
    }

    public void refreshPreferencesPanel() {
        preferencesPanel.setOpen(false);
        preferencesPanel.setOpen(true);
    }

    protected String getPreferencesURI() {
        return OfficeWelcome.constants.root_url() + "employee/preferences/" + OfficeWelcome.instance().employeeId;
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(updateProfile)) {
            UpdateEmployeePopupPanel updatePanel = new UpdateEmployeePopupPanel(OfficeWelcome.instance().employee);
            new GenericPopup(updatePanel).show();
        } else if (event.getSource().equals(changePassword)) {
            ChangePasswordPanel cngPasswordPanel = new ChangePasswordPanel(CreateComposite.CreateCompositeType.CREATE);
            new GenericPopup(cngPasswordPanel).show();
        }
    }
}

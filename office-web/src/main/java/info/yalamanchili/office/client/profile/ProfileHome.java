/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import info.chili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPopupPanel;

import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.utils.JSONUtils;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPopupPanel;
import info.yalamanchili.office.client.profile.certification.MuitiSelectCertificationWidget;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPopupPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPopupPanel;
import info.yalamanchili.office.client.profile.preferences.UpdatePreferencesPanel;
import info.yalamanchili.office.client.profile.skill.MultiSelectSkillWidget;
import info.yalamanchili.office.client.profile.skillset.CreateSkillSetPanel;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPopupPanel;
import info.chili.gwt.rpc.HttpService;
import info.yalamanchili.office.client.companycontact.ReadAllCompanyContactPanel;
import info.yalamanchili.office.client.profile.benefits.RetirementPlanOptInPanel;
import info.yalamanchili.office.client.profile.benefits.RetirementPlanOptOutPanel;
import info.yalamanchili.office.client.profile.benefits.RetirementPlanReadPanel;
import info.yalamanchili.office.client.profile.empdoc.ReadAllEmpDocsPopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePopupPanel;
import info.yalamanchili.office.client.profile.privacy.ReadAllPrivacySettingPopupPanel;
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
    protected DisclosurePanel clientInfoPanel;
    protected DisclosurePanel emergencyContactsPanel;
    protected DisclosurePanel companyContactsPanel;
    protected DisclosurePanel privacyPanel;
    protected DisclosurePanel skillSetDP;
    protected DisclosurePanel preferencesPanel;
    protected DisclosurePanel documentsPanel;
    protected DisclosurePanel benefitsDP;

    public ProfileHome() {
        instance = this;
        init(panel);
    }

    @Override
    protected void configure() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void addWidgets() {
        addEmployeePanel();
        addAddressesPanel();
        addPhonesPanel();
        addEmailsPanel();
        addClientInfoPanel();
        addEmergencyContactsPanel();
        addCompanyContactsPanel();
        addSkillSetPanel();
        addEmpDocsPanel();
        addBenefitsPanel();
        addPreferencesPanel();
        addPrivacyPanel();
        employeeePanel.setOpen(true);
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
                    employeeePanel.setContent(new ReadEmployeePopupPanel(OfficeWelcome.instance().employee));
                }
            });
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
        if (panel.getWidgetIndex(addressesPanel) < 0) {
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
        emergencyContactsPanel = new DisclosurePanel("Emergency Contacts");
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
        companyContactsPanel = new DisclosurePanel("Company Contacts");
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
        skillSetDP = new DisclosurePanel("Skill Set");
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

    protected void addBenefitsPanel() {
        benefitsDP = new DisclosurePanel("Benefits");
        panel.add(benefitsDP);
        benefitsDP.addStyleName("profileHome");
        benefitsDP.addOpenHandler(new OpenHandler<DisclosurePanel>() {
            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                benefitsDP.clear();
                benefitsDP.setContent(new RetirementPlanReadPanel());
            }
        });
    }

    public void refreshBenifitsPanel() {
        benefitsDP.setOpen(false);
        benefitsDP.setOpen(true);
    }

    protected String getBenifitsURI() {
        return OfficeWelcome.constants.root_url() + "retirement-plan";
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
    /*
     *Privacy
     */

    protected void addPrivacyPanel() {
        if (panel.getWidgetIndex(privacyPanel) < 0) {
            privacyPanel = new DisclosurePanel("Privacy");
            panel.add(privacyPanel);
            privacyPanel.addStyleName("profileHome");
            privacyPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
                @Override
                public void onOpen(OpenEvent<DisclosurePanel> event) {
                    privacyPanel.setContent(
                            new ReadAllPrivacySettingPopupPanel(OfficeWelcome.instance().employeeId));
                }
            });
        }
    }

    public void refreshPrivacy() {
        privacyPanel.setOpen(false);
        privacyPanel.setOpen(true);
    }
    /*
     * Emp Documents 
     */

    protected void addEmpDocsPanel() {
        if (panel.getWidgetIndex(documentsPanel) < 0) {
            documentsPanel = new DisclosurePanel("Documents");
            panel.add(documentsPanel);
            documentsPanel.addStyleName("profileHome");
            documentsPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {
                @Override
                public void onOpen(OpenEvent<DisclosurePanel> event) {
                    documentsPanel.setContent(
                            new ReadAllEmpDocsPopupPanel(OfficeWelcome.instance().employeeId));
                }
            });
        }
    }

    public void refreshEmpDocs() {
        documentsPanel.setOpen(false);
        documentsPanel.setOpen(true);
    }
}

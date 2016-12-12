/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.StackPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.ALComposite;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ClickableLink;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPopupPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPopupPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPopupPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePopupPanel;
import info.yalamanchili.office.client.profile.insurance.ProfileBenefitsPanelWidget;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPopupPanel;
import info.yalamanchili.office.client.profile.preferences.PreferencesPanel;
import info.yalamanchili.office.client.profile.privacy.ReadAllPrivacySettingPopupPanel;
import info.yalamanchili.office.client.profile.skillset.UpdateSkillSetPopupPanel;

/**
 *
 * @author prasanthi.p
 */
public class ProfileHomeStackPanel extends ALComposite implements ClickHandler {

    protected StackPanel panel = new StackPanel();
    protected FlowPanel mainProfilePanel = new FlowPanel();
    protected ClickableLink profilePanel = new ClickableLink("Profile");
    protected ClickableLink addressesPanel = new ClickableLink("Addresses");
    protected ClickableLink phonesPanel = new ClickableLink("Phones");
    protected ClickableLink emailsPanel = new ClickableLink("Emails");
    protected ClickableLink clientPanel = new ClickableLink("Client Information");
    protected ClickableLink skillPanel = new ClickableLink("Skill Set");
    protected ClickableLink preferencesPanel = new ClickableLink("Preferences");
    protected ClickableLink privacyPanel = new ClickableLink("Privacy");
    EmployeeFormsAndDocsWidget formsAndDocsPanel = new EmployeeFormsAndDocsWidget();
    ProfileStackPanelWidget contactsPanel = new ProfileStackPanelWidget();
    ProfileImmigraStackPanelWidget immigrationPanel = new ProfileImmigraStackPanelWidget();
    ProfileBenefitsPanelWidget benefitsPanel = new ProfileBenefitsPanelWidget();

    public ProfileHomeStackPanel() {
        init(panel);
        // setSelectItem();
    }

    @Override
    protected void addListeners() {
        profilePanel.addClickHandler(this);
        addressesPanel.addClickHandler(this);
        phonesPanel.addClickHandler(this);
        emailsPanel.addClickHandler(this);
        clientPanel.addClickHandler(this);
        skillPanel.addClickHandler(this);
        preferencesPanel.addClickHandler(this);
        privacyPanel.addClickHandler(this);
    }

    @Override
    protected void configure() {
        TabPanel.instance().profilePanel.sidePanelTop.setHeight("100%");
    }

    @Override
    protected void addWidgets() {
        panel.add(profilePanel, "Profile");
        panel.add(addressesPanel, "Addresses");
        panel.add(phonesPanel, "Phones");
        panel.add(emailsPanel, "Emails");
        panel.add(clientPanel, "Client Information");
        panel.add(contactsPanel, "Contacts");
        panel.add(formsAndDocsPanel, "Forms & Docs");
        panel.add(skillPanel, "Skill Set");
        panel.add(benefitsPanel, "Benefits");
        panel.add(preferencesPanel, "Preferences");
        panel.add(privacyPanel, "Privacy");
        panel.add(immigrationPanel, "Immigration");
    }

//TODO this does not seem to be working
    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(profilePanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadEmployeePopupPanel(OfficeWelcome.instance().employee));
        }
        if (event.getSource().equals(addressesPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllAddressesPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(phonesPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllPhonesPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(emailsPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllEmailsPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(clientPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllClientInfoPopupPanel(OfficeWelcome.instance().employeeId));
        }
        if (event.getSource().equals(skillPanel)) {
            HttpService.HttpServiceAsync.instance().doGet(getSkillSetUrl(OfficeWelcome.instance().employeeId), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String response) {
                            TabPanel.instance().profilePanel.entityPanel.clear();
                            TabPanel.instance().profilePanel.entityPanel.add(new UpdateSkillSetPopupPanel(JSONParser.parseLenient(response).isObject()));
                        }
                    });
        }
        if (event.getSource().equals(preferencesPanel)) {
            HttpService.HttpServiceAsync.instance().doGet(getPreferencesURI(), OfficeWelcome.instance().getHeaders(), true,
                    new ALAsyncCallback<String>() {
                        @Override
                        public void onResponse(String arg0) {
                            JSONObject preferences = JSONParser.parseLenient(arg0).isObject();
                            if (arg0 != null && preferences != null) {
                                TabPanel.instance().profilePanel.entityPanel.clear();
                                TabPanel.instance().profilePanel.entityPanel.add(new PreferencesPanel(preferences));

                            }
                        }
                    });
        }
        if (event.getSource().equals(privacyPanel)) {
            TabPanel.instance().profilePanel.entityPanel.clear();
            TabPanel.instance().profilePanel.entityPanel.add(new ReadAllPrivacySettingPopupPanel(OfficeWelcome.instance().employeeId));
        }
    }

    private String getSkillSetUrl(String employeeId) {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + employeeId;
    }

    private String getPreferencesURI() {
        return OfficeWelcome.constants.root_url() + "employee/preferences/" + OfficeWelcome.instance().employeeId;
    }
}

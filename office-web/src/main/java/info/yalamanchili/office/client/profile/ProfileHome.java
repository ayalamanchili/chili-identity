package info.yalamanchili.office.client.profile;

import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import info.yalamanchili.gwt.composite.ALComposite;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.gwt.JSONUtils;
import info.yalamanchili.office.client.gwt.TableRowOptionsWidget.OptionsType;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.employee.ReadEmployeePanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPanel;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlowPanel;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.address.CreateAddressPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.address.UpdateAddressPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.UpdateEmergencyContactPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.yalamanchili.office.client.profile.phone.UpdatePhonePanel;
import info.yalamanchili.office.client.profile.reportsto.ReadAllReportsToPanel;
import info.yalamanchili.office.client.profile.reportsto.UpdateReportsToPanel;
import java.util.logging.Logger;

public class ProfileHome extends ALComposite {

    private static Logger logger = Logger.getLogger(ProfileHome.class.getName());
    protected FlowPanel panel = new FlowPanel();
    protected DisclosurePanel phonesPanel;
    protected DisclosurePanel emailsPanel;
    protected DisclosurePanel addressesPanel;
    protected DisclosurePanel reportsTosPanel;
    protected DisclosurePanel emergencyContactsPanel;

    public ProfileHome() {
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
                            new ProfileReadAllAddressesPanel(OfficeWelcome.instance().employeeId));

                }
            });
        }
    }

    public class ProfileReadAllAddressesPanel extends ReadAllAddressesPanel {

        public ProfileReadAllAddressesPanel(String parentId) {
            super(parentId);
        }

        @Override
        protected void addOptionsWidget(int row, JSONObject entity) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }

        @Override
        public void updateClicked(String entityId) {
            ProfileUpdateAddressPanel updateaddressPanel = new ProfileUpdateAddressPanel(getEntity(entityId));
            new GenericPopup(updateaddressPanel).show();
        }

        @Override
        public void postDeleteSuccess() {
            addressesPanel.setOpen(false);
            addressesPanel.setOpen(true);
        }

        @Override
        protected void configureCreateButton() {
            createButton.setVisible(true);
        }

        @Override
        protected void createButtonClicked() {
            ProfileCreateAddressesPanel createPanel = new ProfileCreateAddressesPanel(CreateComposite.CreateCompositeType.ADD);;
            new GenericPopup(createPanel).show();
        }
    }

    public class ProfileCreateAddressesPanel extends CreateAddressPanel {

        public ProfileCreateAddressesPanel(CreateCompositeType type) {
            super(type);
        }

        @Override
        protected String getURI() {
            return OfficeWelcome.constants.root_url() + "employee/address/" + OfficeWelcome.instance().employeeId;
        }

        @Override
        protected void postCreateSuccess(String result) {
            GenericPopup.instance().hide();
            addressesPanel.setOpen(false);
            addressesPanel.setOpen(true);
        }
    }

    public class ProfileUpdateAddressPanel extends UpdateAddressPanel {

        public ProfileUpdateAddressPanel(JSONObject entity) {
            super(entity);
        }

        @Override
        protected void postUpdateSuccess(String result) {
            GenericPopup.instance().hide();
            addressesPanel.setOpen(false);
            addressesPanel.setOpen(true);
        }
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
                            new ProfileReadAllPhonesPanel(OfficeWelcome.instance().employeeId));

                }
            });
        }
    }

    public class ProfileReadAllPhonesPanel extends ReadAllPhonesPanel {

        public ProfileReadAllPhonesPanel(String parentId) {
            super(parentId);
        }

        @Override
        protected void addOptionsWidget(int row, JSONObject entity) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }

        @Override
        public void updateClicked(String entityId) {
            ProfileUpdatePhonePanel updatePhonePanel = new ProfileUpdatePhonePanel(getEntity(entityId));
            new GenericPopup(updatePhonePanel).show();
        }

        @Override
        public void postDeleteSuccess() {
            phonesPanel.setOpen(false);
            phonesPanel.setOpen(true);
        }
    }

    public class ProfileUpdatePhonePanel extends UpdatePhonePanel {

        public ProfileUpdatePhonePanel(JSONObject entity) {
            super(entity);
        }

        @Override
        protected void postUpdateSuccess(String result) {
            GenericPopup.instance().hide();
            phonesPanel.setOpen(false);
            phonesPanel.setOpen(true);
        }
    }

    /*
     * Emails
     */
    protected void addEmailsPanel() {
        emailsPanel = null;
        emailsPanel = new DisclosurePanel("Emails");
        panel.add(emailsPanel);
        emailsPanel.addOpenHandler(new OpenHandler<DisclosurePanel>() {

            @Override
            public void onOpen(OpenEvent<DisclosurePanel> event) {
                emailsPanel.setContent(
                        new ReadAllEmailsPanel(OfficeWelcome.instance().employeeId));

            }
        });
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
                        new ProfileReadAllReportsToPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public class ProfileReadAllReportsToPanel extends ReadAllReportsToPanel {

        public ProfileReadAllReportsToPanel(String parentId) {
            super(parentId);
        }

        @Override
        protected void addOptionsWidget(int row, JSONObject entity) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }

        @Override
        public void updateClicked(String entityId) {
            ProfileUpdateReportsToPanel updateReportsToPanel = new ProfileUpdateReportsToPanel(getEntity(entityId));
            new GenericPopup(updateReportsToPanel).show();
        }

        @Override
        public void postDeleteSuccess() {
            reportsTosPanel.setOpen(false);
            reportsTosPanel.setOpen(true);
        }
    }

    public class ProfileUpdateReportsToPanel extends UpdateReportsToPanel {

        public ProfileUpdateReportsToPanel(JSONObject entity) {
            super(entity);
        }

        @Override
        protected void postUpdateSuccess(String result) {
            GenericPopup.instance().hide();
            reportsTosPanel.setOpen(false);
            reportsTosPanel.setOpen(true);
        }
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
                        new ProfileReadAllEmergencyContactsPanel(OfficeWelcome.instance().employeeId));

            }
        });
    }

    public class ProfileReadAllEmergencyContactsPanel extends ReadAllEmergencyContactsPanel {

        public ProfileReadAllEmergencyContactsPanel(String parentId) {
            super(parentId);
        }

        @Override
        protected void addOptionsWidget(int row, JSONObject entity) {
            createOptionsWidget(OptionsType.READ_UPDATE_DELETE, row, JSONUtils.toString(entity, "id"));
        }

        @Override
        public void updateClicked(String entityId) {
            ProfileUpdateEmergencyContactPanel updateEmergencyContactPanel = new ProfileUpdateEmergencyContactPanel(getEntity(entityId));
            new GenericPopup(updateEmergencyContactPanel).show();
        }

        @Override
        public void postDeleteSuccess() {
            emergencyContactsPanel.setOpen(false);
            emergencyContactsPanel.setOpen(true);
        }
    }

    public class ProfileUpdateEmergencyContactPanel extends UpdateEmergencyContactPanel {

        public ProfileUpdateEmergencyContactPanel(JSONObject entity) {
            super(entity);
        }

        @Override
        protected void postUpdateSuccess(String result) {
            GenericPopup.instance().hide();
            emergencyContactsPanel.setOpen(false);
            emergencyContactsPanel.setOpen(true);
        }
    }
}

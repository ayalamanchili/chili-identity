package info.yalamanchili.office.client.profile.employee;

import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.TreePanelComposite;
import info.yalamanchili.office.client.profile.address.AddressOptionsPanel;
import info.yalamanchili.office.client.profile.address.ReadAllAddressesPanel;
import info.yalamanchili.office.client.profile.email.EmailOptionsPanel;
import info.yalamanchili.office.client.profile.email.ReadAllEmailsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.EmergencyContactOptionsPanel;
import info.yalamanchili.office.client.profile.emergencycnt.ReadAllEmergencyContactsPanel;
import info.yalamanchili.office.client.profile.phone.PhoneOptionsPanel;
import info.yalamanchili.office.client.profile.phone.ReadAllPhonesPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ReadAllClientInfoPanel;
import info.yalamanchili.office.client.profile.cllientinfo.ClientInfoOptionsPanel;

import com.google.gwt.json.client.JSONObject;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPanel;

public class TreeEmployeePanel extends TreePanelComposite {

    protected static final String ADDRESS_NODE = "address";
    protected static final String EMAIL_NODE = "email";
    protected static final String PHONE_NODE = "phone";
    protected static final String REPORTS_TO_NODE = "clientInfo";
    protected static final String EMERGENCY_CONTACT_NODE = "emergencyContact";
    protected static final String SkillSet_NODE = "skillset";
    protected static final String ChangePassword_NODE = "changepassword";

    public TreeEmployeePanel(String entityId) {
        super(entityId);
        init("Employee", OfficeWelcome.constants);
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
        addFirstChildLink("Addresses", ADDRESS_NODE);
        addFirstChildLink("Emails", EMAIL_NODE);
        addFirstChildLink("Phones", PHONE_NODE);
        addFirstChildLink("Client Information", REPORTS_TO_NODE);
        addFirstChildLink("Emergency Contacts", EMERGENCY_CONTACT_NODE);
        addFirstChildLink("Skill Set", SkillSet_NODE);
        addFirstChildLink("Change Password",ChangePassword_NODE);
    }

    @Override
    public void treeNodeSelected(String entityNodeKey) {
        if (ADDRESS_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllAddressesPanel(entityId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new AddressOptionsPanel());
        }
        if (EMAIL_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(entityId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new EmailOptionsPanel());
        }
        if (PHONE_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPhonesPanel(entityId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new PhoneOptionsPanel());
        }
        if (REPORTS_TO_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllClientInfoPanel(entityId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new ClientInfoOptionsPanel());
        }
        if (EMERGENCY_CONTACT_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmergencyContactsPanel(entityId));
            TabPanel.instance().myOfficePanel.entityPanel.add(new EmergencyContactOptionsPanel());
        }
        if (SkillSet_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(entityId));
        }
         if (ChangePassword_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ChangePasswordPanel(CreateComposite.CreateCompositeType.CREATE));
            
        }
    }

    @Override
    public JSONObject loadEntity() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void showEntity() {
        // TODO Auto-generated method stub
    }
}

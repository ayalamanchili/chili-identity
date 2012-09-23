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
import com.google.gwt.json.client.JSONParser;
import info.yalamanchili.gwt.callback.ALAsyncCallback;
import info.yalamanchili.office.client.gwt.CreateComposite;
import info.yalamanchili.office.client.profile.password.ResetPasswordPanel;
import info.yalamanchili.office.client.profile.skillset.ReadSkillSetPanel;
import info.yalamanchili.office.client.profile.skillset.TreeSkillSetPanel;
import info.yalamanchili.office.client.rpc.HttpService;
import java.util.logging.Logger;

public class TreeEmployeePanel extends TreePanelComposite {

    private static TreeEmployeePanel instance;

    public static TreeEmployeePanel instance() {
        return instance;
    }
    private static Logger logger = Logger.getLogger(TreeEmployeePanel.class.getName());
    protected static final String ADDRESS_NODE = "address";
    protected static final String EMAIL_NODE = "email";
    protected static final String PHONE_NODE = "phone";
    protected static final String REPORTS_TO_NODE = "clientInfo";
    protected static final String EMERGENCY_CONTACT_NODE = "emergencyContact";
    protected static final String SKILL_SET_NODE = "skillset";
    protected static final String RESET_PASSWORD_NODE = "resetpassword";
    protected TreeSkillSetPanel skillSetTreePanel;

    public TreeEmployeePanel(String entityId) {
        super(entityId);
        instance = this;
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
        HttpService.HttpServiceAsync.instance().doGet(getSkillSetURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String arg0) {
                        if (arg0 != null && JSONParser.parseLenient(arg0).isObject() != null) {
                            skillSetTreePanel = new TreeSkillSetPanel(JSONParser.parseLenient(arg0).isObject());
                            addFirstChildLink("Skill Set", SKILL_SET_NODE, skillSetTreePanel.getRoot());
                        }
                    }
                });
        addFirstChildLink("Reset Password", RESET_PASSWORD_NODE);
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
        if (SKILL_SET_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ReadSkillSetPanel(entityId));
        }
        if (RESET_PASSWORD_NODE.equals(entityNodeKey)) {
            TabPanel.instance().myOfficePanel.entityPanel.clear();
            TabPanel.instance().myOfficePanel.entityPanel.add(new ResetPasswordPanel(CreateComposite.CreateCompositeType.CREATE));

        } //TODO review
        else if (skillSetTreePanel != null) {
            skillSetTreePanel.treeNodeSelected(entityNodeKey);
        }
    }

    @Override
    public JSONObject loadEntity() {
        return OfficeWelcome.instance().employee;
    }

    @Override
    public void showEntity() {
        // TODO Auto-generated method stub
    }

    protected String getSkillSetURI() {
        return OfficeWelcome.constants.root_url() + "employee/skillset/" + entityId;
    }
}

package info.yalamanchili.office.client.profile;

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
import info.yalamanchili.office.client.gwt.GenericPopup;
import info.yalamanchili.office.client.profile.phone.UpdatePhonePanel;

public class ProfileHome extends ALComposite {

    protected static final int READ_EMPLOYEE_WIDGET_INDEX = 0;
    protected static final int READ_EMPLOYEE_PHONES_WIDGET_INDEX = 1;
    protected static final int READ_EMPLOYEE_EMAILS_WIDGET_INDEX = 2;
    protected static final int READ_EMPLOYEE_ADDRESSES_WIDGET_INDEX = 3;
    protected static final int READ_EMPLOYEE_REPORTSTO_WIDGET_INDEX = 4;
    protected static final int READ_EMPLOYEE_EMERGENCYCNT_WIDGET_INDEX = 5;
    protected FlowPanel panel = new FlowPanel();

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
        // TODO check for null pointer
        JSONObject employee = OfficeWelcome.instance().user.get("employee").isObject();
        panel.insert(new ReadEmployeePanel(employee), READ_EMPLOYEE_WIDGET_INDEX);
        panel.insert(getPhonesPanel(employee.get("id").isString().stringValue()), READ_EMPLOYEE_PHONES_WIDGET_INDEX);
        panel.insert(getEmailsPanel(employee.get("id").isString().stringValue()), READ_EMPLOYEE_EMAILS_WIDGET_INDEX);
        // TODO add disclosure planel for reports to and
        // emergency contact.
    }

    protected void refreshPhones() {
        panel.remove(READ_EMPLOYEE_PHONES_WIDGET_INDEX);
        panel.insert(getPhonesPanel(OfficeWelcome.instance().user.get("employee").isObject().get("id").isString().stringValue()), READ_EMPLOYEE_PHONES_WIDGET_INDEX);

    }

    protected DisclosurePanel getPhonesPanel(String empId) {
        DisclosurePanel phonesPanel = new DisclosurePanel("Phones");
        phonesPanel.setContent(new ProfileReadAllPhonesPanel(empId));
        return phonesPanel;
    }

    protected DisclosurePanel getEmailsPanel(String empId) {
        DisclosurePanel emailsPanel = new DisclosurePanel("Emails");
        emailsPanel.setContent(new ReadAllEmailsPanel(empId));
        return emailsPanel;
    }
//Phones

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
    }

    public class ProfileUpdatePhonePanel extends UpdatePhonePanel {

        public ProfileUpdatePhonePanel(JSONObject entity) {
            super(entity);
        }

        @Override
        protected void postSuccess(String result) {
            GenericPopup.instance().hide();
            refreshPhones();
        }
    }
}

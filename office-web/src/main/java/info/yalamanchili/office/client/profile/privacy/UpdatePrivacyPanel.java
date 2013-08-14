/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.privacy;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.gwt.UpdateComposite;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Prashanthi.P
 */
public class UpdatePrivacyPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdatePrivacyPanel.class.getName());

    public UpdatePrivacyPanel(JSONObject entity) {
        initUpdateComposite(entity, "Privacy", OfficeWelcome.constants);

    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject privacy = new JSONObject();
        assignEntityValueFromField("privacyData", privacy);
        assignEntityValueFromField("privacyMode", privacy);
        JSONObject emp = new JSONObject();
        emp.put("id", new JSONString(TreeEmployeePanel.instance().getEntityId()));
        privacy.put("employee", emp);
        logger.info(entity.toString());
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        // TODO Auto-generated method stub
        logger.info(entity.toString());
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(),
                OfficeWelcome.instance().getHeaders(), true, new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable arg0) {
                handleErrorResponse(arg0);
            }

            @Override
            public void onSuccess(String arg0) {
                postUpdateSuccess(arg0);
            }
        });
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("privacyData", entity, DataType.ENUM_FIELD);
        assignFieldValueFromEntity("privacyMode", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Privacy Data");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPrivacySettngsPanel(TreeEmployeePanel.instance().getEntityId()));
        TabPanel.instance().myOfficePanel.entityPanel.add(new PrivacyOptionsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        String[] dataStrs = {"EMAILS", "PHONES", "ADDRESSES", "EMERGENCY_CONTACTS", "SKILL_SET", "COMPANY_CONTACTS"};
        addEnumField("privacyData", false, true, dataStrs);
        String[] modeStrs = {"PUBLIC", "INTERNAL", "PRIVATE"};
        addEnumField("privacyMode", false, true, modeStrs);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "privacy";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.invite;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import java.util.logging.Logger;

/**
 *
 * @author Rohith.Vallabhaneni
 */
public class UpdateInviteCodePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateInviteCodePanel.class.getName());
    private boolean isCasePanel = false;

    public UpdateInviteCodePanel(JSONObject entity) {
        instance = this;
        initUpdateComposite(entity, "InviteCodeService", OfficeWelcome.constants);
    }

    public UpdateInviteCodePanel(JSONObject entity, boolean isCasePanel) {
        this.isCasePanel = isCasePanel;
        instance = this;
        initUpdateComposite(entity, "InviteCodeService", OfficeWelcome.constants);
    }

    protected static UpdateInviteCodePanel instance;

    public static UpdateInviteCodePanel instance() {
        return instance;
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject inviteType = new JSONObject();
        assignEntityValueFromField("invitationType", inviteType);
        assignEntityValueFromField("validFromDate", entity);
        assignEntityValueFromField("expiryDate", entity);
        assignEntityValueFromField("email", entity);
        entity.put("inviteType", inviteType);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
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
        assignFieldValueFromEntity("invitationCode", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("expiryDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("validFromDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("invitationType", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        if (isCasePanel == false) {
            new ResponseStatusWidget().show("Successfully Updated Invitation Code");
            TabPanel.instance().chiliAdminPanel.sidePanelTop.clear();
            TabPanel.instance().chiliAdminPanel.sidePanelTop.add(new InviteCodeSidePanel());
            TabPanel.instance().chiliAdminPanel.entityPanel.clear();
            TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllInviteCodePanel());
        } else {
            new ResponseStatusWidget().show("Successfully Updated Invitation Code");
            TabPanel.instance().immigrationPanel.sidePanelTop.clear();
            TabPanel.instance().immigrationPanel.entityPanel.clear();
        }
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("invitationCode", true, false, DataType.STRING_FIELD);
        addField("expiryDate", false, false, DataType.DATE_FIELD);
        addField("validFromDate", true, false, DataType.DATE_FIELD);
        addField("email", true, false, DataType.STRING_FIELD);
        addEnumField("invitationType", true, false, InvitationType.names());
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "invitecode/update-expiration/" + getEntityId();
    }
}
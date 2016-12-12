/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.email;

import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.yalamanchili.office.client.profile.emailtype.SelectEmailTypeWidget;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import info.chili.gwt.rpc.HttpService;

import java.util.logging.Logger;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author anu
 */
public class UpdateEmailPanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateEmailPanel.class.getName());

    public UpdateEmailPanel(JSONObject entity) {
        initUpdateComposite(entity, "Email", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("email", entity);
        assignEntityValueFromField("primaryEmail", entity);
        assignEntityValueFromField("emailType", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
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
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully  Updated Email Information");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllEmailsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("email", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("primaryEmail", entity, DataType.BOOLEAN_FIELD);
        assignFieldValueFromEntity("emailType", entity, null);
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("email", false, true, DataType.STRING_FIELD);
        addField("primaryEmail", false, false, DataType.BOOLEAN_FIELD);
        addDropDown("emailType", new SelectEmailTypeWidget(false, false));
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "email";
    }
}

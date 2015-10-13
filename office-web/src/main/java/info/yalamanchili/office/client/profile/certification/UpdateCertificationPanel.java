/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.certification;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.rpc.HttpService;

/**
 *
 * @author bala
 */
public class UpdateCertificationPanel extends UpdateComposite {

    public UpdateCertificationPanel(JSONObject entity) {
        initUpdateComposite(entity, "Certification", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        assignEntityValueFromField("description", entity);
        assignEntityValueFromField("certificationVendor", entity);
        assignEntityValueFromField("certificationCode", entity);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        // OfficeWelcome.logger.info("dddd"+entity);
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
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("description", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("certificationVendor", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("certificationCode", entity, DataType.STRING_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Employee Certification Information");
        TabPanel.instance().recruitingPanel.entityPanel.clear();
        TabPanel.instance().recruitingPanel.entityPanel.add(new ReadAllCertificationsPanel());
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("name", false, true, DataType.STRING_FIELD);
        addField("description", false, false, DataType.STRING_FIELD);
        addField("certificationVendor", false, true, DataType.STRING_FIELD);
        addField("certificationCode", false, false, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "certification";
    }
}

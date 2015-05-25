/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.i18n;

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
 * @author ayalamanchili
 */
public class UpdateCi18nResourceBundlePanel extends UpdateComposite {

    private static Logger logger = Logger.getLogger(UpdateCi18nResourceBundlePanel.class.getName());

    public UpdateCi18nResourceBundlePanel(JSONObject entity) {
        initUpdateComposite(entity, "ResourceBundle", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("name", entity);
        JSONObject locale = new JSONObject();
        assignEntityValueFromField("language", locale);
        assignEntityValueFromField("country", locale);
        assignEntityValueFromField("locale", locale);
        entity.put("resourceLocale", locale);
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
        new ResponseStatusWidget().show("Successfully  Updated Resource Bundle");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllci18nResourceBundlesPanel());
    }

    @Override
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("name", entity, DataType.STRING_FIELD);
        if (entity.get("resourceLocale") != null) {
            JSONObject locale = entity.get("resourceLocale").isObject();
            if (locale != null) {
                assignFieldValueFromEntity("language", locale, DataType.STRING_FIELD);
                assignFieldValueFromEntity("country", locale, DataType.STRING_FIELD);
                assignFieldValueFromEntity("variant", locale, DataType.STRING_FIELD);
            }
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
        addField("name", false, true, DataType.STRING_FIELD);
        addField("language", false, true, DataType.STRING_FIELD);
        addField("country", false, true, DataType.STRING_FIELD);
        addField("variant", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "i18n/bundle";
    }
}

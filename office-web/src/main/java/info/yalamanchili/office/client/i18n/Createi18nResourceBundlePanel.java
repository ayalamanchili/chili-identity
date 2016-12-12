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
import info.chili.gwt.crud.CreateComposite;
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
public class Createi18nResourceBundlePanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(Createi18nResourceBundlePanel.class.getName());

    public Createi18nResourceBundlePanel() {
        super(CreateCompositeType.CREATE);
        initCreateComposite("ResourceBundle", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject entity = new JSONObject();
        assignEntityValueFromField("name", entity);
        JSONObject locale = new JSONObject();
        assignEntityValueFromField("language", locale);
        assignEntityValueFromField("country", locale);
        assignEntityValueFromField("locale", locale);
        entity.put("resourceLocale", locale);
        return entity;
    }

    @Override
    protected void createButtonClicked() {
        HttpService.HttpServiceAsync.instance().doPut(getURI(), entity.toString(), OfficeWelcome.instance().getHeaders(), true,
                new AsyncCallback<String>() {
                    @Override
                    public void onFailure(Throwable arg0) {
                        handleErrorResponse(arg0);
                    }

                    @Override
                    public void onSuccess(String arg0) {
                        postCreateSuccess(arg0);
                    }
                });
    }

    @Override
    protected void addButtonClicked() {

    }

    @Override
    protected void postCreateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Created Resource Bundle");
        TabPanel.instance().chiliAdminPanel.entityPanel.clear();
        TabPanel.instance().chiliAdminPanel.entityPanel.add(new ReadAllci18nResourceBundlesPanel());
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
        addField("name", false, true, DataType.STRING_FIELD);
        addField("language", false, true, DataType.STRING_FIELD);
        addField("country", false, true, DataType.STRING_FIELD);
        addField("variant", false, true, DataType.STRING_FIELD);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        // TODO Auto-generated method stub  
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "i18n/bundle";
    }
}

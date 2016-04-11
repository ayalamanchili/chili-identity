/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.UpdateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.TabPanel;
import info.yalamanchili.office.client.profile.employee.TreeEmployeePanel;
import java.util.logging.Logger;

/**
 *
 * @author Madhu.Badiginchala
 */
public class UpdatePassportPanel extends UpdateComposite {
    
    private static Logger logger = Logger.getLogger(UpdatePassportPanel.class.getName());

    public UpdatePassportPanel(JSONObject entity) {
        logger.info("entity plz : " + entity);
        initUpdateComposite(entity, "Passport", OfficeWelcome.constants);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        assignEntityValueFromField("passportNumber", entity);
        assignEntityValueFromField("passportIssuedDate", entity);
        assignEntityValueFromField("passportExpiryDate", entity);
        assignEntityValueFromField("passportCountryOfIssuance", entity);
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
    public void populateFieldsFromEntity(JSONObject entity) {
        assignFieldValueFromEntity("passportNumber", entity, DataType.STRING_FIELD);
        assignFieldValueFromEntity("passportIssuedDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportExpiryDate", entity, DataType.DATE_FIELD);
        assignFieldValueFromEntity("passportCountryOfIssuance", entity, DataType.ENUM_FIELD);
    }

    @Override
    protected void postUpdateSuccess(String result) {
        new ResponseStatusWidget().show("Successfully Updated Client");
        TabPanel.instance().myOfficePanel.entityPanel.clear();
        TabPanel.instance().myOfficePanel.entityPanel.add(new ReadAllPassportsPanel(TreeEmployeePanel.instance().getEntityId()));
    }

    @Override
    protected void addListeners() {
    }

    @Override
    protected void configure() {
    }

    @Override
    protected void addWidgets() {
        addField("passportNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpiryDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("passportCountryOfIssuance", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "passport/save/" + TreeEmployeePanel.instance().getEntityId();
    }

}

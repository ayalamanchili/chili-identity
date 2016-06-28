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
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
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
public class CreatePassportPanel extends CreateComposite {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    public CreatePassportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Passport", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject passport = new JSONObject();
        assignEntityValueFromField("passportNumber", passport);
        assignEntityValueFromField("doYouHoldAValidPassport", passport);
        assignEntityValueFromField("passportIssuedDate", passport);
        assignEntityValueFromField("passportExpiryDate", passport);
        assignEntityValueFromField("passportExpirationAlertIndicator", passport);
        assignEntityValueFromField("passportCountryOfIssuance", passport);
        assignEntityValueFromField("dateOfBirth", passport);
        assignEntityValueFromField("stateOfBirth", passport);
        assignEntityValueFromField("placeOfBirth", passport);
        assignEntityValueFromField("countryOfBirth", passport);
        assignEntityValueFromField("nationality", passport);
        assignEntityValueFromField("countryOfNationality", passport);
        assignEntityValueFromField("passportStateOfIssuance", passport);
        assignEntityValueFromField("identificationMarks", passport);
        assignEntityValueFromField("haveYouEverLostPassport", passport);
        assignEntityValueFromField("travelDocumentNumber", passport);
        assignEntityValueFromField("comments", passport);
        passport.put("targetEntityName", new JSONString("targetEntityName"));
        passport.put("targetEntityId", new JSONString("0"));
        return passport;
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
        new ResponseStatusWidget().show("Successfully Added Passport");
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
        addField("doYouHoldAValidPassport", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpiryDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpirationAlertIndicator", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addEnumField("passportCountryOfIssuance", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("stateOfBirth", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("placeOfBirth", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfBirth", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("nationality", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfNationality", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("passportStateOfIssuance", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("identificationMarks", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("haveYouEverLostPassport", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("travelDocumentNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("comments", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        alignFields();
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
        
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "passport/save/" + TreeEmployeePanel.instance().getEntityId();
    }

    @Override
    protected boolean processClientSideValidations(JSONObject entity) {
        DateField passportIssuedDate = (DateField) fields.get("passportIssuedDate");
        DateField passportExpiryDate = (DateField) fields.get("passportExpiryDate");
        if (passportIssuedDate.getDate() != null && passportExpiryDate.getDate() != null && passportIssuedDate.getDate().after(passportExpiryDate.getDate())) {
            passportExpiryDate.setMessage("Passport Expiry date should be after Passport Issued date");
            return false;
        }
        return true;
    }
}

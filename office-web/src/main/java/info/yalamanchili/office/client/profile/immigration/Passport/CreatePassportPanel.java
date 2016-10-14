/**
 * System Soft Technologies Copyright (C) 2013 ayalamanchili@sstech.mobi
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.immigration.Passport;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.rpc.AsyncCallback;
import info.chili.gwt.crud.CreateComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.BooleanField;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.TextAreaField;
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
public class CreatePassportPanel extends CreateComposite implements ChangeHandler, ClickHandler {

    private static Logger logger = Logger.getLogger(CreatePassportPanel.class.getName());

    public CreatePassportPanel(CreateComposite.CreateCompositeType type) {
        super(type);
        initCreateComposite("Passport", OfficeWelcome.constants2);
    }

    protected EnumField countriesF;
    protected EnumField statesF;

    protected EnumField countriesS;
    protected EnumField stateF;

    protected BooleanField haveYouEverLostPassport;

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject passport = new JSONObject();
        assignEntityValueFromField("passportNumber", passport);
        assignEntityValueFromField("passportIssuedDate", passport);
        assignEntityValueFromField("passportExpiryDate", passport);
        assignEntityValueFromField("passportCountryOfIssuance", passport);
        assignEntityValueFromField("passportStateOfIssuance", passport);
        assignEntityValueFromField("dateOfBirth", passport);
        assignEntityValueFromField("countryOfBirth", passport);
        assignEntityValueFromField("stateOfBirth", passport);
        assignEntityValueFromField("placeOfBirth", passport);
        assignEntityValueFromField("nationality", passport);
        assignEntityValueFromField("countryOfNationality", passport);
        assignEntityValueFromField("identificationMarks", passport);
        assignEntityValueFromField("haveYouEverLostPassport", passport);
        assignEntityValueFromField("reason", passport);
        assignEntityValueFromField("travelDocumentNumber", passport);
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
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
        if (countriesS != null) {
            countriesS.listBox.addChangeHandler(this);
        }

        haveYouEverLostPassport.getBox().addClickHandler(this);
    }

    @Override
    protected void configure() {

    }
    TextAreaField reasonF;

    @Override
    protected void addWidgets() {
        addField("passportNumber", false, true, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("passportIssuedDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addField("passportExpiryDate", false, true, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("passportCountryOfIssuance", false, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("passportStateOfIssuance", false, false, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("dateOfBirth", false, false, DataType.DATE_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfBirth", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addEnumField("stateOfBirth", false, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("placeOfBirth", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addField("nationality", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        addEnumField("countryOfNationality", false, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL);
        addField("identificationMarks", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("haveYouEverLostPassport", false, false, DataType.BOOLEAN_FIELD, Alignment.HORIZONTAL);
        addField("reason", false, false, DataType.TEXT_AREA_FIELD, Alignment.HORIZONTAL);
        addField("travelDocumentNumber", false, false, DataType.STRING_FIELD, Alignment.HORIZONTAL);
        countriesF = (EnumField) fields.get("passportCountryOfIssuance");
        statesF = (EnumField) fields.get("passportStateOfIssuance");
        countriesS = (EnumField) fields.get("countryOfBirth");
        stateF = (EnumField) fields.get("stateOfBirth");
        reasonF = (TextAreaField) fields.get("reason");
        reasonF.setVisible(false);
        haveYouEverLostPassport = (BooleanField) fields.get("haveYouEverLostPassport");
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

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource().equals(haveYouEverLostPassport.getBox()) && haveYouEverLostPassport.getValue()) {
            reasonF.setVisible(true);
        } else {
            reasonF.setVisible(false);
        }
        super.onClick(event);
    }

    @Override
    public void onChange(ChangeEvent event) {
        if (event.getSource().equals(countriesF.listBox)) {
            switch (countriesF.getValue()) {
                case "USA":
                    statesF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    statesF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    statesF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        } else if (event.getSource().equals(countriesS.listBox)) {
            switch (countriesS.getValue()) {
                case "USA":
                    stateF.setValues(USAStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "INDIA":
                    stateF.setValues(IndiaStatesFactory.getStates().toArray(new String[0]));
                    break;
                case "CANADA":
                    stateF.setValues(CanadaStatesFactory.getStates().toArray(new String[0]));
                    break;
            }
        }
    }

}

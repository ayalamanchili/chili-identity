/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.client.profile.employee;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import info.chili.gwt.callback.ALAsyncCallback;
import info.chili.gwt.composite.BaseField;
import info.chili.gwt.composite.BaseFieldWithTextBox;
import info.chili.gwt.crud.TUpdateComposite;
import info.chili.gwt.data.CanadaStatesFactory;
import info.chili.gwt.data.CountryFactory;
import info.chili.gwt.data.IndiaStatesFactory;
import info.chili.gwt.data.USAStatesFactory;
import info.chili.gwt.fields.DataType;
import info.chili.gwt.fields.DateField;
import info.chili.gwt.fields.EnumField;
import info.chili.gwt.fields.StringField;
import info.chili.gwt.rpc.HttpService;
import info.chili.gwt.utils.Alignment;
import info.chili.gwt.utils.JSONUtils;
import info.chili.gwt.widgets.GenericPopup;
import info.chili.gwt.widgets.ResponseStatusWidget;
import info.yalamanchili.office.client.OfficeWelcome;
import info.yalamanchili.office.client.resources.OfficeImages;
import java.util.Map;
import java.util.logging.Logger;

/**
 *
 * @author radhika.mukkala
 */
public class UpdateBirthPassportInfoPopupPanel extends TUpdateComposite implements ChangeHandler {

    private static Logger logger = Logger.getLogger(UpdateBirthPassportInfoPopupPanel.class.getName());
    boolean isReadPanel = false;

    protected EnumField countriesF;
    protected EnumField statesF;

    protected EnumField countriesS;
    protected EnumField stateF;

    public UpdateBirthPassportInfoPopupPanel(String entityId) {
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants2);
    }

    public UpdateBirthPassportInfoPopupPanel(String entityId, boolean isReadPanel) {
        this.isReadPanel = isReadPanel;
        initUpdateComposite(entityId, "PersonalInfo", OfficeWelcome.constants2);
    }

    @Override
    protected JSONObject populateEntityFromFields() {
        JSONObject passportInfoObj = new JSONObject();
        assignEntityValueFromField("passportNumber", passportInfoObj);
        assignEntityValueFromField("passportIssuedDate", passportInfoObj);
        assignEntityValueFromField("passportExpiryDate", passportInfoObj);
        assignEntityValueFromField("passportCountryOfIssuance", passportInfoObj);
        assignEntityValueFromField("passportStateOfIssuance", passportInfoObj);
        assignEntityValueFromField("dateOfBirth", passportInfoObj);
        assignEntityValueFromField("countryOfBirth", passportInfoObj);
        assignEntityValueFromField("stateOfBirth", passportInfoObj);
        entity.put("passport", passportInfoObj);
        return entity;
    }

    @Override
    protected void updateButtonClicked() {
        JSONObject entity = populateEntityFromFields();
        HttpService.HttpServiceAsync.instance().doPut(updatePassportInfo(), entity.toString(),
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
        if (entity.containsKey("passport")) {
            JSONObject passportInfo = entity.get("passport").isObject();
            logger.info("passport obj is .... " + passportInfo);
            assignFieldValueFromEntity("passportNumber", passportInfo, DataType.STRING_FIELD);
            assignFieldValueFromEntity("passportIssuedDate", passportInfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("passportExpiryDate", passportInfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("passportCountryOfIssuance", passportInfo, DataType.ENUM_FIELD);
            if (isReadPanel == true) {
                assignFieldValueFromEntity("passportStateOfIssuance", passportInfo, DataType.STRING_FIELD);
            } else {
                assignFieldValueFromEntity("passportStateOfIssuance", passportInfo, DataType.ENUM_FIELD);
            }
            assignFieldValueFromEntity("dateOfBirth", passportInfo, DataType.DATE_FIELD);
            assignFieldValueFromEntity("countryOfBirth", passportInfo, DataType.ENUM_FIELD);
            if (isReadPanel == true) {
                assignFieldValueFromEntity("stateOfBirth", passportInfo, DataType.STRING_FIELD);
            } else {
                assignFieldValueFromEntity("stateOfBirth", passportInfo, DataType.ENUM_FIELD);
            }
        }
    }

    @Override
    protected void postUpdateSuccess(String result) {
        GenericPopup.hideIfOpen();
        RootPanel.get().clear();
        RootPanel.get().add(new Image(OfficeImages.INSTANCE.logo()));
        RootPanel.get().add(new H1bQuestionnaireWidget(entityId, "page2"));
        new ResponseStatusWidget().show("Successfully  Updated Employee Personal Info");
    }

    @Override
    protected void addListeners() {
        if (countriesF != null) {
            countriesF.listBox.addChangeHandler(this);
        }
        if (countriesS != null) {
            countriesS.listBox.addChangeHandler(this);
        }
    }

    @Override
    protected void configure() {
        if (isReadPanel == false) {
            update.setText("Save");
            update.setVisible(true);
        } else {
            update.setVisible(false);
        }
        configureLabelNames();
        for (Map.Entry<String, BaseField> e : fields.entrySet()) {
            if (e.getValue() instanceof BaseFieldWithTextBox) {
                setVisibleLengthSize(e.getKey(), 20);
            }
        }
    }

    protected void configureLabel(Label l) {
        l.removeStyleName("tfFieldHeader");
        l.setVisible(true);
    }

    private void configureLabelNames() {
        StringField passportNumber = (StringField) fields.get("passportNumber");
        configureLabel(passportNumber.getLabel());
        DateField passportIssuedDate = (DateField) fields.get("passportIssuedDate");
        configureLabel(passportIssuedDate.getLabel());
        DateField passportExpiryDate = (DateField) fields.get("passportExpiryDate");
        configureLabel(passportExpiryDate.getLabel());
        EnumField passportCountryOfIssuance = (EnumField) fields.get("passportCountryOfIssuance");
        configureLabel(passportCountryOfIssuance.getLabel());
        if (isReadPanel == true) {
            StringField stateOfBirth = (StringField) fields.get("passportStateOfIssuance");
            configureLabel(stateOfBirth.getLabel());
        } else {
            EnumField stateOfBirth = (EnumField) fields.get("passportStateOfIssuance");
            configureLabel(stateOfBirth.getLabel());
        }
        DateField dateOfBirth = (DateField) fields.get("dateOfBirth");
        configureLabel(dateOfBirth.getLabel());
        EnumField countryOfBirth = (EnumField) fields.get("countryOfBirth");
        configureLabel(countryOfBirth.getLabel());
        if (isReadPanel == true) {
            StringField stateOfBirth = (StringField) fields.get("stateOfBirth");
            configureLabel(stateOfBirth.getLabel());
        } else {
            EnumField stateOfBirth = (EnumField) fields.get("stateOfBirth");
            configureLabel(stateOfBirth.getLabel());
        }
    }

    @Override
    protected void addWidgets() {
        addField("passportNumber", isReadPanel, true, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 1);
        addEnumField("passportCountryOfIssuance", isReadPanel, true, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 1, 2);
        addField("dateOfBirth", isReadPanel, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 2, 1);
        addEnumField("countryOfBirth", isReadPanel, false, CountryFactory.getCountries().toArray(new String[0]), Alignment.HORIZONTAL, 2, 2);
        if (isReadPanel == true) {
            addField("passportStateOfIssuance", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 1, 3);
        } else {
            addEnumField("passportStateOfIssuance", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 1, 3);
        }
        if (isReadPanel == true) {
            addField("stateOfBirth", isReadPanel, false, DataType.STRING_FIELD, Alignment.HORIZONTAL, 2, 3);
        } else {
            addEnumField("stateOfBirth", isReadPanel, true, USAStatesFactory.getStates().toArray(new String[0]), Alignment.HORIZONTAL, 2, 3);
        }
        addField("passportIssuedDate", isReadPanel, false, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 1);
        addField("passportExpiryDate", isReadPanel, true, DataType.DATE_FIELD, Alignment.HORIZONTAL, 3, 2);
        countriesF = (EnumField) fields.get("passportCountryOfIssuance");
        if (isReadPanel == false) {
            statesF = (EnumField) fields.get("passportStateOfIssuance");
        }
        countriesS = (EnumField) fields.get("countryOfBirth");
        if (isReadPanel == false) {
            stateF = (EnumField) fields.get("stateOfBirth");
        }
        alignFields(200);
    }

    @Override
    protected void addWidgetsBeforeCaptionPanel() {
    }

    @Override
    protected String getURI() {
        return OfficeWelcome.constants.root_url() + "immigrationcase/h1b-questionnaire/get-details/page-2?invitationCode=" + entityId;
    }

    @Override
    public void loadEntity(String entityId) {
        HttpService.HttpServiceAsync.instance().doGet(getURI(), OfficeWelcome.instance().getHeaders(), true,
                new ALAsyncCallback<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.trim().contains("<html>")) {
                            entity = (JSONObject) JSONParser.parseLenient(response);
                            populateFieldsFromEntity(entity);
                        } else {
                            entity = new JSONObject();
                        }
                    }
                });
    }

    protected String updatePassportInfo() {
        return URL.encode(OfficeWelcome.constants.root_url() + "passport/save-passport-info/" + entityId);
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
